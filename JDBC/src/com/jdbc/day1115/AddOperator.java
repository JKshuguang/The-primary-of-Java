package com.jdbc.day1115;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddOperator{
	public static void main(String[] args) {
		//�������Ӷ��� �� ִ��SQL������
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//��������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			
			//��д���ݿ�url
			String url = "jdbc:sqlserver://localhost:1433; DatabaseName=sc";
			
			//sql�˺�
			String user = "JIKE";
			
			//����
			String password = "19980402";
			
			//������ݿ�����
			conn = DriverManager.getConnection(url, user, password);
			
			//�õ�ִ��SQL���Ķ���
			stmt = conn.createStatement();
			
			//дSQL��䣨����һ����¼��
			String sql = "insert into student(name,age) values ('aa',33)";
			
			//ִ��SQL���
		     stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//�ر�conn��Դ
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
				}
			}
			//�ر�stmt��Դ
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e2) {
				}
			}
				
		}
		
		System.out.println("����ɹ�");
		
	}
}