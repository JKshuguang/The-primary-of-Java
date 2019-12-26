package com.lambda.day1219;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

import org.junit.Test;

public class FunctionCiteDemo {
	


	/*
	 * 对象：：实例方法名
	 */
	@Test
	public void test() {
		
		PrintStream ps = System.out;
		Consumer<String> con = null;
		
		//形式一
		con = (x) -> System.out.println(x);
		con.accept("form_1");
		
		//形式二
		con = (x) -> ps.println(x);
		con.accept("form_2");
		
		//形式三
		con = System.out::println;
		con.accept("form_3");
		
		//形式四
		con = ps::println;
		con.accept("form_4");

	}
	
	/*
	 * 类：：静态方法名
	 */
	@Test
	public void test2() {
		
		//形式一
		Comparator<Integer> cp1 = (x,y) -> Integer.compare(x, y);
		System.out.println(cp1.compare(3, 5));
		
		//形式二
		Comparator<Integer> cp2 = Integer::compare;
		System.out.println(cp2.compare(34, 34));
	}
	
	/*
	 * 类：：实力方法名
	 */
	@Test
	public void test3() {
		
		//形式一
		BiPredicate<String, String> bp = (x,y) -> x.equals(y);
		System.out.println(bp.test("sss", "sss"));
		
		//形式二
		BiPredicate<String, String> bp2 = String::equals;
		System.out.println(bp2.test("ddd", "aaa"));
	}
	
}
