package com.lambda.day1217;

import org.junit.Test;

public class TestLambda2 {

	@Test
	public void test() {
		//��
		long num = calculate(100L, 200L, (e1,e2) -> (e1 + e2));
		System.out.println(num);
		
		//��
		long num2 = calculate(100L, 200L, (e1,e2) -> (e1 - e2));
		System.out.println(num2);
		
		//��
		long num3 = calculate(100L, 200L, (e1,e2) -> (e1 * e2));
		System.out.println(num3);
		
		//��
		long num4 = calculate(500L, 200L, (e1,e2) -> (e1/e2));
		System.out.println(num4);
	}
	
	//��������
	public long calculate(Long L1,Long L2,MyFunction2<Long, Long> mf) {
		
		return mf.calculateFun(L1, L2);
	}
	
}
