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
		//现在日期
		LocalDate ld = LocalDate.now();
		
		//过去日期
		LocalDate old = LocalDate.of(2019, 06, 21);
		
		//得到之间的天数
		Period pd = Period.between(old, ld);
		System.out.println(pd);
		
		//分别得到年月日
		System.out.println(pd.getYears());
		System.out.println(pd.getMonths());
		System.out.println(pd.getDays());
	}
	
	/*
	 * LocalTime
	 */
	@Test
	public void test2() {
		//现在时间
		LocalTime lt = LocalTime.now();
		
		//过去时间
		LocalTime olt = LocalTime.of(8, 59,59);
		
		//计算之间间隔
		Duration duration = Duration.between(olt, lt);
		System.out.println(duration);
		
		//分别得到各个小时间
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
		//时间
		LocalDateTime ldt = LocalDateTime.of(2019, 6, 21, 18, 24,59);
		System.out.println(ldt);
		
		//得到Localdatetime的第二种方式
		LocalDateTime ldt2 = LocalDateTime.now();
		System.out.println(ldt2);
		
		//加十年
		ldt.plusYears(10);
		System.out.println(ldt);
		
		//减一年
		ldt.minusYears(1);
		System.out.println(ldt);
		
		//得到年月日 小时 分钟 秒
		System.out.println(ldt.getYear());
		System.out.println(ldt.getMonthValue());
		System.out.println(ldt.getDayOfMonth());
		System.out.println(ldt.getHour());
		System.out.println(ldt.getMinute());
		System.out.println(ldt.getSecond());
	}
	
	/*
	 * 时间戳： Instant (以UNIx 元年：1970 年 1 月 1 日 00：00：00 到某个时间的毫秒数)
	 */
	@Test
	public void test4() {
		//得到当前（默认时区：UTC 时区）
		Instant ins1 = Instant.now();
		System.out.println(ins1);
		
		//加上偏移时间
		OffsetDateTime od = ins1.atOffset(ZoneOffset.ofHours(8));
		System.out.println(ins1);
		
		//转变成毫秒数
		System.out.println(ins1.toEpochMilli());
		
		//用 元年 偏移时间得到一个 时间戳
		Instant ins2 = Instant.ofEpochSecond(600);
		System.out.println(ins2);
	}
	
	//得到时间戳间的间隔
	@Test
	public void test5() {
		//得到当前时间戳
		Instant ins1 = Instant.now();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		//得到当前
		Instant ins2 = Instant.now();
		
		//计算间隔
		Duration du = Duration.between(ins1, ins2);
		System.out.println(du);		
	}
	
}
