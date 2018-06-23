/**
 * Data: 23.05.2016
 *
 * @author Tiago Penha Pedroso
 */
public class Rio {
    
    //Atributos
    public int tamanho;
    
    //Auxiliares
    private boolean[] rio; 
    
    public Rio(int tamanho){
        this.tamanho = tamanho;
        rio = new boolean[tamanho];
        reset();
    }
    
    private void reset() {
        for (int indice = 0; indice < tamanho; indice++) {
            rio[indice] = false;
        }
    }
    
    public boolean getParte(int indiceElemento){
        if (indiceElemento < tamanho) {
            return rio[indiceElemento];
        }
        else{
            return false;
        }
    }
    
    public void copiarCanoa(int posicaoInicial, Canoa canoa){
        posicaoInicial = canoa.validarPosicaoNoRio(posicaoInicial, tamanho);
        int indiceRio = posicaoInicial;

        for (int indiceCanoa = 0; indiceCanoa < canoa.tamanho; indiceCanoa++) {
            rio[indiceRio] = canoa.getParte(indiceCanoa);
            indiceRio++;
        }
    }
    
    public void receberTiro(int posicaoTiro){
        rio[posicaoTiro] = false;
    }
    
}
