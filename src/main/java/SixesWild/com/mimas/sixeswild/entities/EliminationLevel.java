package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

public class EliminationLevel extends Level {
	LevelType type;
	ArrayList<Double> tileFreq;
	ArrayList<Double> multFreq;
	SpecialMoves specialMoves;
	PointThresholds pointThresholds;
	String name;
	Board board;
	int moveCount;
	boolean isUnlocked;
	
	public EliminationLevel(ArrayList<Double> tileFreq, ArrayList<Double> multFreq,
		String name, ArrayList<Square> squares,
		PointThresholds pointThresholds, int moveCount, boolean isUnlocked) {
		this.tileFreq = tileFreq;
		this.multFreq = multFreq;
		this.type = LevelType.ELIMINATION;
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
	
	public EliminationLevel() {
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
		this.type = LevelType.ELIMINATION;
		this.name = "No Name: Elimination Constructor - Empty";
		this.board = new Board();
		this.pointThresholds = new PointThresholds();
		this.moveCount = 40;
		this.isUnlocked = true;
	}
	
	public EliminationLevel(ArrayList<Square> squares) {
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
		this.type = LevelType.ELIMINATION;
		this.name = "No Name: Elimination Constructor - Squares";
		this.board = new Board();
		this.pointThresholds = new PointThresholds();
		this.moveCount = 40;
		this.isUnlocked = true;
	}

	public LevelType getType() {
		return type;
	}

	public void setType(LevelType type) {
		this.type = type;
	}

	public ArrayList<Double> getTileFreq() {
		return tileFreq;
	}

	public void setTileFreq(ArrayList<Double> tileFreq) {
		this.tileFreq = tileFreq;
	}

	public ArrayList<Double> getMultFreq() {
		return multFreq;
	}

	public void setMultFreq(ArrayList<Double> multFreq) {
		this.multFreq = multFreq;
	}

	public SpecialMoves getSpecialMoves() {
		return specialMoves;
	}

	public void setSpecialMoves(SpecialMoves specialMoves) {
		this.specialMoves = specialMoves;
	}

	public PointThresholds getPointThresholds() {
		return pointThresholds;
	}

	public void setPointThresholds(PointThresholds pointThresholds) {
		this.pointThresholds = pointThresholds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getMoveCount() {
		return moveCount;
	}

	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}

	public boolean isUnlocked() {
		return isUnlocked;
	}

	public void setUnlocked(boolean isUnlocked) {
		this.isUnlocked = isUnlocked;
	}
}

