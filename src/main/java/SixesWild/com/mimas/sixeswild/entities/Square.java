package SixesWild.com.mimas.sixeswild.entities;

/**
 * Square is the representation of one position on the Board. They can be
 * marked, have a position noted by coordinates, and have a Tile to hold and
 * represent.
 * 
 * @author Aditya Nivarthi
 */
public class Square {

	protected Tile tile;
	protected int xPosition;
	protected int yPosition;
	protected boolean marked;
	protected boolean isSelected;

	/**
	 * Creates a Square instance with the specified Tile, x and y coordinates,
	 * and marked attribute.
	 * 
	 * @param tile
	 *            The tile in this square.
	 * @param x
	 *            X position on the board.
	 * @param y
	 *            Y position on the board.
	 * @param marked
	 *            The marked attribute.
	 */
	public Square(Tile tile, int x, int y, boolean marked) {
		this.tile = tile;
		this.xPosition = x;
		this.yPosition = y;
		this.marked = marked;
		this.isSelected = false;
	}

	/**
	 * Returns the tile in the square.
	 * 
	 * @return a Tile
	 */
	public Tile getTile() {
		return this.tile;
	}

	/**
	 * Adds the tile in the square.
	 * 
	 * @param tile
	 *            The tile to add.
	 * @return true if successful; false otherwise
	 */
	public boolean addTile(Tile tile) {
		if (tile == null) {
			return false;
		}

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
	 * @return an integer
	 */
	public int getX() {
		return this.xPosition;
	}

	/**
	 * Returns the y position of this square.
	 * 
	 * @return an integer
	 */
	public int getY() {
		return this.yPosition;
	}

	/**
	 * Returns the marked attribute of the square.
	 * 
	 * @return the marked attribute
	 */
	public boolean getMarked() {
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

	/**
	 * Returns the selected attribute of the square.
	 * 
	 * @return the selected attribute
	 */
	public boolean getSelected() {
		return this.isSelected;
	}

	/**
	 * Sets the selected attribute of the square.
	 * 
	 * @param selected
	 *            The value of being selected to set for the square.
	 * @return true
	 */
	public boolean setSelected(boolean selected) {
		this.isSelected = selected;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (o instanceof Square) {
			Square s = (Square) o;
			return this.tile.equals(s.getTile()) && this.xPosition == s.getX()
					&& this.yPosition == s.getY()
					&& this.marked == s.getMarked()
					&& this.isSelected == s.getSelected();
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int result = 17;
		int constVal = 37;
		return result
				* constVal
				* ((this.isSelected ? 0 : 1) + (this.marked ? 0 : 1)
						+ this.xPosition + this.yPosition + this.tile
							.hashCode());
	}
}
