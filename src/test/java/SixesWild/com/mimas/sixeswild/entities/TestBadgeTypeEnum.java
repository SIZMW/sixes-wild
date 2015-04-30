package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test case handles testing the BadgeType enumerated type.
 *
 * @author Aditya Nivarthi
 */
public class TestBadgeTypeEnum extends TestCase {

	/**
	 * Tests the verify the type values in the BadgeType class.
	 */
	public void testBadgeTypeEnum() {
		BadgeType types[] = BadgeType.values();
		assertEquals(types.length, 3);
		assertEquals(types[0], BadgeType.SCORE);
		assertEquals(types[1], BadgeType.STAR);
		assertEquals(types[2], BadgeType.UNLOCK);
	}
}
