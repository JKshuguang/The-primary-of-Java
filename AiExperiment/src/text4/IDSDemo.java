package text4;

import text2.Tree;

public class IDSDemo {

	private static char ch = 'A';
	
	public static void main(String[] args) {
		
		Tree rootTree = new Tree(ch+"");
		
		//����һ���������������
		createTree(rootTree,1,3);
		
		//��������ÿһ��Ľ��
		for(int i= 0;i < 3; i++) {
			//�����������
			System.out.print("��"+i+"��������Ʊ��������");
			idsSearch(rootTree, 0, i);
			System.out.println("\n-----------------------------------");
		}
	}


	//IDS����
	private static void idsSearch(Tree rootTree,int cur,int deep) {
		System.out.print(rootTree.getCh());           
		if(rootTree.getLeftTree()!=null && cur<deep)
			idsSearch(rootTree.getLeftTree(),cur+1,deep);
		if(rootTree.getRightTree()!=null && cur<deep)
			idsSearch(rootTree.getRightTree(),cur+1,deep);
		
	}
	
	//����һ����������
	//���ڲ���cur
	//�������n
	private static void createTree(Tree rootTree,int cur,int n) {
		//���һ��ڵ�
		if(cur == n) return;
		
		rootTree.setLeftTree(new Tree(++ch + ""));
		rootTree.setRightTree(new Tree(++ch + ""));
		
		createTree(rootTree.getLeftTree(), cur+1, n);
		createTree(rootTree.getRightTree(),	cur+1, n);
		
	}
	
	

}
