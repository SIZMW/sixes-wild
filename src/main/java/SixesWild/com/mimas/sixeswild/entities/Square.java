package SixesWild.com.mimas.sixeswild.entities;

/**
 * Square is the representation of one position on the Board. They can be
 * marked, have a position noted by coordinates, and have a Tile to hold and
 * represent.
 * 
 * @author Aditya Nivarthi
 */
public class Square {

	Tile tile;
	int xPosition;
	int yPosition;
	boolean marked;

	/**
	 * Creates a Square instance with the specified Tile, x and y coordinates, and marked
	 * attribute.
	 * 
	 * @param tile
	 *            The tile in this square.
	 * @param x
	 *            X position on the board.
	 * @param y
	 *            Y position on the board.
	 * @param marked
	 *            Marked attribute for "Elimination" game type.
	 */
	public Square(Tile tile, int x, int y, boolean marked) {
		this.tile = tile;
		this.xPosition = x;
		this.yPosition = y;
		this.marked = marked;
	}

	/**
	 * Returns the tile in the square.
	 * 
	 * @return Tile tile
	 */
	public Tile getTile() {
		return this.tile;
	}

	/**
	 * Adds the tile in the square.
	 * 
	 * @param tile
	 *            The tile to add.
	 * @return true if the Tile is added.
	 */
	public boolean addTile(Tile tile) {
		this.tile = tile;
		return true;
	}

	/**
	 * Removes the tile from the square.
	 * 
	 * @return true if the Tile is removed.
	 */
	public boolean removeTile() {
		this.tile = null;
		return true;
	}

	/**
	 * Returns the x position of this square.
	 * 
	 * @return Integer x coordinate
	 */
	public int getX() {
		return this.xPosition;
	}

	/**
	 * Returns the y position of this square.
	 * 
	 * @return Integer y coordinate
	 */
	public int getY() {
		return this.yPosition;
	}

	/**
	 * Returns the marked attribute of the square.
	 * 
	 * @return Boolean marked attribute
	 */
	public boolean getMarked() {
		return this.marked;
	}

	/**
	 * Sets the marked attribute of the square.
	 * 
	 * @param mark
	 *            The value of being marked to set for the square.
	 * @return true if marked attribute is updated.
	 */
	public boolean setMarked(boolean mark) {
		this.marked = mark;
		return true;
	}
}
