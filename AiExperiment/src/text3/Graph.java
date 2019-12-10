package text3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Graph {

    final static int  MAXSIZE=1000;//���1000������

    String[] vertexes=new String[MAXSIZE];  //��������

    int[][] edges=new int[MAXSIZE][MAXSIZE];//�ڽӾ���

    int  verNum,edgeNum;//���������������

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

public ArrayList<CostPath>  ucs(int src,int dst) {

        if (src < 0 && dst < 0 && src >= verNum && dst >= verNum) return null;

        //allPath�洢·��������

   
        
        ArrayList<CostPath> allPath = new ArrayList<CostPath>(
        	
        );

        if (src == dst) {

            allPath.add(new CostPath(String.valueOf(src), 0));

            return allPath;

        }

        //��д���ȼ����еıȽϺ���

        PriorityQueue<CostPath> priFrontier = new PriorityQueue<>(
        		new Comparator<CostPath>() {

					@Override
					public int compare(CostPath o1, CostPath o2) {
						
						return o1.cost - o2.cost;
					}
				});

        //explored�洢��̽�����Ľ��

        ArrayList<Integer> explored = new ArrayList<>();

        //Դ�����ӣ����ô���Ϊ0

        priFrontier.offer(new CostPath(String.valueOf(src), 0));

        while (!priFrontier.isEmpty()) {

            //������С��·�����ӣ����ȼ������

            CostPath cp = priFrontier.remove();

            //pΪ·��

            String p = cp.path;

            //��ȡ·�����һ�����

            String[] pathSplit=p.split("-");//���·��

            int v = Integer.parseInt(pathSplit[pathSplit.length-1]);

            if (v == dst) {  //Ŀ����ԣ�����Ŀ��

                allPath.add(cp);//��·����������ӵ�allPath

                //return  allPath;//���ֻҪ����·��ֱ�ӷ����˳�����

            }

            else {

                //���ý������Ϊ��̽��

                explored.add(v);

                //����forѭ���ҵ����v�ĺ�̽�㲢����Ӧ������ӡ��滻

                for (int i = 0; i < verNum; i++) {

                    if (edges[v][i] > 0) { //�б�

                        //��ϵ�ǰ·������̽�㣬����

                        String p1 = p+"-"+i;

                        //��̽���Ƿ��ڵ�ǰ·���ϣ�����ǣ�����γɻ���������

                        boolean isInCurrentPath = isInStringArray(pathSplit,i);

                        //�жϸú�̽���Ƿ�δ̽���������Ƿ��ڵ�ǰ·����

                        //δ̽�����Ŀ϶���Ҫ���

                        //���⣬��Ȼ��̽�������������ڵ�ǰ·���ϵĽ��Ҳ����ӣ�

                        //�����и��౸ѡ��·���������ڴ���̵�·��

                        if (explored.indexOf(i) == -1 || !isInCurrentPath)

                            //�������

                            priFrontier.offer(new CostPath(p1, cp.cost + edges[v][i]));

                        }

                    }

                }

            }

        

        return allPath;

    }


}
