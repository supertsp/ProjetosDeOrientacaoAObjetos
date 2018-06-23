using System;
using System.Collections.Generic;
using static System.Console;
using static System.ConsoleColor;
using static Telas.MagicConsole;
using static Configs;
using static Som;
using static NotaMusical;


public class Musicas
{

    public static void Abertura(int tempoPadrao)
    {
        NotaMusical[] notas =
        {
            Sol_0,     //00
            Sol_2,     //01
            La_1,     //02
            La_0,     //03
            Re_0,     //04
            Mi_0,     //05
            Do_3,     //06
            La_1,     //07
            Sol_2,    //08
            Sol_0     //09
        };

        int[] tempos =
        {
            tempoPadrao * 4,     //00
            tempoPadrao * 1,     //01
            tempoPadrao * 2,     //02
            tempoPadrao * 3,     //03
            tempoPadrao * 2,     //04
            tempoPadrao * 1,     //05
            tempoPadrao * 1,     //06
            tempoPadrao * 2,     //07
            tempoPadrao * 1,     //08
            tempoPadrao * 4      //09
        };
        Som.Play(notas, tempos);
    }

    public static void Sequencia()
    {
        //Som.Play(
        //    80,
        //    new NotaMusical[]
        //    {
        //        Do_0,  Do_1,  Do_2,  Do_3,  Do_4,  Do_5,
        //        Re_0,  Re_1,  Re_2,  Re_3,  Re_4,  Re_5,
        //        Mi_0,  Mi_1,  Mi_2,  Mi_3,  Mi_4,  Mi_5,
        //        Fa_0,  Fa_1,  Fa_2,  Fa_3,  Fa_4,  Fa_5,
        //        Sol_0, Sol_1, Sol_2, Sol_3, Sol_4, Sol_5,
        //        La_0,  La_1,  La_2,  La_3,  La_4,  La_5,
        //        Si_0,  Si_1,  Si_2,  Si_3,  Si_4,  Si_5,
        //    }
        //);

        Som.Play(
            80,
            new NotaMusical[]
            {
                Do_0,  Re_0,  Mi_0,  Fa_0,  Sol_0,  La_0, Si_0,
                Do_1,  Re_1,  Mi_1,  Fa_1,  Sol_1,  La_1, Si_1,
                Do_2,  Re_2,  Mi_2,  Fa_2,  Sol_2,  La_2, Si_2,
                Do_3,  Re_3,  Mi_3,  Fa_3,  Sol_3,  La_3, Si_3,
                Do_4,  Re_4,  Mi_4,  Fa_4,  Sol_4,  La_4, Si_4,
                Do_5,  Re_5,  Mi_5,  Fa_5,  Sol_5,  La_5, Si_5,

            }
        );
    }

}