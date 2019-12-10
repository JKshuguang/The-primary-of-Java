package text5;


public class Main {
    public static void main(String[] args)

    {
        String[] vers = {"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9"};

        int[][]  edges={

                {0,5,0,0,0,0,0,2,0},

                {5,0,2,0,0,1,0,0,0},

                {0,2,0,4,5,0,0,0,2},

                {0,0,4,0,2,0,0,0,3},

                {0,0,5,2,0,6,0,0,0},

                {0,1,0,0,6,0,1,2,0},

                {0,0,0,0,0,1,0,3,0},

                {2,0,0,0,0,2,3,0,0},

                {0,0,2,3,0,0,0,0,0}

        };

        InfGraph  g=new InfGraph(vers,edges,9,9);

        int[] estimateDistance={3,1,2,5,4,0,1,1,6};//´úÌæÆô·¢º¯Êýh(n)

        System.out.println("Greedy best-first Search:");

        g.parsePath(g.gbfs(g.searchVertex("c4"),g.searchVertex("c6"),estimateDistance));

    }

}
