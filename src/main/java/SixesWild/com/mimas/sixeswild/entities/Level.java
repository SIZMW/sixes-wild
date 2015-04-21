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
	/**
	 * Constructor for Level class.
	 * 
	 * @param tileFreq
	 * @param multFreq
	 * @param type
	 * @param name
	 * @param squares
	 * @param pointThresholds
	 * @param moveCount
	 * @param isUnlocked
	 */
	public Level(ArrayList<Double> tileFreq, ArrayList<Double> multFreq,
				LevelType type, String name, Tile tiles[][],
				PointThresholds pointThresholds, int moveCount) {
		this.type = type;
		this.name = name;
		try {
			this.board = new Board(tiles, tileFreq, multFreq);
		} catch (Exception e) {
			
		}
		
		this.pointThresholds = pointThresholds;
		this.moveCount = moveCount;
		this.timer = null;
	}

	/**
	 * Constructor for Level class.
	 * 
	 * @param tileFreq
	 * @param multFreq
	 * @param type
	 * @param name
	 * @param squares
	 * @param pointThresholds
	 * @param timer
	 * @param isUnlocked
	 */
	public Level(ArrayList<Double> tileFreq, ArrayList<Double> multFreq,
			LevelType type, String name, Tile squares[][],
			PointThresholds pointThresholds, Timer timer) {
		
		this.type = type;
		this.name = name;
		try {
			this.board = new Board(squares, tileFreq, multFreq);
		} catch (Exception e) {

		}
		
		this.pointThresholds = pointThresholds;
		this.timer = timer;
		this.moveCount = 0;
	}

	/**
	 * Default constructor for Level class.
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
		this.board = new Board();
		this.pointThresholds = new PointThresholds();
		this.moveCount = 40;
		this.timer = null;
	}

	/**
	 * Returns the LevelType
	 * @return type
	 */
	public LevelType getType() {
		return type;
	}

	/**
	 * Set the LevelType
	 * @param type
	 */
	public void setType(LevelType type) {
		this.type = type;
	}

	/**
	 * Return the Name of the Level
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the Name the Level
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * @param board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * @return pointThresholds
	 */
	public PointThresholds getPointThresholds() {
		return pointThresholds;
	}

	/**
	 * @param pointThresholds
	 */
	public void setPointThresholds(PointThresholds pointThresholds) {
		this.pointThresholds = pointThresholds;
	}

	/**
	 * @return moveCount
	 */
	public int getMoveCount() {
		return moveCount;
	}

	/**
	 * @param moveCount
	 */
	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}

	/**
	 * @return timer
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * @param timer
	 */
	public void setTimer(Timer timer) {
		this.timer = timer;
	}

}
