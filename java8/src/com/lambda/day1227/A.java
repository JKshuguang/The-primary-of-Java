package com.lambda.day1227;

public interface A {
	default String show() {
		return "A Method";
	}
		public static void groan() {
		System.out.println("wow~");
	}
}
