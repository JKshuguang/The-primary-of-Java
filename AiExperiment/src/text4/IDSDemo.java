package text4;

import text2.Tree;

public class IDSDemo {

	private static char ch = 'A';
	
	public static void main(String[] args) {
		
		Tree rootTree = new Tree(ch+"");
		
		//构建一个三层的满二叉树
		createTree(rootTree,1,3);
		
		//遍历搜索每一层的结果
		for(int i= 0;i < 3; i++) {
			//深度限制搜索
			System.out.print("第"+i+"层深度限制遍历结果：");
			idsSearch(rootTree, 0, i);
			System.out.println("\n-----------------------------------");
		}
	}


	//IDS搜索
	private static void idsSearch(Tree rootTree,int cur,int deep) {
		System.out.print(rootTree.getCh());           
		if(rootTree.getLeftTree()!=null && cur<deep)
			idsSearch(rootTree.getLeftTree(),cur+1,deep);
		if(rootTree.getRightTree()!=null && cur<deep)
			idsSearch(rootTree.getRightTree(),cur+1,deep);
		
	}
	
	//构造一颗满二叉树
	//现在层数cur
	//最深层数n
	private static void createTree(Tree rootTree,int cur,int n) {
		//最后一层节点
		if(cur == n) return;
		
		rootTree.setLeftTree(new Tree(++ch + ""));
		rootTree.setRightTree(new Tree(++ch + ""));
		
		createTree(rootTree.getLeftTree(), cur+1, n);
		createTree(rootTree.getRightTree(),	cur+1, n);
		
	}
	
	

}
