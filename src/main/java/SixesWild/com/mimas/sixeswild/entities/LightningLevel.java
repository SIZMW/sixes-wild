package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

import javax.swing.Timer;

/**
 * @author Cameron
 *
 */
public class LightningLevel extends Level{
	
	/**
	 * @param tileFreq
	 * @param multFreq
	 * @param type
	 * @param name
	 * @param tiles
	 * @param pointThresholds
	 * @param moveCount
	 */
	public LightningLevel(ArrayList<Double> tileFreq, ArrayList<Double> multFreq,
			LevelType type, String name, Tile tiles[][],
			PointThresholds pointThresholds, int timerCount) {
		super();
		this.type = type;
		this.name = name;
		this.pointThresholds = pointThresholds;
		this.moveCount = 0;
		this.timer = new Timer(timerCount,null); //TODO: Fix this Magic
		
		try {
			this.board = new Board(tiles, tileFreq, multFreq);
		} catch (Exception e) {
			
		}
	}
}
