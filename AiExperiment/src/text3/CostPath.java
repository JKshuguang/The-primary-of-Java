	package text3;


public class CostPath {

    public String  path;//·������3216

    public int cost;//·������

    int estCost;//����·�����ۣ�������������������������Ĵ���

    public  CostPath(String Path)

    {

        path=Path; 

        cost=0; 

        estCost=0;

    }

    public  CostPath(String Path,int Cost)

    {

        path=Path; 

        cost=Cost; 

        estCost=0;

    }

    public  CostPath(String Path,int Cost,int EstCost)

    {

        path=Path; 

        cost=Cost; 

        estCost=EstCost;

    }

    public void  print()

    {

       System.out.print(path+",cost:"+cost+",estimate Cost:"+estCost+"||");

    }

}
