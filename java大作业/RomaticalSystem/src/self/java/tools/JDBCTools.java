package self.java.tools;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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
					//�ύ
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
					//ȡ���Զ��ύ
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
					//�ع�
					connection.rollback();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		//�õ�һ�����ݿ�����
		public static Connection getConnection() throws Exception {
			//������Ҫ�Ĳ���
			String driver = null;
			String url = null;
			String user = null;
			String password = null;
			
			//������
			InputStream in = JDBCTools.class.getResourceAsStream("jdbc.properties");
			
			//Properties�����ȡ�����ļ�
			Properties properties = new Properties();
			properties.load(in);
			
			//��ȡ�����ļ�
			driver = properties.getProperty("driverName");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			
			//�������ݿ�����
			Class.forName(driver);
			
			//�õ�һ�����ݿ�����
			return DriverManager.getConnection(url, user, password);
		}
		
		//�ر���Դ
		public static void closeResource(Connection conn,Statement stmt,ResultSet res) {
			//�ر�Connection
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					
				}
			}
			
			//�ر�Statement
			if (stmt != null) {
				try {
					conn.close();
				} catch (Exception e) {
					
				}
			}
			
			//�رս����
			if (res != null) {
				try {
					conn.close();
				} catch (Exception e) {
					
				}
			}
			
		}

}
