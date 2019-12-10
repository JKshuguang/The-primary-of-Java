package text5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import text3.CostPath;

public class InfGraph {

    final static int  MAXSIZE=1000;//最多1000个顶点

    String[] vertexes=new String[MAXSIZE];  //顶点数组

    int[][] edges=new int[MAXSIZE][MAXSIZE];//邻接矩阵

    int  verNum,edgeNum;//顶点个数、边条数

    public  InfGraph()

    {

        verNum=0;

        edgeNum=0;

    }

    public  InfGraph(String[] Vertexes,int[][] Edges,int VerNum,int EdgeNum)

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


public  ArrayList<CostPath>  gbfs(int src,int dst,int[]  estimateDistance) {

        if (src < 0 && dst < 0 && src >= verNum && dst >= verNum) return null;

         //allPath存储找到的路径

        ArrayList<CostPath> allPath=new ArrayList<>();

        if (src == dst)

        {

            allPath.add(new CostPath(String.valueOf(src), 0));

            return allPath;

        }

        //priFrontier存储候选路径队列，用优先级队列实现，这点与一致代价搜索UCS很像

        //costPath是一个路径、代价、估计代价（启发式函数计算出的值）结构

     PriorityQueue<CostPath> priFrontier=new PriorityQueue<>(new Comparator<CostPath>() {

            @Override

            public int compare(CostPath o1, CostPath o2) {

                return o1.cost-o2.cost; //按估计代价排序

            }

        });

        //exploried存储已探索结点

        ArrayList<Integer>  explored=new ArrayList<>();

        priFrontier.offer(new CostPath(String.valueOf(src), 0));

        while(!priFrontier.isEmpty())

        {

            CostPath cp = priFrontier.remove(); //出队

            //拆分路径，结点间以“-”符号隔开

            String[] pathSplit=cp.path.split("-");

            //当前路径最后一个结点，将要被扩展的结点

            int v=Integer.parseInt(pathSplit[pathSplit.length-1]);

            //表示该结点已探索

            explored.add(v);

            if(v==dst)

            {

                allPath.add(cp); //找到路径，添加到结果路径集里

               // return  allPath; //只要求找到的话，直接返回即可

               // 也可设置计数器，返回指定条数路线（如果有的话）

            }

            else

            {

                for(int i=0;i<edges.length;i++)

                     //isInStringArray结点i是否在pathSplit当前路径数组

                    if(edges[v][i]>0 && (!explored.contains(i)

                            || !isInStringArray(pathSplit,i)))

                         priFrontier.offer(new CostPath(cp.path+"-"+i,

                              cp.cost+edges[v][i],estimateDistance[i]));

            }

 

        }

        return  allPath;

    }



}
