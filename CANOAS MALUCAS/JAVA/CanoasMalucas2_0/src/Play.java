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
    static Player p1, p2;

    public static void main(String[] args) {
        
        //Iniciando        
        exibirNoDialogo(NOME_JOGO + " - v.2.0");
        
        //Lendo Jogadores
        p1 = new Player(
                lerString("PLAYER " + PLAYER1 + "\nDigite seu nome:"), 
                lerString("PLAYER " + PLAYER1 + "\nDigite o nome da sua canoa:"), 
                TAMANHO_CANOA, 
                TAMANHO_RIO
        );
        
        p2  = new Player(
                lerString("PLAYER " + PLAYER2 + "\nDigite seu nome:"), 
                lerString("PLAYER " + PLAYER2 + "\nDigite o nome da sua canoa:"), 
                TAMANHO_CANOA, 
                TAMANHO_RIO
        );
                
        //Looping Principal
        while (!existeGanhador()) {            
            //Turno---
            
            //Movendo Canoas
            p1.moverCanoa(
                    lerInt("<<MOVENDO>>   PLAYER " + PLAYER1 + " - " + p1.nome + 
                            "\nDigite a posição inicial da canoa " + p1.canoa.nome + 
                            ".\nObs.: número entre 0 e " + (TAMANHO_RIO - 1)
                    )
            );
            
            p2.moverCanoa(
                    lerInt(
                            "<<MOVENDO>>   PLAYER " + PLAYER2 + " - " + p2.nome + 
                            "\nDigite a posição inicial da canoa " + p2.canoa.nome + 
                            ".\nObs.: número entre 0 e " + (TAMANHO_RIO - 1)
                    )
            );
            
            
            //Atirando
            p1.atirar(
                    lerInt(
                            "ATIRANDO!!!!    PLAYER " + PLAYER1 + " - " + p1.nome + 
                            "\nDigite o local do tiro " +
                            ".\nObs.: número entre 0 e " + (TAMANHO_RIO - 1)
                    ),
                    p2
            );
            
            p2.atirar(
                    lerInt(
                            "ATIRANDO!!!!    PLAYER " + PLAYER2 + " - " + p2.nome + 
                            "\nDigite o local do tiro " +
                            ".\nObs.: número entre 0 e " + (TAMANHO_RIO - 1)
                    ),
                    p1
            );
            
            
            //Salvando Status Atual
            p1.atualizarDano();
            p2.atualizarDano();
            
            //Mostrando Status
            exibirNoDialogoEspecial(playersToString());
        }
        
        //Mensagem Final
        if (p1.perdeu() && p2.perdeu()) {
            exibirNoDialogo("Game Over\nEmpatou :/ ");
        }
        else if (p1.perdeu()) {
            exibirNoDialogo("Game Over\nO " + p2.nome + " VENCEU :)");
        }        
        else if (p2.perdeu()) {
            exibirNoDialogo("Game Over\nO " + p1.nome + " VENCEU :)");
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Métodos de Exibição: lerString(), lerInt(), exibirNoDialogo(), exibirNoDialogoEspecial() e exibirNoConsole()">
    public static String lerString(String mensagem) {
        return showInputDialog(null, mensagem, NOME_JOGO, JOptionPane.PLAIN_MESSAGE);
    }    
    
    public static int lerInt(String mensagem) {
        int numero = -1;
        
        try{
            numero = Integer.parseInt(showInputDialog(null, mensagem, NOME_JOGO, JOptionPane.PLAIN_MESSAGE));
        }catch(Exception e){}
        
        return numero;
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
    // </editor-fold>
        
    public static boolean existeGanhador(){        
        return p1.perdeu() || p2.perdeu();
    }
    
    // <editor-fold defaultstate="collapsed" desc="playersToString()">
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
                
        //PLAYER 1--------------------------------------------------------------
        txt += p1.toString() + p1.canoa.toString();
        
        //PLAYER 2--------------------------------------------------------------
        txt += p2.toString() + p2.canoa.toString();

        return txt;
    }
    // </editor-fold>
    
}
