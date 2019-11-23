package com.jdbc.day1121;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

import com.jdbc.day1119.Employee;

class BeanutilsTest {

	@Test
	void utilsTest() throws IllegalAccessException, InvocationTargetException {

		Object obj = new Employee();
		BeanUtils.setProperty(obj, "name", "JIKE");
		System.out.println(obj);

	}

}
