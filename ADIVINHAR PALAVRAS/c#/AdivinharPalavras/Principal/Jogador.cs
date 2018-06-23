using System;
using System.Collections.Generic;
using System.Text;

public class Jogador
{

    #region Atributos e Propriedades
    //Atributos da Classe
    public int numero;
    public string nome;
    public Palavra[] palavras;
    public int pontuacao;

    //Atributos Auxiliares
    private int indicePalavraAtual;
    #endregion

    #region Construtores
    public Jogador(int numero, int qtdPalavrasSorteadas, Dicionario dicionario)
    {
        this.numero = numero;

        //sortear Palavras pro array
        palavras = dicionario.GetRandomArray(qtdPalavrasSorteadas);
    }
    #endregion

    #region Outros Métodos    
    public int GetIndicePalavraAtual()
    {
        return indicePalavraAtual;
    }

    public int GetLengthOfPalavras()
    {
        return palavras.Length;
    }

    #region GetNext... && Get...Atual
    public Palavra GetPalavraAtual()
    {
        if (indicePalavraAtual < palavras.Length)
        {
            return palavras[indicePalavraAtual];
        }

        return null;
    }

    public Palavra GetNextPalavra()
    {
        Palavra palavraAtual = GetPalavraAtual();
        indicePalavraAtual++;
        return palavraAtual;
    }

    public string GetTextoPalavraAtual()
    {
        if (Object.Equals(GetPalavraAtual(), null))
        {
            return "";
        }

        return GetPalavraAtual().texto;
    }

    public string GetNextTextoPalavra()
    {
        if (Object.Equals(GetPalavraAtual(), null))
        {
            return "";
        }

        return GetNextPalavra().texto;
    }

    public string GetDicaAtual()
    {
        if (Object.Equals(GetPalavraAtual(), null))
        {
            return "";
        }

        return GetPalavraAtual().GetDicaAtual();
    }

    public string GetNextDica()
    {
        if (Object.Equals(GetPalavraAtual(), null))
        {
            return "";
        }

        return GetPalavraAtual().GetNextDica();
    }
    #endregion

    public bool AdivinharPalavra(Palavra tentativa)
    {
        if (Object.Equals(GetPalavraAtual(), null))
        {
            return false;
        }

        return GetPalavraAtual() == tentativa;
    }

    public bool AdivinharPalavra(string tentativa)
    {
        if (Object.Equals(GetPalavraAtual(), null))
        {
            return false;
        }

        tentativa = tentativa.Trim().ToUpper();
        return tentativa == GetTextoPalavraAtual();
    }

    public bool AdivinhouTodasPalavras()
    {
        if (Object.Equals(GetPalavraAtual(), null))
        {
            return true;
        }

        return false;
    }
    #endregion

}
