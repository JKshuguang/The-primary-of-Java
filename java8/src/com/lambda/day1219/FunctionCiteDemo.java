package com.lambda.day1219;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

import org.junit.Test;

public class FunctionCiteDemo {
	


	/*
	 * ���󣺣�ʵ��������
	 */
	@Test
	public void test() {
		
		PrintStream ps = System.out;
		Consumer<String> con = null;
		
		//��ʽһ
		con = (x) -> System.out.println(x);
		con.accept("form_1");
		
		//��ʽ��
		con = (x) -> ps.println(x);
		con.accept("form_2");
		
		//��ʽ��
		con = System.out::println;
		con.accept("form_3");
		
		//��ʽ��
		con = ps::println;
		con.accept("form_4");

	}
	
	/*
	 * �ࣺ����̬������
	 */
	@Test
	public void test2() {
		
		//��ʽһ
		Comparator<Integer> cp1 = (x,y) -> Integer.compare(x, y);
		System.out.println(cp1.compare(3, 5));
		
		//��ʽ��
		Comparator<Integer> cp2 = Integer::compare;
		System.out.println(cp2.compare(34, 34));
	}
	
	/*
	 * �ࣺ��ʵ��������
	 */
	@Test
	public void test3() {
		
		//��ʽһ
		BiPredicate<String, String> bp = (x,y) -> x.equals(y);
		System.out.println(bp.test("sss", "sss"));
		
		//��ʽ��
		BiPredicate<String, String> bp2 = String::equals;
		System.out.println(bp2.test("ddd", "aaa"));
	}
	
}
