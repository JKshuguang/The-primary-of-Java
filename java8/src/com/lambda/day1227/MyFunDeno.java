package com.lambda.day1227;

import org.junit.Test;

public class MyFunDeno implements A,B{
	@Test
	public void test() {
		MyFunDeno mf = new MyFunDeno();
		System.out.println(mf.show());		
	}
	@Override
	public String show() {
		// ÖØÐ´ A ·½·¨
		return A.super.show();
	}
	
	@Test
	public void test2() {
		A.groan();
	}
}
