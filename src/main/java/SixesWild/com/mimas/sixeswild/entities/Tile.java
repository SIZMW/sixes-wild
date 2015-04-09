package SixesWild.com.mimas.sixeswild.entities;

public class Tile {

	int number;
	String type;
	int multiplier;
	
	public Tile(int number, String type, int multiplier) {
		this.number = number;
		this.type = type;
		this.multiplier = multiplier;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getMultiplier() {
		return this.multiplier;
	}
}
