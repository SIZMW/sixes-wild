package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

/**
 * This class is used as a representation of the puzzle level type. The goal in
 * this level is to score as many points as possible with the given number of
 * moves.
 *
 * @author Cameron Jones
 */
public class PuzzleLevel extends GameLevel {

	/**
	 * Creates a PuzzleLevel instance with the specified tile frequencies,
	 * multiplier frequencies, type, name, tile list, point thresholds, move
	 * count, special moves and level number.
	 *
	 * @param tileFreq
	 *            The tile frequencies for the level.
	 * @param multFreq
	 *            The multiplier frequencies for the level.
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
	public PuzzleLevel(ArrayList<Double> tileFreq, ArrayList<Double> multFreq,
			String name, Tile tiles[][], PointThresholds pointThresholds,
			int moveCount, SpecialMoves specialMoves, int levelNumber)
			throws Exception {
		super(tileFreq, multFreq, name, tiles, pointThresholds, moveCount,
				specialMoves, levelNumber);
		type = LevelType.PUZZLE;
	}
}
