package SixesWild.com.mimas.sixeswild.entities;

/**
 * This class is used as a representation of the positions in the game board for
 * Sixes Wild. The board has fixes square positions, each of which holds a tile.
 * 
 * @author Aditya Nivarthi
 */
public class Square {

	Tile tile;
	int xPosition;
	int yPosition;
	boolean marked;

	/**
	 * Constructor for Square class.
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
	 * @return this.tile The tile in the square.
	 */
	public Tile getTile() {
		return this.tile;
	}

	/**
	 * Adds the tile in the square.
	 * 
	 * @param tile
	 *            The tile to add.
	 * @return true
	 */
	public boolean addTile(Tile tile) {
		this.tile = tile;
		return true;
	}

	/**
	 * Removes the tile from the square.
	 * 
	 * @return true
	 */
	public boolean removeTile() {
		this.tile = null;
		return true;
	}

	/**
	 * Returns the x position of this square.
	 * 
	 * @return this.xPosition The x position of the square.
	 */
	public int getX() {
		return this.xPosition;
	}

	/**
	 * Returns the y position of this square.
	 * 
	 * @return this.yPosition The y position of the square.
	 */
	public int getY() {
		return this.yPosition;
	}

	/**
	 * Returns the marked attribute of the square.
	 * 
	 * @return this.marked The marked attribute of the square.
	 */
	public boolean isMarked() {
		return this.marked;
	}

	/**
	 * Sets the marked attribute of the square.
	 * 
	 * @param mark
	 *            The value of being marked to set for the square.
	 * @return true
	 */
	public boolean setMarked(boolean mark) {
		this.marked = mark;
		return true;
	}
}
