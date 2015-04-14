package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

public class TestSixTile extends TestCase {
	public void testTileMethods() {
		SixTile tile = new SixTile();
		assertEquals(tile.getType(), TileType.SIX);
		assertEquals(tile.getNumber(), 6);
		assertEquals(tile.getMultiplier(), 0);
	}
}
