package com.jdbc.day1118;

public class PreparedStagementDemo {

	public static void main(String[] args) {

		System.out.println("DateBase:");
	
			String sql2 = "insert into student(name,age) values (?,?)";
			
			JDBCTools.update2(sql2);

		
		System.out.println("End");
	}

}
