using System;
using System.Collections;
using System.Collections.Generic;

public class Canoa
{
    public string nome;
    public bool[] blocos;

    public Canoa(int tamanho)
    {
        blocos = new bool[tamanho];
        InicializarBlocos();
    }

    public void InicializarBlocos()
    {
        for (int indice = 0; indice < blocos.Length; indice++)
        {
            blocos[indice] = true;
        }
    }

    public void RecontruirBloco(int posicao)
    {
        if (posicao >= 0 && posicao < blocos.Length)
        {
            blocos[posicao] = true;
        }
    }

    public void DestruirBloco(int posicao)
    {
        if (posicao >= 0 && posicao < blocos.Length)
        {
            blocos[posicao] = false;
        }
    }

    public void Afundar()
    {
        for (int indice = 0; indice < blocos.Length; indice++)
        {
            blocos[indice] = false;
        }
    }

    public override string ToString()
    {
        string textBlocos = "";

        foreach (bool bloco in blocos)
        {
            textBlocos += "[" + bloco + "] ";
        }

        return "Canoa{\n" +
                "  + nome = " + nome + "\n" +
                "  + blocos = " + textBlocos + "\n" +
                "}";
    }

}