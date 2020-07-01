
public class BasicPlayer {

	public int playerId;
	public String nick;
	private int arrowsShot;
	public River river;

	public BasicPlayer(int playerId, String nick, int riverSize, int boatSize, String boatName) {
		this.playerId = playerId;
		this.nick = nick;
		Boat tempBoat = new Boat(boatSize, boatName);
		this.river = new River(10, tempBoat);
	}

	public int getArrowsShot() {
		return arrowsShot;
	}

	public void shootArrow(int positionOnEnemyRiver, BasicPlayer enemy) {
		arrowsShot++;
		enemy.river.receiveAttack(positionOnEnemyRiver);
	}

	public String getBoatName(){
		return river.boat.name;
	}
	
	public void moveBoat(int newBoatIndex) {
		river.moveBoat(newBoatIndex);
	}
	
	public boolean wasEnemyDefeated(BasicPlayer enemy) {
		return enemy.river.isEmpty();
	}
	
	public boolean isLoseTheMatch(){
		return river.isEmpty();
	}

	@Override
	public String toString() {
		return "BasicPlayer " + playerId + ": " + nick + "{\n"
				+ river.toString() + "\n"
				+ "  + Lose? " + isLoseTheMatch() + "\n"
				+ "}";
	}
}
