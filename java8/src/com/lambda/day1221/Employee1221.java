package com.lambda.day1221;

public class Employee1221 {
	
	private String name;
	private int age;
	private double salary;
	private Status status;
	
	public Employee1221() {
		super();
	}
	
	public Employee1221(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	

	public Employee1221(String name, int age, double salary, Status status) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee1221 other = (Employee1221) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	



	@Override
	public String toString() {
		return "Employee1221 [name=" + name + ", age=" + age + ", salary=" + salary + ", status=" + status + "]";
	}






	public enum Status {
		
		FREE,
		BUSY,
		VOCATION
	}

}
