package SixesWild.com.mimas.sixeswild.entities;

/**
 * NullTile is one type of Tile that exists on a Board. It represents a position
 * that has no other type of tile. It cannot be moved or interacted with.
 *
 * @author Aditya Nivarthi
 */
public class NullTile extends Tile {

	/**
	 * Creates a NullTile instance with NULL type, number 0 and multiplier 0.
	 */
	public NullTile() {
		super();
		type = TileType.NULL;
		number = 0;
		multiplier = 0;
	}
}
