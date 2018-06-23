public class Canoa{
    public String nome = "";
    public boolean[] blocos;
    public Canoa(int tamanho){
        blocos = new boolean[tamanho];
        inicializarBlocos();
    }
    public void inicializarBlocos(){
        for (int indice = 0; indice < blocos.length; indice++) {
            blocos[indice] = true;
        }
    }
    public void recontruirBloco(int posicao){
        if (posicao >= 0 && posicao < blocos.length) {
            blocos[posicao] = true;
        }
    }
    public void destruirBloco(int posicao){
        if (posicao >= 0 && posicao < blocos.length) {
            blocos[posicao] = false;
        }
    }
    public void afundar(){
        for (int indice = 0; indice < blocos.length; indice++) {
            blocos[indice] = false;
        }
    }
    @Override
    public String toString() {
        String textBlocos = "";
        for (boolean bloco : blocos) {
            textBlocos += "[" + bloco + "] ";
        }        
        return  "Canoa{\n" + 
                "  + nome = " + nome + "\n" + 
                "  + blocos = " + textBlocos + "\n" + 
                "}";
    }
}