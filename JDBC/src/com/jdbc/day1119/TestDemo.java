package com.jdbc.day1119;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

import com.jdbc.day1118.JDBCTools;

public class TestDemo {

	public static void main(String[] args) throws Exception{
		
//		String sql = "select * from employee where no = ?";
//		Employee e = JDBCTest.getEmployee(sql, 1);
//		System.out.println(e.toString());
//		
//		String sql2 = "select * from cat where no = ?";
//		Cat cat = JDBCTest.getCat(sql2,1);
//		System.out.println(cat.toString());
		
		//反射
//		 Class<?> forname = Class.forName("com.jdbc.day1119.Cat");
//		 Cat cat = (Cat) forname.newInstance();
//		 
//		System.out.println("反射构建对象："+cat);
//		
//		Field field = forname.getDeclaredField("catName");
//		System.out.println("获取到的字段："+field);
//		
//		Field[] fieds = forname.getDeclaredFields();
//		for (int i = 0; i < fieds.length; i++) {
//			System.out.println(fieds[i]);
//		}
//		
//		field.setAccessible(true);
//		field.set(cat, "hh");
//		System.out.println(cat);
		
		//测试
		//Test1();
		//Test2();
		
		String sql = "select no,name,ID_Card IDCard,year_Salary yearSalary "
				+ "from employee where no = ?";
		
		Employee employee = JDBCTest.getObject(Employee.class, sql, 1);
		System.out.println(employee);
		
		String sql2 = "Select no,cat_Name catName,fur_Color furColor "
				+ "from cat where no = ?";
		Cat cat = JDBCTest.getObject(Cat.class, sql2, 1);
		System.out.println(cat);
		
	}
	
	

	public static void Test2() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try {
			
			conn = JDBCTools.getConnection();
			
			//准备SQL
			String sql = "select no,name,ID_Card IDCard,year_Salary yearSalary "
					+ "from employee where no = 1";
			
			//得到准备好的语句
			ps = conn.prepareStatement(sql);
			
			//执行查找
			res = ps.executeQuery();
			
			//创建集合存储键值对
			Map<String, Object> map = new HashMap<String, Object>();
			
			//得到ResultSetMetaData对象
			ResultSetMetaData rsmd = res.getMetaData();
			
			//处理查找结果
			while(res.next()) {
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					//得到数据项别名
					String columbLabel = rsmd.getColumnLabel(i+1);
					
					//得到对应数据项的值
					Object columnValue = res.getObject(i+1);
					
					System.out.println(columbLabel+" : " + columnValue);
					
					//将数据项，值放入键值对
					map.put(columbLabel, columnValue);
				}
			}
			
			//打印map
			for(Map.Entry<String ,Object> entry : map.entrySet())
			{
				System.out.println(entry);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.closeResource(conn, ps, res);
		}
		
	}
	
	public static void Test1() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try {
			conn = JDBCTools.getConnection();
			
			String sql = "Select no,cat_Name catName,fur_Color furColor "
					+ "from cat where no = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setObject(1, 1);
			
			res = ps.executeQuery();
			
			ResultSetMetaData rsmt = res.getMetaData();
			

			for (int i = 0; i < rsmt.getColumnCount(); i++) {
					System.out.println(rsmt.getColumnLabel(i+1));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.closeResource(conn, ps, res);
		}
		
		
	}
	
}
