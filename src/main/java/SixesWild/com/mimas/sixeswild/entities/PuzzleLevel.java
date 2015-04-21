package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

/**
 * @author Cameron
 *
 */
public class PuzzleLevel extends Level {
	LevelType type;
	ArrayList<Double> tileFreq;
	ArrayList<Double> multFreq;
	SpecialMoves specialMoves;
	PointThresholds pointThresholds;
	String name;
	Board board;
	int moveCount;
	boolean isUnlocked;
	
	/**
	 * @param tileFreq
	 * @param multFreq
	 * @param name
	 * @param squares
	 * @param pointThresholds
	 * @param moveCount
	 * @param isUnlocked
	 */
	public PuzzleLevel(ArrayList<Double> tileFreq, ArrayList<Double> multFreq,
		String name, ArrayList<Square> squares,
		PointThresholds pointThresholds, int moveCount, boolean isUnlocked) {
		this.tileFreq = tileFreq;
		this.multFreq = multFreq;
		this.type = LevelType.PUZZLE;
		this.name = name;
		//TODO:Verify this is okay....
		try {
			this.board = new Board(squares, tileFreq, multFreq);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.pointThresholds = pointThresholds;
		this.moveCount = moveCount;
		this.isUnlocked = isUnlocked;
	}
	
	/**
	 * 
	 */
	public PuzzleLevel() {
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
		this.name = "No Name: Puzzle Constructor - Empty";
		this.board = new Board();
		this.pointThresholds = new PointThresholds();
		this.moveCount = 40;
		this.isUnlocked = true;
	}
	
	/**
	 * @param squares
	 */
	public PuzzleLevel(ArrayList<Square> squares) {
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
		this.name = "No Name: Puzzle Constructor - Squares";
		this.board = new Board();
		this.pointThresholds = new PointThresholds();
		this.moveCount = 40;
		this.isUnlocked = true;
	}

	/* (non-Javadoc)
	 * @see SixesWild.com.mimas.sixeswild.entities.Level#getType()
	 */
	public LevelType getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see SixesWild.com.mimas.sixeswild.entities.Level#getTileFreq()
	 */
	public ArrayList<Double> getTileFreq() {
		return tileFreq;
	}

	/* (non-Javadoc)
	 * @see SixesWild.com.mimas.sixeswild.entities.Level#setTileFreq(java.util.ArrayList)
	 */
	public void setTileFreq(ArrayList<Double> tileFreq) {
		this.tileFreq = tileFreq;
	}

	/* (non-Javadoc)
	 * @see SixesWild.com.mimas.sixeswild.entities.Level#getMultFreq()
	 */
	public ArrayList<Double> getMultFreq() {
		return multFreq;
	}

	/* (non-Javadoc)
	 * @see SixesWild.com.mimas.sixeswild.entities.Level#setMultFreq(java.util.ArrayList)
	 */
	public void setMultFreq(ArrayList<Double> multFreq) {
		this.multFreq = multFreq;
	}

	/**
	 * @return
	 */
	public SpecialMoves getSpecialMoves() {
		return specialMoves;
	}

	/**
	 * @param specialMoves
	 */
	public void setSpecialMoves(SpecialMoves specialMoves) {
		this.specialMoves = specialMoves;
	}

	/* (non-Javadoc)
	 * @see SixesWild.com.mimas.sixeswild.entities.Level#getPointThresholds()
	 */
	public PointThresholds getPointThresholds() {
		return pointThresholds;
	}

	/* (non-Javadoc)
	 * @see SixesWild.com.mimas.sixeswild.entities.Level#setPointThresholds(SixesWild.com.mimas.sixeswild.entities.PointThresholds)
	 */
	public void setPointThresholds(PointThresholds pointThresholds) {
		this.pointThresholds = pointThresholds;
	}

	/* (non-Javadoc)
	 * @see SixesWild.com.mimas.sixeswild.entities.Level#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see SixesWild.com.mimas.sixeswild.entities.Level#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see SixesWild.com.mimas.sixeswild.entities.Level#getBoard()
	 */
	public Board getBoard() {
		return board;
	}

	/* (non-Javadoc)
	 * @see SixesWild.com.mimas.sixeswild.entities.Level#setBoard(SixesWild.com.mimas.sixeswild.entities.Board)
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/* (non-Javadoc)
	 * @see SixesWild.com.mimas.sixeswild.entities.Level#getMoveCount()
	 */
	public int getMoveCount() {
		return moveCount;
	}

	/* (non-Javadoc)
	 * @see SixesWild.com.mimas.sixeswild.entities.Level#setMoveCount(int)
	 */
	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}

	/* (non-Javadoc)
	 * @see SixesWild.com.mimas.sixeswild.entities.Level#isUnlocked()
	 */
	public boolean isUnlocked() {
		return isUnlocked;
	}

	/* (non-Javadoc)
	 * @see SixesWild.com.mimas.sixeswild.entities.Level#setUnlocked(boolean)
	 */
	public void setUnlocked(boolean isUnlocked) {
		this.isUnlocked = isUnlocked;
	}
}


