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
		assertFalse(tile.hasProcessed());
		tile.setProcessed(true);
		assertTrue(tile.hasProcessed());
	}

	/**
	 * Test equals methods on Tile and SixTile.
	 */
	public void testTileEquals() {
		NullTile nullTile = new NullTile();
		SixTile tile = new SixTile();
		SixTile tile2 = new SixTile();
		NumberTile tile3 = new NumberTile(6, 0);

		tile2.setProcessed(true);

		assertFalse(tile.equals(null));
		assertFalse(tile.equals(nullTile));
		assertFalse(tile.equals(tile2));
		assertFalse(tile.equals(tile3));

		tile2.setProcessed(false);
		assertTrue(tile.equals(tile2));
	}
}
