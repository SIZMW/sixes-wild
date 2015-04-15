package SixesWild.com.mimas.sixeswild.entities;

public class PointThresholds {

	int oneStarThreshold;
	int twoStarThreshold;
	int threeStarThreshold;

	/**
	 * Constructor for PointThreshold class.
	 */
	public PointThresholds() {
		this.oneStarThreshold = 0;
		this.twoStarThreshold = 0;
		this.threeStarThreshold = 0;
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
		setOneStarThreshold(oneStarThreshold);
		setTwoStarThreshold(twoStarThreshold);
		setThreeStarThreshold(threeStarThreshold);
	}

	/**
	 * Sets the one star threshold.
	 * 
	 * @param oneStarThreshold
	 *            The one star threshold.
	 */
	public void setOneStarThreshold(int oneStarThreshold) {
		this.oneStarThreshold = oneStarThreshold;
	}

	/**
	 * Sets the two star threshold.
	 * 
	 * @param twoStarThreshold
	 *            The two star threshold.
	 */
	public void setTwoStarThreshold(int twoStarThreshold) {
		this.twoStarThreshold = twoStarThreshold;
	}

	/**
	 * Sets the three star threshold.
	 * 
	 * @param threeStarThreshold
	 *            The three star threshold.
	 */
	public void setThreeStarThreshold(int threeStarThreshold) {
		this.threeStarThreshold = threeStarThreshold;
	}

	/**
	 * Returns the one star threshold.
	 * 
	 * @return this.oneStarThreshold The one star threshold.
	 */
	public int getOneStarThreshold() {
		return this.oneStarThreshold;
	}

	/**
	 * Returns the two star threshold.
	 * 
	 * @return this.twoStarThreshold The two star threshold.
	 */
	public int getTwoStarThreshold() {
		return this.twoStarThreshold;
	}

	/**
	 * Returns the three star threshold.
	 * 
	 * @return this.threeStarThreshold The three star threshold.
	 */
	public int getThreeStarThreshold() {
		return this.threeStarThreshold;
	}

}
