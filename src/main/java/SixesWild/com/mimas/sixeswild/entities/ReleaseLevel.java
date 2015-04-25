package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

/**
 * This class is used as a representation of the release level type. The goal in
 * this level is to guide the SixTiles to the TargetTiles by moving tiles below
 * the SixTiles to make them fall downward.
 * 
 * @author Cameron Jones
 */
public class ReleaseLevel extends GameLevel {

	/**
	 * Creates a ReleaseLevel instance with the specified tile frequencies,
	 * multiplier frequencies, type, name, tile list, point thresholds, move
	 * count, special moves and level number.
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
	 * @param specialMoves
	 *            The special moves counts for the level.
	 * @param levelNumber
	 *            The number for this level.
	 * @throws Exception
	 *             If board construction throws an exception.
	 */
	public ReleaseLevel(ArrayList<Double> tileFreq, ArrayList<Double> multFreq,
			LevelType type, String name, Tile tiles[][],
			PointThresholds pointThresholds, int moveCount,
			SpecialMoves specialMoves, int levelNumber) throws Exception {
		super(tileFreq, multFreq, type, name, tiles, pointThresholds,
				moveCount, specialMoves, levelNumber);

	}
}
