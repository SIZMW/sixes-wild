package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

/**
 * This class is used as a representation of the elimination level type. The
 * goal in this level is to mark all the squares and create moves using each of
 * the squares at least once.
 *
 * @author Cameron Jones
 */
public class EliminationLevel extends GameLevel {

	/**
	 * Creates an EliminationLevel instance with the specified tile frequencies,
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
	public EliminationLevel(ArrayList<Double> tileFreq,
			ArrayList<Double> multFreq, String name, Tile tiles[][],
			PointThresholds pointThresholds, int restrictionCount,
			SpecialMoves specialMoves, int levelNumber) throws Exception {
		super(tileFreq, multFreq, name, tiles, pointThresholds,
				restrictionCount, specialMoves, levelNumber);
		type = LevelType.ELIMINATION;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see SixesWild.com.mimas.sixeswild.entities.GameLevel#hasBeenCompleted()
	 */
	@Override
	public boolean hasBeenCompleted() {
		for (int i = 0; i < board.SIZE_X; i++) {
			for (int j = 0; j < board.SIZE_Y; j++) {
				if (!board.getSquare(i, j).getMarked()
						&& board.getSquare(i, j).getTile().getType()
								.equals(TileType.NUMBER)) {
					return false;
				}
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see SixesWild.com.mimas.sixeswild.entities.GameLevel#hasTimer()
	 */
	@Override
	public boolean hasTimerRestriction() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see SixesWild.com.mimas.sixeswild.entities.GameLevel#hasMoveCount()
	 */
	@Override
	public boolean hasMovesRestriction() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see SixesWild.com.mimas.sixeswild.entities.GameLevel#makeCopy()
	 */
	@Override
	public GameLevel makeCopy() {
		try {
			return new EliminationLevel(getBoard().getTileFrequencies(),
					getBoard().getMultiplierFrequencies(), name, getBoard()
							.getTileTypes(), pointThresholds, restrictionCount,
					specialMoves, levelNumber);
		} catch (Exception e) {
			return null;
		}
	}
}
