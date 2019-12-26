package com.lambda.test;

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;

public class LambdaDemo2 {
	
	/*�﷨��ʽһ���޲������޷���ֵ
	 * 		() -> lambda��
	 */
	@Test
	public void test() {
		
		//���ڲ���ͬ�ȼ��ı���,jdk1.7�£���Ҫ��final���Σ�1.8֮����Ҫ��Ĭ�ϼ�
		int num = 0;
		
		//����lamdda���ʽ
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello,world!");
				System.out.println(num);
			}
		};
		
		r.run();	
		
		System.out.println("----------------------------------------");
		
		//����lambda���ʽ
		Runnable r1 = () -> System.out.println("Hello,World!");
		//����r1
		r1.run();
		
	}
	
	/*
	 * �﷨��ʽ������һ���������޷���ֵ
	 * ��x�� -> System.out.println(...);
	 */
	@Test
	public void test2() {
		
		Consumer<String> con = (x) -> System.out.println(x);
		con.accept("Hello,World!");
		
		System.out.println("--------------------------");
		//��ֻ��һ������ʱ������ʡ�����ţ����������飩
		
		Consumer<String> con1 = x -> System.out.println(x);
		con.accept("Hello,world!");
	}
	
	/*
	 * �﷨��ʽ�������������ϲ������з���ֵ����lambda���ж������
	 * ��x,y�� -> {   ....;  return ...; }
	 */
	@Test
	public void test3() {
		
		Comparator<Integer> com = (x,y) -> {
			System.out.println("����ʽ�ӿ�");
			return Integer.compare(x, y);
		};
		
		//lambda���н���һ�����ʱ������ʡ�Դ�����
		Comparator<Integer> com2 = (x,y) -> Integer.compare(x, y);
		
	}
	
	/*
	 * �﷨��ʽ�ģ�lambda���ʽ�����б���������Ϳ���ʡ�Բ�д��JVM��ͨ���������жϣ����������ƶϡ�
	 */
	@Test
	public void test4() {
		
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
		
		//�ر�ģ�ָ�������Ļ����͵�ȫ��˵��
		Comparator<Integer> com1 = (Integer x,Integer y) -> Integer.compare(x, y);
	}
	
}

	
