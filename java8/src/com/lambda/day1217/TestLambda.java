package com.lambda.day1217;

import org.junit.Test;

public class TestLambda {

	@Test
	public void test2() {
		
		//��������ո�
		String res = strHandle("     hhjiho hih j   ", (x) -> x.trim());
		System.out.println(res);
		
		//��Сд���ɴ�д
		String res2 = strHandle("lbqszz", (str) -> str.toUpperCase());
		System.out.println(res2);
		
		//��ȡ�ִ�
		String res3 = strHandle("woyoudianfan", (str) -> str.substring(0, 5));
		System.out.println(res3);
	}
	
	//�õ�������ַ���
	public String strHandle(String str,MyFunction mf) {
		
		return mf.getValue(str);
	}
	
}
