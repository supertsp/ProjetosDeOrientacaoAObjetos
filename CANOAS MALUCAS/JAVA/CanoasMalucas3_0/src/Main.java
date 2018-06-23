import static javax.swing.JOptionPane.*;
public class Main{
    public static void main(String[] args) {
        String nomeJogador1 = lerTexto("Digite o nick do Jogador 1");
        String nomeJogador2 = lerTexto("Digite o nick do Jogador 2");
        String nomeCanoa1 = lerTexto("Digite o nome da canoa do Jogador 1");
        String nomeCanoa2 = lerTexto("Digite o nome da canoa do Jogador 2");
        
        Canoa canoa1 = new Canoa(4);
        canoa1.nome = nomeCanoa1;
        
        Canoa canoa2 = new Canoa(4);
        canoa2.nome = nomeCanoa2;
       
        Rio rioP1 = new Rio(10, canoa1);
        Rio rioP2 = new Rio(10, canoa2);
        
        Jogador p1 = new Jogador(1, nomeJogador1, rioP1);
        Jogador p2 = new Jogador(2, nomeJogador2, rioP2);
        
        mostrarMensagem(p1 + "\n------------\n" + p2);
        
        while (!p1.venceuInimigo(p2) && !p2.venceuInimigo(p1)) {                       
            //Movendo as canoas
            p1.rio.moverCanoa(lerNumeroInteiro(
                    "PLAYER 1\nDigite a posição da cano no Rio"
            ));
            p2.rio.moverCanoa(lerNumeroInteiro(
                    "PLAYER 2\nDigite a posição da cano no Rio"
            ));
            
            //Atirando
            p1.atirarFlecha(
                lerNumeroInteiro("PLAYER 1\nDigite a posição do tiro da flecha")
                , p2
            );
            p2.atirarFlecha(
                lerNumeroInteiro("PLAYER 2\nDigite a posição do tiro da flecha")
                , p1
            );
            
            //Estatísticas de jogo
            mostrarMensagem(p1 + "\n------------\n" + p2);
        }
        
        if (p1.venceuInimigo(p2) && p2.venceuInimigo(p1)) {
            mostrarMensagem("Deu empate!!!");
        }
        else if (p1.venceuInimigo(p2)) {
            mostrarMensagem("Player 1 Venceu");
        }
        else if (p2.venceuInimigo(p1)) {
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