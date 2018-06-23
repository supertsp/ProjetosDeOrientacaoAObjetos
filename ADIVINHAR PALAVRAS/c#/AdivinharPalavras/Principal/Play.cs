using System;
using static System.Console;
using static System.ConsoleColor;
using static Telas.MagicConsole;
using static Configs;
using static NotaMusical;
using Telas;

public class Play
{
    
    public static void Main(string[] args)
    {
        //Console.WriteLine(
        //    "Seu nome é {0}, sua idade é {1}, vc nasceu em {2}, seu sexo é {3}",
        //    "Lais", 24, 1993, "feminino"
        //);

        //INICIALIZANDO O PROJETO
        Configs.qtdJogadores = 3;
        Configs.qtdPalavrasPorJogador = 3;
        Configs.Inicializar();

        ////TELA 01 - ABERTURA
        //Tela01.ExibirTudo();

        ////TELA 02 e 03 - REPETINDO ATÉ ACABAR O JOGO
        //bool continuaJogo = true;

        //do
        //{
        //    Tela02.ExibirTudo(true);

        //    for (int cont = 0; cont < jogadores.Length; cont++)
        //    {
        //        if (jogadores[cont].AdivinhouTodasPalavras())
        //        {
        //            continuaJogo = false;
        //        }
        //    }
        //} while (continuaJogo);

        ////TELA 04 - ENCERRAMENTO
        //Tela04.ExibirTudo();
    }
}