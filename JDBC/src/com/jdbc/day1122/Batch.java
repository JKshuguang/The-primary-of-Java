package com.jdbc.day1122;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.jdbc.day1118.JDBCTools;

public class Batch {
	
	public void case1() {
		//����Connection
		Connection connection = null;
		//����Statement
		Statement stms = null;
		
		try {
			//�õ�Connection
			connection = JDBCTools.getConnection();
			
			//ȡ��Ĭ���ύ
			JDBCTools.cancelAuto(connection);
			
			String sql = null;
			//�õ�Statement
			stms = connection.createStatement();
			
			long begin = System.currentTimeMillis();
			for (int i = 0; i < 100000; i++) {
				
				//дSQL
				sql = "Insert into TableA values(" + i + ",'name_" + i + "')";
				
				//ִ��
				stms.executeUpdate(sql);
			}
			long end = System.currentTimeMillis();
			//��ӡִ��ʱ��
			System.err.println("Time : " + (end - begin));// 21678
			
			//�ύ����
			JDBCTools.commit(connection);
			
		} catch (Exception e) {
			//�ع�����
			JDBCTools.rollBack(connection);
			// TODO: handle exception
		} finally {
			JDBCTools.closeResource(connection, stms, null);
		}
		
	}

	public void case2() {
		//����Connection
				Connection connection = null;
				//����Statement
				PreparedStatement ps = null;
				
				try {
					//�õ�Connection
					connection = JDBCTools.getConnection();
					
					//ȡ��Ĭ���ύ
					JDBCTools.cancelAuto(connection);
					
					String sql = null;
					sql = "Insert into TableA values(?,?)";
					//�õ�PreparedStatement
					ps = connection.prepareStatement(sql);
					
					long begin = System.currentTimeMillis();
					for (int i = 0; i < 100000; i++) {
						ps.setObject(1, i);
						ps.setObject(2, "name_" + i);
						
						//ִ��
						ps.executeUpdate();
					}
					long end = System.currentTimeMillis();
					//��ӡִ��ʱ��
					System.err.println("Time : " + (end - begin));// 16721
					
					//�ύ����
					JDBCTools.commit(connection);
					
				} catch (Exception e) {
					//�ع�����
					JDBCTools.rollBack(connection);
					// TODO: handle exception
				} finally {
					JDBCTools.closeResource(connection, ps, null);
				}
				
	}
	
	public void case3() {
		//����Connection
		Connection connection = null;
		//����Statement
		PreparedStatement ps = null;
		
		try {
			//�õ�Connection
			connection = JDBCTools.getConnection();
			
			//ȡ��Ĭ���ύ
			JDBCTools.cancelAuto(connection);
			
			String sql = null;
			sql = "Insert into TableA values(?,?)";
			//�õ�PreparedStatement
			ps = connection.prepareStatement(sql);
			
			long begin = System.currentTimeMillis();
			for (int i = 0; i < 100000; i++) {
				ps.setObject(1, i);
				ps.setObject(2, "name_" + i);
				
				//����SQL
				ps.addBatch();
				
				//�浽һ��������ͳһִ��һ��
				if ((i+1) % 300 == 0) {
					//ִ��batch
					ps.executeBatch();
					
					//���batch
					ps.clearBatch();
				}
				
			}
			//����û���㹻����Ҳִ��
			if (100000 % 300 != 0) {
				//ִ��batch
				ps.executeBatch();
				
				//���batch
				ps.clearBatch();
			}
			long end = System.currentTimeMillis();
			//��ӡִ��ʱ��
			System.err.println("Time : " + (end - begin));// 3184
			
			//�ύ����
			JDBCTools.commit(connection);
			
		} catch (Exception e) {
			//�ع�����
			JDBCTools.rollBack(connection);
			// TODO: handle exception
		} finally {
			JDBCTools.closeResource(connection, ps, null);
		}
		
	}

}
