package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * This test case handles testing the UserProfile class.
 * 
 * @author Aditya Nivarthi
 */
public class TestUserProfile extends TestCase {

	String name;
	UserProfile currentProfile;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	public void setUp() {
		name = "Bob";
		currentProfile = new UserProfile(name);
	}

	/**
	 * Tests the default values.
	 */
	public void testDefaultUserProfile() {
		assertEquals(name, currentProfile.getUserName());
		assertEquals(1, currentProfile.getHighestUnlockedLevel());
		assertEquals(0, currentProfile.getBadgesEarned().size());
		assertEquals(0, currentProfile.getLevelHighScore().size());
		assertEquals("", currentProfile.getAestheticName());
	}

	/**
	 * Tests setting the aesthetic name.
	 */
	public void testAesthetic() {
		currentProfile.setAestheticName("Temporary");
		assertEquals("Temporary", currentProfile.getAestheticName());
	}

	/**
	 * Tests adding and removing high scores.
	 */
	public void testHighScores() {
		// Add high scores
		assertEquals(currentProfile.getHighScoreOfLevel(1), -1);
		currentProfile.addLevelHighScore(1, 1, 3);
		currentProfile.addLevelHighScore(3, 3, 3);
		assertEquals(currentProfile.getHighScoreOfLevel(1), 1);
		assertEquals(currentProfile.getHighScoreOfLevel(2), -1);

		// Remove high scores
		currentProfile.removeLevelHighScore(1);
		currentProfile.removeLevelHighScore(2);
		assertEquals(currentProfile.getHighScoreOfLevel(1), -1);
		assertEquals(currentProfile.getHighScoreOfLevel(3), 3);
	}

	/**
	 * Tests setting the user name.
	 */
	public void testName() {
		name += "TheBuilder";
		currentProfile.setUserName(name);
		assertEquals(name, currentProfile.getUserName());
	}

	/**
	 * Tests LevelHighScore object.
	 */
	public void testScores() {
		// Set highest level
		currentProfile.setHighestLevel(3);
		currentProfile.addLevelHighScore(3, 3, 3);
		assertEquals(3, currentProfile.getHighestUnlockedLevel());
		assertEquals(3, currentProfile.getHighScoreOfLevel(3));
		assertEquals(3, currentProfile.getStarsOfLevel(3));

		// Get LevelHighScore object
		LevelHighScore score = currentProfile.getLevelHighScore(3);
		assertEquals(score.getHighScore(), 3);
		assertEquals(score.getLevel(), 3);
		assertEquals(score.getStars(), 3);

		LevelHighScore score2 = currentProfile.getLevelHighScore(2);
		assertNull(score2);
	}

	/**
	 * Tests adding and removing badges.
	 */
	public void testBadges() {
		// Add badge
		currentProfile.addBadgeEarned("Win");
		currentProfile.addBadgeEarned("Win3");
		assertEquals(currentProfile.getBadgesEarned().get(0), "Win");

		// Remove badge
		currentProfile.removeBadgeEarned("Win");
		currentProfile.removeBadgeEarned("Win2");
		assertEquals(currentProfile.getBadgesEarned().size(), 1);

		// Set badges
		ArrayList<String> badges = new ArrayList<String>();
		badges.add("Hi");

		currentProfile.setBadgesEarned(badges);
		assertEquals(currentProfile.getBadgesEarned().get(0), "Hi");
		
		assertTrue(currentProfile.hasBadge("Hi"));
	}

	/**
	 * Tests the toString method.
	 */
	public void testToString() {
		currentProfile.addLevelHighScore(1, 1, 3);
		currentProfile.addLevelHighScore(3, 3, 3);
		currentProfile.addBadgeEarned("Win");
		System.out.println(currentProfile.toString());
	}
}
