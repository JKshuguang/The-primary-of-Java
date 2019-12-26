package com.lambda.test;

public class FilterEmployeeByAge implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee employee) {

		return employee.getAge() >= 50;
	}

}
