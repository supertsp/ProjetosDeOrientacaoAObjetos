package projeto.telas;

import static projeto.Configs.*;

/**
 * @author Tiago Penha Pedroso Date: 28/05/2018, 16:08:00
 */
public class Tela03 extends Tela {

    public static void exibirSucesso(int indiceJogador) {
        String mensagem = 
            "                TURNO: " + turnos + ENTER_1 +
            "VEZ: " + jogadores[indiceJogador].nome + 
                "                 PONTUAÇÃO: " + jogadores[indiceJogador].pontuacao + ENTER_2 +
            
            "PARABÉNS!!! VOCÊ ACERTOU A PALAVRA SECRETA :)" + ENTER_1 +
            "SINTA-SE UM LEVEL + INTELIGENTE NA SUA VIDA ♥" + ENTER_3 +
            
            "             +" +
                jogadores[indiceJogador].pontuacao + "pts" + ENTER_3 +
            
            "VOCÊ GOSTARIA DE CONTINUAR O JOGO?" + ENTER_1 + 
            "DIGITE \"S\" (SIM) OU \"N\" (NÃO): ";
        
        if (lerString(mensagem)
                .trim()
                .toUpperCase()
                .equals("N")) {

            System.exit(0);
        }

        limpar();
    }

    public static void exibirFracasso(int indiceJogador) {
        String mensagem = 
            "                TURNO: " + turnos + ENTER_1 +
            "VEZ: " + jogadores[indiceJogador].nome + 
                "                 PONTUAÇÃO: " + jogadores[indiceJogador].pontuacao + ENTER_2 +
            
            "OHHHH NÃÃÃOOOOO!!! :)" + ENTER_1 +
            "POR FAVOR, NÃO DESISTA! TENTE NOVAMENTE ;)" + ENTER_4 +
                       
            "VOCÊ GOSTARIA DE CONTINUAR O JOGO?" + ENTER_1 + 
            "DIGITE \"S\" (SIM) OU \"N\" (NÃO): ";
        

        if (lerString(mensagem)
                .trim()
                .toUpperCase()
                .equals("N")) {

            System.exit(0);
        }

        limpar();
    }

}
