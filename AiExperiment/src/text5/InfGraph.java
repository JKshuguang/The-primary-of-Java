package text5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import text3.CostPath;

public class InfGraph {

    final static int  MAXSIZE=1000;//���1000������

    String[] vertexes=new String[MAXSIZE];  //��������

    int[][] edges=new int[MAXSIZE][MAXSIZE];//�ڽӾ���

    int  verNum,edgeNum;//���������������

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

        //�������

        System.out.print("���㣺");

        for(int i=0;i<verNum;i++)

            System.out.print(vertexes[i]+" ");

       //���ÿ����

        System.out.println();

        System.out.println("�ߣ�");

        for(int i=0;i<verNum;i++)

        {

            for(int j=0;j<verNum;j++)

                if(edges[i][j]>0) //��ʾ�бߣ�Ϊ0��û���ˣ������Ǹ�ֵ��

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

                if(j==0) //��һ��·������=>����

                     System.out.print(vertexes[Integer.parseInt(realPath[j])]);

                else 

                      System.out.print("=>"+vertexes[Integer.parseInt(realPath[j])]);

            }
            System.out.println(",Cost:"+subPath.cost);//�������

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

         //allPath�洢�ҵ���·��

        ArrayList<CostPath> allPath=new ArrayList<>();

        if (src == dst)

        {

            allPath.add(new CostPath(String.valueOf(src), 0));

            return allPath;

        }

        //priFrontier�洢��ѡ·�����У������ȼ�����ʵ�֣������һ�´�������UCS����

        //costPath��һ��·�������ۡ����ƴ��ۣ�����ʽ�����������ֵ���ṹ

     PriorityQueue<CostPath> priFrontier=new PriorityQueue<>(new Comparator<CostPath>() {

            @Override

            public int compare(CostPath o1, CostPath o2) {

                return o1.cost-o2.cost; //�����ƴ�������

            }

        });

        //exploried�洢��̽�����

        ArrayList<Integer>  explored=new ArrayList<>();

        priFrontier.offer(new CostPath(String.valueOf(src), 0));

        while(!priFrontier.isEmpty())

        {

            CostPath cp = priFrontier.remove(); //����

            //���·���������ԡ�-�����Ÿ���

            String[] pathSplit=cp.path.split("-");

            //��ǰ·�����һ����㣬��Ҫ����չ�Ľ��

            int v=Integer.parseInt(pathSplit[pathSplit.length-1]);

            //��ʾ�ý����̽��

            explored.add(v);

            if(v==dst)

            {

                allPath.add(cp); //�ҵ�·������ӵ����·������

               // return  allPath; //ֻҪ���ҵ��Ļ���ֱ�ӷ��ؼ���

               // Ҳ�����ü�����������ָ������·�ߣ�����еĻ���

            }

            else

            {

                for(int i=0;i<edges.length;i++)

                     //isInStringArray���i�Ƿ���pathSplit��ǰ·������

                    if(edges[v][i]>0 && (!explored.contains(i)

                            || !isInStringArray(pathSplit,i)))

                         priFrontier.offer(new CostPath(cp.path+"-"+i,

                              cp.cost+edges[v][i],estimateDistance[i]));

            }

 

        }

        return  allPath;

    }



}
