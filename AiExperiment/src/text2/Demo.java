package text2;

public class Demo {

	private static char ch = 'A';
	private static Queue<Tree> Q;
	
	public static void main(String[] args) {
		
		Tree rootTree = new Tree(ch+"");
		
		//����һ���������������
		createTree(rootTree,1,3);
		
		//�����������
		dfs(rootTree);
		
		//�����������
		bfs(rootTree);
		
	}



	//bfs
	private static void bfs(Tree rootTree) {
		//�������
		Q = new Queue<Tree>();
		//��������
		Q.push(rootTree);
		
		while(!Q.isEmpty()) {
			//�õ�����Ԫ��
			Tree node = Q.poll();
			//��Ԫ������
			if(node == null)continue;
			//��ӡ��Ϣ
			System.out.print(node.getCh());
			//��������������
			if(node.getLeftTree()!=null)
				Q.push(node.getLeftTree());
			if(node.getRightTree()!=null)
				Q.push(node.getRightTree());
			
		}
		
	}



	//�����������
	private static void dfs(Tree rootTree) {
		System.out.print(rootTree.getCh());           
		if(rootTree.getLeftTree()!=null)
			dfs(rootTree.getLeftTree());
		if(rootTree.getRightTree()!=null)
			dfs(rootTree.getRightTree());
		
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
