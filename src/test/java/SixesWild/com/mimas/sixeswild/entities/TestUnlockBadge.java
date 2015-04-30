package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test handles the all aspects relating to the badge.
 *
 * @author Marco Duran
 */
public class TestUnlockBadge extends TestCase {
	UnlockBadge badge;
	String name;
	String description;

	/*
	 * (non-Javadoc)
	 *
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	public void setUp() {
		name = "Test1";
		description = "This is a test";

		badge = new UnlockBadge(name, description, 10);
	}

	/**
	 * Tests all the badge methods.
	 */
	public void testBadgeMethods() {
		assertEquals(badge.getName(), name);
		assertEquals(badge.getDescription(), description);
		assertEquals(badge.getType(), BadgeType.UNLOCK);
		assertTrue(badge.unlock(10));
		assertFalse(badge.unlock(9));
	}
}
