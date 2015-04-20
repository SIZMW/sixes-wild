package SixesWild.com.mimas.sixeswild.entities;

/**
 * This class is used as a representation of the six tile entity. It defines the
 * six tiles that must be placed in target tiles in the "Release" game type.
 * 
 * @author Aditya Nivarthi
 */
public class SixTile extends Tile {

	/**
	 * Constructor for SixTile class.
	 */
	public SixTile() {
		super();
		this.type = TileType.SIX;
		this.number = this.SIX;
		this.multiplier = 0;
	}
}
