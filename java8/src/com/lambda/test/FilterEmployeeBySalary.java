package com.lambda.test;

public class FilterEmployeeBySalary implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee e) {
		
		return e.getSalary() >= 5000;
	}

}
