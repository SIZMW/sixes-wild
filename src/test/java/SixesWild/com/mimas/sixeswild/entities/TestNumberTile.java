package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test case handles testing the NumberTile methods.
 * 
 * @author Aditya Nivarthi
 */
public class TestNumberTile extends TestCase {

	/**
	 * Test all methods on NumberTile.
	 */
	public void testTileMethods() {
		NumberTile tile = new NumberTile(1, 1);
		assertEquals(tile.getType(), TileType.NUMBER);
		assertEquals(tile.getNumber(), 1);
		assertEquals(tile.getMultiplier(), 1);
	}
}
