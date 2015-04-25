package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

import javax.swing.Timer;

/**
 * This class is used as a representation of the level entity. It defines the
 * playable level that describes all the constraints and properties of each
 * specific level in the game.
 * 
 * @author Cameron Jones
 */
public abstract class Level {

	protected LevelType type;
	protected SpecialMoves specialMoves;
	protected PointThresholds pointThresholds;
	protected String name;
	protected Board board;
	protected Timer timer;
	protected int moveCount;
	protected int levelNumber;

	/**
	 * Creates a Level instance with the specified tile frequencies, multiplier
	 * frequencies, type, name, tile list, point thresholds, move count, special
	 * moves and level number.
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
	public Level(ArrayList<Double> tileFreq, ArrayList<Double> multFreq,
			LevelType type, String name, Tile tiles[][],
			PointThresholds pointThresholds, int moveCount,
			SpecialMoves specialMoves, int levelNumber) throws Exception {
		this.type = type;
		this.name = name;
		this.pointThresholds = pointThresholds;
		this.moveCount = moveCount;
		this.timer = null;
		this.specialMoves = specialMoves;
		this.levelNumber = levelNumber;
		try {
			this.board = new Board(tiles, tileFreq, multFreq);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Creates a Level instance with the specified tile frequencies, multiplier
	 * frequencies, type, name, tile list, point thresholds, timer, special
	 * moves and level number.
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
	 * @param timer
	 *            The timer for the level.
	 * @param specialMoves
	 *            The special moves counts for the level.
	 * @param levelNumber
	 *            The number for this level.
	 * @throws Exception
	 *             If board construction throws an exception.
	 */
	public Level(ArrayList<Double> tileFreq, ArrayList<Double> multFreq,
			LevelType type, String name, Tile tiles[][],
			PointThresholds pointThresholds, Timer timer,
			SpecialMoves specialMoves, int levelNumber) throws Exception {
		this.type = type;
		this.name = name;
		this.pointThresholds = pointThresholds;
		this.timer = timer;
		this.moveCount = 0;
		this.specialMoves = specialMoves;
		this.levelNumber = levelNumber;

		this.board = new Board(tiles, tileFreq, multFreq);
	}

	/**
	 * Returns the type of level.
	 * 
	 * @return a LevelType
	 */
	public LevelType getType() {
		return this.type;
	}

	/**
	 * Set the type of level.
	 * 
	 * @param type
	 *            The level type to set for the level.
	 */
	public void setType(LevelType type) {
		this.type = type;
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
	 * Returns the timer for the level.
	 * 
	 * @return a Timer
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * Sets the timer for the level.
	 * 
	 * @param timer
	 *            The new timer to set for the level.
	 */
	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	/**
	 * Sets the SpecialMoves
	 * 
	 * @param newSpecialMoves
	 *            The new special moves for the level.
	 */
	public void setSpecialMoves(SpecialMoves newSpecialMoves) {
		this.specialMoves = newSpecialMoves;
	}

	/**
	 * Returns the Levels Special Moves
	 * 
	 * @return a SpecialMoves
	 */
	public SpecialMoves getSpecialMoves() {
		return this.specialMoves;
	}

	/**
	 * Returns the LevelNumber
	 * 
	 * @return the integer level number
	 */
	public int getLevelNumber() {
		return this.levelNumber;
	}

	/**
	 * Sets the level number to the specified level number.
	 * 
	 * @param newNumber
	 *            The new level number for the level.
	 */
	public void setLevelNumber(int newNumber) {
		this.levelNumber = newNumber;
	}
}
