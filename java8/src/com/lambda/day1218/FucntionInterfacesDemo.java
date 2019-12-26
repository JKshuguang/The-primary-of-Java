package com.lambda.day1218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

public class FucntionInterfacesDemo {

	/*
	 * Consumer<T> : 消费型接口
	 * void accept(T t);
	 */
	@Test
	public void test() {
		consumeActivity(1000.0, (m) -> System.out.println("教育投资：" + m));
		consumeActivity(2000.0, (m) -> System.out.println("情感投资：" + m));
	}
	
	public void consumeActivity(Double money,Consumer<Double> con) {
		
		con.accept(money);
	}
	
	
	/*
	 * 供给型接口：Suppliter<T>
	 * 	T get()
	 */
	@Test
	public void test2() {
		
		//得到随机数
		List<Integer> list = getIntegers(19, () -> (int)(Math.random()*100));
		for (Integer inte : list) {
			System.out.println(inte);
		}

		
	}
	
	//得到指定数量随机数
	public List<Integer> getIntegers(int num,Supplier<Integer> sup){
		//保存随机数
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < num; i++) {
			Integer e = sup.get();
			list.add(e);
		}
		
		return list;
	}
	
	
	/*
	 * 函数型接口：Function<T,R>
	 * 		R apply(T t)
	 */
	@Test
	public void test3() {
		//得到字符串长度
		int length = 0;
		length = getStrLenth("lbqsdd", (str) -> str.length());
		System.out.println(length);
		
		//转换字符串成大写
		String newStr = strHandle("lbqsdd", (str) -> str.toUpperCase());
		System.out.println(newStr);
	}
	
	//输入字符串得到长度
	public int getStrLenth(String str,Function<String, Integer> fun) {
		return fun.apply(str);
	}
	
	//处理字符串
	public String strHandle(String str,Function<String, String> fun) {
		return fun.apply(str);
	}
	
	/*
	 * 断言型接口：Predicate<T> 
	 * 		boolean test(T t);
	 */
	@Test
	public void test4() {
		
		List<String> list = Arrays.asList("jinxiaokun","libingqing","jiayou","haha","ye","dda");
		
		//过滤长度小于五的
		List<String> newList = filterString(list, (str) -> str.length() > 5);
		for (String str : newList) {
			System.out.println(str);
		}
		
		System.out.println("----------------------------------------------");
		
		//过滤出以“a”结尾的
		List<String> newList2 = filterString(list, (str) -> str.endsWith("a"));
		for (String str : newList2) {
			System.out.println(str);
		}
	}
	
	//按照指定要求过滤字符串
	public List<String> filterString(List<String> list,Predicate<String> pre){
		//创建一个集合
		List<String> newList = new ArrayList<String>();
		
		for (String str : list) {
			if (pre.test(str)) {
				newList.add(str);
			}
		}
		
		return newList;
	}
	
	
}













