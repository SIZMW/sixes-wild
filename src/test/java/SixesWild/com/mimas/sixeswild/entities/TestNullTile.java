package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test case handles testing the NullTile methods.
 * 
 * @author Aditya Nivarthi
 */
public class TestNullTile extends TestCase {

	/**
	 * Test all methods on NullTile.
	 */
	public void testTileMethods() {
		NullTile tile = new NullTile();
		assertEquals(tile.getType(), TileType.NULL);
		assertEquals(tile.getNumber(), 0);
		assertEquals(tile.getMultiplier(), 0);
	}
}
