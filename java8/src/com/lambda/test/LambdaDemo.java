package com.lambda.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LambdaDemo {
	
	List<Employee> employees = Arrays.asList(
		new Employee("����", 32, 3333.33),
		new Employee("����", 23, 4444.33),
		new Employee("����", 18, 5555.33),
		new Employee("����", 56, 6666.33),
		new Employee("����", 40, 7777.33),
		new Employee("����", 66, 8888.33),
		new Employee("С��", 53, 9999.33)
	); 

	//���󣬲�ѯ�������35��Ա��
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
	
	//�Ż�1: �����Ż�ģʽ
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
	
	//�Ż���ʽ���� �����ڲ���
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
	
	//�Ż���ʽ����lambda���ʽ
	@Test
	public void test6() {
		
		List<Employee> list = FilterEmployee2(employees, (e) -> e.getSalary() >= 5000);
		list.forEach(System.out::println);
	}
	
	
	//�Ż���ʽ�ģ�Stream
	@Test
	public void test() {
		
		employees.stream()
				 .filter((e) -> e.getSalary() > 5000)
				 .limit(2)//����ǰ����
				 .forEach(System.out::println);
		
		System.out.println("---------------------------------------------");
		
		employees.stream()
				 .map(Employee::getName)
				 .forEach(System.out::println);
	}
	
}
