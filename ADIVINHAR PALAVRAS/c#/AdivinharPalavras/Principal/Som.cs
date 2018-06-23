using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

public class Som
{

    //Atributos(var) globais
    public static int tempoMiliPadrao = 250;    

    //Atributos auxiliares
    private static NotaMusical beepNota;
    private static int beepTempoMili;

    private static void Beep()
    {
        Console.Beep((int)beepNota, beepTempoMili);
    }

    public static void Play(int tempoMili, NotaMusical nota)
    {
        beepNota = nota;
        beepTempoMili = tempoMili;

        Thread thread = new Thread(
            new ThreadStart(Beep)
        );
        thread.Start();
        Thread.Sleep(tempoMili);
    }

    public static void Play(NotaMusical nota)
    {
        Play(tempoMiliPadrao, nota);
    }

    public static void Play(NotaMusical[] notas)
    {
        for (int cont = 0; cont < notas.Length; cont++)
        {
            Play(notas[cont]);
            Thread.Sleep(tempoMiliPadrao);
        }
    }

    public static void Play(int tempoMiliPadrao, NotaMusical[] notas)
    {
        for (int cont = 0; cont < notas.Length; cont++)
        {
            Play(tempoMiliPadrao, notas[cont]);
            Thread.Sleep(tempoMiliPadrao);
        }
    }

    public static void Play(NotaMusical[] notas, int[] temposMili)
    {
        for (int cont = 0; cont < notas.Length; cont++)
        {
            Play(temposMili[cont], notas[cont]);
            Thread.Sleep(temposMili[cont]);
        }
    }
    
}

