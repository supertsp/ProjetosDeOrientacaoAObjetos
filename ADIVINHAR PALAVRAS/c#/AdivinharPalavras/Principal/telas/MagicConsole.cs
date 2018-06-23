using System;
using System.Collections.Generic;
using System.Threading;
using static System.Console;
using static System.ConsoleColor;

namespace Telas
{
    public class MagicConsole
    {

        #region constantes
        protected const string ENTER_1 = "\n";
        protected const string ENTER_2 = "\n\n";
        protected const string ENTER_3 = "\n\n\n";
        protected const string ENTER_4 = "\n\n\n\n";
        protected const string ENTER_5 = "\n\n\n\n\n";
        protected const string ENTER_6 = "\n\n\n\n\n\n";

        protected const string SPACE_1 = " ";
        protected const string SPACE_2 = "  ";
        protected const string SPACE_3 = "   ";
        protected const string SPACE_4 = "    ";
        protected const string SPACE_5 = "     ";
        protected const string SPACE_6 = "      ";
        #endregion




        #region Exibir...(...)

        #region Exibir(...)    
        public static void Exibir(Object mensagem)
        {
            ForegroundColor = White;
            BackgroundColor = Black;
            Write(mensagem);
        }

        public static void Exibir(int tempoMili, Object mensagem)
        {
            ForegroundColor = White;
            BackgroundColor = Black;

            char[] arrayChar = mensagem.ToString().ToCharArray();

            for (int cont = 0; cont < arrayChar.Length; cont++)
            {
                Write(arrayChar[cont]);
                Thread.Sleep(tempoMili);
            }
        }

        public static void Exibir(int tempoMili, NotaMusical somChar, Object mensagem)
        {
            ForegroundColor = White;
            BackgroundColor = Black;

            char[] arrayChar = mensagem.ToString().ToCharArray();

            for (int cont = 0; cont < arrayChar.Length; cont++)
            {
                Som.Play(tempoMili, somChar);
                Write(arrayChar[cont]);
                Thread.Sleep(tempoMili);
            }
        }

        public static void Exibir(int tempoMili, NotaMusical[] somCadaChar, Object mensagem)
        {
            ForegroundColor = White;
            BackgroundColor = Black;

            char[] arrayChar = mensagem.ToString().ToCharArray();

            for (int cont = 0; cont < arrayChar.Length; cont++)
            {
                if (cont < somCadaChar.Length)
                {
                    Som.Play(tempoMili, somCadaChar[cont]);
                }
                Write(arrayChar[cont]);
                Thread.Sleep(tempoMili);
            }
        }

        public static void Exibir(ConsoleColor corTexto, Object mensagem)
        {
            ForegroundColor = corTexto;
            BackgroundColor = Black;
            Write(mensagem);
            ForegroundColor = White;
        }

        public static void Exibir(int tempoMili, ConsoleColor corTexto, Object mensagem)
        {
            ForegroundColor = corTexto;
            BackgroundColor = Black;

            char[] arrayChar = mensagem.ToString().ToCharArray();

            for (int cont = 0; cont < arrayChar.Length; cont++)
            {
                Write(arrayChar[cont]);
                Thread.Sleep(tempoMili);
            }

            ForegroundColor = White;
        }

        public static void Exibir(int tempoMili, NotaMusical somChar, ConsoleColor corTexto, Object mensagem)
        {
            ForegroundColor = corTexto;
            BackgroundColor = Black;

            char[] arrayChar = mensagem.ToString().ToCharArray();

            for (int cont = 0; cont < arrayChar.Length; cont++)
            {
                Som.Play(tempoMili, somChar);
                Write(arrayChar[cont]);
                Thread.Sleep(tempoMili);
            }

            ForegroundColor = White;
        }

        public static void Exibir(Object mensagem, ConsoleColor corFundo)
        {
            BackgroundColor = corFundo;
            Write(mensagem);
            BackgroundColor = Black;
        }

        public static void Exibir(Object mensagem, int tempoMili, ConsoleColor corFundo)
        {
            ForegroundColor = White;
            BackgroundColor = corFundo;

            char[] arrayChar = mensagem.ToString().ToCharArray();

            for (int cont = 0; cont < arrayChar.Length; cont++)
            {
                Write(arrayChar[cont]);
                Thread.Sleep(tempoMili);
            }

            BackgroundColor = Black;
        }

