package com.jdbc.day1122;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.jdbc.day1118.JDBCTools;

public class Batch {
	
	public void case1() {
		//声明Connection
		Connection connection = null;
		//声明Statement
		Statement stms = null;
		
		try {
			//得到Connection
			connection = JDBCTools.getConnection();
			
			//取消默认提交
			JDBCTools.cancelAuto(connection);
			
			String sql = null;
			//得到Statement
			stms = connection.createStatement();
			
			long begin = System.currentTimeMillis();
			for (int i = 0; i < 100000; i++) {
				
				//写SQL
				sql = "Insert into TableA values(" + i + ",'name_" + i + "')";
				
				//执行
				stms.executeUpdate(sql);
			}
			long end = System.currentTimeMillis();
			//打印执行时间
			System.err.println("Time : " + (end - begin));// 21678
			
			//提交事务
			JDBCTools.commit(connection);
			
		} catch (Exception e) {
			//回滚事务
			JDBCTools.rollBack(connection);
			// TODO: handle exception
		} finally {
			JDBCTools.closeResource(connection, stms, null);
		}
		
	}

	public void case2() {
		//声明Connection
				Connection connection = null;
				//声明Statement
				PreparedStatement ps = null;
				
				try {
					//得到Connection
					connection = JDBCTools.getConnection();
					
					//取消默认提交
					JDBCTools.cancelAuto(connection);
					
					String sql = null;
					sql = "Insert into TableA values(?,?)";
					//得到PreparedStatement
					ps = connection.prepareStatement(sql);
					
					long begin = System.currentTimeMillis();
					for (int i = 0; i < 100000; i++) {
						ps.setObject(1, i);
						ps.setObject(2, "name_" + i);
						
						//执行
						ps.executeUpdate();
					}
					long end = System.currentTimeMillis();
					//打印执行时间
					System.err.println("Time : " + (end - begin));// 16721
					
					//提交事务
					JDBCTools.commit(connection);
					
				} catch (Exception e) {
					//回滚事务
					JDBCTools.rollBack(connection);
					// TODO: handle exception
				} finally {
					JDBCTools.closeResource(connection, ps, null);
				}
				
	}
	
	public void case3() {
		//声明Connection
		Connection connection = null;
		//声明Statement
		PreparedStatement ps = null;
		
		try {
			//得到Connection
			connection = JDBCTools.getConnection();
			
			//取消默认提交
			JDBCTools.cancelAuto(connection);
			
			String sql = null;
			sql = "Insert into TableA values(?,?)";
			//得到PreparedStatement
			ps = connection.prepareStatement(sql);
			
			long begin = System.currentTimeMillis();
			for (int i = 0; i < 100000; i++) {
				ps.setObject(1, i);
				ps.setObject(2, "name_" + i);
				
				//积攒SQL
				ps.addBatch();
				
				//存到一定数量就统一执行一次
				if ((i+1) % 300 == 0) {
					//执行batch
					ps.executeBatch();
					
					//清空batch
					ps.clearBatch();
				}
				
			}
			//最终没有足够积累也执行
			if (100000 % 300 != 0) {
				//执行batch
				ps.executeBatch();
				
				//清空batch
				ps.clearBatch();
			}
			long end = System.currentTimeMillis();
			//打印执行时间
			System.err.println("Time : " + (end - begin));// 3184
			
			//提交事务
			JDBCTools.commit(connection);
			
		} catch (Exception e) {
			//回滚事务
			JDBCTools.rollBack(connection);
			// TODO: handle exception
		} finally {
			JDBCTools.closeResource(connection, ps, null);
		}
		
	}

}
