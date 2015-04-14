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
	 */
	public TargetTile() {
		super();
		this.type = TileType.TARGET;
		this.number = SIX;
		this.multiplier = 0;
	}
}
