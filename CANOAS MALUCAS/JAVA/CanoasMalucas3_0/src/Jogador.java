public class Jogador {
    public int numeroJogador;
    public String nick;
    private int flechasAtiradas;
    public Rio rio;
    public Jogador(int numeroJogador, String nick, Rio rio){
        this.numeroJogador = numeroJogador;
        this.nick = nick;
        this.rio = rio;
    }
    public int getFlechasAtiradas() {
        return flechasAtiradas;
    }
    public void atirarFlecha(int posicaoRioInimigo, Jogador inimigo) {
        flechasAtiradas++;
        inimigo.rio.receberAtaque(posicaoRioInimigo);        
    }
    public boolean venceuInimigo(Jogador inimigo){
        return inimigo.rio.estaVazio();
    }
    @Override
    public String toString() {
        return  "Jogador " + numeroJogador + ": " + nick + "{\n" + 
                "  + " + rio + "\n" +
                "  + Perdeu? " + rio.estaVazio() + "\n" +
                "}";
    }    
}