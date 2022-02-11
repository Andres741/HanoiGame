import zzz.o;

public class App 
{
    //private String t3 = "";
    private final static int[] arr = {3,0,0};;
    private final static int ancho = arr.length + 1;

    public static void drawSegment(int a)
    {
        if (a < 0)
        {
            a = 0;
        }
        
        final int blancos = ancho - a;

        o.pr(".", blancos);
        o.pr("0", a);
        o.pr("|");
        o.pr("0", a);
        o.pr(".", blancos);

        o.pr("*");
    }

    public static void drawTowers()
    {
        for (int k = arr.length; k > 0; k--)
        {
            for (int i = 0; i < arr.length; i++)
            {
                drawSegment(arr[i]-k+1);
                //drawSegment(h.length-h[i]-k);
            }
            o.p();
        }
    }


    private static void mover(final int desde, final int hasta, final HanoiTowers h)
    {
        o.p("Movimiento desde la torre " + desde + " hasta la " + hasta);
        if(h.legalMove(desde, hasta))
        {
            o.pca("Movimiento legal");
        } else {
            o.pct("Movimiento ilegal");
        }

        o.p("Tamaño anillo movido: " + h.move(desde, hasta));
        o.p(h.makeTowers());
    }

    public static void main(String[] args) 
    {
        o.bhr();

        var h = new HanoiTowers(7,6);
        /*
        h.printMatrix();
        /*
        h.constLineas[0].append("Hola");
        h.constLineas[1].append("Holaa");
        h.constLineas[2].append("Holaaa");
        //*/
        o.p(h.makeTowers());
        o.hr();
        
        final int tw = 1;
        o.p("Top tower " + tw + ": " + h.topTower(tw));
        o.hr();
        mover(0, 1, h);
        o.hr();
        mover(0, 1, h);
        o.hr();
        mover(0, 2, h);
        o.hr();
        mover(1, 2, h);
        o.hr();
        mover(1, 2, h);
        o.hr();
        mover(0, 4, h);
        o.hr();
        mover(1, 3, h);
        o.hr();

        /*
        o.hr();
        String[] ss = {"Hola", "Holaa", "Holaaa"};
        o.p(ss);
        //*/

        o.bhr();
    }
}
/*
   0|0   *    |    *    |    *    |    *
  00|00  *   0|0   *    |    *    |    *
 000|000 *  00|00  *   0|0   *    |    *

    |    *    |    *    |    *
  00|00  *    |    *    |    *
 000|000 *   0|0   *    |    *
*/