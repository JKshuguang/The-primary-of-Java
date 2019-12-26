package com.lambda.day1222;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.lambda.day1221.Employee1221;
import com.lambda.day1221.Employee1221.Status;

public class TerminalOperationDemo {
	
	List<Employee1221> employees = Arrays.asList(
			new Employee1221("张三", 23, 3434.1, Status.FREE),
			new Employee1221("李四", 33, 5555.5, Status.BUSY),
			new Employee1221("王五", 21, 8787.5, Status.VOCATION),
			new Employee1221("赵六", 65, 7777.3, Status.FREE),
			new Employee1221("王七", 12, 5655.7, Status.FREE)
			);
	
	@Test
	public void test() {
		
		//allMatch ----- 是否匹配所有元素
		//是否所有员工都是 BUSY 状态
		boolean b1 = employees.stream()
							  .allMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b1);
		
		//anyMatch ----- 是否至少匹配一个元素
		//是否有一个员工处于 BUSY 状态
		boolean b2 = employees.stream()
							  .anyMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b2);
		
		//noneMatch ---- 是否没有匹配所有元素
		//是否所有员工都处于 VOCATION 状态
		boolean b3 = employees.stream()
							  .noneMatch((e) -> e.getStatus().equals(Status.VOCATION));
		System.out.println(b3);
		
		Optional<Employee1221> op1 = null;
		//findFirst ---- 得到第一个元素
		//得到工资最高的员工
			op1 = employees.stream()
						   .sorted((e1,e2) -> -Double.compare(e1.getSalary(), e2.getSalary()))
						   .findFirst();
			System.out.println(op1.get());
			
		//findAny --- 返回当前流中的任意元素
		//得到任意一个处于 FREE 的员工
			op1 = employees.parallelStream()	//并行查找流
						   .filter((e) -> e.getStatus().equals(Status.FREE))
						   .findAny();
			System.out.println(op1.get());
			
		//count ----- 返回流中元素的总个数
			long count = employees.stream()
								  .count();
			System.out.println(count);
			
			Optional<Employee1221> op = null;
		//max ------ 返回流中最大值
			//返回年龄最大的员工（传递 Comparator 比较器）
			op = employees.stream()
						  .max((e1,e2) -> Integer.compare(e1.getAge(), e2.getAge()));
			System.out.println(op.get());
			
		//min ------ 返回流中最小值
			//返回年龄最小的员工
			op = employees.stream()
						  .min((e1,e2) -> Integer.compare(e1.getAge(), e2.getAge()));
			System.out.println(op.get());
		
			System.out.println("------");
		//得到公司最小工资

			int a = employees.stream()
					.min((e1,e2) -> Integer.compare(e1.getAge(), e2.getAge()))
					.map(Employee1221::getAge)
					.get();
					
			
					
		
		System.out.println(a);
	}
}
