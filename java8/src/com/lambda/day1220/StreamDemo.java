package com.lambda.day1220;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.lambda.test.Employee;

public class StreamDemo {

	List<Employee> employees = Arrays.asList(
			new Employee("张三", 32, 3333.33),
			new Employee("李四", 23, 4444.33),
			new Employee("李四", 18, 5555.33),
			new Employee("李四", 18, 5555.33),
			new Employee("李四", 18, 5555.33),
			new Employee("赵六", 40, 6666.33),
			new Employee("孙七", 40, 7777.33),
			new Employee("王八", 66, 8888.33),
			new Employee("小九", 66, 9999.33)
		); 
	
	//创建一个Stream的方式
	@Test
	public void test() {
		
		//得到Stream的四个方式
		//方式一：通过Connection 得到Stram
		Stream<Employee> stream = employees.stream();
		stream.filter((emp) -> emp.getSalary() < 6000)
			  .map(Employee::getName)
			  .forEach(System.out::println);
		
		//方式二：通过Arrays类中的静态方法Stream获取数组流
		String[] strs = {"wo","you","dian","fan","a"};
		Stream<String> stream2 = Arrays.stream(strs);
		stream2.map((str) -> str.toUpperCase())
			   .forEach(System.out::println);
		
		//方式三：通过Stream类中的静态方法of得到
		Stream<String> stream3 = Stream.of("wo","jue","de","ni","bu","ting","hua");
		stream3.map((str) -> str.toUpperCase())
			   .forEach(System.out::println);
		
		//方式四：创建无限流
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x+2);
		stream4.limit(20).forEach(System.out::println);
	}
	
	//Stream的中间操作
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
