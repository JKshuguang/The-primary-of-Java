package com.lambda.day1217;

import org.junit.Test;

public class TestLambda2 {

	@Test
	public void test() {
		//加
		long num = calculate(100L, 200L, (e1,e2) -> (e1 + e2));
		System.out.println(num);
		
		//减
		long num2 = calculate(100L, 200L, (e1,e2) -> (e1 - e2));
		System.out.println(num2);
		
		//乘
		long num3 = calculate(100L, 200L, (e1,e2) -> (e1 * e2));
		System.out.println(num3);
		
		//除
		long num4 = calculate(500L, 200L, (e1,e2) -> (e1/e2));
		System.out.println(num4);
	}
	
	//进行运算
	public long calculate(Long L1,Long L2,MyFunction2<Long, Long> mf) {
		
		return mf.calculateFun(L1, L2);
	}
	
}
