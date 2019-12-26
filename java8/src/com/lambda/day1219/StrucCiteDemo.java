package com.lambda.day1219;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.lambda.test.Employee;

public class StrucCiteDemo {

	
	@Test
	public void test() {
		//�õ��޲ι����µ�Employee
		Supplier<Employee> sup = () -> new Employee();
		Employee emp = sup.get();
		System.out.println(emp);
		
		//�õ�һ��������Employee
		Function<Integer, Employee> fun = (x) -> new Employee(x);
		Employee emp1 = fun.apply(23);
		System.out.println(emp1);
		
		//�õ�һ�������ĵڶ�����ʽ
		Function<Integer, Employee> fun2 = Employee::new;
		Employee emp2 = fun2.apply(34);
		System.out.println(emp2);
		
		//�õ�����������Employee
		BiFunction<Integer, Integer, Employee> bf = Employee::new;
		Employee emp3 = bf.apply(34, 60000);
		System.out.println(emp3);
		
	}
	
}
