package SixesWild.com.mimas.sixeswild.entities;

/**
 * Badge contains the information about each badge, such as its name,
 * description, unlock status and requirements for unlocking.
 * 
 * @author Marco Duran
 */
public class Badge {
	String name;
	String description;
	boolean isUnlocked;

	/**
	 * Creates a Badge instance with the specified name, description and
	 * unlocked status.
	 * 
	 * @param name
	 *            The name of the badge.
	 * @param description
	 *            The description of the badge.
	 * @param isUnlocked
	 *            The locked status of the badge.
	 */
	public Badge(String name, String description, boolean isUnlocked) {
		this.name = name;
		this.description = description;
		this.isUnlocked = isUnlocked;
	}

	/**
	 * Unlocks the badge.
	 */
	public void unlock() {
		this.isUnlocked = true;
	}

	/**
	 * Locks the badge.
	 */
	public void lock() {
		this.isUnlocked = false;
	}

	/**
	 * Returns the description of the badge.
	 * 
	 * @return String for description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Returns the name of the badge.
	 * 
	 * @return String for name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Determines if this badge can be unlocked.
	 * 
	 * @return true if can be unlocked; false otherwise.
	 */
	public boolean unlockNow() {
		boolean unlocked = false;
		if (this.isUnlocked == true) {
			unlocked = true;
			return unlocked;
		} else {
			return unlocked;
		}
	}
}
