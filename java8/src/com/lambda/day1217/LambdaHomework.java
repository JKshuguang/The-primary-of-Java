package com.lambda.day1217;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.lambda.test.Employee;

public class LambdaHomework {

	List<Employee> employees = Arrays.asList(
			new Employee("����", 32, 3333.33),
			new Employee("����", 23, 4444.33),
			new Employee("����", 18, 5555.33),
			new Employee("����", 56, 6666.33),
			new Employee("����", 40, 7777.33),
			new Employee("����", 66, 8888.33),
			new Employee("С��", 53, 9999.33)
		); 

	@Test
	public void test() {
		
		Collections.sort(employees,(e1,e2) -> {
			if(e1.getAge() == e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			}else {
				return -Integer.compare(e1.getAge(),e2.getAge());
			}
		});
		
		for (Employee emp : employees) {
			System.out.println(emp);
		}
		
	}
	

	
	
}
