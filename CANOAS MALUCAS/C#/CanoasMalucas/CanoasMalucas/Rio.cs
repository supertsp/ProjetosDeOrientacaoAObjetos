public class Rio
{
    public bool[] blocos;
    public Canoa canoa;
    private int ultimaPosicaoMovimentoCanoa;
    public Rio(int tamanho, Canoa canoa)
    {
        if (tamanho > (canoa.blocos.Length * 2))
        {
            blocos = new bool[tamanho];
            this.canoa = canoa;
            MoverCanoa(0);
        }
    }
    public int GetUltimaPosicaoMovimentoCanoa()
    {
        return ultimaPosicaoMovimentoCanoa;
    }
    public void LimparRio()
    {
        for (int indice = 0; indice < blocos.Length; indice++)
        {
            blocos[indice] = false;
        }
    }
    public void MoverCanoa(int posicao)
    {
        int limiteCanoa = posicao + canoa.blocos.Length - 1;
        if (posicao >= 0 && limiteCanoa < blocos.Length)
        {
            ultimaPosicaoMovimentoCanoa = posicao;
            int indiceCanoa = 0;
            for (int indiceRio = 0; indiceRio < blocos.Length; indiceRio++)
            {
                if (indiceRio >= posicao && indiceCanoa < canoa.blocos.Length)
                {
                    blocos[indiceRio] = canoa.blocos[indiceCanoa];
                    indiceCanoa++;
                }
                else
                {
                    blocos[indiceRio] = false;
                }
            }
        }
    }
    public bool EstaVazio()
    {
        foreach (bool bloco in blocos)
        {
            if (bloco == true)
            {
                return false;
            }
        }
        return true;
    }
    /*
                [0][1][2][3]
    [~][~][~][~][#][#][~][#][~][~]
    [0][1][2][3][4][5][6][7][8][9]
                 U     A  F
    */
    public void ReceberAtaque(int posicao)
    {
        if (posicao >= 0 && posicao < blocos.Length)
        {
            int posicaoFinalCanoa = ultimaPosicaoMovimentoCanoa + canoa.blocos.Length;
            if (posicao >= ultimaPosicaoMovimentoCanoa && posicao < posicaoFinalCanoa)
            {
                int posicaoDentroCanoa = posicao - ultimaPosicaoMovimentoCanoa;
                canoa.DestruirBloco(posicaoDentroCanoa);
            }
            MoverCanoa(ultimaPosicaoMovimentoCanoa);
        }
    }

    public override string ToString()
    {
        string textCanoa = "";
        for (int indice = 0; indice < canoa.blocos.Length; indice++)
        {
            textCanoa += indice + ":[" + canoa.blocos[indice] + "]  ";
        }
        string textBlocos = "";
        for (int indice = 0; indice < blocos.Length; indice++)
        {
            textBlocos += indice + ":[" + blocos[indice] + "]  ";
        }
        return "Rio{\n" +
                "  + canoa (" + canoa.nome + ") = " + textCanoa + "\n" +
                "  + blocos = " + textBlocos + "\n" +
                "  + Esta Vazio? " + EstaVazio() + "\n" +
                "}";
    }
}