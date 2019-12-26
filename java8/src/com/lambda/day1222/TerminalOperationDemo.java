package com.lambda.day1222;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.lambda.day1221.Employee1221;
import com.lambda.day1221.Employee1221.Status;

public class TerminalOperationDemo {
	
	List<Employee1221> employees = Arrays.asList(
			new Employee1221("����", 23, 3434.1, Status.FREE),
			new Employee1221("����", 33, 5555.5, Status.BUSY),
			new Employee1221("����", 21, 8787.5, Status.VOCATION),
			new Employee1221("����", 65, 7777.3, Status.FREE),
			new Employee1221("����", 12, 5655.7, Status.FREE)
			);
	
	@Test
	public void test() {
		
		//allMatch ----- �Ƿ�ƥ������Ԫ��
		//�Ƿ�����Ա������ BUSY ״̬
		boolean b1 = employees.stream()
							  .allMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b1);
		
		//anyMatch ----- �Ƿ�����ƥ��һ��Ԫ��
		//�Ƿ���һ��Ա������ BUSY ״̬
		boolean b2 = employees.stream()
							  .anyMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b2);
		
		//noneMatch ---- �Ƿ�û��ƥ������Ԫ��
		//�Ƿ�����Ա�������� VOCATION ״̬
		boolean b3 = employees.stream()
							  .noneMatch((e) -> e.getStatus().equals(Status.VOCATION));
		System.out.println(b3);
		
		Optional<Employee1221> op1 = null;
		//findFirst ---- �õ���һ��Ԫ��
		//�õ�������ߵ�Ա��
			op1 = employees.stream()
						   .sorted((e1,e2) -> -Double.compare(e1.getSalary(), e2.getSalary()))
						   .findFirst();
			System.out.println(op1.get());
			
		//findAny --- ���ص�ǰ���е�����Ԫ��
		//�õ�����һ������ FREE ��Ա��
			op1 = employees.parallelStream()	//���в�����
						   .filter((e) -> e.getStatus().equals(Status.FREE))
						   .findAny();
			System.out.println(op1.get());
			
		//count ----- ��������Ԫ�ص��ܸ���
			long count = employees.stream()
								  .count();
			System.out.println(count);
			
			Optional<Employee1221> op = null;
		//max ------ �����������ֵ
			//������������Ա�������� Comparator �Ƚ�����
			op = employees.stream()
						  .max((e1,e2) -> Integer.compare(e1.getAge(), e2.getAge()));
			System.out.println(op.get());
			
		//min ------ ����������Сֵ
			//����������С��Ա��
			op = employees.stream()
						  .min((e1,e2) -> Integer.compare(e1.getAge(), e2.getAge()));
			System.out.println(op.get());
		
			System.out.println("------");
		//�õ���˾��С����

			int a = employees.stream()
					.min((e1,e2) -> Integer.compare(e1.getAge(), e2.getAge()))
					.map(Employee1221::getAge)
					.get();
					
			
					
		
		System.out.println(a);
	}
}
