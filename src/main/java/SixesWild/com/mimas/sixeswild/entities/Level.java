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

	LevelType type;
	SpecialMoves specialMoves;
	PointThresholds pointThresholds;
	String name;
	Board board;
	Timer timer;
	int moveCount;
	int levelNumber;

	/**
	 * 
	 * Creates a Level instance with the specified tile frequencies, multiplier
	 * frequencies, type, name, tile list, point thresholds and move count.
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
	 * @throws Exception 
	 */
	public Level(ArrayList<Double> tileFreq, ArrayList<Double> multFreq,
			LevelType type, String name, Tile tiles[][],
			PointThresholds pointThresholds, int moveCount, SpecialMoves specialMoves, int levelNumber) throws Exception {
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
	 * frequencies, type, name, tile list, point thresholds and timer.
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
	 * @throws Exception 
	 */
	public Level(ArrayList<Double> tileFreq, ArrayList<Double> multFreq,
			LevelType type, String name, Tile tiles[][],
			PointThresholds pointThresholds, Timer timer, SpecialMoves specialMoves, int levelNumber) throws Exception {
		this.type = type;
		this.name = name;
		this.pointThresholds = pointThresholds;
		this.timer = timer;
		this.moveCount = 0;
		this.specialMoves = specialMoves;
		this.levelNumber = levelNumber;
		try {
			this.board = new Board(tiles, tileFreq, multFreq);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Creates a Level instance.
	 */
	public Level() {
		ArrayList<Double> tileFreq = new ArrayList<Double>();
		ArrayList<Double> multFreq = new ArrayList<Double>();

		tileFreq.add(.10);
		tileFreq.add(.20);
		tileFreq.add(.30);
		tileFreq.add(.30);
		tileFreq.add(.05);
		tileFreq.add(.05);
		multFreq.add(.95);
		multFreq.add(.025);
		multFreq.add(.025);

		this.type = LevelType.PUZZLE;
		this.name = "No Name";
		
		// TODO Please modify the board creation in the future
		this.board = new Board();
		
		this.pointThresholds = new PointThresholds();
		this.moveCount = 40;
		this.timer = null;
		this.levelNumber = 0;
	}

	/**
	 * Returns the type of level.
	 * 
	 * @return LevelType type
	 */
	public LevelType getType() {
		return type;
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
	 * @return name String name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name the level.
	 * 
	 * @param name
	 *            The name of the level.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the board in the level.
	 * 
	 * @return board Board level board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Sets the board in the level to the given board.
	 * 
	 * @param board
	 *            The board to set for the level.
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Returns the point threshold values for the level.
	 * 
	 * @return pointThresholds PointThreshold values
	 */
	public PointThresholds getPointThresholds() {
		return pointThresholds;
	}

	/**
	 * Sets the point threshold values for the level.
	 * 
	 * @param pointThresholds
	 *            The point thresholds to set for the level.
	 */
	public void setPointThresholds(PointThresholds pointThresholds) {
		this.pointThresholds = pointThresholds;
	}

	/**
	 * Returns the number of moves for the level.
	 * 
	 * @return moveCount Integer number of moves
	 */
	public int getMoveCount() {
		return moveCount;
	}

	/**
	 * Sets the number of moves for the level.
	 * 
	 * @param moveCount
	 *            The number of moves to set for the level.
	 */
	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}

	/**
	 * Returns the timer for the level.
	 * 
	 * @return timer Timer for level
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * Sets the timer for the level.
	 * 
	 * @param timer
	 *            The timer to set for the level.
	 */
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	/**
	 * Sets the SpecialMoves
	 * 
	 * @param newSpecialMoves
	 */
	public void setSpecialMoves(SpecialMoves newSpecialMoves){
		this.specialMoves = newSpecialMoves;
	}
	
	/**
	 * Returns the Levels Special Moves
	 * 
	 * @return this.specialMoves
	 */
	public SpecialMoves getSpecialMoves(){
		return this.specialMoves;
	}
	
	/**
	 * Returns the LevelNumber
	 * 
	 * @return this.levelNumber;
	 */
	public int getLevelNumber(){
		return this.levelNumber;
	}
	
	public void setLevelNumber(int newNumber){
		this.levelNumber = newNumber;
	}
}
