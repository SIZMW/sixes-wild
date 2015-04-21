package SixesWild.com.mimas.sixeswild.entities;

import java.util.HashSet;
import java.util.Set;

public class Selection {

	protected Set<Square> squareSet;

	public Selection() {
		squareSet = new HashSet<Square>();
	}

	public boolean add(Square square) {
		return squareSet.add(square);
	}

	public boolean remove(Square square) {
		return squareSet.remove(square);
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
		// Verify selection exists
		if (squareSet.equals(null)) {
			return false;
		}

		// Verify squares exist
		for (Square e : squareSet) {
			if (e.equals(null)) {
				return false;
			}
		}

		// Check if each square is next to at least one other square in the
		// selection. This allows for the "T" move.
		boolean nextTo = false;

		for (Square e : squareSet) {
			for (Square f : squareSet) {

				// Don't check square against itself
				if (!e.equals(f) && this.isSquareNextTo(e, f)) {
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
