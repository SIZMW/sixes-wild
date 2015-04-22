package SixesWild.com.mimas.sixeswild.entities;
import java.util.ArrayList;

public class UserProfile {

	String userName;
	int highestLevel;
	ArrayList<String> badgesEarned;
	ArrayList<LevelHighScore> levelHighScores;
	String aestheticName;

	/**
	 * Constructor for UserProfile 
	 * 
	 * @param userName A String that is the user's name.
	 */
	public UserProfile(String userName) {
		this.userName = userName;
		this.highestLevel = 1;
		this.badgesEarned = new ArrayList<String>();
		this.levelHighScores = new ArrayList<LevelHighScore>();
		this.aestheticName = "";
	}
	
	/**
	 * Returns the user name of the profile
	 * 
	 * @return A String that is the user's name.
	 */
	public String getUserName(){
		return userName;
	}
	
	/**
	 * Returns the highest level unlocked by the user.
	 * 
	 * @return An int of the highest level unlocked by the user.
	 */
	public int getHighestLevel(){
		return highestLevel;
	}
	
	/**
	 * Returns a list of all the badges earned by the user.
	 * 
	 * @return An ArrayList<String> of the badges earned by the user.
	 */
	public ArrayList<String> getBadgesEarned(){
		return badgesEarned;
	}
	
	/**
	 * Returns a list of all the level high scores/stars achieved by the user.
	 * 
	 * @return An ArrayList<LevelHighScore> of the high scores/stars achieved by the user.
	 */
	public ArrayList<LevelHighScore> getLevelHighScore(){
		return levelHighScores;
	}
	
	/**
	 * Returns the high score of the level given.
	 * 
	 * @param level An int of the level that the high score will be taken from.
	 * @return An int of the high score of the level wanted. Returns -1 if the level was not found in the list.
	 */
	public int getHighScoreOfLevel(int level){
		for(LevelHighScore lhs: levelHighScores){
			if(lhs.getLevel() == level){
				return lhs.getHighScore();
			}
		}
		
		return -1;
	}
	
	/**
	 * Gets the aesthetic that the user uses.
	 * 
	 * @return An aesthetic that is used by the user.
	 */
	public String getAestheticName(){
		return aestheticName;
	}
	
	/**
	 * Gets the level high score object of the specified level.
	 * 
	 * @param level An int that specifies the level wanted.
	 * @return A LevelHighScore that is of the specified level. Returns null if the level could not be found in the list.
	 */
	public LevelHighScore getLevelHighScore(int level){
		for(LevelHighScore lhs: levelHighScores){
			if(lhs.getLevel() == level){
				return lhs;
			}
		}
		
		return null;
	}
	
	/**
	 * Sets the user name to the String given.
	 * 
	 * @param userName The String for the new user name.
	 */
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	/**
	 * Sets the highest level unlocked by the player.
	 * 
	 * @param highestLevel An int of the highest level unlocked by the player.
	 */
	public void setHighestLevel(int highestLevel){
		this.highestLevel = highestLevel;
	}
	
	/**
	 * Sets the badges earned by the user.
	 * 
	 * @param badgesEarned An ArrayList<String> of the badges earned by the user.
	 */
	public void setBadgesEarned(ArrayList<String> badgesEarned){
		this.badgesEarned = badgesEarned;
	}
	
	/**
	 * Adds a level high score to the user profile.
	 * 
	 * @param level	An int of the level.
	 * @param highScore An int of the high score achieved by the user.
	 * @param stars An int of the number of stars achieved by the user equivalent to the high score.
	 */
	public void addLevelHighScore(int level, int highScore, int stars){
		this.levelHighScores.add(new LevelHighScore(level, highScore, stars));
	}
	
	public void removeLevelHighScore(int level){
		for(LevelHighScore lhs: levelHighScores){
			if(lhs.getLevel() == level){
				levelHighScores.remove(lhs);
			}
		}
	}
	
	/**
	 * Add a badge earned by the user.
	 * 
	 * @param badge A String of the badge earned by the user.
	 */
	public void addBadgeEarned(String badge){
		badgesEarned.add(badge);
	}
	
	/**
	 * Removes a badge earned by the user.
	 * 
	 * @param badge A String of the badge that is going to be removed from the user's earned list.
	 */
	public void removeBadgeEarned(String badge){
		for(String str: badgesEarned){
			if(str.equals(badge)){
				badgesEarned.remove(str);
			}
		}
	}
	
	/**
	 * Sets the aesthetic of the user's profile.
	 * 
	 * @param aesthetic An Aesthetic that will be set in the user's profile.
	 */
	public void setAestheticName(String aestheticName){
		this.aestheticName = aestheticName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * Converts the user's profile into a string for outputting.
	 */
	public String toString(){
		String str = "";
		str += "User Name: " + userName + "\n";
		str += "	Highest Level: " + highestLevel + "\n";
		str += "	Badges Earned:\n";
		for(String badge: badgesEarned){
			str += "		" + badge + "\n";
		}
		str += "	Level High Scores:\n";
		for(LevelHighScore lhs: levelHighScores){
			str += "		Level: " + lhs.getLevel() + "\n";
			str += "		  High Score: " + lhs.getHighScore() + "\n";
			str += "		  Stars: " + lhs.getStars() + "\n";
		}
		
		str += "	Aesthetic: " + aestheticName;
		
		return str;
	}
}
