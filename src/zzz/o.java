package zzz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class o 
{
	public final static String cTriste = ":(";
	public final static String cAlegre = ":)";
	public final static int elPuerto = 44444;
	private final static int numBarritas = 71;
	
	private o() {}
	
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void p(Object o)
	{
		System.out.println(o);
	}
    
    public static void p(Object o0, Object o1, boolean con)
	{
        oIf( ()->p(o0) , ()->p(o1) , con);
	}
	public static void p(Object[] o)
	{
        for (var a : o) 
        {
            System.out.println(a.toString());
        }
	}
	
	public static void p()
	{
		System.out.println();
	}
	
	public static void pct(Object o)
	{
		pr(o);
		pr(" ");
		p(cTriste);
	}
	
	public static void pct()
	{
		p(cTriste);
	}
	
	public static void pca(Object o)
	{
		pr(o);
		pr(" ");
		p(cAlegre);
	}
	
    public static void pca()
	{
		p(cAlegre);
    }

	public static void pr(Object o)
	{
		System.out.print(o);
	}

	public static void pr(Object o, int n)
	{
		ofor (() -> System.out.print(o), n);
	}
	
	public static void hr()
	{
        /*
        var r = new Runnable[2];
        r[0] = () -> pr("-");
        r[1] = () -> pr(" ");
        */

        Runnable[] r = { ()->pr("-") , ()->pr(" ") };

        ofor(r, numBarritas);
        p();
	}
    
    public static void hr(int n)
	{
        ofor(()->hr(), n);
    }
    public static void bhr()
	{
        p();

        ofor(()->pr("-"), numBarritas);

		p();	
		p();	
    }
    
	/**
	 * Devuelve true se se respode "si o false se se responde "no".
	 * Imprime el string que se le pase por par�metro a no ser que sea null, 
	 * y adem�s si la respuesta ha sido distinta de "si" o "no" se vuelve a 
	 * imprimir el mismo String y a esperar una nueva respuesta.
	 * 
	 * @param pregunta
	 * @return boolean
	 * @throws IOException
	 */
    public static boolean respuestaAfirmativa(String pregunta) throws IOException
    {
        if (pregunta != null)
        {
            p(pregunta + "(Si/No)");
        }
        String res = in.readLine();
        
        if (res.equalsIgnoreCase("si"))
        {
        	return true;
        } 
        else if (res.equalsIgnoreCase("no")) 
        {
        	return false;
        } 
        else 
        {
            p("Respuesta no v�lida");
            return respuestaAfirmativa(pregunta);
        }
    }
    /**
     * Funciona de forma similar al metodo respuestaAfirmativa, pere este devuelve un n�mero 
     * entre los dos dados por par�metro.
     * 
     * @param pregunta
     * @param min
     * @param max
     * @return int
     * @throws IOException
     */
    public static int inInt(int min, String pregunta, int max) throws IOException
    {
        int res = 0;
        if (pregunta != null)
        {
            p(pregunta);
        }
        Scanner sc = new Scanner(in.readLine());
        
        if (!sc.hasNextInt())
        {
            p("No se ha encontrado el n�mero, vuelva a escribirlo:");
            return inInt(min, pregunta, max);
        }
        res = sc.nextInt();
        if (min > res || res > max)
        {
            p("Número no admitido.");
            p("Escriba un número entre " + min + " y " + max + ":");
            return inInt(min, pregunta, max);
        }
        return res;
    }
    
    /**
     * Devuleve el string el metodo pide escribir al usuario y escribe el String 
     * que se le pasa por par�metro si no es null.
     * 
     * @param pregunta
     * @return
     * @throws IOException
     */
    public static String in(String pregunta) throws IOException
    {
        if (pregunta != null)
        {
            p(pregunta);
        }
        return in.readLine();
    }
    
    /**
     * Devuelve una array de String pidi�ndoselos al usuario hasta que este escriba "fin", 
     * admitiendo solo los nombres que no est�n registrados del tipo de persona especificado.
     * @param pregunta
     * @param tipoPersona: solo admitido "paciente", "enfermero" y "tecnico" como argumento.
     * @return
     * @throws IOException
     */
    public static String[] inArgs(String pregunta) throws IOException
    {
    	LinkedList<String> args = new LinkedList<String>();
        if (pregunta != null)
        {
            p(pregunta);
        }
        
        p("Para terminar escriba 'Fin':");
        
        for(String res = in.readLine();
           !res.equalsIgnoreCase("fin");
            res = in.readLine())
        {
        	args.add(res);
        }
        
        return args.toArray(new String[0]);
    }
    
    public static void dor(final int millis)
    {
    	try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    public static void ofor(final Runnable r, final int reps)
    {
        for(int k = 0; k < reps; k++)
        {
            r.run();
        }
    }

    public static void ofor(final Runnable[] r, final int reps)
    {
        for(int k = 0; k < reps; k++)
        {
            r[k%r.length].run();
        }
    }

    public static void ofor2(final Runnable[] r, final int repfe)
    {
        final int reps = repfe * r.length;
        for(int k = 0; k < reps; k++)
        {
            r[k%r.length].run();
        }
    }

    public static void oIf(final Runnable r0, final Runnable r1, final boolean con) 
    {
        if (con) {
            r0.run();
        } else {
            r1.run();
        }
    }

    public static String remp(String texto, String reemlazo, String cambio)
    {
        var res = new StringBuilder();
        var recolector = new StringBuilder();
        int cont = 0;

        for (int k = 0; k < texto.length(); k++)
        {
            //
            if (texto.charAt(k) == cambio.charAt(cont))
            {
                cont++;
                if (cont == cambio.length())
                {
                    res.append(reemlazo);
                    recolector = new StringBuilder();
                    cont = 0;
                }
                else
                {
                    recolector.append(texto.charAt(k));
                }
            }
            else
            {
                res.append(recolector);
                recolector = new StringBuilder();
                res.append(texto.charAt(k));
                cont = 0;
            }
        }

        return res.toString();
    }

    public static String upper(String texto)
	{
        var res = new StringBuilder();

        char[] c =  new char[1];
        String s;

        for (int k = 0; k < texto.length(); k++)
        {
            c[0] = texto.charAt(k);
            s = new String(c);
            s = s.toUpperCase();
            res.append(s);
        }

        return res.toString();
    }

    public static String lower(String texto)
	{
        var res = new StringBuilder();
        
        char[] c =  new char[1];
        String s;

        for (int k = 0; k < texto.length(); k++)
        {
            c[0] = texto.charAt(k);
            s = new String(c);
            s = s.toLowerCase();
            res.append(s);
        }

        return res.toString();
    }


    /**
     *o.start( () ->
     *{
     *    Code_lines 
     *});

     *<hr/>

     *Thread t = o.start( () ->
     *{
     *    Code_lines 
     *});
     * 
     * @param r El runable que se ejecutará e un nuevo hilo. 
     * @return Un hilo en ejecución que incorpora al parámetro r.
     */
    public static Thread start(final Runnable r)
    {
        final Thread t = new Thread(r);
        t.start();
        return t;
    }
    public static Thread start(final Runnable r, byte prior)
    {
        /*
        prior = (prior > Thread.MAX_PRIORITY)?Thread.MAX_PRIORITY:prior;
        prior = (prior < Thread.MIN_PRIORITY)?Thread.MIN_PRIORITY:prior;
        */

        if (prior < Thread.MIN_PRIORITY)
            prior = Thread.MIN_PRIORITY;
        
        else if (prior > Thread.MAX_PRIORITY)
            prior = Thread.MAX_PRIORITY;

        final Thread t = new Thread(r);
        t.setPriority(prior);
        t.start();
        return t;
    }
    
    public static Thread start(final Runnable r, final boolean newThead)
    {
        final Thread t = new Thread(r);

        if (newThead) 
        {
            t.start();
        } 
        else 
        {
            r.run();
        }
        
        return t;
    }

    /**
     *Thread t = o.thread( () ->
     *{
     *    Code_lines 
     *});

     * @param r El Runnable que se envolverá en un Thread
     * @return Un hilo sin ejecutarse que incorpora a r.
     */
    public static Thread thread(final Runnable r)
    {
        return new Thread(r);
    }

    public static LinkedList<String> textToWords(String text) 
    {
        var res = new LinkedList<String>(); 
        var sb = new StringBuilder();
        char c;

        for (int i = 0; i < text.length(); i++) 
        {
            c = text.charAt(i);

            if(Character.isLetter(c))
            {
                sb.append(c);
            }
            else if(sb.length() != 0)
            {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        return res;
    }

    public static HashMap<String, Integer> multipicityWords(Iterable<String> words) 
    {
        var hash = new HashMap<String, Integer>();

        for (String s : words) 
        {
            if (hash.containsKey(s))
            {
                hash.replace(s, hash.get(s) + 1);
            }
            else 
            {
                hash.put(s, 1);
            }
            
        }

        return hash;
    }

    public static HashMap<String, Integer> multipicityWords(String text) 
    {
        return multipicityWords(textToWords(text));
    }

    public static void upDownStack(Stack<Integer> s)
    {
        var ss = new Stack<Integer>();
        var sss = new Stack<Integer>();

        while(!s.empty())
        {
            ss.add(s.pop());
        }
        while(!ss.empty())
        {
            sss.add(ss.pop());
        }
        while(!sss.empty())
        {
            s.add(sss.pop());
        }
    }
    public static void upDownStackR(Stack<Integer> s)
    {
        if (!s.empty()) 
        {
            Integer ob = s.pop();
            upDownStackR(s);
            upDownStackRHelper(s, ob);
        }
    }
    public static void upDownStackRHelper(Stack<Integer> s, Integer i)
    {
        if (s.empty()) 
        {
            s.add(i);
        }
        else
        {
            Integer ob = s.pop();
            upDownStackRHelper(s, ob);
            s.add(i);
        }
    }
    public static void upDownStackRn(Stack<Integer> s)
    {
        if (!s.empty()) 
        {
            Integer ob = s.pop();
            upDownStackRn(s);
            upDownStackRnHelper(s, ob);
        }
    }
    public static void upDownStackRnHelper(Stack<Integer> s, Integer i)
    {
        if (s.empty()) 
        {
            s.add(i);
        }
        else
        {
            Integer ob = s.pop();
            upDownStackRHelper(s, ob);
            s.add(i);
        }
    }



    public static void main(String[] args) 
    {
        bhr();

        //*
        var s = "Leonardo III Tocco (después de 1436-antes de agosto de 1503) fue el último déspota de Epiro y conde palatino de Cefalonia y Zacinto, territorios que gobernó desde la muerte de su padre Carlo II Tocco en 1448 hasta su conquista por el Imperio otomano en 1479. Leonardo fue uno de los últimos gobernantes latinos independientes en poseer territorios en la Grecia continental. Después de la caída de su reino, huyó a Italia, donde se convirtió en terrateniente y diplomático, pero continuó reclamando sus títulos en el exilio hasta su muerte." + 
        "Aunque heredó numerosas posesiones en la Grecia continental, la mayoría de estas, incluida la capital en Arta, fueron conquistadas por los otomanos en 1449, el primer año de su reinado. Heredó el trono cuando todavía era menor de edad, por lo que su gobierno estuvo encabezado por un consejo de regencia de cuatro miembros durante varios años. Al ser lo suficientemente mayor para gobernar por sí mismo, ordenó asesinar a todos sus antiguos regentes. A pesar de que Leonardo participó en varias actividades antiotomanas, como cooperar con la República de Venecia en la primera guerra turco-veneciana (1463-1479), su reino permaneció en paz durante la mayor parte del período, lo que permitió que sus posesiones insulares devinieran en una de las regiones más prósperas de Grecia.";
        //*/
        //var s = ". a a a bbb hola mundo do do do de a a a , , ! ! = k";
        //String[] s = {"a", "c"};
        var a = multipicityWords(s);
        var ks = a.keySet();

        class Cont
        {
            int num;

            Cont()
            {
                num = 0;
            }

            void contpp()
            {
                num++;
            }
            int getNum() 
            {
                return num;
            }
        }
        var cont = new Cont();

        ks.forEach((k)-> 
        {
            p(k + ": " + a.get(k));
            cont.contpp();
        });
        p();
        p("Numero de elementos: " + cont.getNum());
        p("Si si, " + ks.size());

        hr();

        var st = new Stack<Integer>();
        for (int i = 0; i < 10; i++) 
        {
            st.add(i);
        }

        st.forEach((num)->
        {
            pr(num + ", ");
        });
        upDownStack(st);
        p();
        st.forEach((num)->
        {
            pr(num + ", ");
        });
        p();

        hr();

        int nnn = 0;
        for (int i = 0; i <= 1000; i++) 
        {
            nnn += i;
        }
        p(nnn);

        hr();
        String[] noms = {"Ana Belén ", "Andrés", "Sara", "Ae12", "Z", "Daniel ", "Vanesa Ana Virginia", "Ramiro"};


        for (var n : noms) 
        {
            pr(n);
            //if(n.matches("^([A-Z Á-Ú][a-z á-ú]+[ ]?)+$"))
            if(n.matches("^[A-Z Á-Ú][a-z á-ú]+([A-Z Á-Ú a-z á-ú][ ])*$") || n.matches("^[A-Z Á-Ú a-z á-ú]*[ ][a-z á-ú]$"))
            {
                p(": 1");
            }
            else 
            {
                p(": 0");
            }
        }

        bhr();
    }
}