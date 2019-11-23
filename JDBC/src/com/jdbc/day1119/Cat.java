package com.jdbc.day1119;

public class Cat {
	//±àºÅ
	private int no;
	
	//Ãû×Ö
	private String catName;
	
	//Ã«Æ¤ÑÕÉ«
	private String furColor;
	

	public Cat() {
		super();
	}

	public Cat(int no, String catName, String furColor) {
		super();
		this.no = no;
		this.catName = catName;
		this.furColor = furColor;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

	@Override
	public String toString() {
		return "Cat [no=" + no + ", catName=" + catName + ", furColor=" + furColor + "]";
	}
	
}
