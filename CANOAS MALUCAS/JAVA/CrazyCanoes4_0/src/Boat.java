
public class Boat {

	public String name = "";
	public boolean[] blocks;

	public Boat(int size) {
		blocks = new boolean[size];
		initBlocks();
	}

	public void initBlocks() {
		for (int index = 0; index < blocks.length; index++) {
			blocks[index] = true;
		}
	}

	public void rebuildBlock(int index) {
		if (index >= 0 && index < blocks.length) {
			blocks[index] = true;
		}
	}

	public void destroyBlock(int index) {
		if (index >= 0 && index < blocks.length) {
			blocks[index] = false;
		}
	}

	public void sink() {
		for (int index = 0; index < blocks.length; index++) {
			blocks[index] = false;
		}
	}

	@Override
	public String toString() {
		String textBlocks = "";
		for (boolean block : blocks) {
			textBlocks += "[" + (block ? "O" : "x") + "]";
		}
		return "Boat{\n"
				+ "  + name = " + name + "\n"
				+ "  + blocks = " + textBlocks + "\n"
				+ "}";
	}
}
