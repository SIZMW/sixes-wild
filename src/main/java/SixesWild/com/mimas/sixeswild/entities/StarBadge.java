package SixesWild.com.mimas.sixeswild.entities;

/**
 * StarBadge represents the badge that can be unlocked after a certain number of
 * stars have been achieved.
 *
 * @author Marco Duran
 */
public class StarBadge extends Badge {

	protected int requiredStars;

	/**
	 * Creates a StarBadge instance with the specified name, description and
	 * star count.
	 *
	 * @param name
	 *            The name of the badge.
	 * @param description
	 *            The description of the badge.
	 * @param stars
	 *            The number of stars required to unlock the badge.
	 */
	public StarBadge(String name, String description, int stars) {
		super(name, description);
		requiredStars = stars;
		type = BadgeType.STAR;
	}

	/**
	 * Determines if this badge can be unlocked with the specified star count.
	 *
	 * @param stars
	 *            The star count to verify against the badge requirements.
	 * @return true if badge can be unlocked; false otherwise
	 */
	@Override
	public boolean unlock(int stars) {
		return (stars >= requiredStars);
	}
}
