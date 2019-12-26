package com.lambda.day1225;

import java.util.concurrent.RecursiveTask;


public class ForkJoinCalcalate extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1234567899L;
	/**
	 * 
	 */
	//开始和结束位置
	private long start;
	private long end;
	
	//最小限制
	private static final long WIDTH  =  100000;
	
	
	//构造函数
	public ForkJoinCalcalate(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}



	@Override
	protected Long  compute() {
		//到临界长度则计算总和
		long length = end - start;
		if (length <= WIDTH) {
			long sum = 0;
			for (long i = start; i <= end; i++) {
				sum += i;
			}
			return sum;
		}else {
			//划分
			long middle = (end + start) / 2;
			
			//计算左半部分总和线程
			ForkJoinCalcalate left = new ForkJoinCalcalate(start, middle);
			left.fork();
			
			//计算右半部分总和线程
			ForkJoinCalcalate right = new ForkJoinCalcalate(middle + 1, end);
			right.fork();
			
			//返回结果
			return left.join() + right.join();
		}
		
	}
	
	

}
