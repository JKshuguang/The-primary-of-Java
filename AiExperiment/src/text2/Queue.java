package text2;


import java.util.LinkedList;

public class Queue<T> {
	//集合存储
	LinkedList<T> Q = new LinkedList<T>();
	
	//添加元素到队列尾
	public void push(T node) {
		Q.add(node);
	}
	
	//移除节点
	public T poll() {
		return Q.pollFirst();
	}
	
	//判断队列是够为空
	public boolean isEmpty() {
		return Q.isEmpty();
	}
}
