using System;
using System.Collections.Generic;
using System.Text;


public class Dicionario
{

    #region Atributos e Propriedades
    private List<Palavra> palavras;

    #endregion

    #region Construtores
    public Dicionario()
    {
        palavras = new List<Palavra>();
    }
    #endregion

    #region Métodos Length, Add, Get e Remove
    public int Length()
    {
        return palavras.Count;
    }

    public void Add(Palavra novaPalavra)
    {
        palavras.Add(novaPalavra);
    }

    public Palavra Get(int indice)
    {
        return palavras[indice];
    }

    public Palavra GetRandom()
    {
        Random num = new Random();
        int indice = num.Next(0, Length());
        return Get(indice);
    }

    public Palavra[] GetRandomArray(int length)
    {
        Palavra[] palavrasTemp = new Palavra[length];

        for (int cont = 0; cont < length; cont++)
        {
            palavrasTemp[cont] = GetRandom();
        }

        return palavrasTemp;
    }

    public void Remove(int indice)
    {
        palavras.RemoveAt(indice);
    }

    public void Remove(Palavra palavraProcurada)
    {
        palavras.Remove(palavraProcurada);
    }
    #endregion
}
