using System;
using System.Collections.Generic;
using System.Text;
using static Configs;

namespace Telas
{
    public class Tela03 : MagicConsole
    {

        public static void ExibirSucesso(int indiceJogador)
        {
            string mensagem =
                "                TURNO: " + turnos + ENTER_1 +
                "VEZ: " + jogadores[indiceJogador].nome +
                    "                 PONTUAÇÃO: " + jogadores[indiceJogador].pontuacao + ENTER_2 +

                "PARABÉNS!!! VOCÊ ACERTOU A PALAVRA SECRETA :)" + ENTER_1 +
                "SINTA-SE UM LEVEL + INTELIGENTE NA SUA VIDA ♥" + ENTER_3 +

                "             +" +
                    jogadores[indiceJogador].pontuacao + "pts" + ENTER_3 +

                "VOCÊ GOSTARIA DE CONTINUAR O JOGO?" + ENTER_1 +
                "DIGITE \"S\" (SIM) OU \"N\" (NÃO): ";

            if (LerString(mensagem)
                    .Trim()
                    .ToUpper() == "N")
            {
                Environment.Exit(0);
            }

            Limpar();
        }

        public static void ExibirFracasso(int indiceJogador)
        {
            string mensagem =
                "                TURNO: " + turnos + ENTER_1 +
                "VEZ: " + jogadores[indiceJogador].nome +
                    "                 PONTUAÇÃO: " + jogadores[indiceJogador].pontuacao + ENTER_2 +

                "OHHHH NÃÃÃOOOOO!!! :)" + ENTER_1 +
                "POR FAVOR, NÃO DESISTA! TENTE NOVAMENTE ;)" + ENTER_4 +

                "VOCÊ GOSTARIA DE CONTINUAR O JOGO?" + ENTER_1 +
                "DIGITE \"S\" (SIM) OU \"N\" (NÃO): ";


            if (LerString(mensagem)
                    .Trim()
                    .ToUpper() == "N")
            {
                Environment.Exit(0);
            }

            Limpar();
        }

    }
}
