package com.lambda.day1220;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.lambda.test.Employee;

public class StreamDemo {

	List<Employee> employees = Arrays.asList(
			new Employee("����", 32, 3333.33),
			new Employee("����", 23, 4444.33),
			new Employee("����", 18, 5555.33),
			new Employee("����", 18, 5555.33),
			new Employee("����", 18, 5555.33),
			new Employee("����", 40, 6666.33),
			new Employee("����", 40, 7777.33),
			new Employee("����", 66, 8888.33),
			new Employee("С��", 66, 9999.33)
		); 
	
	//����һ��Stream�ķ�ʽ
	@Test
	public void test() {
		
		//�õ�Stream���ĸ���ʽ
		//��ʽһ��ͨ��Connection �õ�Stram
		Stream<Employee> stream = employees.stream();
		stream.filter((emp) -> emp.getSalary() < 6000)
			  .map(Employee::getName)
			  .forEach(System.out::println);
		
		//��ʽ����ͨ��Arrays���еľ�̬����Stream��ȡ������
		String[] strs = {"wo","you","dian","fan","a"};
		Stream<String> stream2 = Arrays.stream(strs);
		stream2.map((str) -> str.toUpperCase())
			   .forEach(System.out::println);
		
		//��ʽ����ͨ��Stream���еľ�̬����of�õ�
		Stream<String> stream3 = Stream.of("wo","jue","de","ni","bu","ting","hua");
		stream3.map((str) -> str.toUpperCase())
			   .forEach(System.out::println);
		
		//��ʽ�ģ�����������
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x+2);
		stream4.limit(20).forEach(System.out::println);
	}
	
	//Stream���м����
	@Test
	public void test2() {
		employees.stream()
				 .filter((emp) -> emp.getAge() < 34)
				 .limit(2)
				 .skip(2)
				 .distinct()
				 .forEach(System.out::println);
	}
	
}
