package text3;


public class Main {

 

    public static void main(String[] args)

    {

        //¶¥µã±í

        String[] vers = {"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9"};

        int[][]  edgs={     //ÁÚ½Ó¾ØÕó

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

        Graph  g=new Graph(vers,edgs,9,13);

        System.out.println("Uniform-cost Search:");

        g.parsePath(g.ucs(g.searchVertex("c4"),g.searchVertex("c6")));

    }

}
