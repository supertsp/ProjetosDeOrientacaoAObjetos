package projeto;

import static projeto.Configs.*;
import projeto.telas.*;
import static projeto.telas.Tela.*;

/**
 *
 * @author tiago
 */
public class Play {

    public static void main(String[] args) {
        //INICIALIZANDO O PROJETO
        Configs.qtdJogadores = 3;
        Configs.qtdPalavrasPorJogador = 2;
        Configs.inicializar();
        
        Tela.usarJOptionPane = true;

        //TELA 01 - ABERTURA
        Tela01.exibirTudo();
        
        //TELA 02 e 03 - REPETINDO ATÉ ACABAR O JOGO
        boolean continuaJogo = true;
        
        do{
            Tela02.exibirTudo(true);
            
            for (int cont = 0; cont < jogadores.length; cont++) {
                if (jogadores[cont].adivinhouTodasPalavras()) {                    
                    continuaJogo = false;
                }
            }
        }while(continuaJogo);
        
        //TELA 04 - ENCERRAMENTO
        Tela04.exibirTudo();
    }
    
}
