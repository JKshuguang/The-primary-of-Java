package com.jdbcdemo;


import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] srg) {

		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 

		//����JDBC����

		String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=SC"; 

		//���ӷ����������ݿ�

		String userName = "JIKE"; //Ĭ���û���

		String userPwd = "19980402"; //����

		Connection dbConn = null;

		try {

		   Class.forName(driverName);

		   dbConn = DriverManager.getConnection(dbURL, userName, userPwd);

		   System.out.println(dbConn);
		   System.out.println("Connection Successful!"); 

		     //������ӳɹ� ����̨���Connection  Successful!

		} catch (Exception e) {

		   e.printStackTrace();

		}

		}

 

}

