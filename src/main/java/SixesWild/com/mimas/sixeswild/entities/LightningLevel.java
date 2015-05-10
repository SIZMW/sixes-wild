package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

/**
 * This class is used as a representation of the lightning level type. The goal
 * in this level is to score as many points as possible in the given time.
 *
 * @author Cameron Jones
 */
public class LightningLevel extends GameLevel {

	/**
	 * Creates a LightningLevel instance with the specified tile frequencies,
	 * multiplier frequencies, type, name, tile list, point threshold values,
	 * timer, special moves and level number.
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
	 * @param restrictionCount
	 *            The number of the restriction for the level.
	 * @param specialMoves
	 *            The special moves counts for the level.
	 * @param levelNumber
	 *            The number for this level.
	 * @throws Exception
	 *             If board construction throws an exception.
	 */
	public LightningLevel(ArrayList<Double> tileFreq,
			ArrayList<Double> multFreq, String name, Tile tiles[][],
			PointThresholds pointThresholds, int restrictionCount,
			SpecialMoves specialMoves, int levelNumber) throws Exception {
		super(tileFreq, multFreq, name, tiles, pointThresholds,
				restrictionCount, specialMoves, levelNumber);
		type = LevelType.LIGHTNING;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SixesWild.com.mimas.sixeswild.entities.GameLevel#hasBeenCompleted()
	 */
	@Override
	public boolean hasBeenCompleted() {
		return restrictionCount <= 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SixesWild.com.mimas.sixeswild.entities.GameLevel#hasTimer()
	 */
	@Override
	public boolean hasTimerRestriction() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SixesWild.com.mimas.sixeswild.entities.GameLevel#hasMoveCount()
	 */
	@Override
	public boolean hasMovesRestriction() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SixesWild.com.mimas.sixeswild.entities.GameLevel#makeCopy()
	 */
	@Override
	public GameLevel makeCopy() {
		try {
			return new LightningLevel(getBoard().getTileFrequencies(),
					getBoard().getMultiplierFrequencies(), name, getBoard()
							.getTileTypes(), pointThresholds, restrictionCount,
					specialMoves, levelNumber);
		} catch (Exception e) {
			return null;
		}
	}
}
