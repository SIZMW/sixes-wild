package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

import javax.swing.Timer;

/**
 * This class is used as a representation of the lightning level type. The goal
 * in this level is to score as many points as possible in the given time.
 * 
 * @author Cameron Jones
 */
public class LightningLevel extends Level {

	/**
	 * Creates a LightningLevel instance with the specified tile frequencies,
	 * multiplier frequencies, type, name, tile list, point threshold values and
	 * timer amount.
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
	 * @param timerCount
	 *            The timer amount for the level.
	 * @throws Exception 
	 */
	public LightningLevel(ArrayList<Double> tileFreq,
			ArrayList<Double> multFreq, LevelType type, String name,
			Tile tiles[][], PointThresholds pointThresholds, int timerCount) throws Exception {
		super(tileFreq, multFreq, type, name, tiles, pointThresholds, new Timer(timerCount,null));
	
	}
}
