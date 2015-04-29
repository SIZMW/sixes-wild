package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test case handles testing the TileType enumerated type.
 *
 * @author Aditya Nivarthi
 */
public class TestLevelTypeEnum extends TestCase {

	/**
	 * Tests the verify the type values in the TileType class.
	 */
	public void testTileTypeEnum() {
		LevelType types[] = LevelType.values();
		assertEquals(types.length, 4);
		assertEquals(types[0], LevelType.PUZZLE);
		assertEquals(types[1], LevelType.RELEASE);
		assertEquals(types[2], LevelType.LIGHTNING);
		assertEquals(types[3], LevelType.ELIMINATION);
	}
}
