package SixesWild.com.mimas.sixeswild.entities;

/**
 * Tile is an abstract entity that represents the tiles that are placed on a
 * Board. It has a type, number value and multiplier.
 * 
 * @author Aditya Nivarthi
 */
public abstract class Tile {

	final int SIX = 6;

	TileType type;
	int number;
	int multiplier;

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
	 * @return TileType type
	 */
	public TileType getType() {
		return this.type;
	}

	/**
	 * Returns the number of the tile.
	 * 
	 * @return Integer number
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * Returns the multiplier of the tile.
	 * 
	 * @return Integer multiplier
	 */
	public int getMultiplier() {
		return this.multiplier;
	}

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

	public int hashCode() {
		int result = 17;
		int constVal = 37;
		return result * constVal
				* (this.type.hashCode() + this.number + this.multiplier);
	}
}
