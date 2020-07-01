
import java.util.ArrayList;
import java.util.List;


public class Boat {

	public String name = "";
	private List<Boolean> blocks;
	private int sizeOriginal;
	
	public Boat(int size) {
		blocks = new ArrayList<>(size);
		this.sizeOriginal = size;
		initBlocks();
	}
	
	public Boat(int size, String name) {
		this(size);
		this.name = name;
	}

	public void initBlocks() {
		for (int index = 0; index < sizeOriginal(); index++) {
			blocks.add(true);
		}
	}
	
	public Boolean getBlock(int indexOfBlock){
		if (indexOfBlock >= 0 && indexOfBlock < sizeCurrent()) {
			return blocks.get(indexOfBlock);
		}
		
		return null;
	}

	public void rebuildBlock() {
		if (sizeCurrent() < sizeOriginal()) {
			blocks.add(true);
		}
	}
	
	public void rebuild(){
		for (int indexOfBlock = sizeCurrent() - 1; indexOfBlock < sizeOriginal(); indexOfBlock++) {
			blocks.add(true);
		}
	}

	public void destroyBlock(int indexOfBlock) {
		if (indexOfBlock >= 0 && indexOfBlock < sizeCurrent()) {
			blocks.remove(indexOfBlock);
		}
	}

	public void sink() {
		for (int index = 0; index < sizeCurrent(); index++) {
			blocks.remove(index);
		}
	}
	
	public int sizeCurrent(){
		return blocks.size();
	}
	
	public int sizeOriginal(){
		return sizeOriginal;
	}

	@Override
	public String toString() {
		String textBlocks = "";
		
		for (int indexOfBlock = 0; indexOfBlock < sizeOriginal(); indexOfBlock++) {
			if (indexOfBlock < sizeCurrent()) {
				textBlocks += "[" + (getBlock(indexOfBlock) ? "O" : "x") + "]";
			}
			else{
				textBlocks += "[x]";
			}
		}
		
		return textBlocks;
	}
}
