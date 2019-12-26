package com.lambda.day1227;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

import org.junit.Test;

public class TimeDemo2 {
	
	/*
	 * ʱ�������
	 * TemporalAdjuster
	 */
	@Test
	public void test1() {
		//�õ���ǰʱ��
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		//��ʱ������Ϊ����µ� 10 ��
		LocalDateTime ldt2 = ldt.withDayOfMonth(10);
		System.out.println(ldt2);
		
		//����ʱ������� �ҵ���һ������
		LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		System.out.println(ldt3);
		
		//�Զ��壺�ҵ���һ��������
		LocalDateTime ldt5 = ldt.with((l) -> {
			LocalDateTime ldt4 = (LocalDateTime) l;
			
			//�������ܼ�
			DayOfWeek dow = ldt4.getDayOfWeek();
			
			if (dow.equals(DayOfWeek.FRIDAY)) {
				//����Ļ� ������
				return ldt4.plusDays(3);
				
			} else if (dow.equals(DayOfWeek.SATURDAY)) {
				//�����Ļ� ������
				return ldt4.plusDays(2);
			} else {
				//���յĻ� ��һ��
				return ldt4.plusDays(1);
			}
		});
		System.out.println(ldt5);
	}
	
	/*
	 * ʱ���ʽ���Ĵ���
	 * DateTimeFormatter
	 */
	@Test
	public void test2() {
		//����һ��ת���ĸ�ʽ
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
		
		//�õ�����ʱ��
		LocalDateTime ldt = LocalDateTime.now();
		
		//ת��
		String strDate = ldt.format(dtf);
		System.err.println(strDate);
	}
	
	/*
	 * ʱ����ʽ������
	 * ZonedDate��ZonedTime��ZonedDateTime
	 */
	@Test
	public void test3() {
		//�õ�����ʱ��
		Set<String> set = ZoneId.getAvailableZoneIds();
		set.forEach(System.out::println);
	}
	
	@Test
	public void test4() {
		LocalDateTime ldt = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println(ldt);
		
		LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
		ZonedDateTime zdt = ldt2.atZone(ZoneId.of("America/Los_Angeles"));
		System.err.println(zdt);
	}
}
