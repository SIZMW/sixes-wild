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
	 * @param specialMoves
	 *            The special moves counts for the level.
	 * @param levelNumber
	 *            The number for this level.
	 * @param timer
	 *            The timer amount for the level.
	 * @throws Exception
	 *             If board construction throws an exception.
	 */
	public LightningLevel(ArrayList<Double> tileFreq,
			ArrayList<Double> multFreq, String name, Tile tiles[][],
			PointThresholds pointThresholds, SpecialMoves specialMoves,
			int levelNumber, int timer) throws Exception {
		super(tileFreq, multFreq, name, tiles, pointThresholds, specialMoves,
				levelNumber, timer);
		type = LevelType.LIGHTNING;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see SixesWild.com.mimas.sixeswild.entities.GameLevel#hasBeenCompleted()
	 */
	@Override
	public boolean hasBeenCompleted() {
		return timerCount <= 0;
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
}
