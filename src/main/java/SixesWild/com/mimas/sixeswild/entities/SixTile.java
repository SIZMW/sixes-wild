package SixesWild.com.mimas.sixeswild.entities;

/**
 * This class is used as a representation of the six tile entity for Sixes
 * Wild.
 * 
 * @author Aditya Nivarthi
 */
public class SixTile extends Tile {

	int number;
	final int SIX = 6;

	/**
	 * Constructor for SixTile class.
	 */
	public SixTile() {
		super();
		this.type = TileType.SIX;
		this.number = SIX;
		this.multiplier = 0;
	}
}
