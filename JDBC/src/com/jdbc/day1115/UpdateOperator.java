package com.jdbc.day1115;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class UpdateOperator {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try {
			//�õ����ݿ�����
			conn = getConnection();
			
			//�õ�ִ��SQL���Ķ���
			stmt = conn.createStatement();
			
			//дSQL��䣨���¼�¼��
			String sql = "update student set name = 'JIN1' "
					+ "where name = 'jin' ";
			
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//�ر���Դ
			connectionClose(conn,stmt,res);
			
		}
		
		
	}

	private static Connection getConnection() throws Exception {
		
		InputStream in = SelectOperator.class.getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);
		
		Connection conn;
		//��������
		String driverName = properties.getProperty("driverName");
		//String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		Class.forName(driverName); 
		
		//��д���ݿ�url
		String url = properties.getProperty("url");
		//String url = "jdbc:sqlserver://localhost:1433; DatabaseName=sc";
		
		//sql�˺�
		String user = properties.getProperty("user");
		//String user = "JIKE";
		
		//����
		String password = properties.getProperty("password");
		//String password = "19980402";
		
		//������ݿ�����
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	private static void connectionClose(Connection conn, Statement stmt, ResultSet res) {
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		if(stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		if(res != null) {
			try {
				res.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
