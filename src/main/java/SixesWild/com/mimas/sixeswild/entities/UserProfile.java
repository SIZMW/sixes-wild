package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

/**
 * User Profile is used to store all the information about the current player of
 * the game.
 * 
 * @author Yahel Nachum
 */
public class UserProfile {

	protected String userName;
	protected int highestUnlockedLevel;
	protected ArrayList<String> badgesEarned;
	protected ArrayList<LevelHighScore> levelHighScores;
	protected String aestheticName;

	/**
	 * Creates a UserProfile instance with the specified name.
	 * 
	 * @param userName
	 *            The name of the user.
	 */
	public UserProfile(String userName) {
		this.userName = userName;
		this.highestUnlockedLevel = 1;
		this.badgesEarned = new ArrayList<String>();
		this.levelHighScores = new ArrayList<LevelHighScore>();
		this.aestheticName = "";
	}

	/**
	 * Returns the user name of the profile
	 * 
	 * @return a String
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Returns the highest level unlocked by the user.
	 * 
	 * @return an integer
	 */
	public int getHighestUnlockedLevel() {
		return highestUnlockedLevel;
	}

	/**
	 * Returns a list of all the badges earned by the user.
	 * 
	 * @return the badgesEarned property
	 */
	public ArrayList<String> getBadgesEarned() {
		return badgesEarned;
	}

	/**
	 * Returns whether or not the badge name given is earned by the user.
	 * 
	 * @param badgeName
	 *            A String of the badge name that is being looked for.
	 * @return true if earned; false otherwise
	 */
	public boolean hasBadge(String badgeName) {
		for (String badge : badgesEarned) {
			if (badge.equals(badgeName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns a list of all the level high scores/stars achieved by the user.
	 * 
	 * @return the levelHighScores property
	 */
	public ArrayList<LevelHighScore> getLevelHighScore() {
		return levelHighScores;
	}

	/**
	 * Returns the high score of the level given.
	 * 
	 * @param level
	 *            An Integer of the level that the high score will be taken
	 *            from.
	 * @return an integer of the score if exists; -1 otherwise
	 */
	public int getHighScoreOfLevel(int level) {
		for (LevelHighScore lhs : levelHighScores) {
			if (lhs.getLevel() == level) {
				return lhs.getHighScore();
			}
		}

		return -1;
	}

	/**
	 * Returns the stars equivalent of a high score for the given level.
	 * 
	 * @param level
	 *            An int of the level that the stars will be taken from.
	 * @return an integer of the star count if exists; -1 otherwise
	 */
	public int getStarsOfLevel(int level) {
		for (LevelHighScore lhs : levelHighScores) {
			if (lhs.getLevel() == level) {
				return lhs.getStars();
			}
		}

		return -1;
	}

	/**
	 * Gets the name of the aesthetic that the user uses.
	 * 
	 * @return a String
	 */
	public String getAestheticName() {
		return aestheticName;
	}

	/**
	 * Gets the level high score object of the specified level.
	 * 
	 * @param level
	 *            An Integer that specifies the level wanted.
	 * @return a LevelHighScore for the level if exists; null otherwise
	 */
	public LevelHighScore getLevelHighScore(int level) {
		for (LevelHighScore lhs : levelHighScores) {
			if (lhs.getLevel() == level) {
				return lhs;
			}
		}

		return null;
	}

	/**
	 * Sets the user name to the String given.
	 * 
	 * @param userName
	 *            The String for the new user name.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Sets the highest level unlocked by the player.
	 * 
	 * @param highestLevel
	 *            An integer of the highest level unlocked by the player.
	 */
	public void setHighestLevel(int highestLevel) {
		this.highestUnlockedLevel = highestLevel;
	}

	/**
	 * Sets the badges earned by the user.
	 * 
	 * @param badgesEarned
	 *            The list of badge names that the user has earned.
	 */
	public void setBadgesEarned(ArrayList<String> badgesEarned) {
		this.badgesEarned = badgesEarned;
	}

	/**
	 * Adds a level high score to the user profile.
	 * 
	 * @param level
	 *            An integer of the level.
	 * @param highScore
	 *            An integer of the high score achieved by the user.
	 * @param stars
	 *            An integer of the number of stars achieved by the user
	 *            equivalent to the high score.
	 */
	public void addLevelHighScore(int level, int highScore, int stars) {
		this.levelHighScores.add(new LevelHighScore(level, highScore, stars));
	}

	/**
	 * Removes the high score for the specified level.
	 * 
	 * @param level
	 *            The level number of the level.
	 */
	public void removeLevelHighScore(int level) {
		for (LevelHighScore lhs : levelHighScores) {
			if (lhs.getLevel() == level) {
				levelHighScores.remove(lhs);
			}
		}
	}

	/**
	 * Add a badge earned by the user.
	 * 
	 * @param badge
	 *            The name of the badge earned by the user.
	 */
	public void addBadgeEarned(String badge) {
		badgesEarned.add(badge);
	}

	/**
	 * Removes a badge earned by the user.
	 * 
	 * @param badge
	 *            The name of the badge to be removed from the user's earned
	 *            list.
	 */
	public void removeBadgeEarned(String badge) {
		for (String str : badgesEarned) {
			if (str.equals(badge)) {
				badgesEarned.remove(str);
			}
		}
	}

	/**
	 * Sets the aesthetic of the user's profile.
	 * 
	 * @param aestheticName
	 *            The name of the aesthetic to set for the user profile.
	 */
	public void setAestheticName(String aestheticName) {
		this.aestheticName = aestheticName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User Name: ");
		builder.append(userName);
		builder.append("\n");
		builder.append("	Highest Level: ");
		builder.append(highestUnlockedLevel);
		builder.append("\n");
		builder.append("	Badges Earned:\n");

		for (String badge : badgesEarned) {
			builder.append("		");
			builder.append(badge);
			builder.append("\n");
		}

		builder.append("	Level High Scores:\n");

		for (LevelHighScore lhs : levelHighScores) {
			builder.append("		Level: ");
			builder.append(lhs.getLevel());
			builder.append("\n");

			builder.append("		  High Score: ");
			builder.append(lhs.getHighScore());
			builder.append("\n");

			builder.append("		  Stars: ");
			builder.append(lhs.getStars());
			builder.append("\n");
		}

		builder.append("	Aesthetic: ");
		builder.append(aestheticName);

		return builder.toString();
	}
}
