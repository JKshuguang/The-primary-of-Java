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
			new Employee1221("����", 23, 3434.1, Status.FREE),
			new Employee1221("����", 33, 5555.5, Status.BUSY),
			new Employee1221("����", 21, 8787.5, Status.VOCATION),
			new Employee1221("����", 65, 7777.3, Status.FREE),
			new Employee1221("����", 12, 5655.7, Status.FREE)
			);
	
	/*
	 * ��Լ�� reduce(T identity,BinaryOperator) / reduce(Binary Operator)
	 * ���Խ�����Ԫ�ط�������������õ�һ��ֵ
	 */
	@Test
	public void test1() {
		//BinaryOperator �Ǽ̳� BiFunction<T,T,T> ��
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		//��Լ
		Integer sum = list.stream()
						  .reduce(0, (x,y) -> x+y);
		System.out.println(sum);
	}
	
	/*
	 * �ռ��� Collectq----����ת����������ʽ������һ�� Collector �Ľӿ�ʵ�֣����ڸ� stream �е�Ԫ�������ܵķ���
	 */
	@Test
	public void test2() {
		
		//��Ա�������ռ���һ�� list
		List<String> list = employees.stream()
									 .map(Employee1221::getName)
									 .collect(Collectors.toList());
		list.forEach(System.out::println);
									 	
		System.out.println("---------------------------");
		
		//��Ա�������ռ���һ�� set
		Set<String> set = employees.stream()
								   .map(Employee1221::getName)
								   .collect(Collectors.toSet());
		set.forEach(System.out::println);
		
		System.out.println("----------------------------");
		
		//��Ա�������ռ���һ�� ָ��������
		HashSet<String> hset = employees.stream()
									    .map(Employee1221::getName)
									    .collect(Collectors.toCollection(HashSet :: new));
		hset.forEach(System.out::println);
	}

	/*
	 * ���õ� Collect ����
	 */
	@Test
	public void test3() {
		//�õ�����
		Long count = employees.stream()
				.collect(Collectors.counting());
		System.out.println(count);
		
		//�õ�ƽ��ֵ
		Double ave = employees.stream()
				.collect(Collectors.averagingDouble(Employee1221::getSalary));
		System.out.println(ave);
		
		//�ܺ�
		Double sum = employees.stream()
				.collect(Collectors.summingDouble(Employee1221::getSalary));
		System.out.println(sum);
		
		//���ֵ
		Optional<Employee1221> op= employees.stream()
				 .collect(Collectors.maxBy((e1,e2) -> Integer.compare(e1.getAge(),e2.getAge())));
		System.out.println(op.get());
		
		//��Сֵ
		Optional<Double> op2 = employees.stream()
				.map(Employee1221::getSalary)
				.collect(Collectors.minBy(Double::compare));	//Double �����Ѿ�ʵ�ֵľ�̬ compare ����
		System.out.println(op2.get());
	}
	
	//����
	@Test
	public void test4() {
		Map<Status, List<Employee1221>> map = employees.stream()
				.collect(Collectors.groupingBy(Employee1221::getStatus));
		
		//���� map
		for (Map.Entry<Status, List<Employee1221>> emp : map.entrySet()) {
			System.out.println("The elements belong key " + emp.getKey());
			emp.getValue().forEach(System.out::println);
			System.out.println();
		}
		
	}
	
	//�༶����
	public void test5() {
		Map<Status, Map<String, List<Employee1221>>> map = employees.stream()
				.collect(Collectors.groupingBy(Employee1221::getStatus, Collectors.groupingBy((e) -> {
					if (e.getAge() < 35) {
						return "����";
					}else if (e.getAge() < 60) {
						return "����";
					}else {
						return "����";
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
	
	//����
	@Test
	public void test6() {
		Map<Boolean, List<Employee1221>> map = employees.stream()
				.collect(Collectors.partitioningBy((e) -> e.getSalary()>6000));
		for (Map.Entry<Boolean, List<Employee1221>> emps : map.entrySet()) {
			System.out.println("-------" + emps.getKey() + "----------");
			emps.getValue().forEach(System.out::println);
		}
	}
	
	//����
	@Test
	public void test7() {
		//����
		String str = employees.stream()
				.map(Employee1221::getName)
				.collect(Collectors.joining(",","#","#")); //��һ�����������Ӽ���ַ����������ֱ����λ�ַ�������ʥ��
		System.out.println(str);
		
	}
	
	//�ռ�
	@Test
	public void test8() {
		DoubleSummaryStatistics dss = employees.stream()
				.collect(Collectors.summarizingDouble(Employee1221::getSalary));
		
		//�õ�����
		System.out.println(dss.getSum());
		
		//�õ����
		System.out.println(dss.getMax());
		
		//�õ���С
		System.out.println(dss.getMin());
		
	}
}
