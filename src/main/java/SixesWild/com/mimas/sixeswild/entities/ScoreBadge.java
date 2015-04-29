package SixesWild.com.mimas.sixeswild.entities;

/**
 * ScoreBadge represents a badge that is unlocked when a specified score has
 * been achieved during gameplay.
 *
 * @author Marco Duran
 */
public class ScoreBadge extends Badge {

	protected int requiredScore;

	/**
	 * Creates a ScoreBadge instance with the specified name, description and
	 * required score.
	 *
	 * @param name
	 *            The name of the badge.
	 * @param description
	 *            The description of the badge.
	 * @param score
	 *            The score that must be achieved to unlock this badge.
	 */
	public ScoreBadge(String name, String description, int score) {
		super(name, description);
		requiredScore = score;
		type = BadgeType.SCORE;
	}

	/**
	 * Determines if this badge can be unlocked with the specified score.
	 *
	 * @param score
	 *            The score to verify against the badge requirements.
	 * @return true if badge can be unlocked; false otherwise
	 */
	@Override
	public boolean unlock(int score) {
		return (score >= requiredScore);
	}
}
