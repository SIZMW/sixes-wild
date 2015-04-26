package SixesWild.com.mimas.sixeswild.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Selection is the entity that defines the current Square selection that the
 * player requests during the game.
 * 
 * @author Aditya Nivarthi
 */
public class Selection {

	protected Set<Square> squareSet;

	/**
	 * Creates a Selection instance.
	 */
	public Selection() {
		squareSet = new HashSet<Square>();
	}

	/**
	 * Adds the given square to the selection.
	 * 
	 * @param square
	 *            The Square to add to the selection.
	 * @return true if square was added; false otherwise.
	 */
	public boolean add(Square square) {
		if (square == null) {
			return false;
		}

		return squareSet.add(square);
	}

	/**
	 * Removes the given square from the selection.
	 * 
	 * @param square
	 *            The Square to remove from the selection.
	 * @return true if successful; false otherwise
	 */
	public boolean remove(Square square) {
		return squareSet.remove(square);
	}

	/**
	 * Clears the entire selection.
	 * 
	 * @return true if successful
	 */
	public boolean clear() {
		squareSet.clear();
		return true;
	}

	/**
	 * Returns the selection as an array.
	 * 
	 * @return an Array
	 */
	public Object[] getArray() {
		return squareSet.toArray();
	}

	/**
	 * Returns whether two squares are next to each other. Checks if squares are
	 * vertically or horizontally adjacent, but not diagonally next to each
	 * other.
	 * 
	 * @param squareOne
	 *            First square to compare.
	 * @param squareTwo
	 *            Second square to compare.
	 * @return true if squares are next to each other; false otherwise.
	 */
	protected boolean isSquareNextTo(Square squareOne, Square squareTwo) {
		return (Math.abs(squareOne.getX() - squareTwo.getX()) == 1 && Math
				.abs(squareOne.getY() - squareTwo.getY()) == 0)
				|| (Math.abs(squareOne.getX() - squareTwo.getX()) == 0 && Math
						.abs(squareOne.getY() - squareTwo.getY()) == 1);
	}

	/**
	 * Returns whether the selection is valid or not, based on squares being
	 * next to one another and sum of the tiles in the squares.
	 * 
	 * @return true if selection is valid; false otherwise
	 */
	public boolean isSelectionValid() {

		// If selection has only one tile
		if (this.squareSet.size() <= 1) {
			return false;
		}

		Object squareArray[] = this.squareSet.toArray();

		// Check if each square is next to at least one other square in the
		// selection. This allows for the "T" move.
		boolean nextTo = false;

		for (int i = 0; i < squareArray.length; i++) {
			for (int j = 0; j < squareArray.length; j++) {

				// Don't check square against itself
				if (i != j
						&& this.isSquareNextTo((Square) squareArray[i],
								(Square) squareArray[j])) {
					nextTo = true;
				}
			}

			// If a square was not next to any other ones
			if (!nextTo) {
				return false;
			}

			// Reset boolean
			nextTo = false;
		}

		return this.isSelectionSumValid();
	}

	/**
	 * Returns whether the selection is currently valid or not, based on the
	 * squares being next to each other. This is used to determine if the move
	 * should continue onward or be reset.
	 * 
	 * @return true if selection is valid; false otherwise
	 */
	public boolean isSelectionStillValid() {

		// If selection has only one tile, allow more to be selected
		if (this.squareSet.size() <= 1) {
			return true;
		}

		Object squareArray[] = this.squareSet.toArray();

		// Check if each square is next to at least one other square in the
		// selection. This allows for the "T" move.
		boolean nextTo = false;

		for (int i = 0; i < squareArray.length; i++) {
			for (int j = 0; j < squareArray.length; j++) {

				// Don't check square against itself
				if (i != j
						&& this.isSquareNextTo((Square) squareArray[i],
								(Square) squareArray[j])) {
					nextTo = true;
				}
			}

			// If a square was not next to any other ones
			if (!nextTo) {
				return false;
			}

			// Reset boolean
			nextTo = false;
		}
		return this.isSelectionSumStillValid();
	}

	/**
	 * Returns whether the sum of the tiles in the squares in the current
	 * selection is equal to 6 or not.
	 * 
	 * @return true if sum equals 6; false otherwise.
	 */
	protected boolean isSelectionSumValid() {
		// Check sum of selection of squares
		int sum = 0;
		for (Square e : squareSet) {

			// Check for invalid types in selection
			if (!e.getTile().getType().equals(TileType.NUMBER)) {
				return false;
			}
			sum += e.getTile().getNumber();
		}

		// Invalid sum
		if (sum != 6) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Returns whether the current selection is valid in regards to the sum
	 * still being smaller than 6. Determines if the current move should still
	 * be allowed to continue.
	 * 
	 * @return true if sum is less than 6; false otherwise.
	 */
	protected boolean isSelectionSumStillValid() {
		// Check sum of selection of squares
		int sum = 0;
		for (Square e : squareSet) {

			// Check for invalid types in selection
			if (!e.getTile().getType().equals(TileType.NUMBER)) {
				return false;
			}
			sum += e.getTile().getNumber();
		}

		// Invalid sum
		if (sum > 6) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Returns the score that is calculated from this selection. Score is the
	 * number of tiles in the selection multiplied by the product of all the
	 * multipliers of each tile.
	 * 
	 * @return an integer
	 */
	public int getScore() {
		int score = 0;
		int multiplier = 1;
		for (Square e : squareSet) {
			score += 1;
			multiplier *= e.getTile().getMultiplier();
		}

		return score * multiplier;
	}

	/**
	 * Returns whether the selection is still valid to continue a swap move.
	 * 
	 * @return true if selection is valid; false otherwise
	 */
	public boolean isSwapStillValid() {

		// If selection does not have only two tiles
		if (this.squareSet.size() > 2) {
			return false;
		}

		for (Square e : squareSet) {

			// Check for invalid types in selection
			if (!e.getTile().getType().equals(TileType.NUMBER)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns whether the selection is valid to complete a swap move.
	 * 
	 * @return true if selection is valid; false otherwise
	 */
	public boolean isSwapValid() {

		// If selection does not have only two tiles
		if (this.squareSet.size() != 2) {
			return false;
		}

		for (Square e : squareSet) {

			// Check for invalid types in selection
			if (!e.getTile().getType().equals(TileType.NUMBER)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns whether the selection is still valid to continue a remove move.
	 * 
	 * @return true if selection is valid; false otherwise
	 */
	public boolean isRemoveStillValid() {

		// If selection does not have one tile
		if (this.squareSet.size() > 1) {
			return false;
		}

		for (Square e : squareSet) {

			// Check for invalid types in selection
			if (!e.getTile().getType().equals(TileType.NUMBER)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns whether the selection is valid to complete a remove move.
	 * 
	 * @return true if selection is valid; false otherwise
	 */
	public boolean isRemoveValid() {

		// If selection does not have one tile
		if (this.squareSet.size() != 1) {
			return false;
		}

		for (Square e : squareSet) {

			// Check for invalid types in selection
			if (!e.getTile().getType().equals(TileType.NUMBER)) {
				return false;
			}
		}

		return true;
	}
}
