package com.lambda.day1221;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.lambda.day1221.Employee1221.Status;

public class MidOperatorDemo {

	List<Employee1221> employees = Arrays.asList(
			new Employee1221("����", 23, 3434.1, Status.FREE),
			new Employee1221("����", 33, 5555.5, Status.BUSY),
			new Employee1221("����", 21, 8787.5, Status.VOCATION),
			new Employee1221("����", 65, 7777.3, Status.FREE),
			new Employee1221("����", 12, 5655.7, Status.FREE)
			);
	
	
	@Test
	public void test2() {
		
		//��Ȼ���򣬰���Ԫ��ʵ�ֵ� Comparable ����
		String[] str2 = {"li","bin","qing","jin","xiao","kun"};
		
		Arrays.stream(str2)
			  .sorted()
			  .forEach(System.out::println);
		
	}
	
	
	
	@Test
	public void test() {
		//sorted() ��������
		//�Լ�����һ�� comparator �Ƚ�����������
		employees.stream()
				 .sorted((e1,e2) -> {
					if (e1.getAge() == e2.getAge()) {
						return e1.getName().compareTo(e2.getName());
					}else{
						return e1.getAge() - e2.getAge();
					}
				 })
				 .forEach(System.out::println);
	}
	
}
