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
//			    System.out.println("�������ݿ�����ʧ��");  
//			    System.exit(0);  
//			}  
//			System.out.println("���ݿ���سɹ�");  
//			String user = "JIKE";  
//			String password = "19980402";  
//			System.out.println("׼������....");  
//			Connection connection = DriverManager.getConnection(connectDB,user,password);  
//			System.out.println("���ӳɹ�");  
//			Statement stmt = connection.createStatement();  
//			              String sql0 = "USE people";  
//			              stmt.execute(sql0);  
	}

}
