package com.jdbc.day1119;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

import com.jdbc.day1118.JDBCTools;

public class JDBCTest {
	
	/**
	 * 
	 * @param clazz  ���ܷ������������
	 * @param sql	����SQL���
	 * @param args	���ܶ�Ӧռλ��
	 * @return	����һ��T�ͷ���õ��ĳ�ʼ����
	 */
	
	public static <T> T getObject(Class<T> clazz,String sql, Object...args) {
		T entity = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try {
			conn = JDBCTools.getConnection();
			
			//�õ�preparedStatement����
			ps = conn.prepareStatement(sql);
			
			//��ռλ����ֵ
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1,args[i]);
			}
			
			//ִ��SQL
			res = ps.executeQuery();
			
			//����map����
			Map<String, Object> values = new HashMap<String, Object>();
			
			//����ResultSetMetaData����
			ResultSetMetaData rsmd = res.getMetaData();
			
			while(res.next()) {
				//���÷��䴴������
				entity = clazz.newInstance();
				
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					//�õ��������ǩ
					String columnLabel = rsmd.getColumnLabel(i+1);

					//�õ������� ��ֵ
					Object columnValue = res.getObject(i+1);
					
					//����ֵ�Է��뼯��
					values.put(columnLabel, columnValue);
				}
			}
			
			//��value��Ϊ�գ����÷���Ϊclazz��������
			if(values.size() > 0) {
				entity = clazz.newInstance();
				
				//����map��Ϊ��Ӧ�����и�ֵ
				for (Map.Entry<String , Object> entry : values.entrySet()) {
					//�õ���
					String key = entry.getKey();
					
					//�õ�ֵ
					Object value = entry.getValue();
					
					//�����Ը�ֵ
					Field field = clazz.getDeclaredField(key);
					field.setAccessible(true);
					field.set(entity, value);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.closeResource(conn, ps, res);
		}
		
		
		return entity;
	}

	public static Employee getEmployee(String sql,Object...args) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet res = null;
		Employee employee = null;
		try {
			conn = JDBCTools.getConnection();
			
			preparedStatement = conn.prepareStatement(sql);
			
			for (int i = 0; i < args.length; i++) {
				
				preparedStatement.setObject(i+1, args[i]);
			}
			
			res = preparedStatement.executeQuery();
			
			if (res.next()) {
				int no = res.getInt(1);
				String name = res.getString("name");
				String IDCard = res.getString(3);
				double salary = res.getDouble(4);
				
				employee = new Employee(no,name,IDCard,salary);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.closeResource(conn, preparedStatement, res);
		}
		
		return employee;
	}

	public static Cat getCat(String sql2, Object ...args) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet res = null;
		Cat cat = null;
		try {
			conn = JDBCTools.getConnection();
			
			preparedStatement = conn.prepareStatement(sql2);
			
			for (int i = 0; i < args.length; i++) {
				
				preparedStatement.setObject(i+1, args[i]);
			}
			
			res = preparedStatement.executeQuery();
			
			if (res.next()) {
				int no = res.getInt(1);
				String name = res.getString(2);
				String furColor = res.getString(3);
				
				cat = new Cat(no, name, furColor);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.closeResource(conn, preparedStatement, res);
		}
		
		return cat;
	}
	
	
}
