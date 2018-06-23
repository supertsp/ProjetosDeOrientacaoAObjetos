using System;
using System.Collections.Generic;
using System.Text;

namespace Telas
{
    public class Tela01 : MagicConsole
    {

        public static void ExibirTudo()
        {
            Limpar();
            Exibir("BEM-VINDO AO JOGO DE ADIVINHAR PALAVRAS :)" + ENTER_2);

            for (int cont = 0; cont < Configs.jogadores.Length; cont++)
            {
                Configs.jogadores[cont].nome =
                    LerString(
                            "JOGADOR " + (cont + 1) +
                            "\nDIGITE SEU NOME: "
                    );

                Exibir(ENTER_1);
            }

            Limpar();
        }

    }
}
