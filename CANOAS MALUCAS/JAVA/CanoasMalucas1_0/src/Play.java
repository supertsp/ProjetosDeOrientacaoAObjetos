import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import javax.swing.JTextArea;

/**
 * Data: 04.05.2016
 *
 * @author Tiago Penha Pedroso
 */
public class Play {

    public static final int TAMANHO_CANOA = 4;
    public static final int TAMANHO_RIO = 10;
    
    static final String NOME_JOGO = "Canoas Malucas";
    static final int PLAYER1 = 1;
    static final int PLAYER2 = 2;
    static String nomeP1;
    static String nomeCanoaP1;
    static String nomeP2;
    static String nomeCanoaP2;
    static boolean[] canoaP1 = new boolean[TAMANHO_CANOA];
    static boolean[] canoaP2 = new boolean[TAMANHO_CANOA];
    static boolean[] rioP1 = new boolean[TAMANHO_RIO];
    static boolean[] rioP2 = new boolean[TAMANHO_RIO];

    public static void main(String[] args) {
        
        //Iniciando
        resetCanoas();
        resetRios();
        exibirNoDialogo(NOME_JOGO + " - v.1.0");
        
        //Lendo Jogadores
        nomeP1 = lerString("PLAYER " + PLAYER1 + "\nDigite seu nome:");
        nomeP2 = lerString("PLAYER " + PLAYER2 + "\nDigite seu nome:");
        
        //Lendo Nome Canoas
        nomeCanoaP1 = lerString("PLAYER " + PLAYER1 + " - " + nomeP1 + "\nDigite o nome da sua canoa:");
        nomeCanoaP2 = lerString("PLAYER " + PLAYER2 + " - " + nomeP2 + "\nDigite o nome da sua canoa:");
                
        //Looping Principal
        while (!existeGanhador()) {            
            //Turno---
            
            //Movendo Canoas
            int posCanoaP1 = lerInt("<<MOVENDO>>   PLAYER " + PLAYER1 + " - " + nomeP1 + 
                            "\nDigite a posição inicial da canoa " + nomeCanoaP1 + 
                            ". Obs.: número entre 0 e " + (TAMANHO_RIO - 1));
            posCanoaP1 = validarPosicaoCanoa(posCanoaP1);
            moverCanoa(posCanoaP1,PLAYER1);
            
            int posCanoaP2 = lerInt("<<MOVENDO>>   PLAYER " + PLAYER2 + " - " + nomeP2 + 
                            "\nDigite a posição inicial da canoa " + nomeCanoaP2 + 
                            ". Obs.: número entre 0 e " + (TAMANHO_RIO - 1));
            posCanoaP2 = validarPosicaoCanoa(posCanoaP2);
            moverCanoa(posCanoaP2, PLAYER2);
            
            //Atirando
            atirar(
                    lerInt("ATIRANDO!!!!    PLAYER " + PLAYER1 + " - " + nomeP1 + 
                            "\nDigite o local do tiro " +
                            ". Obs.: número entre 0 e " + (TAMANHO_RIO - 1)), 
                    rioP2
            );
            
            atirar(
                    lerInt("ATIRANDO!!!!    PLAYER " + PLAYER2 + " - " + nomeP2 + 
                            "\nDigite o local do tiro " +
                            ". Obs.: número entre 0 e " + (TAMANHO_RIO - 1)), 
                    rioP1
            );
            
            //Salvando Status Atual
            atribuirRioACanoa(posCanoaP1, rioP1, canoaP1);
            atribuirRioACanoa(posCanoaP2, rioP2, canoaP2);
            
            //Mostrando Status
            exibirNoDialogoEspecial(playersToString());
        }
        
        //Mensagem Final
        if (!canoaFlutuando(canoaP1) && !canoaFlutuando(canoaP2)) {
            exibirNoDialogo("Game Over\nEmpatou :/ ");
        }
        else if (!canoaFlutuando(canoaP1)) {
            exibirNoDialogo("Game Over\nO " + nomeP2 + " VENCEU :)");
        }        
        else if (!canoaFlutuando(canoaP2)) {
            exibirNoDialogo("Game Over\nO " + nomeP1 + " VENCEU :)");
        }
    }
    
    public static String lerString(String mensagem) {
        return showInputDialog(null, mensagem, NOME_JOGO, JOptionPane.PLAIN_MESSAGE);
    }    
    
    public static int lerInt(String mensagem) {
        return Integer.parseInt(showInputDialog(null, mensagem, NOME_JOGO, JOptionPane.PLAIN_MESSAGE));
    }

    public static void exibirNoDialogo(String mensagem) {
        showMessageDialog(null, mensagem, NOME_JOGO, JOptionPane.PLAIN_MESSAGE);
    }
    
    public static void exibirNoDialogoEspecial(String mensagem) {
        JTextArea tArea = new JTextArea(mensagem);        
        tArea.setEditable(false);
        showMessageDialog(null, tArea, NOME_JOGO, JOptionPane.PLAIN_MESSAGE);
    }
    
    public static void exibirNoConsole(String mensagem){
        System.out.println(mensagem);
    }

    public static void resetRios() {
        for (int indice = 0; indice < TAMANHO_RIO; indice++) {
            rioP1[indice] = false;
            rioP2[indice] = false;
        }
    }

