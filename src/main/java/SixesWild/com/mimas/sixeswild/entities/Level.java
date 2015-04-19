package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

import javax.swing.Timer;

/**
 * @author Cameron
 *
 */
public class Level {
	ArrayList<Double> tileFreq;
	ArrayList<Double> multFreq;
	LevelType type;
	String name;
	Board board;
	//SpecialMoveConstraints specialMoveConstraints;
	PointThresholds pointThresholds;
	int moveCount;
	Timer timer;
	boolean isUnlocked;

	/**
	 * @param tileFreq
	 * @param multFreq
	 * @param type
	 * @param name
	 * @param squares
	 * @param pointThresholds
	 * @param moveCount
	 * @param isUnlocked
	 */
	public Level(ArrayList<Double> tileFreq, ArrayList<Double> multFreq, LevelType type, String name, ArrayList<Square> squares, PointThresholds pointThresholds, int moveCount, boolean isUnlocked){
		this.tileFreq = tileFreq;
		this.multFreq = multFreq;
		this.type = type;
		this.name = name;
		//this.board = new Board(squares, tileFreq, multFreq);
		this.pointThresholds = pointThresholds;
		this.moveCount = moveCount;
		this.isUnlocked = isUnlocked;
	}

	/**
	 * @param tileFreq
	 * @param multFreq
	 * @param type
	 * @param name
	 * @param squares
	 * @param pointThresholds
	 * @param timer
	 * @param isUnlocked
	 */
	public Level(ArrayList<Double> tileFreq, ArrayList<Double> multFreq, LevelType type, String name, ArrayList<Square> squares, PointThresholds pointThresholds, Timer timer, boolean isUnlocked){
		this.tileFreq = tileFreq;
		this.multFreq = multFreq;
		this.type = type;
		this.name = name;
		//this.board = new Board(squares, tileFreq, multFreq);
		this.pointThresholds = pointThresholds;
		this.timer = timer;
		this.isUnlocked = isUnlocked;
	}

	/**
	 * @param squares
	 * @param type
	 */
	public Level(ArrayList<Square> squares, String type){
		this.tileFreq = new ArrayList<Double>();
		this.tileFreq.add(.10);
		this.tileFreq.add(.20);
		this.tileFreq.add(.30);
		this.tileFreq.add(.30);
		this.tileFreq.add(.05);
		this.tileFreq.add(.05);
		this.multFreq.add(.95);
		this.multFreq.add(.025);
		this.multFreq.add(.025);
		this.type = LevelType.PUZZLE;
		this.name = "No Name";
		this.board = new Board();
		this.pointThresholds = new PointThresholds();
		this.moveCount = 40;
		this.isUnlocked = true;
	}

	/**
	 *
	 */
	public Level(){
		this.tileFreq = new ArrayList<Double>();
		this.multFreq = new ArrayList<Double>();
		this.tileFreq.add(.10);
		this.tileFreq.add(.20);
		this.tileFreq.add(.30);
		this.tileFreq.add(.30);
		this.tileFreq.add(.05);
		this.tileFreq.add(.05);
		this.multFreq.add(.95);
		this.multFreq.add(.025);
		this.multFreq.add(.025);
		this.type = LevelType.PUZZLE;
		this.name = "No Name";
		this.board = new Board();
		this.pointThresholds = new PointThresholds();
		this.moveCount = 40;
		this.isUnlocked = true;
	}

	/**
	 * @return tileFreq
	 */
	public ArrayList<Double> getTileFreq() {
		return tileFreq;
	}

	/**
	 * @param tileFreq
	 */
	public void setTileFreq(ArrayList<Double> tileFreq) {
		this.tileFreq = tileFreq;
	}

	/**
	 * @return multFreq
	 */
	public ArrayList<Double> getMultFreq() {
		return multFreq;
	}

	/**
	 * @param multFreq
	 */
	public void setMultFreq(ArrayList<Double> multFreq) {
		this.multFreq = multFreq;
	}

	/**
	 * @return type
	 */
	public LevelType getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(LevelType type) {
		this.type = type;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
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

	/**
	 * @return isUnlocked
	 */
	public boolean isUnlocked() {
		return isUnlocked;
	}

	/**
	 * @param isUnlocked
	 */
	public void setUnlocked(boolean isUnlocked) {
		this.isUnlocked = isUnlocked;
	}
}
