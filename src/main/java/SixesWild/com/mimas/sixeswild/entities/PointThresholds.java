package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;
import java.util.Collections;

public class PointThresholds {

	ArrayList<Integer> thresholds = new ArrayList<Integer>();

	/**
	 * Constructor for PointThreshold class.
	 */
	public PointThresholds() {
		this.thresholds.add(0);
		this.thresholds.add(0);
		this.thresholds.add(0);
	}

	/**
	 * Constructor for PointThreshold class.
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
	 * Sets the star thresholds.
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
	 * @return this.thresholds.get(0) The one star threshold.
	 */
	public int getOneStarThreshold() {
		return this.thresholds.get(0);
	}

	/**
	 * Returns the two star threshold.
	 * 
	 * @return this.thresholds.get(1) The two star threshold.
	 */
	public int getTwoStarThreshold() {
		return this.thresholds.get(1);
	}

	/**
	 * Returns the three star threshold.
	 * 
	 * @return this.thresholds.get(2) The three star threshold.
	 */
	public int getThreeStarThreshold() {
		return this.thresholds.get(2);
	}

}
