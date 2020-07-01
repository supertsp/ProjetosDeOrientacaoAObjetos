import static javax.swing.JOptionPane.*;
public class Main{
    public static void main(String[] args) {
        String nomeJogador1 = lerTexto("Digite o nick do Jogador 1");
        String nomeJogador2 = lerTexto("Digite o nick do Jogador 2");
        String nomeCanoa1 = lerTexto("Digite o nome da canoa do Jogador 1");
        String nomeCanoa2 = lerTexto("Digite o nome da canoa do Jogador 2");
        
        Boat canoa1 = new Boat(4);
        canoa1.name = nomeCanoa1;
        
        Boat canoa2 = new Boat(4);
        canoa2.name = nomeCanoa2;
       
        River rioP1 = new River(10, canoa1);
        River rioP2 = new River(10, canoa2);
        
        BasicPlayer p1 = new BasicPlayer(1, nomeJogador1, rioP1);
        BasicPlayer p2 = new BasicPlayer(2, nomeJogador2, rioP2);
        
        mostrarMensagem(p1 + "\n------------\n" + p2);
        
        while (!p1.wasEnemyDefeated(p2) && !p2.wasEnemyDefeated(p1)) {                       
            //Movendo as canoas
            p1.river.moveBoat(lerNumeroInteiro(
                    "PLAYER 1\nDigite a posição da cano no Rio"
            ));
            p2.river.moveBoat(lerNumeroInteiro(
                    "PLAYER 2\nDigite a posição da cano no Rio"
            ));
            
            //Atirando
            p1.shotArrow(
                lerNumeroInteiro("PLAYER 1\nDigite a posição do tiro da flecha")
                , p2
            );
            p2.shotArrow(
                lerNumeroInteiro("PLAYER 2\nDigite a posição do tiro da flecha")
                , p1
            );
            
            //Estatísticas de jogo
            mostrarMensagem(p1 + "\n------------\n" + p2);
        }
        
        if (p1.wasEnemyDefeated(p2) && p2.wasEnemyDefeated(p1)) {
            mostrarMensagem("Deu empate!!!");
        }
        else if (p1.wasEnemyDefeated(p2)) {
            mostrarMensagem("Player 1 Venceu");
        }
        else if (p2.wasEnemyDefeated(p1)) {
            mostrarMensagem("Player 2 Venceu");
        }
    }
    public static void mostrarMensagem(Object novaMensagem){
        showMessageDialog(null, novaMensagem);
    }
    public static int lerNumeroInteiro(String novaMensagem){
        return Integer.parseInt(showInputDialog(novaMensagem));
    }
    public static double lerNumeroReal(String novaMensagem){
        return Double.parseDouble(showInputDialog(novaMensagem));
    }
    public static String lerTexto(String novaMensagem){
        return showInputDialog(novaMensagem);
    }
}   