package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

public class ReleaseLevel extends Level {
	LevelType type;
	ArrayList<Double> tileFreq;
	ArrayList<Double> multFreq;
	SpecialMoves specialMoves;
	PointThresholds pointThresholds;
	String name;
	Board board;
	//Timer timer;
	int moveCount;
	boolean isUnlocked;
	
	public ReleaseLevel(){
		this.type = LevelType.PUZZLE;
		this.tileFreq = tileFreq;
		this.multFreq = multFreq;
		this.specialMoves = specialMoves;
		this.pointThresholds = pointThresholds;
		this.name = name;
		this.board = new Board();
		this.moveCount = moveCount;
		this.isUnlocked = false;
	}

}

