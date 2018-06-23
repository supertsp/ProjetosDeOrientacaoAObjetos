using System;
using System.Collections.Generic;
using System.Text;
using static Configs;

namespace Telas
{
    public class Tela02 : MagicConsole
    {

        public static void ExibirTudo(bool debug)
        {
            for (int cont = 0; cont < jogadores.Length; cont++)
            {
                string mensagem =
                    "                TURNO: " + turnos + ENTER_1 +
                    "VEZ: " + jogadores[cont].nome +
                        "                 PONTUAÇÃO: " + jogadores[cont].pontuacao + ENTER_3 +

                    "(" + (jogadores[cont].GetIndicePalavraAtual() + 1) +
                        "/" + qtdPalavrasPorJogador + ") PALAVRA: " +
                        GetUnderlines(
                                jogadores[cont]
                                        .GetTextoPalavraAtual()
                                        .Length) +
                        (debug ?
                            "           //" + jogadores[cont].GetTextoPalavraAtual() :
                            "") + ENTER_1 +
                    "       PONTOS: " + jogadores[cont].GetPalavraAtual().pontos + ENTER_3;

                //tem mais dicas?
                if (jogadores[cont].GetPalavraAtual().GetIndiceDicaAtual()
                        < jogadores[cont].GetPalavraAtual().GetLengthOfDicas())
                {

                    mensagem +=
                        "VOCÊ GOSTARIA DE USAR SUA DICA nº "
                            + (jogadores[cont].GetPalavraAtual().GetIndiceDicaAtual() + 1)
                            + "?" + ENTER_1 +
                        "DIGITE \"S\" (SIM) OU \"N\" (NÃO): ";

                    if (LerString(mensagem)
                            .Trim()
                            .ToUpper() == "S")
                    {

                        Exibir(ENTER_1 + "DICA: " + jogadores[cont].GetNextDica() + ENTER_1);
                    }
                }
                else
                {
                    Exibir(mensagem + ENTER_1);
                }

                string tentativa = LerString(ENTER_1 + "QUAL SERIA A PALAVRA CERTA? ");
                if (jogadores[cont].AdivinharPalavra(tentativa))
                {
                    Limpar();
                    jogadores[cont].pontuacao += jogadores[cont].GetPalavraAtual().pontos;
                    jogadores[cont].GetNextPalavra();
                    Tela03.ExibirSucesso(cont);
                }
                else
                {
                    Limpar();
                    Tela03.ExibirFracasso(cont);
                }

            }//for

            turnos++;

            Limpar();
        }

        public static void ExibirTudo()
        {
            ExibirTudo(false);
        }

    }
}
