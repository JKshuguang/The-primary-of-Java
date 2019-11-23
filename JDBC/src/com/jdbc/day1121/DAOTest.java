package com.jdbc.day1121;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jdbc.day1119.Cat;
import com.jdbc.day1119.Employee;


class DAOTest {

	DAO dao = new DAO();
	
	@Test
	void testUpdate() {
		String sql = null;
//		sql = "insert into employee(no,name,ID_Card,year_Salary) "
//				+ "values(?,?,?,?)";
//		dao.update(sql, 3,"JXK","5202021998",33333.4);
		
		sql = "Delete  from employee where name = ?";
		dao.update(sql, "JXK");
	}

	@Test
	void testGet() {
		
		String sql = "select no,name,ID_Card IDCard,year_Salary yearSalary "
				+ "from employee where no = ?";
		
		Employee employee = dao.get(Employee.class, sql, 1);
		System.out.println(employee);
		
		String sql2 = "Select no,cat_Name catName,fur_Color furColor "
				+ "from cat where no = ?";
		Cat cat = dao.get(Cat.class, sql2, 1);
		System.out.println(cat);
	}

	@Test
	void testGetList() {
		List<Employee> list = null;
		
		String sql = "select no,name,ID_Card IDCard,year_Salary yearSalary "
				+ "from employee";
		
		list = dao.getList(Employee.class, sql);
		
		System.out.println(list);
	}

	@Test
	void testGetValue() {
		String sql = "select year_Salary yearSalary "
				+ "from employee where no = ?";
		double salary = dao.getValue(sql, 2);
		System.out.println(salary);
	}

}
