package SixesWild.com.mimas.sixeswild.entities;

/**
 * This class is used as a representation of the target tile entity. It defines
 * the position where a six number tile must land in the "Release" game type.
 * 
 * @author Aditya Nivarthi
 */
public class TargetTile extends Tile {

	/**
	 * Constructor for TargetTile class.
	 */
	public TargetTile() {
		this.type = TileType.TARGET;
		this.number = this.SIX;
		this.multiplier = 0;
	}
}
