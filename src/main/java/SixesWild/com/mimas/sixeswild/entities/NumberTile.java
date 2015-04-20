package SixesWild.com.mimas.sixeswild.entities;

/**
 * NumberTile is one type of Tile that exists on a Board. It represents the
 * tiles that are used in moves to score points in the game. These tiles are
 * selected in sums of six to create moves.
 * 
 * @author Aditya Nivarthi
 */
public class NumberTile extends Tile {

	/**
	 * Creates a NumberTile instance with NUMBER type and the specified number
	 * and multiplier.
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
