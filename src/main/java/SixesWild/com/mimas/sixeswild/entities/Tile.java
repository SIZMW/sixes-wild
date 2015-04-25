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
		this.type = TileType.NULL;
		this.number = 0;
		this.multiplier = 0;
	}

	/**
	 * Returns the type from this tile.
	 * 
	 * @return a TileType
	 */
	public TileType getType() {
		return this.type;
	}

	/**
	 * Returns the number of the tile.
	 * 
	 * @return an integer
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * Returns the multiplier of the tile.
	 * 
	 * @return an integer
	 */
	public int getMultiplier() {
		return this.multiplier;
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

		if (o instanceof Tile) {
			Tile t = (Tile) o;
			return this.type.equals(t.getType())
					&& this.number == t.getNumber()
					&& this.multiplier == t.getMultiplier();
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
		return result * constVal
				* (this.type.hashCode() + this.number + this.multiplier);
	}
}
