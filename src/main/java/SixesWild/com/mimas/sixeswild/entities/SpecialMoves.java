package SixesWild.com.mimas.sixeswild.entities;

/**
 * This class is used as a representation of the special moves entity. It
 * aggregates the amount of special moves available for each level into one
 * class.
 * 
 * @author Yahel Nachum
 */
public class SpecialMoves {

	int resetBoardCount;
	int swapTileCount;
	int removeTileCount;
	int xStacySpecialMoveCount;

	/**
	 * Default constructor for SpecialMoves class.
	 */
	public SpecialMoves() {
		this.resetBoardCount = 0;
		this.swapTileCount = 0;
		this.removeTileCount = 0;
		this.xStacySpecialMoveCount = 0;
	}

	/**
	 * Parameterized constructor for SpecialMoves class.
	 * 
	 * @param resetBoardCount
	 *            The reset board count.
	 * @param swapTileCount
	 *            The swap tile count.
	 * @param removeTileCount
	 *            The remove tile count.
	 * @param otherSpecialMoveCount
	 *            The other special move count.
	 */
	public SpecialMoves(int resetBoardCount, int swapTileCount,
			int removeTileCount, int xStacySpecialMoveCount) {
		this.resetBoardCount = resetBoardCount;
		this.swapTileCount = swapTileCount;
		this.removeTileCount = removeTileCount;
		this.xStacySpecialMoveCount = xStacySpecialMoveCount;
	}

	/**
	 * Sets the reset board count.
	 * 
	 * @param resetBoardCount
	 *            The reset board count.
	 */
	public void setResetBoardCount(int resetBoardCount) {
		this.resetBoardCount = resetBoardCount;
	}

	/**
	 * Sets the swap tile count.
	 * 
	 * @param swapTileCount
	 *            The swap tile count.
	 */
	public void setSwapTileCount(int swapTileCount) {
		this.swapTileCount = swapTileCount;
	}

	/**
	 * Sets the remove tile count.
	 * 
	 * @param removeTileCount
	 *            The remove tile count.
	 */
	public void setRemoveTileCount(int removeTileCount) {
		this.removeTileCount = removeTileCount;
	}

	/**
	 * Sets the xStacy special move count.
	 * 
	 * @param xStacySpecialMoveCount
	 *            The xStacy special move count.
	 */
	public void setXStacySpecialMoveCount(int xStacySpecialMoveCount) {
		this.xStacySpecialMoveCount = xStacySpecialMoveCount;
	}

	/**
	 * Returns the reset board count.
	 * 
	 * @return this.resetBoardCount The reset board count.
	 */
	public int getResetBoardCount() {
		return this.resetBoardCount;
	}

	/**
	 * Returns the swap tile count.
	 * 
	 * @return this.swapTileCount The swap tile count.
	 */
	public int getSwapTileCount() {
		return this.swapTileCount;
	}

	/**
	 * Returns the remove tile count.
	 * 
	 * @return this.removeTileCount The remove tile count.
	 */
	public int getRemoveTileCount() {
		return this.removeTileCount;
	}

	/**
	 * Returns the xStacy special move count.
	 * 
	 * @return this.xStacySpecialMoveCount The xStacy special move count.
	 */
	public int getXStacySpecialMoveCount() {
		return this.xStacySpecialMoveCount;
	}
}
