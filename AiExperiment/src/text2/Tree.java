package text2;

public class Tree {
	
	private String mes;
	private Tree leftTree;
	private Tree rightTree;
	
	//无参构造函数
	public Tree() {
		mes = "";
		leftTree = null;
	    rightTree = null;
	}
	//有参构造函数
	public Tree(String mes) {
		super();
		this.mes = mes;
		leftTree = null;
	    rightTree = null;		
	}
	//得到值
	public String getCh() {
		return mes;
	}
	//更新值
	public void setCh(String mes) {
		this.mes = mes;
	}
	//得到左子树
	public Tree getLeftTree() {
		return leftTree;
	}
	//更新左子树
	public void setLeftTree(Tree leftTree) {
		this.leftTree = leftTree;
	}
	//得到右子树
	public Tree getRightTree() {
		return rightTree;
	}
	//更新右子树
	public void setRightTree(Tree rightTree) {
		this.rightTree = rightTree;
	}


}
