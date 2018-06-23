package projeto;

import java.util.ArrayList;

/**
 * @author Tiago Penha Pedroso
 * Date: 05/05/2018, 21:32:41
 */

public class Dicionario {
    
    //Atributos da classe
    public ArrayList<Palavra> palavras;
    
    //Atributos Auxiliares
    //private int indicePalavraAtual;
    
    public Dicionario(){
        palavras = new ArrayList<>();
    }
    
    public int length(){
        return palavras.size();
    }
    
    public void add(Palavra novaPalavra){
        palavras.add(novaPalavra);
    }
    
    public Palavra get(int indicePalavra){
        return palavras.get(indicePalavra);
    }
    
    public Palavra getRandom(){
        int indice = (int)(Math.random() * length());
        return get(indice);
    }
    
    public Palavra[] getRandomArray(int qtdPalavras){
        Palavra[] palavras = new Palavra[qtdPalavras];
        
        for (int cont = 0; cont < qtdPalavras; cont++) {
            palavras[cont] = getRandom();
        }
        
        return palavras;
    }
    
    public void remove(int indicePalavra){
        palavras.remove(indicePalavra);
    }
    
    public void remove(Palavra palavraProcurada){
        palavras.remove(palavraProcurada);
    }
    
}