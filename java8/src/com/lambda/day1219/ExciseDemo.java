package com.lambda.day1219;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

import com.lambda.test.Employee;

public class ExciseDemo {

	@Test
	public void test() {
		//消费型接口 花钱例子
		Consumer<Integer> coms = (x) -> System.out.println("buy gift to girlfriend waste " + x + " dollers");
		coms.accept(1000);
		
		System.out.println("----------------------");
		
		//供给型接口 得到10个随机数
		Supplier<List<Integer>> getList = () -> {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < 10; i++) {
				list.add((int)(Math.random()*100));
			}
			return list;
		};
		
		List<Integer> list = getList.get();
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
		//函数型接口 得到大写字符串
		Function<String, String> fun = (x) -> x.toUpperCase();
		String newStr = fun.apply("lbqkuaililiwo");
		System.out.println(newStr);
		
		//预测型接口 判断是否大于100
		Predicate<Integer> pre = (x) -> x>100;
		boolean isTrue = pre.test(10);
		System.out.println(isTrue);
	}
	
	@Test
	public void test2() {
		//对象：：方法名
		PrintStream ps = System.out;
		Consumer<String> cons = (x) -> System.out.println(x);
		cons.accept("Hello,world!");
		Consumer<String> cons1 = System.out::println;
		cons1.accept("you can really dance");
		Consumer<String> cons2 = ps::println;
		cons2.accept("although embrow can not reservertion");
		
	}
	
	@Test
	public void test3() {
		Comparator<Integer> con = Integer::compare;
		System.out.println(con.compare(34, 45));
		
		BiPredicate<String, String> bp = String::equals;

	}
	
	@Test
	public void test4() {
		
		Supplier<Employee> sup = Employee::new;
		System.out.println(sup.get());
		
		Function<Integer, Employee> fun = Employee::new;
		System.out.println(fun.apply(34));
		
		BiFunction<Integer, Integer, Employee> fun2 = Employee::new;
		System.out.println(fun2.apply(23, 2323232));
		
		Function<Integer, String[]> fun3 = String[]::new;
		System.out.println(fun3.apply(34).length);
	}
	
}
