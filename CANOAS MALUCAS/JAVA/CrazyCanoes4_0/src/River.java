
public class River {

	public boolean[] waterParts;
	public Boat boat;
	private int lastPositionOfBoat;

	public River(int size, Boat boat) {
		if (size > (boat.sizeOriginal() * 2)) {
			waterParts = new boolean[size];
			this.boat = boat;
			moveBoat(0);
		}
	}

	public int getLastPositionOfBoat() {
		return lastPositionOfBoat;
	}

	public void cleanWaters() {
		for (int index = 0; index < waterParts.length; index++) {
			waterParts[index] = false;
		}
	}

	public void moveBoat(int newBoatIndex) {
		int maxIndex = newBoatIndex + boat.sizeCurrent() - 1;
		
		if (newBoatIndex >= 0 && maxIndex < waterParts.length) {
			lastPositionOfBoat = newBoatIndex;
			int indexOfBoat = 0;
			
			for (int indexOfRiver = 0; indexOfRiver < waterParts.length; indexOfRiver++) {
				
				if (indexOfRiver >= newBoatIndex && indexOfBoat < boat.sizeCurrent()) {
					waterParts[indexOfRiver] = boat.getBlock(indexOfBoat);
					indexOfBoat++;
				} else {
					waterParts[indexOfRiver] = false;
				}
				
			}
		}
	}

	public boolean isEmpty() {
		for (boolean bloco : waterParts) {
			if (bloco == true) {
				return false;
			}
		}
		return true;
	}

	/*
                [0][1][2][3]
    [~][~][~][~][#][#][~][#][~][~]
    [0][1][2][3][4][5][6][7][8][9]
                 U     A  F
	 */
	public void receiveAttack(int waterPartIndex) {
		if (waterPartIndex >= 0 && waterPartIndex < waterParts.length) {
			int maxBoatIndex = lastPositionOfBoat + boat.sizeCurrent();
			
			if (waterPartIndex >= lastPositionOfBoat && waterPartIndex < maxBoatIndex) {
				int indexOfBoat = waterPartIndex - lastPositionOfBoat;
				boat.destroyBlock(indexOfBoat);
			}
			
			moveBoat(lastPositionOfBoat);
		}
	}

	@Override
	public String toString() {
		
		String waterPartsText = "";
		for (int indice = 0; indice < waterParts.length; indice++) {
			waterPartsText += "[" + (waterParts[indice] ? "O" : "~") + "]";
		}
		return ""
				+ "  + boat \"" + boat.name + "\": " + boat.toString() + "\n"
				+ "  + waterParts: " + waterPartsText + "\n"
				+ "  + Is Empty? " + isEmpty();
	}
}
