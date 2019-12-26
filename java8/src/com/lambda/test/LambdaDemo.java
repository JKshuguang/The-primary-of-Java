package com.lambda.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LambdaDemo {
	
	List<Employee> employees = Arrays.asList(
		new Employee("张三", 32, 3333.33),
		new Employee("李四", 23, 4444.33),
		new Employee("王三", 18, 5555.33),
		new Employee("赵六", 56, 6666.33),
		new Employee("孙七", 40, 7777.33),
		new Employee("王八", 66, 8888.33),
		new Employee("小九", 53, 9999.33)
	); 

	//需求，查询年龄大于35的员工
	@Test
	public void test3() {
		List<Employee> list = filterEmployees(employees);
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	public List<Employee> filterEmployees(List<Employee> list){
		
		List<Employee> emps = new ArrayList<Employee>();
		
		for (Employee emp : list) {
			if (emp.getAge() >= 35) {
				emps.add(emp);
			}
		}
		
		return emps;
	}
	
	//优化1: 策略优化模式
	@Test
	public void test4() {
		List<Employee> list = FilterEmployee2(employees, new FilterEmployeeByAge());
		
		for (Employee emp : list) {
			System.out.println(emp);
		}
		
		System.out.println("--------------------------------------");
		
		List<Employee> list2 = FilterEmployee2(employees, new FilterEmployeeBySalary());
		for (Employee emp : list2) {
			System.out.println(emp);
		}
		
	}
	public List<Employee> FilterEmployee2(List<Employee> list,MyPredicate<Employee> mp){
		
		List<Employee> emps = new ArrayList<Employee>();
		
		for (Employee emp : list) {
			if (mp.test(emp)) {
				emps.add(emp);
			}
		}
		
		return emps;
	}
	
	//优化方式二： 匿名内部类
	@Test
	public void test5() {
		
		List<Employee> emps = FilterEmployee2(employees, new MyPredicate<Employee>() {
			
			@Override
			public boolean test(Employee e) {
				
				return e.getSalary() < 5000;
			}
		});
		
		for (Employee emp : emps) {
			System.out.println(emp);
		}
	}
	
	//优化方式三：lambda表达式
	@Test
	public void test6() {
		
		List<Employee> list = FilterEmployee2(employees, (e) -> e.getSalary() >= 5000);
		list.forEach(System.out::println);
	}
	
	
	//优化方式四：Stream
	@Test
	public void test() {
		
		employees.stream()
				 .filter((e) -> e.getSalary() > 5000)
				 .limit(2)//限制前两行
				 .forEach(System.out::println);
		
		System.out.println("---------------------------------------------");
		
		employees.stream()
				 .map(Employee::getName)
				 .forEach(System.out::println);
	}
	
}
