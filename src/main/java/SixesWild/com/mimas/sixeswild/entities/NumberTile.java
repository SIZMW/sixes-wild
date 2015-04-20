package SixesWild.com.mimas.sixeswild.entities;

/**
 * This class is used as a representation of the number tile entity. It defines
 * the tile with a number that is used to create moves in the game and score
 * points.
 * 
 * @author Aditya Nivarthi
 */
public class NumberTile extends Tile {

	/**
	 * Constructor for NumberTile class.
	 * 
	 * @param number
	 *            The value on the tile.
	 * @param multiplier
	 *            The multiplier of the tile count.
	 */
	public NumberTile(int number, int multiplier) {
		super();
		this.type = TileType.NUMBER;
		this.number = number;
		this.multiplier = multiplier;
	}
}
