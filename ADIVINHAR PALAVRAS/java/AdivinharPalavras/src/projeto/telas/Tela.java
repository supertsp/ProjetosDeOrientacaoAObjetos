package projeto.telas;

import static java.lang.System.*;
import static javax.swing.JOptionPane.*;
import java.util.Scanner;

/**
 * @author Tiago Penha Pedroso Date: 14/05/2018, 16:10:21
 */
public class Tela {
    
    public static boolean usarJOptionPane;
    
    private static Scanner scanner = new Scanner(System.in);

    protected static final String ENTER_1 = "\n";
    protected static final String ENTER_2 = "\n\n";
    protected static final String ENTER_3 = "\n\n\n";
    protected static final String ENTER_4 = "\n\n\n\n";
    protected static final String ENTER_5 = "\n\n\n\n\n";
    protected static final String ENTER_6 = "\n\n\n\n\n\n";

    public static void exibirLinha(Object mensagem) {
        if (usarJOptionPane) {
            showMessageDialog(null, mensagem);
        }
        else{
            out.println(mensagem);
        }
    }

    public static void exibir(Object mensagem) {
        if (usarJOptionPane) {
            showMessageDialog(null, mensagem);
        }
        else{
            out.print(mensagem);
        }
    }

    protected static String getUnderlines(int qtd) {
        String underlines = "";
        for (int cont = 0; cont < qtd; cont++) {
            underlines += "_ ";
        }
        return underlines;
    }

    public static void limpar() {
        for (int cont = 0; cont < 30; cont++) {
            out.print(ENTER_1);
        }        
    }

    public static String lerString(Object mensagem) {
        if (usarJOptionPane) {
            return showInputDialog(mensagem);
        }
        else{
            exibir(mensagem);
            return scanner.nextLine();
        }
    }

    public static int lerInt(Object mensagem) {
        return Integer.parseInt(lerString(mensagem));
    }

    public static double lerDouble(Object mensagem) {
        return Double.parseDouble(lerString(mensagem));
    }

}
