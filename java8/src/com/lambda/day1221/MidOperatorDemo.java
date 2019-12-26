package com.lambda.day1221;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.lambda.day1221.Employee1221.Status;

public class MidOperatorDemo {

	List<Employee1221> employees = Arrays.asList(
			new Employee1221("张三", 23, 3434.1, Status.FREE),
			new Employee1221("李四", 33, 5555.5, Status.BUSY),
			new Employee1221("王五", 21, 8787.5, Status.VOCATION),
			new Employee1221("赵六", 65, 7777.3, Status.FREE),
			new Employee1221("王七", 12, 5655.7, Status.FREE)
			);
	
	
	@Test
	public void test2() {
		
		//自然排序，按照元素实现的 Comparable 排序
		String[] str2 = {"li","bin","qing","jin","xiao","kun"};
		
		Arrays.stream(str2)
			  .sorted()
			  .forEach(System.out::println);
		
	}
	
	
	
	@Test
	public void test() {
		//sorted() 定制排序
		//自己创建一个 comparator 比较器进行排序
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
