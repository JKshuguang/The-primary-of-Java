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
	 * 时间矫正器
	 * TemporalAdjuster
	 */
	@Test
	public void test1() {
		//得到当前时间
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		//将时间设置为这个月的 10 号
		LocalDateTime ldt2 = ldt.withDayOfMonth(10);
		System.out.println(ldt2);
		
		//利用时间矫正器 找到下一个周五
		LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		System.out.println(ldt3);
		
		//自定义：找到下一个工作日
		LocalDateTime ldt5 = ldt.with((l) -> {
			LocalDateTime ldt4 = (LocalDateTime) l;
			
			//检查今天周几
			DayOfWeek dow = ldt4.getDayOfWeek();
			
			if (dow.equals(DayOfWeek.FRIDAY)) {
				//周五的话 加三天
				return ldt4.plusDays(3);
				
			} else if (dow.equals(DayOfWeek.SATURDAY)) {
				//周六的话 加两天
				return ldt4.plusDays(2);
			} else {
				//周日的话 加一天
				return ldt4.plusDays(1);
			}
		});
		System.out.println(ldt5);
	}
	
	/*
	 * 时间格式化的处理
	 * DateTimeFormatter
	 */
	@Test
	public void test2() {
		//声明一个转换的格式
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
		
		//得到现在时间
		LocalDateTime ldt = LocalDateTime.now();
		
		//转化
		String strDate = ldt.format(dtf);
		System.err.println(strDate);
	}
	
	/*
	 * 时区格式化处理
	 * ZonedDate、ZonedTime、ZonedDateTime
	 */
	@Test
	public void test3() {
		//得到所有时区
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
