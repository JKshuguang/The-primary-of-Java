package self.java.tools;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTools {
	
	//处理数据库事务
		//提交事务
		public static void commit(Connection connection) {
			if (connection != null) {
				try {
					//提交
					connection.commit();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}

		//取消事务的自动提交
		public static void cancelAuto(Connection connection) {
			if (connection != null) {
				try {
					//取消自动提交
					connection.setAutoCommit(false);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//回滚事务
		public static void rollBack(Connection connection) {
			if (connection != null) {
				try {
					//回滚
					connection.rollback();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		//得到一个数据库连接
		public static Connection getConnection() throws Exception {
			//声明必要的参数
			String driver = null;
			String url = null;
			String user = null;
			String password = null;
			
			//输入流
			InputStream in = JDBCTools.class.getResourceAsStream("jdbc.properties");
			
			//Properties对象读取配置文件
			Properties properties = new Properties();
			properties.load(in);
			
			//读取配置文件
			driver = properties.getProperty("driverName");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			
			//加载数据库驱动
			Class.forName(driver);
			
			//得到一个数据库连接
			return DriverManager.getConnection(url, user, password);
		}
		
		//关闭资源
		public static void closeResource(Connection conn,Statement stmt,ResultSet res) {
			//关闭Connection
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					
				}
			}
			
			//关闭Statement
			if (stmt != null) {
				try {
					conn.close();
				} catch (Exception e) {
					
				}
			}
			
			//关闭结果集
			if (res != null) {
				try {
					conn.close();
				} catch (Exception e) {
					
				}
			}
			
		}

}
