using System;
using System.Collections.Generic;
using System.Text;
using static Configs;

namespace Telas
{
    public class Tela04 : MagicConsole
    {

        public static void ExibirTudo()
        {
            string mensagem =
                "          *-----------------------*" + ENTER_1 +
                "          |      PLACAR FINAL     |" + ENTER_1 +
                "          *-----------------------*" + ENTER_2;

            string nomeVencedor = "";
            int maiorPontos = 0;

            for (int cont = 0; cont < jogadores.Length; cont++)
            {
                mensagem +=
                    "JOGADOR " + (cont + 1) + ": " +
                        jogadores[cont].nome + ENTER_1 +
                    "  PONTURAÇÃO: " + jogadores[cont].pontuacao + ENTER_2;

                //descobrindo quem fez + pontos
                if (jogadores[cont].pontuacao > maiorPontos)
                {
                    maiorPontos = jogadores[cont].pontuacao;
                    nomeVencedor = jogadores[cont].nome;
                }

            }

            mensagem += ENTER_1 +
                "PARABÉNS " + nomeVencedor + "!!! VOCÊ ACERTOU TODAS :)" + ENTER_1 +
                "  AGORA VÔCE JÁ ESTÁ PRONTO PRO ENEM!" + ENTER_1;

            Exibir(mensagem);
        }

    }
}
