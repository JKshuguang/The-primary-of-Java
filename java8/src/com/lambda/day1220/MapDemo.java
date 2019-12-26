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
		
		// map 的使用
		Stream<Stream<Character>> stream = list.stream()
				.map(MapDemo::filerStream);
		
		stream.forEach((com) -> {
			com.forEach(System.out::println);
		});
		
		// flatMap 的使用
			list.stream()
				.flatMap(MapDemo::filerStream)
				.forEach(System.out::println);
		
		
	}
	
	//得到一个 character 的stream
	public static Stream<Character> filerStream(String str){
		
		//建立一个list
		List<Character> list = new ArrayList<Character>();
		
		for (Character ch : str.toCharArray()) {
			list.add(ch);
		}
		
		return list.stream();
	}
	
}
