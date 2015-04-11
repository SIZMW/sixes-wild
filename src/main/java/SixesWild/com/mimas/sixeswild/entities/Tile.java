package SixesWild.com.mimas.sixeswild.entities;

//TODO Make this class abstract

/**
 * @author Aditya Nivarthi
 * @brief This class is used as a representation of the Tile entity for Sixes
 *        Wild. It represents abstract tile that is used to define the specific
 *        types of tiles.
 */
public class Tile {
	String type;

	/**
	 * @brief Constructor for Tile object.
	 * @param type
	 *            The type of tile.
	 */
	public Tile(String type) {
		this.type = type;
	}

	/**
	 * @brief Returns the type from this tile.1
	 * @return this.type The type of tile.
	 */
	public String getType() {
		return this.type;
	}
}
