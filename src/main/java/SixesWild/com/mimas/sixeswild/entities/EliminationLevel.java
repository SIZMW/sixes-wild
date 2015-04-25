package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

/**
 * This class is used as a representation of the elimination level type. The
 * goal in this level is to mark all the squares and create moves using each of
 * the squares at least once.
 * 
 * @author Cameron Jones
 */
public class EliminationLevel extends Level {

	/**
	 * Creates an EliminationLevel instance with the specified tile frequencies,
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
	public EliminationLevel(ArrayList<Double> tileFreq,
			ArrayList<Double> multFreq, LevelType type, String name,
			Tile tiles[][], PointThresholds pointThresholds, int moveCount,
			SpecialMoves specialMoves, int levelNumber) throws Exception {
		super(tileFreq, multFreq, type, name, tiles, pointThresholds,
				moveCount, specialMoves, levelNumber);

	}
}
