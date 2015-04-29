package SixesWild.com.mimas.sixeswild.entities;

public class UnlockBadge extends Badge {

	protected int highestLevel;

	/**
	 * Creates an UnlockedBadge instance with the specified name and
	 * description.
	 *
	 * @param name
	 *            The name of the badge.
	 * @param description
	 *            The description of the badge.
	 */
	public UnlockBadge(String name, String description, int level) {
		super(name, description);
		highestLevel = level;
		type = BadgeType.UNLOCK;
	}

	/**
	 * Determines if this badge can be unlocked with the specified highest level
	 * unlocked.
	 *
	 * @param highestLevel
	 *            The highest level unlocked to verify against the badge
	 *            requirements.
	 * @return true if badge can be unlocked; false otherwise
	 */
	@Override
	public boolean unlock(int level) {
		return (level >= highestLevel);
	}
}
