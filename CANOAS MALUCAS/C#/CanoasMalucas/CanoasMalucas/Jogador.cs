public class Jogador
{
    public int numeroJogador;
    public string nick;
    private int flechasAtiradas;
    public Rio rio;

    public Jogador(int numeroJogador, string nick, Rio rio)
    {
        this.numeroJogador = numeroJogador;
        this.nick = nick;
        this.rio = rio;
    }

    public int GetFlechasAtiradas()
    {
        return flechasAtiradas;
    }

    public void AtirarFlecha(int posicaoRioInimigo, Jogador inimigo)
    {
        flechasAtiradas++;
        inimigo.rio.ReceberAtaque(posicaoRioInimigo);
    }

    public bool VenceuInimigo(Jogador inimigo)
    {
        return inimigo.rio.EstaVazio();
    }

    public override string ToString()
    {
        return "Jogador " + numeroJogador + ": " + nick + "{\n" +
                "  + " + rio + "\n" +
                "  + Perdeu? " + rio.EstaVazio() + "\n" +
                "}";
    }

}