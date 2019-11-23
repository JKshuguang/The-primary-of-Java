package com.jdbc.day1115;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddOperator{
	public static void main(String[] args) {
		//声明连接对象 和 执行SQL语句对象
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			
			//填写数据库url
			String url = "jdbc:sqlserver://localhost:1433; DatabaseName=sc";
			
			//sql账号
			String user = "JIKE";
			
			//密码
			String password = "19980402";
			
			//获得数据库连接
			conn = DriverManager.getConnection(url, user, password);
			
			//得到执行SQL语句的对象
			stmt = conn.createStatement();
			
			//写SQL语句（插入一条记录）
			String sql = "insert into student(name,age) values ('aa',33)";
			
			//执行SQL语句
		     stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//关闭conn资源
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
				}
			}
			//关闭stmt资源
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e2) {
				}
			}
				
		}
		
		System.out.println("插入成功");
		
	}
}