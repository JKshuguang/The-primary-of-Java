package text6;


public class MainTest { 

   

  public static void main(String[] args) { 

    Map map = new Map(); 

    AStar aStar = new AStar(); 

    map.ShowMap(); 

    aStar.search(map); 

    System.out.println("============================="); 

    System.out.println("����A*�㷨�����"); 

    System.out.println("============================="); 

    map.ShowMap();  

  } 

} 

