import java.io.IOException;

import zzz.o;

public class HanoiGame 
{
    public static HanoiTowers h;
    public  static int moves = 0;
    
    public static int preguntarDesde() throws IOException
    {
        final int res = o.inInt(0, "¿De qué torre vas a cojer el disco?: ", h.towers);
        return res-1;
    }
    public static int preguntarHasta() throws IOException
    {
        final int res = o.inInt(0, "A cuál torre vas a depositar el disco?: ", h.towers);
        return res-1;
    }

    public static void movimiento() throws IOException
    {
        o.p();
        o.hr();

        final int
        desde = preguntarDesde(),
        hasta = preguntarHasta();
        o.p();

        if (h.legalMove(desde, hasta))
        {
            moves++;

            o.p("Has movido el disco " + h.move(desde, hasta));
            o.p(h.makeTowers());
        }
        else
        {
            o.p("El movimiento no se puede realizar");
            o.p(h.makeTowers());
        }
    }

    public static void main(String[] args) throws IOException
    {
        o.bhr();

        o.p("¡Bievenido al juego de las torres de hanoi!".toUpperCase());
        h = new HanoiTowers(o.inInt(0, "¿Cuántos discos van a haber en las torres?", 7));
        o.hr();

        o.p(h.makeTowers());

        do
        {
            movimiento();
        } while (! h.gameFinish());
        o.hr();

        o.p("Has conseguido completar el juego con " + moves + " movimientos.");

        o.bhr();
    }
}
