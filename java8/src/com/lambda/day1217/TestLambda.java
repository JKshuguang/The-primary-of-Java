package com.lambda.day1217;

import org.junit.Test;

public class TestLambda {

	@Test
	public void test2() {
		
		//消除两侧空格
		String res = strHandle("     hhjiho hih j   ", (x) -> x.trim());
		System.out.println(res);
		
		//将小写换成大写
		String res2 = strHandle("lbqszz", (str) -> str.toUpperCase());
		System.out.println(res2);
		
		//提取字串
		String res3 = strHandle("woyoudianfan", (str) -> str.substring(0, 5));
		System.out.println(res3);
	}
	
	//得到处理的字符串
	public String strHandle(String str,MyFunction mf) {
		
		return mf.getValue(str);
	}
	
}
