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
	protected int highestStoryLevelUnlocked;
	protected int highestUserLevelUnlocked;
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
		highestStoryLevelUnlocked = 1;
		highestUserLevelUnlocked = 1;
		badgesEarned = new ArrayList<String>();
		levelHighScores = new ArrayList<LevelHighScore>();
		aestheticName = "";
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
	 * Returns the highest story level unlocked by the user.
	 *
	 * @return an integer
	 */
	public int getHighestStoryLevelUnlocked() {
		return highestStoryLevelUnlocked;
	}

	/**
	 * Returns the highest user level unlocked by the user.
	 *
	 * @return an integer
	 */
	public int getHighestUserLevelUnlocked() {
		return highestUserLevelUnlocked;
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
	 * @return an integer of the score if exists; 0 otherwise
	 */
	public int getHighScoreOfLevel(int level) {
		for (LevelHighScore lhs : levelHighScores) {
			if (lhs.getLevel() == level) {
				return lhs.getHighScore();
			}
		}

		return 0;
	}

	/**
	 * Returns the stars equivalent of a high score for the given level.
	 *
	 * @param level
	 *            The level number that the stars will be taken from.
	 * @param type
	 *            The type of level to get the stars achieved.
	 * @return an integer of the star count if exists; 0 otherwise
	 */
	public int getStarsOfLevel(int level, MenuTypes type) {
		for (LevelHighScore lhs : levelHighScores) {
			if (lhs.getLevel() == level && lhs.getLevelType().equals(type)) {
				return lhs.getStars();
			}
		}

		return 0;
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
	 * Sets the highest story level unlocked by the player.
	 *
	 * @param highestLevel
	 *            An integer of the highest story level unlocked by the player.
	 */
	public void setHighestStoryLevel(int highestLevel) {
		highestStoryLevelUnlocked = highestLevel;
	}

	/**
	 * Sets the highest user level unlocked by the player.
	 *
	 * @param highestLevel
	 *            An integer of the highest user level unlocked by the player.
	 */
	public void setHighestUserLevel(int highestLevel) {
		highestUserLevelUnlocked = highestLevel;
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
	 * Adds a level high score to the user profile if the level does not exist
	 * in the list. Otherwise it updates the previous score if the new one is
	 * higher.
	 *
	 * @param level
	 *            An integer of the level.
	 * @param highScore
	 *            An integer of the high score achieved by the user.
	 * @param stars
	 *            An integer of the number of stars achieved by the user
	 *            equivalent to the high score.
	 * @param type
	 *            The type of level to distinguish the level number.
	 */
	public void addLevelHighScore(int level, int highScore, int stars,
			MenuTypes type) {
		for (LevelHighScore e : levelHighScores) {
			if (e.getLevel() == level && e.getLevelType().equals(type)) {
				if (e.getHighScore() < highScore) {
					levelHighScores.remove(e);
					levelHighScores.add(new LevelHighScore(level, highScore,
							stars, type));
					return;
				} else {
					return;
				}
			}
		}

		levelHighScores.add(new LevelHighScore(level, highScore, stars, type));
	}

	/**
	 * Removes the high score for the specified level.
	 *
	 * @param level
	 *            The level number of the level.
	 * @param type
	 *            The type of level to distinguish the level number.
	 */
	public void removeLevelHighScore(int level, MenuTypes type) {
		for (LevelHighScore lhs : levelHighScores) {
			if (lhs.getLevel() == level && lhs.getLevelType().equals(type)) {
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
}
