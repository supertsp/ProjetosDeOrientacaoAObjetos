/**
 * Data: 23.05.2016
 *
 * @author Tiago Penha Pedroso
 */
public class Player {
    
    //Atributos
    public String nome;
    public Canoa canoa;
    public Rio rio;
    
    //Auxiliares
    private int ultimaPosicaoCanoa;
    
    public Player(String nome, String nomeCanoa, int tamanhoCanoa, int tamanhoRio){
        this.nome = nome;
        
        canoa = new Canoa(nomeCanoa, tamanhoCanoa);
        rio = new Rio(tamanhoRio);
    }
    
    public boolean perdeu(){
        return !canoa.estaFlutuando();
    }
    
        
    private boolean tiroValido(int posicaoTiro){
        return posicaoTiro >= 0 && posicaoTiro < rio.tamanho;
    }
    
    public void atirar(int posicaoTiro, Player outroPlayer){
        if (tiroValido(posicaoTiro)) {
            outroPlayer.rio.receberTiro(posicaoTiro);
        }
    }
    
    private void transferirCanoaParaRio(int posicaoInicial){
        rio.copiarCanoa(posicaoInicial, canoa);
    }
    
    private void transferirRioParaCanoa(int posicaoInicial){
        canoa.copiarRio(posicaoInicial, rio);
    }
    
    public void moverCanoa(int novaPosicaoCanoa){
        ultimaPosicaoCanoa = canoa.validarPosicaoNoRio(novaPosicaoCanoa, rio.tamanho);        
        transferirCanoaParaRio(ultimaPosicaoCanoa);
    }
    
    public void atualizarDano(){
        transferirRioParaCanoa(ultimaPosicaoCanoa);
    }
    
    @Override
    public String toString(){
        String txt = "";        
        int tamanhoNomeP1 = nome.length();
        String linhaBasePlayer = "+-----------------------------";        
        String linhaBaseP1 = linhaBasePlayer;
        
        for (int i = 0; i < tamanhoNomeP1; i++) {
            linhaBaseP1 += "-";
        }
        
        linhaBaseP1 += "-+\n";
        
        txt += linhaBaseP1 + "PLAYER 1: " + nome + " \n" + linhaBaseP1 + "\n";
        
        return txt;
    }
    
}
