package SixesWild.com.mimas.sixeswild.entities;

/**
 * This class is used as a representation of the target tile entity for Sixes
 * Wild. It defines the postion where a six number tile must land when playing
 * the "Release" game type.
 * 
 * @author Aditya Nivarthi
 */
public class TargetTile extends Tile {

	int number;
	final int SIX = 6;

	/**
	 * Constructor for TargetTile class.
	 * 
	 * @param type
	 *            The type of tile.
	 */
	public TargetTile(String type) {
		super(type);
		this.number = SIX;
	}

	/**
	 * Returns the number for the tile.
	 * 
	 * @return this.number The number for this tile.
	 */
	public int getNumber() {
		return this.number;
	}

}
