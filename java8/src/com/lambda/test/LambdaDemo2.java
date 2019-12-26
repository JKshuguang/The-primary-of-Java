package com.lambda.test;

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;

public class LambdaDemo2 {
	
	/*语法格式一：无参数，无返回值
	 * 		() -> lambda体
	 */
	@Test
	public void test() {
		
		//与内部类同等级的变量,jdk1.7下，需要加final修饰，1.8之后不需要，默认加
		int num = 0;
		
		//不用lamdda表达式
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello,world!");
				System.out.println(num);
			}
		};
		
		r.run();	
		
		System.out.println("----------------------------------------");
		
		//运用lambda表达式
		Runnable r1 = () -> System.out.println("Hello,World!");
		//运行r1
		r1.run();
		
	}
	
	/*
	 * 语法格式二：有一个参数，无返回值
	 * （x） -> System.out.println(...);
	 */
	@Test
	public void test2() {
		
		Consumer<String> con = (x) -> System.out.println(x);
		con.accept("Hello,World!");
		
		System.out.println("--------------------------");
		//当只有一个参数时，可以省略括号（但并不建议）
		
		Consumer<String> con1 = x -> System.out.println(x);
		con.accept("Hello,world!");
	}
	
	/*
	 * 语法格式三：有两个以上参数，有返回值，且lambda中有多条语句
	 * （x,y） -> {   ....;  return ...; }
	 */
	@Test
	public void test3() {
		
		Comparator<Integer> com = (x,y) -> {
			System.out.println("函数式接口");
			return Integer.compare(x, y);
		};
		
		//lambda体中仅有一条语句时，可以省略大括号
		Comparator<Integer> com2 = (x,y) -> Integer.compare(x, y);
		
	}
	
	/*
	 * 语法格式四：lambda表达式参数列表的数据类型可以省略不写，JVM会通过上下文判断，即“类型推断”
	 */
	@Test
	public void test4() {
		
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
		
		//特别的，指明参数的话，就得全部说明
		Comparator<Integer> com1 = (Integer x,Integer y) -> Integer.compare(x, y);
	}
	
}

	
