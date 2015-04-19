package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test case handles testing the SixTile methods.
 * 
 * @author Aditya Nivarthi
 */
public class TestSixTile extends TestCase {

	/**
	 * Test all methods on SixTile.
	 */
	public void testTileMethods() {
		SixTile tile = new SixTile();
		assertEquals(tile.getType(), TileType.SIX);
		assertEquals(tile.getNumber(), 6);
		assertEquals(tile.getMultiplier(), 0);
	}
}
