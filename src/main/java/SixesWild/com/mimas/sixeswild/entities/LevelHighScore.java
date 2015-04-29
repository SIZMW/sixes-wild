package SixesWild.com.mimas.sixeswild.entities;

/**
 * LevelHighScore defines a high score attribute of the user profile that stores
 * a user's highest score for a specific level.
 *
 * @author Yahel Nachum
 */
public class LevelHighScore {

	protected int level;
	protected int highScore;
	protected int stars;
	protected MenuTypes type;

	/**
	 * Creates a LevelHighScore instance with the specified level, high score
	 * and star count.
	 *
	 * @param level
	 *            The level number for this score.
	 * @param highScore
	 *            The score for this score.
	 * @param stars
	 *            The number of stars received for this score.
	 * @param type
	 *            The type of level to distinguish the level number.
	 */
	public LevelHighScore(int level, int highScore, int stars, MenuTypes type) {
		this.level = level;
		this.highScore = highScore;
		this.stars = stars;
		this.type = type;
	}

	/**
	 * Returns the level number.
	 *
	 * @return the integer level number for this score.
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Returns the high score for this score.
	 *
	 * @return the integer high score for this score.
	 */
	public int getHighScore() {
		return highScore;
	}

	/**
	 * Returns the star count for this score.
	 *
	 * @return the integer star count.
	 */
	public int getStars() {
		return stars;
	}

	/**
	 * Returns the level type for the level number for this score.
	 *
	 * @return a MenuTypes
	 */
	public MenuTypes getLevelType() {
		return type;
	}
}
