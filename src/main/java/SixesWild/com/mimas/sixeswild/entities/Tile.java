package SixesWild.com.mimas.sixeswild.entities;

/**
 * Tile is an abstract entity that represents the tiles that are placed on a
 * Board. It has a type, number value and multiplier.
 *
 * @author Aditya Nivarthi
 */
public abstract class Tile {

	public final int SIX = 6;
	public final int ZERO = 0;

	protected TileType type;
	protected int number;
	protected int multiplier;

	/**
	 * Creates a Tile instance with NULL type, number 0 and multiplier 0.
	 */
	public Tile() {
		type = TileType.NULL;
		number = 0;
		multiplier = 0;
	}

	/**
	 * Returns the type from this tile.
	 *
	 * @return a TileType
	 */
	public TileType getType() {
		return type;
	}

	/**
	 * Returns the number of the tile.
	 *
	 * @return an integer
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Returns the multiplier of the tile.
	 *
	 * @return an integer
	 */
	public int getMultiplier() {
		return multiplier;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (o instanceof Tile) {
			Tile t = (Tile) o;
			return type.equals(t.getType()) && number == t.getNumber()
					&& multiplier == t.getMultiplier();
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = 17;
		int constVal = 37;
		return result * constVal * (type.hashCode() + number + multiplier);
	}
}
