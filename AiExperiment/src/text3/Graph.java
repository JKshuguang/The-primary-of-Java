package text3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Graph {

    final static int  MAXSIZE=1000;//最多1000个顶点

    String[] vertexes=new String[MAXSIZE];  //顶点数组

    int[][] edges=new int[MAXSIZE][MAXSIZE];//邻接矩阵

    int  verNum,edgeNum;//顶点个数、边条数

    public  Graph()

    {

        verNum=0;

        edgeNum=0;

    }

    public  Graph(String[] Vertexes,int[][] Edges,int VerNum,int EdgeNum)

    {

        vertexes=Vertexes;

        edges=Edges;

        verNum=VerNum;

        edgeNum=EdgeNum;

    }
    

    public  void print()

    {

        //输出顶点

        System.out.print("顶点：");

        for(int i=0;i<verNum;i++)

            System.out.print(vertexes[i]+" ");

       //输出每条边

        System.out.println();

        System.out.println("边：");

        for(int i=0;i<verNum;i++)

        {

            for(int j=0;j<verNum;j++)

                if(edges[i][j]>0) //表示有边，为0就没有了，不考虑负值边

                   System.out.print(vertexes[i]+"=>"+vertexes[j]+":"+edges[i][j]+" ");

             System.out.println();

        }

    }


    public  int searchVertex(String vertex)

    {

        for(int i=0;i<verNum;i++)

            if(vertexes[i]==vertex) return i;

       return -1;

    }


    public  void  parsePath(ArrayList<CostPath> path)

    {

        for(int i=0;i<path.size();i++)

        {

            CostPath subPath=path.get(i);

            String[]  realPath=subPath.path.split("-");


            for(int j=0;j<realPath.length;j++)
            {

                if(j==0) //第一条路径不加=>符号

                     System.out.print(vertexes[Integer.parseInt(realPath[j])]);

                else 

                      System.out.print("=>"+vertexes[Integer.parseInt(realPath[j])]);

            }
            System.out.println(",Cost:"+subPath.cost);//输出代价

        }

    }


    public  boolean  isInStringArray(String[] s,int v)

    {

        for(int i=0;i<s.length;i++)

            if(Integer.parseInt(s[i])==v) return  true;

        return  false;

    }

public ArrayList<CostPath>  ucs(int src,int dst) {

        if (src < 0 && dst < 0 && src >= verNum && dst >= verNum) return null;

        //allPath存储路径及代价

   
        
        ArrayList<CostPath> allPath = new ArrayList<CostPath>(
        	
        );

        if (src == dst) {

            allPath.add(new CostPath(String.valueOf(src), 0));

            return allPath;

        }

        //重写优先级队列的比较函数

        PriorityQueue<CostPath> priFrontier = new PriorityQueue<>(
        		new Comparator<CostPath>() {

					@Override
					public int compare(CostPath o1, CostPath o2) {
						
						return o1.cost - o2.cost;
					}
				});

        //explored存储已探索过的结点

        ArrayList<Integer> explored = new ArrayList<>();

        //源结点入队，设置代价为0

        priFrontier.offer(new CostPath(String.valueOf(src), 0));

        while (!priFrontier.isEmpty()) {

            //代价最小的路径出队（优先级队列嘛）

            CostPath cp = priFrontier.remove();

            //p为路径

            String p = cp.path;

            //获取路径最后一个结点

            String[] pathSplit=p.split("-");//拆分路径

            int v = Integer.parseInt(pathSplit[pathSplit.length-1]);

            if (v == dst) {  //目标测试，发现目标

                allPath.add(cp);//将路径及代价添加到allPath

                //return  allPath;//如果只要最优路径直接返回退出即可

            }

            else {

                //将该结点设置为已探索

                explored.add(v);

                //下面for循环找到结点v的后继结点并做相应处理：入队、替换

                for (int i = 0; i < verNum; i++) {

                    if (edges[v][i] > 0) { //有边

                        //组合当前路径及后继结点，备用

                        String p1 = p+"-"+i;

                        //后继结点是否在当前路径上，如果是，则会形成环，将丢弃

                        boolean isInCurrentPath = isInStringArray(pathSplit,i);

                        //判断该后继结点是否未探索、或者是否不在当前路径上

                        //未探索过的肯定需要入队

                        //另外，虽然已探索过，但并不在当前路径上的结点也需入队，

                        //这样有更多备选的路径，不至于错过短的路径

                        if (explored.indexOf(i) == -1 || !isInCurrentPath)

                            //将其入队

                            priFrontier.offer(new CostPath(p1, cp.cost + edges[v][i]));

                        }

                    }

                }

            }

        

        return allPath;

    }


}
