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
	//��ʼ�ͽ���λ��
	private long start;
	private long end;
	
	//��С����
	private static final long WIDTH  =  100000;
	
	
	//���캯��
	public ForkJoinCalcalate(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}



	@Override
	protected Long  compute() {
		//���ٽ糤��������ܺ�
		long length = end - start;
		if (length <= WIDTH) {
			long sum = 0;
			for (long i = start; i <= end; i++) {
				sum += i;
			}
			return sum;
		}else {
			//����
			long middle = (end + start) / 2;
			
			//������벿���ܺ��߳�
			ForkJoinCalcalate left = new ForkJoinCalcalate(start, middle);
			left.fork();
			
			//�����Ұ벿���ܺ��߳�
			ForkJoinCalcalate right = new ForkJoinCalcalate(middle + 1, end);
			right.fork();
			
			//���ؽ��
			return left.join() + right.join();
		}
		
	}
	
	

}
