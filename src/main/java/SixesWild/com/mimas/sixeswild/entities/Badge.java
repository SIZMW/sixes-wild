package SixesWild.com.mimas.sixeswild.entities;
/**
 * 
 * @author Marco Duran
 * This class will display all of the information for the badges
 *
 */
public class Badge {
	String name;
	String description;
	boolean isUnlocked;
	
	public Badge(String name, String description, boolean isUnlocked){
		this.name = name;
		this.description = description;
		this.isUnlocked = isUnlocked;
	}
	/** Makes the badge unlocked */
	public void unlock(){
		this.isUnlocked = true;
	}
	
	/** Makes the badge locked */
	public void lock(){
		this.isUnlocked = false;
	}
	
	/**Receives the description of the badge */
	public String getDescription(){
		return this.description;
	}
	
	/**Receives the name of the badge */
	public String getName(){
		return this.name;
	}
	
	/**Gives a check to see if the badge is able to be unlocked */
	//TODO criteria for unlock is needed
	public boolean unlockNow(){
		boolean unlocked = false;
		if(this.isUnlocked == true){
			unlocked = true;
			return unlocked;
		}
		else{
			return unlocked;
		}
	}
	
	
}
