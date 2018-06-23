using System;
using System.Collections.Generic;
using System.Text;


public class Palavra
{

    #region Atributos e Propriedades
    //Atributos da Classe
    public string texto;
    public int pontos;
    public string[] dicas;

    //Atributos Auxiliares
    private int indiceDicaAtual;

    //Constantes
    public static readonly Palavra VAZIA = new Palavra("", new string[] { "" });
    #endregion

    #region Construtores
    public Palavra(string texto, string[] dicas)
    {
        this.texto = texto.Trim().ToUpper();
        pontos = this.texto.Length;
        this.dicas = dicas;
    }
    #endregion

    #region Sobreescritas de Object e Sobrecargas de Operadores
    public override string ToString()
    {
        string mensagem = "Palavra{\n";
        mensagem += "   texto: " + texto + "\n";
        mensagem += "   pontos: " + pontos + "\n";
        mensagem += "   dicas: \n";

        foreach (var item in dicas)
        {
            mensagem += "     " + item + "\n";
        }

        mensagem += "}\n";
        return mensagem;

    }

    public override bool Equals(Object outraPalavra)
    {
        if (outraPalavra == null || !(outraPalavra is Palavra)) return false;
        //if (!(outraPalavra is Palavra) || outraPalavra == null) return false;

        Palavra outra = outraPalavra as Palavra;
        return texto == outra.texto;
    }

    public static bool operator ==(Palavra palavra1, Palavra palavra2)
    {
        if (Object.Equals(palavra1, null) || Object.Equals(palavra2, null)) return false;

        return palavra1.Equals(palavra2);
    }

    public static bool operator !=(Palavra palavra1, Palavra palavra2)
    {
        return !(palavra1 == palavra2);
    }
    #endregion

    #region Outros Métodos
    public int GetIndiceDicaAtual()
    {
        return indiceDicaAtual;
    }

    public int GetLengthOfDicas()
    {
        return dicas.Length;
    }

    public string GetDicaAtual()
    {
        if (indiceDicaAtual < dicas.Length)
        {
            return dicas[indiceDicaAtual];
        }

        return "";
    }

    public string GetNextDica()
    {
        string dicaAtual = GetDicaAtual();
        indiceDicaAtual++;
        return dicaAtual;
    }
    #endregion

}