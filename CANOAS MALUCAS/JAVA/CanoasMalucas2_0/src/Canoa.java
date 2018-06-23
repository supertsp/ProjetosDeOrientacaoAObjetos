/**
 * Data: 23.05.2016
 *
 * @author Tiago Penha Pedroso
 */
public class Canoa {
    
    //Atributos
    public String nome;
    public int tamanho;
    
    //Auxiliares
    private boolean[] canoa; 
    
    public Canoa(String nome, int tamanho){
        this.nome = nome;
        this.tamanho = tamanho;
        canoa = new boolean[tamanho];
        reset();
    }
    
    private void reset() {
        for (int indice = 0; indice < tamanho; indice++) {
            canoa[indice] = true;
        }
    }
    
    public boolean getParte(int indiceElemento){
        if (indiceElemento < tamanho) {
            return canoa[indiceElemento];
        }
        else{
            return false;
        }
    }
    
    public void copiarRio(int posicaoInicial, Rio rio){
        posicaoInicial = validarPosicaoNoRio(posicaoInicial, rio.tamanho);
        int indiceRio = posicaoInicial;

        for (int indiceCanoa = 0; indiceCanoa < tamanho; indiceCanoa++) {
            canoa[indiceCanoa] = rio.getParte(indiceRio);
            indiceRio++;
        }
    }
    
    public int validarPosicaoNoRio(int posicao, int tamanhoRio) {
        if (
            posicao < 0 ||
            ((posicao + tamanho) > tamanhoRio)
        ){
            posicao = posicao - ((posicao + tamanho) - tamanhoRio);
        }
        
        return posicao;
    }
    
    public boolean estaFlutuando(){
        boolean aindaExiste = false;
        
        for (int i = 0; i < tamanho; i++) {
            if (canoa[i]) {
                aindaExiste = true;
                break;
            }
        }
        
        return aindaExiste;
    }
    
    
    
    
    @Override
    public String toString(){
        String txt = "";        
        String linhaBaseCanoa = "  +-+-+-+-+\n";
        
        txt += "CANOA: " + nome + "\n";        
        txt += linhaBaseCanoa + "  |";
        
        for (int i = 0; i < tamanho; i++) {
            if (i == tamanho - 1) {
                txt += canoa[i] ? "X" : "-";
            }
            else{
                txt += canoa[i] ? "X " : "- ";
            }
        }
        
        txt += "|\n" + linhaBaseCanoa + "   0 1 2 3\n\n";
        
        return txt;
    }
    
}
