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
	 * @param clazz  接受反射过来的类名
	 * @param sql	接受SQL语句
	 * @param args	接受对应占位符
	 * @return	返回一个T型反射得到的初始化类
	 */
	
	public static <T> T getObject(Class<T> clazz,String sql, Object...args) {
		T entity = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try {
			conn = JDBCTools.getConnection();
			
			//得到preparedStatement对象
			ps = conn.prepareStatement(sql);
			
			//给占位符赋值
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1,args[i]);
			}
			
			//执行SQL
			res = ps.executeQuery();
			
			//定义map集合
			Map<String, Object> values = new HashMap<String, Object>();
			
			//定义ResultSetMetaData对象
			ResultSetMetaData rsmd = res.getMetaData();
			
			while(res.next()) {
				//利用反射创建对象
				entity = clazz.newInstance();
				
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					//得到数据项标签
					String columnLabel = rsmd.getColumnLabel(i+1);

					//得到数据项 的值
					Object columnValue = res.getObject(i+1);
					
					//将键值对放入集合
					values.put(columnLabel, columnValue);
				}
			}
			
			//若value不为空，则用反射为clazz创建对象
			if(values.size() > 0) {
				entity = clazz.newInstance();
				
				//遍历map，为对应属性列赋值
				for (Map.Entry<String , Object> entry : values.entrySet()) {
					//得到键
					String key = entry.getKey();
					
					//得到值
					Object value = entry.getValue();
					
					//给属性赋值
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
