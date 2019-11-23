package com.jdbc.day1121;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.jdbc.day1118.JDBCTools;

public class DAO {

	//INSET,UPDATE,DELETE ����
	public void update(String sql,Object ... args) {
		
		//�õ�һ��Connection
		Connection conn = null;
		
		//�õ�һ��PreparedStatement
		PreparedStatement ps = null;
		
		
		try {
			//�õ�Connection
			conn = JDBCTools.getConnection();
			
			//�õ�Prepared Statement
			ps = conn.prepareStatement(sql);
			
			//��ռλ����ֵ
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			
			//ִ��SQL
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//�ر���Դ
			JDBCTools.closeResource(conn, ps, null);
		}
		
	}
	
	//��ѯһ����¼�����ض�Ӧ����
	public <T> T get(Class<T> clazz,String sql,Object ... args) {
		List<T> list = getList(clazz, sql, args);
		
		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}
	
	//��ѯ������¼�����ض�������ļ���
	public <T> List<T> getList(Class<T> clazz,String sql,Object ... args){
		
		List<T> list = new ArrayList<T>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try {
			
			conn = JDBCTools.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			
			res = ps.executeQuery();
			
			//��������
			List<Map<String, Object>> values = handleResultSetToMapList(res);
			
			//�õ������
			list = transferMapListToBeanList(clazz, values);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.closeResource(conn, ps, res);
		}
		
		return list;

	}

	private <T> List<T> transferMapListToBeanList(Class<T> clazz, List<Map<String, Object>> values)
			throws Exception {
		
		List<T> list = new ArrayList<T>();
		T entity = null;
		if (values.size() > 0) {
			for(int i = 0; i < values.size(); i++) {
				Map<String, Object> m = values.get(i);
				entity = clazz.newInstance();
				
				for(Map.Entry<String, Object> entry : m.entrySet()) {
					//�õ���
					String key = entry.getKey();
					
					//�õ�ֵ
					Object value = entry.getValue();
					

					BeanUtils.setProperty(entity, key, value);
				}
				list.add(entity);
			}
			
		}
		
		return list;
	}

	private List<Map<String, Object>> handleResultSetToMapList(ResultSet res) throws SQLException {
		ResultSetMetaData rsmd = res.getMetaData();
		
		//����һ���������飬�洢����Ԫ��
		List<Map<String , Object> > values = new ArrayList<>();
		
		//����һ��map�洢��ֵ��
		Map<String , Object> map = null;
		
		//��ѯ�н����ʼ����
		while(res.next()) {
			map = new HashMap<String, Object>();

			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				String columnLabel = rsmd.getColumnLabel(i+1);
				Object columnValue = res.getObject(i+1);
				map.put(columnLabel, columnValue);
			}
			
			values.add(map);
		}
		return values;
	}
	
	//����ĳ����¼��ĳһ���ֶε�ֵ������ͳ�Ƶ�ֵ
	public <E> E getValue(String sql,Object ... args) {

		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try {
			
			
			conn = JDBCTools.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			res = ps.executeQuery();
			
			if(res.next()) {
				return (E) res.getObject(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.closeResource(conn, ps, res);	
		}
		
		return null;
	}
	
	
}
