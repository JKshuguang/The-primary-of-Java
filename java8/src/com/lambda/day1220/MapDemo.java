package com.lambda.day1220;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class MapDemo {
	
	@Test
	public void test() {
		
		List<String> list = Arrays.asList("jin","xiao","kun");
		
		// map ��ʹ��
		Stream<Stream<Character>> stream = list.stream()
				.map(MapDemo::filerStream);
		
		stream.forEach((com) -> {
			com.forEach(System.out::println);
		});
		
		// flatMap ��ʹ��
			list.stream()
				.flatMap(MapDemo::filerStream)
				.forEach(System.out::println);
		
		
	}
	
	//�õ�һ�� character ��stream
	public static Stream<Character> filerStream(String str){
		
		//����һ��list
		List<Character> list = new ArrayList<Character>();
		
		for (Character ch : str.toCharArray()) {
			list.add(ch);
		}
		
		return list.stream();
	}
	
}
