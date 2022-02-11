import zzz.o;

public class HanoiTowers 
{
    public final int[][] matrix;
    public final int with;
    public final int higth;
    public final int towers;
    public StringBuilder[] constLineas;

    public HanoiTowers(final int h, final int t)
    {
        higth = h;
        towers = t;
        with = h + 1;

        matrix = new int[higth][towers];
        constLineas = new StringBuilder[higth];
        reiniciarLineas();

        int [] linea;
        for (int a = 0; a < matrix.length; a++)
        {
            linea = matrix[a];
            for (int b = 0; b < linea.length; b++)
            {
                if (b == 0)
                {
                    linea[b] = a + 1;
                }
                else 
                {
                    linea[b] = 0;
                }
            }
        }
    }
    public HanoiTowers(final int h)
    {
        higth = h;
        towers = 3;
        with = higth + 1;

        matrix = new int[higth][towers];
        constLineas = new StringBuilder[h];
        reiniciarLineas();

        int [] linea;
        for (int a = 0; a < matrix.length; a++)
        {
            linea = matrix[a];
            for (int b = 0; b < linea.length; b++)
            {
                if (b == 0)
                {
                    linea[b] = a + 1;
                }
                else 
                {
                    linea[b] = 0;
                }
            }
        }
    }
    public HanoiTowers()
    {
        higth = 3;
        towers = 3;
        with = higth + 1;

        matrix = new int[higth][towers];
        constLineas = new StringBuilder[higth];
        reiniciarLineas();

        int [] linea;
        for (int a = 0; a < matrix.length; a++)
        {
            linea = matrix[a];
            for (int b = 0; b < linea.length; b++)
            {
                if (b == 0)
                {
                    linea[b] = a + 1;
                }
                else 
                {
                    linea[b] = 0;
                }
            }
        }
    }
    /**
     * 
     * @param a: ancho anillos
     */
    public void makeSegment(int lin, int num)
    {
        if (num < 0)
        {
            num = 0;
        }

        final int blancos = with - num;
        final var sb = constLineas[lin];

        Runnable 
        r1 = ()->sb.append("."), 
        r2 = ()->sb.append("0");

        o.ofor(r1, blancos);
        o.ofor(r2, num);
        sb.append("|");
        o.ofor(r2, num);
        o.ofor(r1, blancos);

        sb.append("  ");
    } //:)

    /**
     * 
     * @param a linea a realizar
     */
    public void makeLine(int a)
    {
        int[] line = matrix[a];

        for (int k = 0; k < line.length; k++)
        {
            makeSegment(a, line[k]);
        }
    }

    private void reiniciarLineas()
    {
        for (int k = 0; k < constLineas.length; k++)
        {
            constLineas[k] = new StringBuilder();
        }
    }

    public String[] makeTowers()
    {
        String[] res = new String[matrix.length];

        //*
        class Link
        {
            private int num;
            public Link(int num)
            {
                this.num = num;
            }
            public int getNum() 
            {
                return --num;
            }
        }

        var l = new Link(matrix.length);

        Thread[] hilosLineas = new Thread[matrix.length];

        for (int k = 0; k < hilosLineas.length; k++)
        {
            var th = new Thread(()-> 
            {
                int numl = l.getNum();
                makeLine(numl);
                res[numl] = constLineas[numl].toString();
            });
            th.start();
            hilosLineas[k] = th;
            //hilosLineas[k].start();
        }

        for (var a : hilosLineas)
        {
            try {
                //if (a != null)
                a.join();
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
        //*/

        /*
        for (int k = 0; k < matrix.length; k++)
        {
            makeLine(k);
            res[k] = constLineas[k].toString();
        }
        //*/
        
        reiniciarLineas();
        return res;
    }

    public int topTower(int tower)
    {
        for (int k = 0, num; k < higth; k++)
        {
            num = matrix[k][tower];
            if (num != 0)
            {
                return num;
            }
        }
        return 0;
    }

    public int changeTop(final int tw, final int newNum) 
    {
        for (int k = 0, num; k < higth; k++)
        {
            num = matrix[k][tw];
            if (num != 0)
            {
                matrix[k][tw] = newNum;
                return num;
            }
        }
        matrix[higth-1][tw] = newNum;
        return 0;
    }
    public int putTop(final int tw, final int newNum) 
    {
        for (int k = 1, num; k < higth; k++)
        {
            num = matrix[k][tw];
            if (num != 0)
            {
                matrix[k-1][tw] = newNum;
                return num;
            }
        }
        matrix[higth-1][tw] = newNum;
        return 0;
    }

    public int move(int desde, int hasta)
    {
       final var res = changeTop(desde, 0);
       putTop(hasta, res);
       return res;
       //return replaceTop(hasta, putTop(desde, 0));
    }
    public boolean legalMove(int desde, int hasta)
    {
        if(topTower(desde) == 0 ) return false;
        if(topTower(hasta) == 0 ) return true;
        return (topTower(desde)+1) == (topTower(hasta));
    }

    public boolean gameFinish()
    {
        return matrix[0][towers-1] == 1;
    }

    public void printMatrix()
    {
        for (int[] a: matrix)
        {
            for (int b : a)
            {
                o.pr(b + " ,");
            }
            o.p();
        }
    }
}
