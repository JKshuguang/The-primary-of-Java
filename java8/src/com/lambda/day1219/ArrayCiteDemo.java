package com.lambda.day1219;

import java.util.function.Function;

import org.junit.Test;

public class ArrayCiteDemo {

	@Test
	public void test() {
		//��ʽһ
		Function<Integer, String[]> fun = (x) -> new String[x];
		String[] newStrs = fun.apply(9);
		System.out.println(newStrs.length);
		
		//��ʽ��
		Function<Integer, String[]> fun2 = String[]::new;
		String[] newStrs2 = fun2.apply(29);
		System.out.println(newStrs2.length);
		

	}

	
	
}
