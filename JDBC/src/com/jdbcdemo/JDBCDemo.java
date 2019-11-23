package com.jdbcdemo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCDemo {

	String url = null;
	String user = null;
	String password = null;
	InputStream in = null;
	Properties properties =null;
	
	public JDBCDemo() {
		
		try {
			in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
			
			properties = new Properties();
			properties.load(in);
			
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public Connection getConnection() throws Exception {

		//Class.forName(driverName);  
		Connection connection = DriverManager.getConnection(url,user,password);
		
		return connection;
	}

}