package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

/**
 * This class is used as a representation of the level entity. It defines the
 * playable level that describes all the constraints and properties of each
 * specific level in the game.
 *
 * @author Cameron Jones
 */
public abstract class GameLevel {

	protected LevelType type;
	protected SpecialMoves specialMoves;
	protected PointThresholds pointThresholds;
	protected String name;
	protected Board board;
	protected int timerCount;
	protected int moveCount;
	protected int levelNumber;

	/**
	 * Creates a GameLevel instance with the specified tile frequencies,
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
	public GameLevel(ArrayList<Double> tileFreq, ArrayList<Double> multFreq,
			String name, Tile tiles[][], PointThresholds pointThresholds,
			int moveCount, SpecialMoves specialMoves, int levelNumber)
			throws Exception {
		type = LevelType.PUZZLE;
		this.name = name;
		this.pointThresholds = pointThresholds;
		this.moveCount = moveCount;
		timerCount = 0;
		this.specialMoves = specialMoves;
		this.levelNumber = levelNumber;
		try {
			board = new Board(tiles, tileFreq, multFreq);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Creates a GameLevel instance with the specified tile frequencies,
	 * multiplier frequencies, type, name, tile list, point thresholds, timer,
	 * special moves and level number.
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
	 * @param timer
	 *            The timer for the level.
	 * @param specialMoves
	 *            The special moves counts for the level.
	 * @param levelNumber
	 *            The number for this level.
	 * @throws Exception
	 *             If board construction throws an exception.
	 */
	public GameLevel(ArrayList<Double> tileFreq, ArrayList<Double> multFreq,
			String name, Tile tiles[][], PointThresholds pointThresholds,
			SpecialMoves specialMoves, int levelNumber, int timer)
			throws Exception {
		type = LevelType.PUZZLE;
		this.name = name;
		this.pointThresholds = pointThresholds;
		timerCount = timer;
		moveCount = 0;
		this.specialMoves = specialMoves;
		this.levelNumber = levelNumber;
		board = new Board(tiles, tileFreq, multFreq);
	}

	/**
	 * Returns the type of level.
	 *
	 * @return a LevelType
	 */
	public LevelType getType() {
		return type;
	}

	/**
	 * Return the name of the level.
	 *
	 * @return a String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name the level.
	 *
	 * @param name
	 *            The new name of the level.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the board in the level.
	 *
	 * @return a Board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Sets the board in the level to the given board.
	 *
	 * @param board
	 *            The new board to set for the level.
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Returns the point threshold values for the level.
	 *
	 * @return a PointThresholds
	 */
	public PointThresholds getPointThresholds() {
		return pointThresholds;
	}

	/**
	 * Sets the point threshold values for the level.
	 *
	 * @param pointThresholds
	 *            The new point thresholds to set for the level.
	 */
	public void setPointThresholds(PointThresholds pointThresholds) {
		this.pointThresholds = pointThresholds;
	}

	/**
	 * Returns the number of moves for the level.
	 *
	 * @return the integer number of moves
	 */
	public int getMoveCount() {
		return moveCount;
	}

	/**
	 * Sets the number of moves for the level.
	 *
	 * @param moveCount
	 *            The new number of moves to set for the level.
	 */
	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}

	/**
	 * Updates the move count by the specified amount, with a minimum count of
	 * 0.
	 *
	 * @param delta
	 *            The integer value to update the move count.
	 */
	public synchronized void updateMoveCount(int delta) {
		moveCount += (delta + moveCount >= 0) ? delta : (-1 * moveCount);
	}

	/**
	 * Returns the timer for the level.
	 *
	 * @return a Timer
	 */
	public int getTimer() {
		return timerCount;
	}

	/**
	 * Sets the timer for the level.
	 *
	 * @param timer
	 *            The new timer to set for the level.
	 */
	public void setTimer(int timer) {
		timerCount = (timer >= 0) ? timer : 0;
	}

	/**
	 * Updates the timer count by the specified amount, with a minimum count of
	 * 0.
	 *
	 * @param delta
	 *            The integer value to update the timer count.
	 */
	public synchronized void updateTimerCount(int delta) {
		timerCount += (delta + timerCount >= 0) ? delta : (-1 * timerCount);
	}

	/**
	 * Sets the SpecialMoves
	 *
	 * @param newSpecialMoves
	 *            The new special moves for the level.
	 */
	public void setSpecialMoves(SpecialMoves newSpecialMoves) {
		specialMoves = newSpecialMoves;
	}

	/**
	 * Returns the Levels Special Moves
	 *
	 * @return a SpecialMoves
	 */
	public SpecialMoves getSpecialMoves() {
		return specialMoves;
	}

	/**
	 * Returns the LevelNumber
	 *
	 * @return the integer level number
	 */
	public int getLevelNumber() {
		return levelNumber;
	}

	/**
	 * Sets the level number to the specified level number.
	 *
	 * @param newNumber
	 *            The new level number for the level.
	 */
	public void setLevelNumber(int newNumber) {
		levelNumber = newNumber;
	}

	/**
	 * Returns whether the level has a timer as a level restriction.
	 *
	 * @return true if restriction is a timer; false otherwise
	 */
	public abstract boolean hasTimerRestriction();

	/**
	 * Returns whether the level has moves as a level restriction.
	 *
	 * @return true if restriction is a move count; false otherwise
	 */
	public abstract boolean hasMovesRestriction();

	/**
	 * Determines if the level has been completed.
	 *
	 * @return true if complete; false otherwise
	 */
	public abstract boolean hasBeenCompleted();

	/**
	 * Creates a copy of this level and returns the new GameLevel object.
	 * 
	 * @return a GameLevel
	 */
	public abstract GameLevel makeCopy();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}
}
