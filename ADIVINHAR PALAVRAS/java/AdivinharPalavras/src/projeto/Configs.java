package projeto;

/**
 * @author Tiago Penha Pedroso
 * Date: 28/05/2018, 15:12:44
 */

//Configs = Variáveis Globais do projeto
public class Configs {
    
    //Atributos de Configuração do projeto
    public static int qtdJogadores = 2;
    public static Jogador[] jogadores;
    public static int qtdPalavrasPorJogador = 3;

    //Atributos de Controle do projeto
    public static int turnos = 1;

    //Atibutos Auxiliares da classe
    private static String[] dicas = {"dica 01", "dica 02"};
    private static Dicionario dicionario = new Dicionario();
    
    public static void inicializar(){
        dicionario.add(new Palavra("abelha", dicas));
        
        dicionario.add(new Palavra("bola", dicas));
        
        dicionario.add(new Palavra("casa", dicas));
        dicionario.add(new Palavra("cabelo", dicas));
        dicionario.add(new Palavra("carro", dicas));
        dicionario.add(new Palavra("cachorro", dicas));
        dicionario.add(new Palavra("chuveiro", dicas));
        dicionario.add(new Palavra("colher", dicas));
        dicionario.add(new Palavra("computador", dicas));
        
        dicionario.add(new Palavra("diario", dicas));
        
        dicionario.add(new Palavra("escola", dicas));
        
        dicionario.add(new Palavra("faca", dicas));
        
        dicionario.add(new Palavra("gato", dicas));
        
        dicionario.add(new Palavra("homem", dicas));
        
        dicionario.add(new Palavra("igreja", dicas));
        
        dicionario.add(new Palavra("janela", dicas));
        
        dicionario.add(new Palavra("lhama", dicas));
        
        dicionario.add(new Palavra("mesa", dicas));
        dicionario.add(new Palavra("musica", dicas));
        dicionario.add(new Palavra("mulher", dicas));
        
        dicionario.add(new Palavra("navio", dicas));
        
        dicionario.add(new Palavra("olho", dicas));
        
        dicionario.add(new Palavra("pedra", dicas));
        
        dicionario.add(new Palavra("queijo", dicas));
        
        dicionario.add(new Palavra("rato", dicas));
        
        dicionario.add(new Palavra("sapo", dicas));
        
        jogadores = new Jogador[qtdJogadores];
        for (int cont = 0; cont < qtdJogadores; cont++) {
            jogadores[cont] = new Jogador(
                    (cont + 1), 
                    qtdPalavrasPorJogador, 
                    dicionario
            );
        }
    }
    
}