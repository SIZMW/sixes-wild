package SixesWild.com.mimas.sixeswild.entities;

/**
 * This class is used as a representation of the Tile entity for Sixes Wild. It
 * represents abstract tile that is used to define the specific types of tiles.
 * 
 * @author Aditya Nivarthi
 */
public abstract class Tile {
	String type;

	/**
	 * Constructor for Tile object.
	 * 
	 * @param type
	 *            The type of tile.
	 */
	public Tile(String type) {
		this.type = type;
	}

	/**
	 * Returns the type from this tile.1
	 * 
	 * @return this.type The type of tile.
	 */
	public String getType() {
		return this.type;
	}
}