        public static void Exibir(Object mensagem, int tempoMili, NotaMusical somChar, ConsoleColor corFundo)
        {
            ForegroundColor = White;
            BackgroundColor = corFundo;

            char[] arrayChar = mensagem.ToString().ToCharArray();

            for (int cont = 0; cont < arrayChar.Length; cont++)
            {
                Som.Play(tempoMili, somChar);
                Write(arrayChar[cont]);
                Thread.Sleep(tempoMili);
            }

            BackgroundColor = Black;
        }

        public static void Exibir(ConsoleColor corFundo, ConsoleColor corTexto, Object mensagem)
        {
            BackgroundColor = corFundo;
            ForegroundColor = corTexto;
            Write(mensagem);
            BackgroundColor = Black;
            ForegroundColor = White;
        }

        public static void Exibir(int tempoMili, ConsoleColor corFundo, ConsoleColor corTexto, Object mensagem)
        {
            BackgroundColor = corFundo;
            ForegroundColor = corTexto;

            char[] arrayChar = mensagem.ToString().ToCharArray();

            for (int cont = 0; cont < arrayChar.Length; cont++)
            {
                Write(arrayChar[cont]);
                Thread.Sleep(tempoMili);
            }

            BackgroundColor = Black;
            ForegroundColor = White;
        }

        public static void Exibir(int tempoMili, NotaMusical somNota, ConsoleColor corFundo, ConsoleColor corTexto, Object mensagem)
        {
            BackgroundColor = corFundo;
            ForegroundColor = corTexto;

            char[] arrayChar = mensagem.ToString().ToCharArray();

            for (int cont = 0; cont < arrayChar.Length; cont++)
            {
                Som.Play(tempoMili, somNota);
                Write(arrayChar[cont]);
                Thread.Sleep(tempoMili);
            }

            BackgroundColor = Black;
            ForegroundColor = White;
        }
        #endregion

        #region ExibirLinha(...)
        public static void ExibirLinha(Object mensagem)
        {
            Exibir(mensagem + "\n");
        }

        public static void ExibirLinha(int tempoMili, Object mensagem)
        {
            char[] arrayChar = mensagem.ToString().ToCharArray();

            for (int cont = 0; cont < arrayChar.Length; cont++)
            {
                Write(arrayChar[cont]);
                Thread.Sleep(tempoMili);
            }

            Write("\n");
        }

        public static void ExibirLinha(ConsoleColor corTexto, Object mensagem)
        {
            Exibir(corTexto, mensagem + "\n");
        }


        #endregion

        #endregion

        #region Ler...(...)

        #region LerString(...)
        public static string LerString(Object mensagem)
        {
            Exibir(mensagem);
            return ReadLine();
        }

        public static string LerString(Object mensagem, ConsoleColor corTexto)
        {
            Exibir(mensagem, corTexto);
            return ReadLine();
        }


        #endregion

        #region LerInt(...)
        public static int LerInt(Object mensagem)
        {
            return int.Parse(LerString(mensagem));
        }

        public static int LerInt(Object mensagem, ConsoleColor corTexto)
        {
            return int.Parse(LerString(mensagem, corTexto));
        }


        #endregion

        #region LerFloat(...)
        public static float LerFloat(Object mensagem)
        {
            return float.Parse(LerString(mensagem));
        }

        public static float LerFloat(Object mensagem, ConsoleColor corTexto)
        {
            return float.Parse(LerString(mensagem, corTexto));
        }


        #endregion

        #region LerDouble(...)
        public static double LerDouble(Object mensagem)
        {
            return double.Parse(LerString(mensagem));
        }

        public static double LerDouble(Object mensagem, ConsoleColor corTexto)
        {
            return double.Parse(LerString(mensagem, corTexto));
        }


        #endregion

        #endregion

        protected static String GetUnderlines(int qtd)
        {
            string underlines = "";
            for (int cont = 0; cont < qtd; cont++)
            {
                underlines += "_ ";
            }
            return underlines;
        }


        public static void Limpar()
        {
            Clear();
        }


    }//class

}//namespace