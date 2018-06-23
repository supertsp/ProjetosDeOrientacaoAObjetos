using System;
using System.Collections.Generic;
using System.Text;

//Configs = Variáveis Globais do projeto
public class Configs
{

    #region Atributos e Propriedades
    //Atributos de Configuração do projeto
    public static int qtdJogadores = 2;
    public static Jogador[] jogadores;
    public static int qtdPalavrasPorJogador = 3;

    //Atributos de Controle do projeto
    public static int turnos = 1;

    //Atibutos Auxiliares da classe
    private static String[] dicas = { "dica 01", "dica 02" };
    private static Dicionario dicionario = new Dicionario();
    #endregion

    static Configs()
    {
        Inicializar();
    }

    public static void Inicializar()
    {
        #region Criando Dicionario
        //                          123456789
        dicionario.Add(new Palavra("abelha", dicas));
        //                          123456789
        dicionario.Add(new Palavra("bola", dicas));
        //                          123456789
        dicionario.Add(new Palavra("casa", dicas));
        //                          123456789
        dicionario.Add(new Palavra("cabelo", dicas));
        //                          123456789
        dicionario.Add(new Palavra("carro", dicas));
        //                          123456789
        dicionario.Add(new Palavra("cachorro", dicas));
        //                          123456789
        dicionario.Add(new Palavra("chuveiro", dicas));
        //                          123456789
        dicionario.Add(new Palavra("colher", dicas));
        //                          1234567890
        dicionario.Add(new Palavra("computador", dicas));
        //                          123456789
        dicionario.Add(new Palavra("diario", dicas));
        //                          123456789
        dicionario.Add(new Palavra("escola", dicas));
        //                          123456789
        dicionario.Add(new Palavra("faca", dicas));
        //                          123456789
        dicionario.Add(new Palavra("gato", dicas));
        //                          123456789
        dicionario.Add(new Palavra("homem", dicas));
        //                          123456789
        dicionario.Add(new Palavra("igreja", dicas));
        //                          123456789
        dicionario.Add(new Palavra("janela", dicas));
        //                          123456789
        dicionario.Add(new Palavra("lhama", dicas));
        //                          123456789
        dicionario.Add(new Palavra("mesa", dicas));
        //                          123456789
        dicionario.Add(new Palavra("musica", dicas));
        //                          123456789
        dicionario.Add(new Palavra("mulher", dicas));
        //                          123456789
        dicionario.Add(new Palavra("navio", dicas));
        //                          123456789
        dicionario.Add(new Palavra("olho", dicas));
        //                          123456789
        dicionario.Add(new Palavra("pedra", dicas));
        //                          123456789
        dicionario.Add(new Palavra("queijo", dicas));
        //                          123456789
        dicionario.Add(new Palavra("rato", dicas));
        //                          123456789
        dicionario.Add(new Palavra("sapo", dicas));
        #endregion

        //Criando os jogadores
        jogadores = new Jogador[qtdJogadores];
        for (int cont = 0; cont < qtdJogadores; cont++)
        {
            jogadores[cont] = new Jogador(
                    (cont + 1),
                    qtdPalavrasPorJogador,
                    dicionario
            );
        }
    }

}
