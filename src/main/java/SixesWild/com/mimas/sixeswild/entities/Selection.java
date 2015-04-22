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
	 * @return true if Square was added; false otherwise.
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
	 * @return Result of Set remove method.
	 */
	public boolean remove(Square square) {
		return squareSet.remove(square);
	}

	/**
	 * Clears the entire selection.
	 * 
	 * @return true on success; false otherwise.
	 */
	public boolean clear() {
		squareSet.clear();
		return true;
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
	 * @return true if Squares are next to each other; false otherwise.
	 */
	protected boolean isSquareNextTo(Square squareOne, Square squareTwo) {
		return (Math.abs(squareOne.getX() - squareTwo.getX()) == 1 && Math
				.abs(squareOne.getY() - squareTwo.getY()) == 0)
				|| (Math.abs(squareOne.getX() - squareTwo.getX()) == 0 && Math
						.abs(squareOne.getY() - squareTwo.getY()) == 1);
	}

	/**
	 * Returns whether the given selection is valid or not.
	 * 
	 * @return true if selection is valid; false otherwise.
	 */
	public boolean isValidSelection() {

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
		}

		return true;
	}
}
