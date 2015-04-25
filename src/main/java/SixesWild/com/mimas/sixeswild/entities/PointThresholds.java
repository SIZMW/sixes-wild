package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;
import java.util.Collections;

/**
 * PointThresholds is an aggregation entity that holds all the point thresholds
 * for a Level. It has the one, two and three star point values for a Level.
 * 
 * @author Yahel Nachum
 */
public class PointThresholds {

	protected ArrayList<Integer> thresholds = new ArrayList<Integer>();

	/**
	 * Creates a PointThresholds instance with 0 for all thresholds.
	 */
	public PointThresholds() {
		this.thresholds.add(0);
		this.thresholds.add(0);
		this.thresholds.add(0);
	}

	/**
	 * Creates a PointThresholds instance with the specified threshold values.
	 * 
	 * @param oneStarThreshold
	 *            The one star threshold integer.
	 * @param twoStarThreshold
	 *            The two star threshold integer.
	 * @param threeStarThreshold
	 *            The three star threshold integer.
	 */
	public PointThresholds(int oneStarThreshold, int twoStarThreshold,
			int threeStarThreshold) {
		this.thresholds.add(oneStarThreshold);
		this.thresholds.add(twoStarThreshold);
		this.thresholds.add(threeStarThreshold);

		Collections.sort(thresholds);
	}

	/**
	 * Sets the point thresholds to the specified values.
	 * 
	 * @param oneStarThreshold
	 *            The one star threshold.
	 * @param twoStarThreshold
	 *            The two star threshold.
	 * @param threeStarThreshold
	 *            The three star threshold.
	 */
	public void setStarThresholds(int oneStarThreshold, int twoStarThreshold,
			int threeStarThreshold) {
		this.thresholds.set(0, oneStarThreshold);
		this.thresholds.set(1, twoStarThreshold);
		this.thresholds.set(2, threeStarThreshold);

		Collections.sort(thresholds);
	}

	/**
	 * Returns the one star threshold.
	 * 
	 * @return an integer
	 */
	public int getOneStarThreshold() {
		return this.thresholds.get(0);
	}

	/**
	 * Returns the two star threshold.
	 * 
	 * @return an integer
	 */
	public int getTwoStarThreshold() {
		return this.thresholds.get(1);
	}

	/**
	 * Returns the three star threshold.
	 * 
	 * @return an integer
	 */
	public int getThreeStarThreshold() {
		return this.thresholds.get(2);
	}
}
