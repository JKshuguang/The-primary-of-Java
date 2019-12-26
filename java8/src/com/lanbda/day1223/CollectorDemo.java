package com.lanbda.day1223;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.lambda.day1221.Employee1221;
import com.lambda.day1221.Employee1221.Status;

public class CollectorDemo {
	
	List<Employee1221> employees = Arrays.asList(
			new Employee1221("张三", 23, 3434.1, Status.FREE),
			new Employee1221("李四", 33, 5555.5, Status.BUSY),
			new Employee1221("王五", 21, 8787.5, Status.VOCATION),
			new Employee1221("赵六", 65, 7777.3, Status.FREE),
			new Employee1221("王七", 12, 5655.7, Status.FREE)
			);
	
	/*
	 * 归约： reduce(T identity,BinaryOperator) / reduce(Binary Operator)
	 * 可以将流中元素反复结合起来，得到一个值
	 */
	@Test
	public void test1() {
		//BinaryOperator 是继承 BiFunction<T,T,T> 的
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		//归约
		Integer sum = list.stream()
						  .reduce(0, (x,y) -> x+y);
		System.out.println(sum);
	}
	
	/*
	 * 收集： Collectq----将流转化成其他形式。接收一个 Collector 的接口实现，用于给 stream 中的元素做汇总的方法
	 */
	@Test
	public void test2() {
		
		//将员工名字收集成一个 list
		List<String> list = employees.stream()
									 .map(Employee1221::getName)
									 .collect(Collectors.toList());
		list.forEach(System.out::println);
									 	
		System.out.println("---------------------------");
		
		//将员工名字收集成一个 set
		Set<String> set = employees.stream()
								   .map(Employee1221::getName)
								   .collect(Collectors.toSet());
		set.forEach(System.out::println);
		
		System.out.println("----------------------------");
		
		//将员工名字收集成一个 指定的容器
		HashSet<String> hset = employees.stream()
									    .map(Employee1221::getName)
									    .collect(Collectors.toCollection(HashSet :: new));
		hset.forEach(System.out::println);
	}

	/*
	 * 常用的 Collect 操作
	 */
	@Test
	public void test3() {
		//得到总数
		Long count = employees.stream()
				.collect(Collectors.counting());
		System.out.println(count);
		
		//得到平均值
		Double ave = employees.stream()
				.collect(Collectors.averagingDouble(Employee1221::getSalary));
		System.out.println(ave);
		
		//总和
		Double sum = employees.stream()
				.collect(Collectors.summingDouble(Employee1221::getSalary));
		System.out.println(sum);
		
		//最大值
		Optional<Employee1221> op= employees.stream()
				 .collect(Collectors.maxBy((e1,e2) -> Integer.compare(e1.getAge(),e2.getAge())));
		System.out.println(op.get());
		
		//最小值
		Optional<Double> op2 = employees.stream()
				.map(Employee1221::getSalary)
				.collect(Collectors.minBy(Double::compare));	//Double 类张已经实现的静态 compare 方法
		System.out.println(op2.get());
	}
	
	//分组
	@Test
	public void test4() {
		Map<Status, List<Employee1221>> map = employees.stream()
				.collect(Collectors.groupingBy(Employee1221::getStatus));
		
		//遍历 map
		for (Map.Entry<Status, List<Employee1221>> emp : map.entrySet()) {
			System.out.println("The elements belong key " + emp.getKey());
			emp.getValue().forEach(System.out::println);
			System.out.println();
		}
		
	}
	
	//多级分组
	public void test5() {
		Map<Status, Map<String, List<Employee1221>>> map = employees.stream()
				.collect(Collectors.groupingBy(Employee1221::getStatus, Collectors.groupingBy((e) -> {
					if (e.getAge() < 35) {
						return "青年";
					}else if (e.getAge() < 60) {
						return "中年";
					}else {
						return "老年";
					}
				})));
		System.out.println(map);
//		for (Map.Entry<Status, Map<String, List<Employee1221>>> emps1 : map.entrySet()) {
//			System.out.println(emps1);
////			System.out.println("The Group " + emps1.getKey() + " as flow");
////			for (Map.Entry<String, List<Employee1221>> emps2 : emps1.getValue().entrySet()) {
////				System.out.println("---The group belong " + emps2.getKey());
////				emps2.getValue().forEach(System.out::println);
////				
////			}
//		}
	}
	
	//分区
	@Test
	public void test6() {
		Map<Boolean, List<Employee1221>> map = employees.stream()
				.collect(Collectors.partitioningBy((e) -> e.getSalary()>6000));
		for (Map.Entry<Boolean, List<Employee1221>> emps : map.entrySet()) {
			System.out.println("-------" + emps.getKey() + "----------");
			emps.getValue().forEach(System.out::println);
		}
	}
	
	//连接
	@Test
	public void test7() {
		//连接
		String str = employees.stream()
				.map(Employee1221::getName)
				.collect(Collectors.joining(",","#","#")); //第一个参数是连接间的字符，二三个分别的首位字符，都可圣洛
		System.out.println(str);
		
	}
	
	//收集
	@Test
	public void test8() {
		DoubleSummaryStatistics dss = employees.stream()
				.collect(Collectors.summarizingDouble(Employee1221::getSalary));
		
		//得到总数
		System.out.println(dss.getSum());
		
		//得到最大
		System.out.println(dss.getMax());
		
		//得到最小
		System.out.println(dss.getMin());
		
	}
}
