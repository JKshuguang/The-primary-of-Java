package com.lambda.day1219;

public class Fun{

	private String string = null;
	
	
	
	public Fun(String string) {
		super();
		this.string = string;
	}



	public  boolean show(String t1) {
		
		return string.endsWith(t1);
	}
	
}
