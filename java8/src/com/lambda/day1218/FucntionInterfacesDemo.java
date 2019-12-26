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
	 * Consumer<T> : �����ͽӿ�
	 * void accept(T t);
	 */
	@Test
	public void test() {
		consumeActivity(1000.0, (m) -> System.out.println("����Ͷ�ʣ�" + m));
		consumeActivity(2000.0, (m) -> System.out.println("���Ͷ�ʣ�" + m));
	}
	
	public void consumeActivity(Double money,Consumer<Double> con) {
		
		con.accept(money);
	}
	
	
	/*
	 * �����ͽӿڣ�Suppliter<T>
	 * 	T get()
	 */
	@Test
	public void test2() {
		
		//�õ������
		List<Integer> list = getIntegers(19, () -> (int)(Math.random()*100));
		for (Integer inte : list) {
			System.out.println(inte);
		}

		
	}
	
	//�õ�ָ�����������
	public List<Integer> getIntegers(int num,Supplier<Integer> sup){
		//���������
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < num; i++) {
			Integer e = sup.get();
			list.add(e);
		}
		
		return list;
	}
	
	
	/*
	 * �����ͽӿڣ�Function<T,R>
	 * 		R apply(T t)
	 */
	@Test
	public void test3() {
		//�õ��ַ�������
		int length = 0;
		length = getStrLenth("lbqsdd", (str) -> str.length());
		System.out.println(length);
		
		//ת���ַ����ɴ�д
		String newStr = strHandle("lbqsdd", (str) -> str.toUpperCase());
		System.out.println(newStr);
	}
	
	//�����ַ����õ�����
	public int getStrLenth(String str,Function<String, Integer> fun) {
		return fun.apply(str);
	}
	
	//�����ַ���
	public String strHandle(String str,Function<String, String> fun) {
		return fun.apply(str);
	}
	
	/*
	 * �����ͽӿڣ�Predicate<T> 
	 * 		boolean test(T t);
	 */
	@Test
	public void test4() {
		
		List<String> list = Arrays.asList("jinxiaokun","libingqing","jiayou","haha","ye","dda");
		
		//���˳���С�����
		List<String> newList = filterString(list, (str) -> str.length() > 5);
		for (String str : newList) {
			System.out.println(str);
		}
		
		System.out.println("----------------------------------------------");
		
		//���˳��ԡ�a����β��
		List<String> newList2 = filterString(list, (str) -> str.endsWith("a"));
		for (String str : newList2) {
			System.out.println(str);
		}
	}
	
	//����ָ��Ҫ������ַ���
	public List<String> filterString(List<String> list,Predicate<String> pre){
		//����һ������
		List<String> newList = new ArrayList<String>();
		
		for (String str : list) {
			if (pre.test(str)) {
				newList.add(str);
			}
		}
		
		return newList;
	}
	
	
}













