package SixesWild.com.mimas.sixeswild.entities;

/**
 * This class is used as a representation of the null type in Sixes Wild. It is
 * used to mark places that are not populated with tiles in a game.
 * 
 * @author Aditya Nivarthi
 */
public class NullTile extends Tile {

	/**
	 * Constructor for NullTile class.
	 * 
	 * @param type
	 *            The type of tile.
	 */
	public NullTile(String type) {
		super(type);
	}

}
