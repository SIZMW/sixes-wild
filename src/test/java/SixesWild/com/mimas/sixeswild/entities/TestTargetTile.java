package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test case handles testing the TargetTile methods.
 *
 * @author Aditya Nivarthi
 */
public class TestTargetTile extends TestCase {

	/**
	 * Test all methods on TargetTile.
	 */
	public void testTileMethods() {
		TargetTile tile = new TargetTile();
		assertEquals(tile.getType(), TileType.TARGET);
		assertEquals(tile.getNumber(), 0);
		assertEquals(tile.getMultiplier(), 0);
	}
}
