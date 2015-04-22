package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

/**
 * This class is used as a representation of the puzzle level type. The
 * goal in this level is to score as many points as possible with the given
 * number of moves.
 * 
 * @author Cameron Jones
 */
public class PuzzleLevel extends Level {

	/**
	 * Creates a PuzzleLevel instance with the specified tile frequencies,
	 * multiplier frequencies, type, name, tile list, point thresholds and move
	 * count.
	 * 
	 * @param tileFreq
	 *            The tile frequencies for the level.
	 * @param multFreq
	 *            The multiplier frequencies for the level.
	 * @param type
	 *            The type of level.
	 * @param name
	 *            The name of the level.
	 * @param tiles
	 *            The list of tiles for the board in the level.
	 * @param pointThresholds
	 *            The point threshold values for the level.
	 * @param moveCount
	 *            The number of moves for the level.
	 */
	public PuzzleLevel(ArrayList<Double> tileFreq, ArrayList<Double> multFreq,
			LevelType type, String name, Tile tiles[][],
			PointThresholds pointThresholds, int moveCount) {
		super();
		this.type = type;
		this.name = name;
		this.pointThresholds = pointThresholds;
		this.moveCount = moveCount;
		this.timer = null;

		try {
			this.board = new Board(tiles, tileFreq, multFreq);
		} catch (Exception e) {

		}
	}
}
