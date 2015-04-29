package SixesWild.com.mimas.sixeswild.entities;

/**
 * Checks to see if the score for the level has reached the criteria of the
 * badge.
 *
 * @author Marco Duran
 */
public class ScoreBadge extends Badge {
	int criteriaScore;

	/**
	 * Constructor for a score badge.
	 *
	 * @param name
	 *            Name of badge
	 * @param description
	 *            Description of badge
	 * @param isUnlocked
	 *            Verify if badge is unlocked
	 * @param criteriaScore
	 *            Score to be fulfilled
	 */
	public ScoreBadge(String name, String description, boolean isUnlocked,
			int criteriaScore) {
		super(name, description, isUnlocked);
		this.criteriaScore = criteriaScore;
	}

	/**
	 * Unlocks the badge.
	 *
	 * @param score
	 *            Score of the current game, is compared to criteria score.
	 */
	public void unlock(int score) {
		if (score > criteriaScore) {
			isUnlocked = true;
		} else {
			isUnlocked = false;
		}
	}
}
