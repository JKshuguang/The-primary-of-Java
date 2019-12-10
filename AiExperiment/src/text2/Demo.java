package text2;

public class Demo {

	private static char ch = 'A';
	private static Queue<Tree> Q;
	
	public static void main(String[] args) {
		
		Tree rootTree = new Tree(ch+"");
		
		//构建一个三层的满二叉树
		createTree(rootTree,1,3);
		
		//深度优先搜索
		dfs(rootTree);
		
		//宽度优先搜索
		bfs(rootTree);
		
	}



	//bfs
	private static void bfs(Tree rootTree) {
		//构造队列
		Q = new Queue<Tree>();
		//根进队列
		Q.push(rootTree);
		
		while(!Q.isEmpty()) {
			//得到队首元素
			Tree node = Q.poll();
			//空元素跳过
			if(node == null)continue;
			//打印信息
			System.out.print(node.getCh());
			//左右子树进队列
			if(node.getLeftTree()!=null)
				Q.push(node.getLeftTree());
			if(node.getRightTree()!=null)
				Q.push(node.getRightTree());
			
		}
		
	}



	//深度优先搜索
	private static void dfs(Tree rootTree) {
		System.out.print(rootTree.getCh());           
		if(rootTree.getLeftTree()!=null)
			dfs(rootTree.getLeftTree());
		if(rootTree.getRightTree()!=null)
			dfs(rootTree.getRightTree());
		
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
