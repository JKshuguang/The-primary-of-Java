package text2;


import java.util.LinkedList;

public class Queue<T> {
	//���ϴ洢
	LinkedList<T> Q = new LinkedList<T>();
	
	//���Ԫ�ص�����β
	public void push(T node) {
		Q.add(node);
	}
	
	//�Ƴ��ڵ�
	public T poll() {
		return Q.pollFirst();
	}
	
	//�ж϶����ǹ�Ϊ��
	public boolean isEmpty() {
		return Q.isEmpty();
	}
}
