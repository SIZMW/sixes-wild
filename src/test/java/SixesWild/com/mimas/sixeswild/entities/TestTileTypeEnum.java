package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test case handles testing the TileType enumerated type.
 *
 * @author Aditya Nivarthi
 */
public class TestTileTypeEnum extends TestCase {

	/**
	 * Tests the verify the type values in the TileType class.
	 */
	public void testTileTypeEnum() {
		TileType types[] = TileType.values();
		assertEquals(types.length, 4);
		assertEquals(types[0], TileType.NULL);
		assertEquals(types[1], TileType.NUMBER);
		assertEquals(types[2], TileType.TARGET);
		assertEquals(types[3], TileType.SIX);
	}
}