    public static void resetCanoas() {
        for (int indice = 0; indice < TAMANHO_CANOA; indice++) {
            canoaP1[indice] = true;
            canoaP2[indice] = true;
        }
    }

    public static void atribuirCanoaAoRio(int posicaoInicial, boolean[] canoa, boolean[] rio) {
        int indiceRio = posicaoInicial;

        for (int indiceCanoa = 0; indiceCanoa < TAMANHO_CANOA; indiceCanoa++) {
            rio[indiceRio] = canoa[indiceCanoa];
            indiceRio++;
        }
    }

    public static void atribuirRioACanoa(int posicaoInicial, boolean[] rio, boolean[] canoa) {
        int indiceRio = posicaoInicial;

        for (int indiceCanoa = 0; indiceCanoa < TAMANHO_CANOA; indiceCanoa++) {
            canoa[indiceCanoa] = rio[indiceRio];
            indiceRio++;
        }
    }
    
    public static int validarPosicaoCanoa(int posicaoCanoa) {
        if ((posicaoCanoa + TAMANHO_CANOA) > TAMANHO_RIO) {
            posicaoCanoa = posicaoCanoa - ((posicaoCanoa + TAMANHO_CANOA) - TAMANHO_RIO);
        }
        
        return posicaoCanoa;
    }
    
    public static void moverCanoa(int novaPosicaoCanoa, int player){
        novaPosicaoCanoa = validarPosicaoCanoa(novaPosicaoCanoa);
        System.out.println("posicaoCanoa: " + novaPosicaoCanoa);
        switch(player){
            case PLAYER1:
                atribuirCanoaAoRio(novaPosicaoCanoa, canoaP1, rioP1);
                break;
                
            case PLAYER2:
                atribuirCanoaAoRio(novaPosicaoCanoa, canoaP2, rioP2);
                break;
        }
        
    }
        
    public static boolean tiroValido(int posicaoTiro){
        return posicaoTiro >= 0 && posicaoTiro < TAMANHO_RIO;
    }
    
    public static void atirar(int posicaoTiro, boolean[] rio){
        System.out.println("tiro: " + posicaoTiro);
        if (tiroValido(posicaoTiro)) {
            rio[posicaoTiro] = false;
        }
    }
    
    public static boolean canoaFlutuando(boolean[] canoa){
        boolean aindaExiste = false;
        
        for (int i = 0; i < TAMANHO_CANOA; i++) {
            if (canoa[i]) {
                aindaExiste = true;
                break;
            }
        }
        
        return aindaExiste;
    }
    
    public static boolean existeGanhador(){
        boolean canoasFlutuando = canoaFlutuando(canoaP1) && canoaFlutuando(canoaP2);
        return !canoasFlutuando;
    }
    
    public static String playersToString() {
        /* MODELO
        
         +---------------+
         |PLAYER 1: JOÃO |
         +---------------+
         CANOA: BUBASSAURUX
         +-------+
         |X   X X|
         +-+-+-+-+
          0 1 2 3
        
         */

        String txt = "";
        int tamanhoNomeP1 = nomeP1.length();
        int tamanhoNomeP2 = nomeP2.length();
        String linhaBasePlayer = "+-----------------------------";
        String linhaBaseCanoa = "  +-+-+-+-+\n";
        
        //PLAYER 1--------------------------------------------------------------
        String linhaBaseP1 = linhaBasePlayer;
        
        for (int i = 0; i < tamanhoNomeP1; i++) {
            linhaBaseP1 += "-";
        }
        
        linhaBaseP1 += "-+\n";
        
        txt += linhaBaseP1 + "PLAYER 1: " + nomeP1 + " \n" + linhaBaseP1;
        
        txt += "CANOA: " + nomeCanoaP1 + "\n";
        
        txt += linhaBaseCanoa + "  |";
        
        for (int i = 0; i < TAMANHO_CANOA; i++) {
            if (i == TAMANHO_CANOA - 1) {
                txt += canoaP1[i] ? "X" : "-";
            }
            else{
                txt += canoaP1[i] ? "X " : "- ";
            }
        }
        
        txt += "|\n" + linhaBaseCanoa + "   0 1 2 3\n\n";
        
        //PLAYER 2--------------------------------------------------------------
        String linhaBaseP2 = linhaBasePlayer;
        
        for (int i = 0; i < tamanhoNomeP1; i++) {
            linhaBaseP2 += "-";
        }
        
        linhaBaseP2 += "-+\n";
        
        txt += linhaBaseP2 + "PLAYER 2: " + nomeP2 + " \n" + linhaBaseP2;
        
        txt += "CANOA: " + nomeCanoaP2 + "\n";
        
        txt += linhaBaseCanoa + "  |";
        
        for (int i = 0; i < TAMANHO_CANOA; i++) {
            if (i == TAMANHO_CANOA - 1) {
                txt += canoaP2[i] ? "X" : "-";
            }
            else{
                txt += canoaP2[i] ? "X " : "- ";
            }
        }
        
        txt += "|\n" + linhaBaseCanoa + "   0 1 2 3\n\n";

        return txt;
    }
    
}
