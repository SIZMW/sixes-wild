package SixesWild.com.mimas.sixeswild.entities;

/**
 * SixTile is one type of Tile that exists on a Board. It represents the Tile
 * that must fall into a TargetTile during the "Release" game type. It has all
 * the attributes of a Tile.
 * 
 * @author Aditya Nivarthi
 */
public class SixTile extends Tile {

	/**
	 * Creates a SixTile instance with SIX type, number SIX and multiplier 0.
	 */
	public SixTile() {
		super();
		this.type = TileType.SIX;
		this.number = this.SIX;
		this.multiplier = 0;
	}
}
