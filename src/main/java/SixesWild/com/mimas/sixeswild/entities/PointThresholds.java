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
		thresholds.add(0);
		thresholds.add(0);
		thresholds.add(0);
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
		thresholds.add(oneStarThreshold);
		thresholds.add(twoStarThreshold);
		thresholds.add(threeStarThreshold);

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
		thresholds.set(0, oneStarThreshold);
		thresholds.set(1, twoStarThreshold);
		thresholds.set(2, threeStarThreshold);

		Collections.sort(thresholds);
	}

	/**
	 * Returns the one star threshold.
	 *
	 * @return an integer
	 */
	public int getOneStarThreshold() {
		return thresholds.get(0);
	}

	/**
	 * Returns the two star threshold.
	 *
	 * @return an integer
	 */
	public int getTwoStarThreshold() {
		return thresholds.get(1);
	}

	/**
	 * Returns the three star threshold.
	 *
	 * @return an integer
	 */
	public int getThreeStarThreshold() {
		return thresholds.get(2);
	}

	/**
	 * Returns the number of stars to award for the specified score.
	 *
	 * @param score
	 *            The score to convert to stars.
	 * @return an integer
	 */
	public int getStarsForScore(int score) {
		if (score > thresholds.get(2)) {
			return 3;
		} else if (score > thresholds.get(1)) {
			return 2;
		} else if (score > thresholds.get(0)) {
			return 1;
		}
		return 0;
	}
}
