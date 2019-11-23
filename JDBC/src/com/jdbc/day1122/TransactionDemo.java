package com.jdbc.day1122;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdbc.day1118.JDBCTools;

public class TransactionDemo {

	public void update(String sql,Object ... args) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JDBCTools.getConnection();
			ps = conn.prepareStatement(sql);
			
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.closeResource(conn, ps, null);
		}
		
		
	}
	
public void update(Connection connection,String sql,Object ... args) {
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			ps.executeUpdate();
			
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.closeResource(null, ps, null);
		}
		
		
	}
	
}
