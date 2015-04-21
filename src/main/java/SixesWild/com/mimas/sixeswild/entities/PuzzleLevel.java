package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

/**
 * @author Cameron
 *
 */
public class PuzzleLevel extends Level{
	
	/**
	 * @param tileFreq
	 * @param multFreq
	 * @param type
	 * @param name
	 * @param tiles
	 * @param pointThresholds
	 * @param moveCount
	 */
	public PuzzleLevel(ArrayList<Double> tileFreq, ArrayList<Double> multFreq,
			LevelType type, String name, Tile tiles[][],
			PointThresholds pointThresholds, int moveCount) {
		super();
		this.type = type;
		this.name = name;
		this.pointThresholds = pointThresholds;
		this.moveCount = moveCount;
		this.timer = null;
		
		try {
			this.board = new Board(tiles, tileFreq, multFreq);
		} catch (Exception e) {
			
		}
	}
}
