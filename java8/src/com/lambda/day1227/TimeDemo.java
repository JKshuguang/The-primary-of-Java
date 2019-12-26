package com.lambda.day1227;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;

import org.junit.Test;

public class TimeDemo {
	
	/*
	 * LocalDate
	 */
	@Test
	public void test1() {
		//��������
		LocalDate ld = LocalDate.now();
		
		//��ȥ����
		LocalDate old = LocalDate.of(2019, 06, 21);
		
		//�õ�֮�������
		Period pd = Period.between(old, ld);
		System.out.println(pd);
		
		//�ֱ�õ�������
		System.out.println(pd.getYears());
		System.out.println(pd.getMonths());
		System.out.println(pd.getDays());
	}
	
	/*
	 * LocalTime
	 */
	@Test
	public void test2() {
		//����ʱ��
		LocalTime lt = LocalTime.now();
		
		//��ȥʱ��
		LocalTime olt = LocalTime.of(8, 59,59);
		
		//����֮����
		Duration duration = Duration.between(olt, lt);
		System.out.println(duration);
		
		//�ֱ�õ�����Сʱ��
		System.out.println(duration.toHours());
		System.out.println(duration.toMinutes());
		System.out.println(duration.getSeconds());
		System.out.println(duration.toMillis());
		System.out.println(duration.getNano());
	}
	
	/*
	 * LocalDateTime
	 */
	@Test
	public void test3() {
		//ʱ��
		LocalDateTime ldt = LocalDateTime.of(2019, 6, 21, 18, 24,59);
		System.out.println(ldt);
		
		//�õ�Localdatetime�ĵڶ��ַ�ʽ
		LocalDateTime ldt2 = LocalDateTime.now();
		System.out.println(ldt2);
		
		//��ʮ��
		ldt.plusYears(10);
		System.out.println(ldt);
		
		//��һ��
		ldt.minusYears(1);
		System.out.println(ldt);
		
		//�õ������� Сʱ ���� ��
		System.out.println(ldt.getYear());
		System.out.println(ldt.getMonthValue());
		System.out.println(ldt.getDayOfMonth());
		System.out.println(ldt.getHour());
		System.out.println(ldt.getMinute());
		System.out.println(ldt.getSecond());
	}
	
	/*
	 * ʱ����� Instant (��UNIx Ԫ�꣺1970 �� 1 �� 1 �� 00��00��00 ��ĳ��ʱ��ĺ�����)
	 */
	@Test
	public void test4() {
		//�õ���ǰ��Ĭ��ʱ����UTC ʱ����
		Instant ins1 = Instant.now();
		System.out.println(ins1);
		
		//����ƫ��ʱ��
		OffsetDateTime od = ins1.atOffset(ZoneOffset.ofHours(8));
		System.out.println(ins1);
		
		//ת��ɺ�����
		System.out.println(ins1.toEpochMilli());
		
		//�� Ԫ�� ƫ��ʱ��õ�һ�� ʱ���
		Instant ins2 = Instant.ofEpochSecond(600);
		System.out.println(ins2);
	}
	
	//�õ�ʱ�����ļ��
	@Test
	public void test5() {
		//�õ���ǰʱ���
		Instant ins1 = Instant.now();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		//�õ���ǰ
		Instant ins2 = Instant.now();
		
		//������
		Duration du = Duration.between(ins1, ins2);
		System.out.println(du);		
	}
	
}
