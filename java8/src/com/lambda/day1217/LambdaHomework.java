package com.lambda.day1217;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.lambda.test.Employee;

public class LambdaHomework {

	List<Employee> employees = Arrays.asList(
			new Employee("张三", 32, 3333.33),
			new Employee("李四", 23, 4444.33),
			new Employee("王三", 18, 5555.33),
			new Employee("赵六", 56, 6666.33),
			new Employee("孙七", 40, 7777.33),
			new Employee("王八", 66, 8888.33),
			new Employee("小九", 53, 9999.33)
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
