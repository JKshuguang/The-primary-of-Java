package com.jdbc.day1118;

import java.sql.Connection;
import java.sql.Statement;

public class SQLInject {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = JDBCTools.getConnection();
			stmt = conn.createStatement();
			//�ܱ�SQLע��
//			String sql = "select * from STU where ";
//			
//			//Sqlע��
//			JDBCTools.inject(sql);
			
			
			String sql = "Select * from STU where username=? AND password=?";
			JDBCTools.inject2(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.closeResource(conn, stmt, null);
		}
		
	}

}
