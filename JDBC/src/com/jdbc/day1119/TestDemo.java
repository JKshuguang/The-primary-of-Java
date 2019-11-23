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
		
		//����
//		 Class<?> forname = Class.forName("com.jdbc.day1119.Cat");
//		 Cat cat = (Cat) forname.newInstance();
//		 
//		System.out.println("���乹������"+cat);
//		
//		Field field = forname.getDeclaredField("catName");
//		System.out.println("��ȡ�����ֶΣ�"+field);
//		
//		Field[] fieds = forname.getDeclaredFields();
//		for (int i = 0; i < fieds.length; i++) {
//			System.out.println(fieds[i]);
//		}
//		
//		field.setAccessible(true);
//		field.set(cat, "hh");
//		System.out.println(cat);
		
		//����
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
			
			//׼��SQL
			String sql = "select no,name,ID_Card IDCard,year_Salary yearSalary "
					+ "from employee where no = 1";
			
			//�õ�׼���õ����
			ps = conn.prepareStatement(sql);
			
			//ִ�в���
			res = ps.executeQuery();
			
			//�������ϴ洢��ֵ��
			Map<String, Object> map = new HashMap<String, Object>();
			
			//�õ�ResultSetMetaData����
			ResultSetMetaData rsmd = res.getMetaData();
			
			//������ҽ��
			while(res.next()) {
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					//�õ����������
					String columbLabel = rsmd.getColumnLabel(i+1);
					
					//�õ���Ӧ�������ֵ
					Object columnValue = res.getObject(i+1);
					
					System.out.println(columbLabel+" : " + columnValue);
					
					//�������ֵ�����ֵ��
					map.put(columbLabel, columnValue);
				}
			}
			
			//��ӡmap
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
