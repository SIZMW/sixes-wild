package SixesWild.com.mimas.sixeswild.entities;

/**
 * This class is used as a representation of the number tile entity for Sixes
 * Wild.
 * 
 * @author Aditya Nivarthi
 */
public class NumberTile extends Tile {

	int number;
	int multiplier;

	/**
	 * Constructor for NumberTile class.
	 * 
	 * @param type
	 *            The type of tile.
	 * @param number
	 *            The value on the tile.
	 * @param multiplier
	 *            The multiplier of the tile count.
	 */
	public NumberTile(String type, int number, int multiplier) {
		super(type);
		this.number = number;
		this.multiplier = multiplier;
	}

	/**
	 * Returns the number of the tile.
	 * 
	 * @return this.number The number of the tile.
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * Returns the multiplier of the tile.
	 * 
	 * @return this.multiplier The multiplier of the tile.
	 */
	public int getMultiplier() {
		return this.multiplier;
	}

}
