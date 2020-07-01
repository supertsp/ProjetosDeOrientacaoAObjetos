
public class BasicPlayer {

	public int playerId;
	public String nick;
	private int arrowsShot;
	public River river;

	public BasicPlayer(int playerId, String nick, River river) {
		this.playerId = playerId;
		this.nick = nick;
		this.river = river;
	}

	public int getArrowsShot() {
		return arrowsShot;
	}

	public void shotArrow(int positionOnEnemyRiver, BasicPlayer enemy) {
		arrowsShot++;
		enemy.river.receiveAttack(positionOnEnemyRiver);
	}

	public boolean wasEnemyDefeated(BasicPlayer enemy) {
		return enemy.river.isEmpty();
	}

	@Override
	public String toString() {
		return "BasicPlayer " + playerId + ": " + nick + "{\n"
				+ "  + " + river + "\n"
				+ "  + Lose? " + river.isEmpty() + "\n"
				+ "}";
	}
}
