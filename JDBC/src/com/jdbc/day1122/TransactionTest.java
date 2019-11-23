package com.jdbc.day1122;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.jdbc.day1118.JDBCTools;

class TransactionTest {

	TransactionDemo td = new TransactionDemo();
	
	@Test
	void transactionTest() {
		
		Connection conn = null;
		
		try {
			conn  = JDBCTools.getConnection();
			
			//ȡ���Զ��ύ
			conn.setAutoCommit(false);
			
			String sql = "update employee set year_Salary  = year_Salary - 500 "
					+ "where no = 1";
			td.update(conn,sql);
			
			int j = 5/0;
			System.out.println(j);
			
			sql  = "update employee set year_Salary = year_Salary + 500 "
					+ "where no = 2";
			td.update(conn,sql);
			
			//�ύ����
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//�ع�����
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} finally {
			JDBCTools.closeResource(conn, null, null);
		}
	
	}

}
