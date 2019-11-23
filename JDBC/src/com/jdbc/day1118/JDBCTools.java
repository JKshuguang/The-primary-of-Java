package com.jdbc.day1118;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTools {
	
	//�������ݿ�����
	//�ύ����
	public static void commit(Connection connection) {
		if (connection != null) {
			try {
				connection.commit();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	//ȡ��������Զ��ύ
	public static void cancelAuto(Connection connection) {
		if (connection != null) {
			try {
				connection.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//�ع�����
	public static void rollBack(Connection connection) {
		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void update1(String sql) {
		
		Connection conn = null;
		Statement stms = null;
		
		try {
			//�õ�һ��Connection��
			conn = JDBCTools.getConnection();
			//��ʼ����Ҫ�����������
			String name = "JXK1";
			int age = 21;
			Date birth = new Date(new java.util.Date().getTime());
			
			//ƴ��
			sql = sql + "('"
					+ name 
					+"',"
					+ age
					+","
					+ birth
					+")";
			
			//�õ�Statement����
			stms = conn.createStatement();
			
			//ִ�в������
			stms.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//�ر���Դ
			JDBCTools.closeResource(conn, stms, null);
		}
		
	}
	
	public static void update2(String sql) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			conn = JDBCTools.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, "tom");
			preparedStatement.setInt(2, 33);
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.closeResource(conn, preparedStatement, null);
		}
	}
	
	public static void update3(String sql,Object ...args ) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			conn = JDBCTools.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i+1, args[i]);
			}
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.closeResource(conn, preparedStatement, null);
		}
	}
	
	public static Connection getConnection() throws Exception {
		
		String driver = null;
		String url = null;
		String user = null;
		String password = null;
		
		
		InputStream in = JDBCTools.class.getResourceAsStream("jdbc.properties");
		
		Properties properties = new Properties();
		properties.load(in);
		
		driver = properties.getProperty("driverName");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		
		Class.forName(driver);
		
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void closeResource(Connection conn,Statement stmt,ResultSet res) {
		
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				
			}
		}
		
		if (stmt != null) {
			try {
				conn.close();
			} catch (Exception e) {
				
			}
		}
		
		if (res != null) {
			try {
				conn.close();
			} catch (Exception e) {
				
			}
		}
		
	}

	public static void inject(String sql) {
		Connection conn = null;
		Statement stms = null;
		ResultSet res = null;
		
		try {
			conn = JDBCTools.getConnection();
			
			//SQLע��
			String user = "a ' OR password = ";
			String password = " OR '1' = '1";
			
			//������¼
//			String user = "tom1";
//			String password = "123321";
			sql = sql + "username='"+ user +"' AND password='" + password + "'";
			
			System.out.println(sql);
			
			stms = conn.createStatement();
			
			res = stms.executeQuery(sql);
			
			if(res.next()) {
				System.out.println("��¼�ɹ�");
			}else {
				System.out.println("��¼ʧ��");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.closeResource(conn, stms, null);
		}
		
	}

	public static void inject2(String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try {
			conn = JDBCTools.getConnection();
			
			//SQLע��
			String user = "a ' OR password = ";
			String password = " OR '1' = '1";
			
			//������¼
//			String user = "tom1";
//			String password = "123321";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user);
			ps.setString(2, password);
			
			System.out.println(sql);
			
			
			
			res = ps.executeQuery();
			
			if(res.next()) {
				System.out.println("��¼�ɹ�");
			}else {
				System.out.println("��¼ʧ��");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.closeResource(conn, ps, null);
		}
		
	}


	
	
}
