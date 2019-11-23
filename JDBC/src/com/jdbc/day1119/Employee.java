package com.jdbc.day1119;

public class Employee {
	//编号
	private int no;
	
	//姓名
	private String name;
	
	//身份证
	private String IDCard;
	
	//年度工资
	private double yearSalary;
	

	public Employee() {
		super();
	}

	public Employee(int no, String name, String iDCard, double yearSalary) {
		super();
		this.no = no;
		this.name = name;
		IDCard = iDCard;
		this.yearSalary = yearSalary;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public double getYearSalary() {
		return yearSalary;
	}

	public void setYearSalary(double yearSalary) {
		this.yearSalary = yearSalary;
	}

	@Override
	public String toString() {
		return "Employee [no=" + no + ", name=" + name + ", IDCard=" + IDCard + ", yearSalary=" + yearSalary + "]";
	}
	
	
	

}
