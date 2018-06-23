package projeto;

/**
 * @author Tiago Penha Pedroso Date: 05/05/2018, 20:51:12
 */
public class Jogador {

    //Atributos da classe
    public int numero;
    public String nome;
    public Palavra[] palavras;
    public int pontuacao;

    //Atributos Auxiliares
    private int contPalavraAtual;

    public Jogador(
            int numero, 
            int qtdPalavrasSorteadas, 
            Dicionario dicionario) {
        
        this.numero = numero;

        //sortear as palavras pro array
        palavras = dicionario.getRandomArray(qtdPalavrasSorteadas);
    }

    public int getIndicePalavraAtual() {
        return contPalavraAtual;
    }

    public Palavra getPalavraAtual() {
        if (contPalavraAtual < palavras.length) {
            return palavras[contPalavraAtual];
        }

        return null;
    }

    public String getTextoPalavraAtual() {
        return getPalavraAtual().texto;
    }

    public Palavra getNextPalavra() {
        Palavra palavraAtual = getPalavraAtual();
        contPalavraAtual++;
        return palavraAtual;
    }

    public String getNextTextoPalavra() {
        return getNextPalavra().texto;
    }

    public String getDicaAtual() {
        return getPalavraAtual().getDicaAtual();
    }

    public String getNextDica() {
        return getPalavraAtual().getNextDica();
    }

    public boolean adivinharPalavra(String tentativa) {
        tentativa = tentativa.trim().toUpperCase();
        return getTextoPalavraAtual().equals(tentativa);
    }

    public boolean adivinharPalavra(Palavra tentativa) {
        return getPalavraAtual().equals(tentativa);
    }

    public boolean adivinhouTodasPalavras() {
        return getPalavraAtual() == null;
    }
}
