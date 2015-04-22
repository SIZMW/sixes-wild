package SixesWild.com.mimas.sixeswild.entities;

public class LevelHighScore {
	
	int level;
	int highScore;
	int stars;
	
	public LevelHighScore(int level, int highScore, int stars){
		this.level = level;
		this.highScore = highScore;
		this.stars = stars;
	}
	
	public int getLevel(){
		return level;
	}
	
	public int getHighScore(){
		return highScore;
	}
	
	public int getStars(){
		return stars;
	}
}
