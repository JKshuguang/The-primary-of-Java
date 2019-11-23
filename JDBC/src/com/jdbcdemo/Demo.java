package com.jdbcdemo;

import java.sql.Connection;

public class Demo {

	public static void main(String[] args) throws Exception {
		JDBCDemo adDemo = new JDBCDemo();
		
		
		
		Connection connection = adDemo.getConnection();
		System.out.println(connection);
//		 String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		 String connectDB = "jdbc:sqlserver://localhost:1433; DatabaseName=SC"; 
//		 
//		 try {  
//			    Class.forName(JDriver);  
//			} catch (Exception e) {  
//			    System.out.println("加载数据库引擎失败");  
//			    System.exit(0);  
//			}  
//			System.out.println("数据库加载成功");  
//			String user = "JIKE";  
//			String password = "19980402";  
//			System.out.println("准备连接....");  
//			Connection connection = DriverManager.getConnection(connectDB,user,password);  
//			System.out.println("连接成功");  
//			Statement stmt = connection.createStatement();  
//			              String sql0 = "USE people";  
//			              stmt.execute(sql0);  
	}

}
