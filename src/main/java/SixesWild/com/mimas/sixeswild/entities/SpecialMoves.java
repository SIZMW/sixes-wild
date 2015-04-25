package SixesWild.com.mimas.sixeswild.entities;

/**
 * SpecialMoves is an aggregation entity to hold all the counts of special moves
 * in a Level.
 * 
 * @author Yahel Nachum
 */
public class SpecialMoves {

	protected int resetBoardCount;
	protected int swapTileCount;
	protected int removeTileCount;
	protected int xStacySpecialMoveCount;

	/**
	 * Creates a SpecialMoves instance with 0 as count for all the special move
	 * types.
	 */
	public SpecialMoves() {
		this.resetBoardCount = 0;
		this.swapTileCount = 0;
		this.removeTileCount = 0;
		this.xStacySpecialMoveCount = 0;
	}

	/**
	 * Creates a SpecialMoves instance with the specified counts for all the
	 * special move types.
	 * 
	 * @param resetBoardCount
	 *            The reset board count.
	 * @param swapTileCount
	 *            The swap tile count.
	 * @param removeTileCount
	 *            The remove tile count.
	 * @param xStacySpecialMoveCount
	 *            The xStacy special move count.
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
	 *            The new reset board count.
	 */
	public void setResetBoardCount(int resetBoardCount) {
		this.resetBoardCount = resetBoardCount;
	}

	/**
	 * Sets the swap tile count.
	 * 
	 * @param swapTileCount
	 *            The new swap tile count.
	 */
	public void setSwapTileCount(int swapTileCount) {
		this.swapTileCount = swapTileCount;
	}

	/**
	 * Sets the remove tile count.
	 * 
	 * @param removeTileCount
	 *            The new remove tile count.
	 */
	public void setRemoveTileCount(int removeTileCount) {
		this.removeTileCount = removeTileCount;
	}

	/**
	 * Sets the xStacy special move count.
	 * 
	 * @param xStacySpecialMoveCount
	 *            The new xStacy special move count.
	 */
	public void setXStacySpecialMoveCount(int xStacySpecialMoveCount) {
		this.xStacySpecialMoveCount = xStacySpecialMoveCount;
	}

	/**
	 * Returns the reset board count.
	 * 
	 * @return an integer
	 */
	public int getResetBoardCount() {
		return this.resetBoardCount;
	}

	/**
	 * Returns the swap tile count.
	 * 
	 * @return an integer
	 */
	public int getSwapTileCount() {
		return this.swapTileCount;
	}

	/**
	 * Returns the remove tile count.
	 * 
	 * @return an integer
	 */
	public int getRemoveTileCount() {
		return this.removeTileCount;
	}

	/**
	 * Returns the xStacy special move count.
	 * 
	 * @return an integer
	 */
	public int getXStacySpecialMoveCount() {
		return this.xStacySpecialMoveCount;
	}
}
