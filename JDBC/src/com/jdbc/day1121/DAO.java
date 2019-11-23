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

	//INSET,UPDATE,DELETE 操作
	public void update(String sql,Object ... args) {
		
		//得到一个Connection
		Connection conn = null;
		
		//得到一个PreparedStatement
		PreparedStatement ps = null;
		
		
		try {
			//得到Connection
			conn = JDBCTools.getConnection();
			
			//得到Prepared Statement
			ps = conn.prepareStatement(sql);
			
			//给占位符赋值
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			
			//执行SQL
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			JDBCTools.closeResource(conn, ps, null);
		}
		
	}
	
	//查询一条记录，返回对应对象
	public <T> T get(Class<T> clazz,String sql,Object ... args) {
		List<T> list = getList(clazz, sql, args);
		
		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}
	
	//查询多条记录，返回多条对象的集合
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
			
			//处理结果集
			List<Map<String, Object>> values = handleResultSetToMapList(res);
			
			//得到结果集
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
					//得到键
					String key = entry.getKey();
					
					//得到值
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
		
		//定义一个集合数组，存储所有元组
		List<Map<String , Object> > values = new ArrayList<>();
		
		//定义一个map存储键值对
		Map<String , Object> map = null;
		
		//查询有结果则开始遍历
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
	
	//返回某条记录的某一个字段的值或者是统计的值
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
