	package text3;


public class CostPath {

    public String  path;//路径，如3216

    public int cost;//路径代价

    int estCost;//估计路径代价，启发函数或评估函数计算出的代价

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
