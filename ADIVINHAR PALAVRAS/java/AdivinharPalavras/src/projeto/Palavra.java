package projeto;

/**
 * @author Tiago Penha Pedroso
 * Date: 05/05/2018, 20:28:22
 */

public class Palavra {
    
    //Atributos da classe
    public String texto;
    public int pontos;
    public String[] dicas;
    
    //Atributos Auxiliares
    private int contDicaAtual;
    
    public Palavra(String texto, String[] dicas){
        this.texto = texto.trim().toUpperCase();                       
        pontos = this.texto.length();
        this.dicas = dicas;
    }
    
    //alt + insert

    @Override
    public String toString() {
        String textoFinal = "";
        
        for (String dica : dicas) {
            textoFinal += "\n     \"" + dica + "\"";
        }
        
        return  "Palavra{\n" + 
                "  texto:  " + texto + "\n" +
                "  pontos: " + pontos + "\n" +
                "  dicas:  " + textoFinal + "\n" +
                "}";
    }

    @Override
    public boolean equals(Object outraPalavra) {
        if (outraPalavra instanceof Palavra) {
            Palavra outra = (Palavra) outraPalavra;            
            if (texto.equals(outra.texto)) {
                return true;
            }
        }
        
        return false;
    }
    
    public int getIndiceDicaAtual(){
        return contDicaAtual;
    }
    
    public int getLengthOfDicas(){
        return dicas.length;
    }
    
    public String getDicaAtual(){
        if (contDicaAtual < dicas.length) {
            return dicas[contDicaAtual];
        }

        return "";
    }
    
    public String getNextDica(){        
        String dicaAtual = getDicaAtual();
        contDicaAtual++;
        return dicaAtual;
    }
    
}