package projeto.telas;

import static projeto.Configs.*;

/**
 * @author Tiago Penha Pedroso Date: 28/05/2018, 15:29:31
 */
public class Tela02 extends Tela {

    public static void exibirTudo(boolean debug) {
        for (int cont = 0; cont < jogadores.length; cont++) {
            String mensagem = 
                "                TURNO: " + turnos + ENTER_1 +
                "VEZ: " + jogadores[cont].nome + 
                    "                 PONTUAÇÃO: " + jogadores[cont].pontuacao + ENTER_3 +
                
                "(" + (jogadores[cont].getIndicePalavraAtual() + 1) +
                    "/" + qtdPalavrasPorJogador + ") PALAVRA: " +
                    getUnderlines(
                            jogadores[cont]
                                    .getTextoPalavraAtual()
                                    .length()) +
                    (debug ?
                        "           //" + jogadores[cont].getTextoPalavraAtual() :
                        "") + ENTER_1 +
                "       PONTOS: " + jogadores[cont].getPalavraAtual().pontos + ENTER_3;
                
            //tem mais dicas?
            if (jogadores[cont].getPalavraAtual().getIndiceDicaAtual()
                    < jogadores[cont].getPalavraAtual().getLengthOfDicas()) {
                
                mensagem += 
                    "VOCÊ GOSTARIA DE USAR SUA DICA nº "
                        + (jogadores[cont].getPalavraAtual().getIndiceDicaAtual() + 1)
                        + "?" + ENTER_1 +
                    "DIGITE \"S\" (SIM) OU \"N\" (NÃO): ";
                
                if (lerString(mensagem)
                        .trim()
                        .toUpperCase()
                        .equals("S")) {
                    
                    exibir(ENTER_1 + "DICA: " + jogadores[cont].getNextDica() + ENTER_1);
                }
            }
            else{
                exibir(mensagem + ENTER_1);
            }
            
            String tentativa = lerString(ENTER_1 + "QUAL SERIA A PALAVRA CERTA? ");
            if (jogadores[cont].adivinharPalavra(tentativa)) {
                limpar();
                jogadores[cont].pontuacao += jogadores[cont].getPalavraAtual().pontos;                
                jogadores[cont].getNextPalavra();
                Tela03.exibirSucesso(cont);
            }
            else{
                limpar();
                Tela03.exibirFracasso(cont);
            }
            
        }//for
        
        turnos++;

        limpar();
    }    
    
    public static void exibirTudo() {
        exibirTudo(false);
    }
}
