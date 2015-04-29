package SixesWild.com.mimas.sixeswild.entities;

/**
 * TargetTile is one type of Tile that exists on a Board. It represents the
 * position in the board where SixTiles must fall during the "Release" game
 * type. It has all the attributes of a Tile.
 *
 * @author Aditya Nivarthi
 */
public class TargetTile extends Tile {

	/**
	 * Creates a TargetTile instance with TARGET type, number 6 and multiplier
	 * 0.
	 */
	public TargetTile() {
		type = TileType.TARGET;
		number = ZERO;
		multiplier = 0;
	}
}
