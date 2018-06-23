using System;
using System.Collections;
using System.Collections.Generic;

public class Program
{
    public static void Main(string[] args)
    {
        string nomeJogador1 = LerTexto("Digite o nick do Jogador 1: ");
        string nomeJogador2 = LerTexto("Digite o nick do Jogador 2: ");
        string nomeCanoa1 = LerTexto("Digite o nome da canoa do Jogador 1: ");
        string nomeCanoa2 = LerTexto("Digite o nome da canoa do Jogador 2: ");
        MostrarMensagem("");

        Canoa canoa1 = new Canoa(4);
        canoa1.nome = nomeCanoa1;

        Canoa canoa2 = new Canoa(4);
        canoa2.nome = nomeCanoa2;

        Rio rioP1 = new Rio(10, canoa1);
        Rio rioP2 = new Rio(10, canoa2);

        Jogador p1 = new Jogador(1, nomeJogador1, rioP1);
        Jogador p2 = new Jogador(2, nomeJogador2, rioP2);

        MostrarMensagem(p1 + "\n------------\n" + p2);
        MostrarMensagem("");

        while (!p1.VenceuInimigo(p2) && !p2.VenceuInimigo(p1))
        {
            //Movendo as canoas
            p1.rio.MoverCanoa(LerNumeroInteiro(
                    "PLAYER 1, " + p1.nick + ", digite a posição da canoa no Rio: "
            ));
            MostrarMensagem("");
            p2.rio.MoverCanoa(LerNumeroInteiro(
                    "PLAYER 2, " + p2.nick + ", digite a posição da canoa no Rio: "
            ));
            MostrarMensagem("");

            //Atirando
            p1.AtirarFlecha(
                LerNumeroInteiro("PLAYER 1, " + p1.nick + ", digite a posição do tiro da flecha: ")
                , p2
            );
            MostrarMensagem("");
            p2.AtirarFlecha(
                LerNumeroInteiro("PLAYER 2, " + p2.nick + ", digite a posição do tiro da flecha: ")
                , p1
            );
            MostrarMensagem("");

            //Estatísticas de jogo
            MostrarMensagem(p1 + "\n------------\n" + p2);
            MostrarMensagem("");
        }

        if (p1.VenceuInimigo(p2) && p2.VenceuInimigo(p1))
        {
            MostrarMensagem("Deu empate!!!");
        }
        else if (p1.VenceuInimigo(p2))
        {
            MostrarMensagem("Player 1 Venceu");
        }
        else if (p2.VenceuInimigo(p1))
        {
            MostrarMensagem("Player 2 Venceu");
        }
    }
    public static void MostrarMensagem(Object novaMensagem)
    {
        Console.WriteLine(novaMensagem);
    }
    public static int LerNumeroInteiro(string novaMensagem)
    {
        Console.Write(novaMensagem);
        return int.Parse(Console.ReadLine());
    }
    public static double LerNumeroReal(string novaMensagem)
    {
        Console.Write(novaMensagem);
        return double.Parse(Console.ReadLine());
    }
    public static string LerTexto(string novaMensagem)
    {
        Console.Write(novaMensagem);
        return Console.ReadLine();
    }
}