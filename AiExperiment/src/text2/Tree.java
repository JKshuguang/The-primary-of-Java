package text2;

public class Tree {
	
	private String mes;
	private Tree leftTree;
	private Tree rightTree;
	
	//�޲ι��캯��
	public Tree() {
		mes = "";
		leftTree = null;
	    rightTree = null;
	}
	//�вι��캯��
	public Tree(String mes) {
		super();
		this.mes = mes;
		leftTree = null;
	    rightTree = null;		
	}
	//�õ�ֵ
	public String getCh() {
		return mes;
	}
	//����ֵ
	public void setCh(String mes) {
		this.mes = mes;
	}
	//�õ�������
	public Tree getLeftTree() {
		return leftTree;
	}
	//����������
	public void setLeftTree(Tree leftTree) {
		this.leftTree = leftTree;
	}
	//�õ�������
	public Tree getRightTree() {
		return rightTree;
	}
	//����������
	public void setRightTree(Tree rightTree) {
		this.rightTree = rightTree;
	}


}
