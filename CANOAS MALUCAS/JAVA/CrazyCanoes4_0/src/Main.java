
import static javax.swing.JOptionPane.*;

public class Main {

	public static void main(String[] args) {
		String nomeJogador1 = lerTexto("Digite o nick do Jogador 1");
		String nomeJogador2 = lerTexto("Digite o nick do Jogador 2");
		String nomeCanoa1 = lerTexto("Digite o nome da canoa do Jogador 1");
		String nomeCanoa2 = lerTexto("Digite o nome da canoa do Jogador 2");

		BasicPlayer p1 = new BasicPlayer(1, nomeJogador1, 10, 4, nomeCanoa1);
		BasicPlayer p2 = new BasicPlayer(2, nomeJogador2, 10, 4, nomeCanoa2);

		GameMatch.addPlayer(0, p1);
		GameMatch.addPlayer(1, p2);

		mostrarMensagem(GameMatch.getPlayer(0) + "\n------------\n" + GameMatch.getPlayer(1));

		while (!GameMatch.isMatchOver()) {
			//Movendo as canoas
			GameMatch.moveBoat(0, lerNumeroInteiro(
					"PLAYER 1\nDigite a posição da cano no Rio"
			));
			GameMatch.moveBoat(1, lerNumeroInteiro(
					"PLAYER 2\nDigite a posição da cano no Rio"
			));

			//Atirando
			GameMatch.shootArrowAtEnemy(0,
					lerNumeroInteiro("PLAYER 1\nDigite a posição do tiro da flecha"),
					 1
			);
			GameMatch.shootArrowAtEnemy(1,
					lerNumeroInteiro("PLAYER 2\nDigite a posição do tiro da flecha"),
					 0
			);

			//Estatísticas de jogo
			mostrarMensagem(GameMatch.getPlayer(0) + "\n------------\n" + GameMatch.getPlayer(1));
		}

		if (GameMatch.wasEnemyDefeated(0, 1) && GameMatch.wasEnemyDefeated(1, 0)) {
			mostrarMensagem("Deu empate!!!");
		} else if (GameMatch.wasEnemyDefeated(0, 1)) {
			mostrarMensagem("Player 1 Venceu");
		} else if (GameMatch.wasEnemyDefeated(1, 0)) {
			mostrarMensagem("Player 2 Venceu");
		}
	}

	public static void mostrarMensagem(Object novaMensagem) {
		showMessageDialog(null, novaMensagem);
	}

	public static int lerNumeroInteiro(String novaMensagem) {
		return Integer.parseInt(showInputDialog(novaMensagem));
	}

	public static double lerNumeroReal(String novaMensagem) {
		return Double.parseDouble(showInputDialog(novaMensagem));
	}

	public static String lerTexto(String novaMensagem) {
		return showInputDialog(novaMensagem);
	}
}
