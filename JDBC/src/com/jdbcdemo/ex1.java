package com.jdbcdemo;



import java.sql.*;

public class ex1 {

	public static void main(String []args){

	    System.out.println("database example:");

	   Connection conn = null;

	      Statement stmt = null;

	  try{

	     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 

	     String url="jdbc:sqlserver://localhost:1433; DatabaseName=sc"; //sc为数据库名   

	     String user="JIKE";

	     String password="19980402"; // 用户名和密码；

	     conn= DriverManager.getConnection(url,user,password);

	     stmt=conn.createStatement();
	     
	     String sql = "select * from student";

	     ResultSet rs = stmt.executeQuery(sql);
	   

	     while(rs.next())

	     {

	      System.out.println(rs.getString(1)+"  "+ rs.getString(2));
	      
	     }  

	  }catch(Exception ex){

	   System.out.println(ex.toString());

	  }

	  finally{

	   if(stmt!=null){

	    try{

	      stmt.close();	

	    }catch(Exception ex){}    

	   }

	   if(conn!=null){

	    try{

	     conn.close(); 

	    }catch(Exception ex){}    

	   }    

	  }

	  System.out.println("End");

	 }

 

}

