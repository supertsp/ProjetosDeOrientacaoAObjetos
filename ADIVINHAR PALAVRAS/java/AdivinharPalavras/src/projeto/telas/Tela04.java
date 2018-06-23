package projeto.telas;

import static projeto.Configs.*;

/**
 * @author Tiago Penha Pedroso
 * Date: 29/05/2018, 08:18:01
 */

public class Tela04 extends Tela{
    
    public static void exibirTudo() {
        String mensagem = 
            "          *-----------------------*" + ENTER_1+
            "          |      PLACAR FINAL     |" + ENTER_1 +
            "          *-----------------------*" + ENTER_2;
        
        String nomeVencedor = "";
        int maiorPontos = 0;
        
        for (int cont = 0; cont < jogadores.length; cont++) {
            mensagem += 
                "JOGADOR " + (cont + 1) + ": " + 
                    jogadores[cont].nome + ENTER_1 +
                "  PONTURAÇÃO: " + jogadores[cont].pontuacao + ENTER_2;
            
            //descobrindo quem fez + pontos
            if (jogadores[cont].pontuacao > maiorPontos) {
                maiorPontos = jogadores[cont].pontuacao;
                nomeVencedor = jogadores[cont].nome;
            }
            
        }
        
        mensagem += ENTER_1 +
            "PARABÉNS " + nomeVencedor + "!!! VOCÊ ACERTOU TODAS :)" + ENTER_1 +
            "  AGORA VÔCE JÁ ESTÁ PRONTO PRO ENEM!" + ENTER_1;
        
        exibir(mensagem);
    }
    
}