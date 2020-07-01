
public class GameMatch {

	public static BasicPlayer[] currentPlayers = new BasicPlayer[2];

	public static void addPlayer(
			int indexOfPlayer, int playerId, String nick,
			int riverSize, int boatSize, String boatName) {

		if (indexOfPlayer >= 0 && indexOfPlayer < currentPlayers.length) {
			currentPlayers[indexOfPlayer] = new BasicPlayer(
					playerId, nick, riverSize, boatSize, boatName
			);
		}
	}

	public static void addPlayer(int indexOfPlayer, BasicPlayer newPlayer) {
		if (indexOfPlayer >= 0 && indexOfPlayer < currentPlayers.length) {
			currentPlayers[indexOfPlayer] = newPlayer;
		}
	}

	public static BasicPlayer getPlayer(int indexOfPlayer) {
		if (indexOfPlayer >= 0 && indexOfPlayer < currentPlayers.length) {
			return currentPlayers[indexOfPlayer];
		}

		return null;
	}

	public static void moveBoat(int indexOfPlayer, int newBoatPosition) {
		if (indexOfPlayer >= 0 && indexOfPlayer < currentPlayers.length) {
			currentPlayers[indexOfPlayer].moveBoat(newBoatPosition);
		}
	}

	public static void shootArrowAtEnemy(int indexOfPlayer, int positionOnEnemyRiver, int indexOfEnemy) {
		if (indexOfPlayer >= 0 && indexOfPlayer < currentPlayers.length && indexOfPlayer != indexOfEnemy) {
			currentPlayers[indexOfPlayer].shootArrow(positionOnEnemyRiver, currentPlayers[indexOfEnemy]);
		}
	}

	public static boolean isMatchOver() {
		for (int index = 0; index < currentPlayers.length; index++) {
			if (currentPlayers[index].isLoseTheMatch()) {
				return true;
			}
		}

		return false;
	}

	public static boolean wasEnemyDefeated(int indexOfPlayer, int indexOfEnemy) {
		if (indexOfPlayer >= 0 && indexOfPlayer < currentPlayers.length
				&& indexOfEnemy >= 0 && indexOfEnemy < currentPlayers.length
				&& indexOfPlayer != indexOfEnemy) {
			return currentPlayers[indexOfPlayer].wasEnemyDefeated(currentPlayers[indexOfEnemy]);
		}

		return false;
	}

}
