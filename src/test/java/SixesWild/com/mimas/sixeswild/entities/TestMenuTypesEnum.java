package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test case handles testing the MenuTypes enumerated type.
 *
 * @author Aditya Nivarthi
 */
public class TestMenuTypesEnum extends TestCase {

	/**
	 * Tests the verify the type values in the MenuTypes class.
	 */
	public void testTileTypeEnum() {
		MenuTypes types[] = MenuTypes.values();
		assertEquals(types.length, 2);
		assertEquals(types[0], MenuTypes.STORY);
		assertEquals(types[1], MenuTypes.USER);
	}
}
