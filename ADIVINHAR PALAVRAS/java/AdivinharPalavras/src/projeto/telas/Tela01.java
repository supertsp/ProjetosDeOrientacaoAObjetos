package projeto.telas;

import projeto.Jogador;
import projeto.Configs;

/**
 * @author Tiago Penha Pedroso
 * Date: 28/05/2018, 15:11:08
 */

public class Tela01 extends Tela{
    
    public static void exibirTudo(){
        limpar();
        exibir("BEM-VINDO AO JOGO DE ADIVINHAR PALAVRAS :)" + ENTER_2);
        
        for (int cont = 0; cont < Configs.jogadores.length; cont++) {
            Configs.jogadores[cont].nome = 
                lerString(
                        "JOGADOR " + (cont + 1) +
                        "\nDIGITE SEU NOME: "
                );
        
            exibir(ENTER_1);
        }
        
        limpar();
    }
    
}