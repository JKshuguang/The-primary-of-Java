package com.lambda.day1225;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.Test;

public class ParallelStreamDemo {
	
	@Test
	public void test() {
		//��ʼʱ��
		Instant start = Instant.now();
		
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalcalate(0, 10000000000L);
		Long sum = pool.invoke(task);
		System.out.println(sum);
		//����ʱ��
		Instant end = Instant.now();
		System.out.println("�ķ�ʱ�䣺 " + Duration.between(start, end));
		
	}
	
	@Test
	public void test1() {
		//��ʼʱ��
		Instant start = Instant.now();
		
		long sum = 0;
		for (long i = 0; i < 100000000000L; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		//����ʱ��
		Instant end = Instant.now();
		System.out.println("�ķ�ʱ�䣺 " + Duration.between(start, end));
	}
	

	@Test
	public void test3() {
		//��ʼʱ��
		Instant start = Instant.now();
		
		LongStream.rangeClosed(0, 100000000000L)
		 		  .parallel()
		 		  .reduce(0,Long::sum);
		
		//����ʱ��
		Instant end = Instant.now();
		System.out.println("�ķ�ʱ�䣺 " + Duration.between(start, end));
		
	}
}
