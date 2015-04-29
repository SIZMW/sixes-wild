package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test handles the all aspects relating to the badge.
 *
 * @author Marco Duran
 */
public class TestScoreBadge extends TestCase {
	ScoreBadge badge;
	String name;
	String description;
	boolean isUnlocked;

	/*
	 * (non-Javadoc)
	 *
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	public void setUp() {
		name = "Test1";
		description = "This is a test";

		badge = new ScoreBadge(name, description, 10);
	}

	/**
	 * Tests all the badge methods.
	 */
	public void testBadgeMethods() {
		assertEquals(badge.getName(), name);
		assertEquals(badge.getDescription(), description);
		assertTrue(badge.unlock(13));
	}
}
