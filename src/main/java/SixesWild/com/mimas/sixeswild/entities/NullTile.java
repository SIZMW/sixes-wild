package SixesWild.com.mimas.sixeswild.entities;

/**
 * This class is used as a representation of the null tile entity. It is used to
 * mark places that are not populated with playable tiles in a game.
 * 
 * @author Aditya Nivarthi
 */
public class NullTile extends Tile {

	/**
	 * Constructor for NullTile class.
	 */
	public NullTile() {
		super();
		this.type = TileType.NULL;
		this.number = 0;
		this.multiplier = 0;
	}
}
