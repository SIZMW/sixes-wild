package SixesWild.com.mimas.sixeswild.entities;

/**
 * Badge contains the information about each badge, such as its name,
 * description, unlock status and requirements for unlocking.
 *
 * @author Marco Duran
 */
public abstract class Badge {

	protected String name;
	protected String description;
	protected BadgeType type;

	/**
	 * Creates a Badge instance with the specified name, description and
	 * unlocked status.
	 *
	 * @param name
	 *            The name of the badge.
	 * @param description
	 *            The description of the badge.
	 */
	public Badge(String name, String description) {
		this.name = name;
		this.description = description;
		type = BadgeType.UNLOCK;
	}

	/**
	 * Returns the description of the badge.
	 *
	 * @return a String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the name of the badge.
	 *
	 * @return a String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the type of the badge.
	 *
	 * @return a BadgeType
	 */
	public BadgeType getType() {
		return type;
	}

	/**
	 * Determines if this badge can be unlocked.
	 *
	 * @param value
	 *            The value required to determine if this badge is unlocked.
	 * @return true if the badge can be unlocked; false otherwise
	 */
	public abstract boolean unlock(int value);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}
}
