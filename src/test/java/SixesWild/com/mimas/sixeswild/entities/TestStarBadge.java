package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test handles the all aspects relating to the badge.
 *
 * @author Marco Duran
 */
public class TestStarBadge extends TestCase {
	StarBadge badge;
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

		badge = new StarBadge(name, description, 10);
	}

	/**
	 * Tests all the badge methods.
	 */
	public void testBadgeMethods() {
		assertEquals(badge.getName(), name);
		assertEquals(badge.getDescription(), description);
		assertTrue(badge.unlock(10));
	}
}
