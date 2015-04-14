package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

public class TestNumberTile extends TestCase {
	public void testTileMethods() {
		NumberTile tile = new NumberTile(1, 1);
		assertEquals(tile.getType(), TileType.NUMBER);
		assertEquals(tile.getNumber(), 1);
		assertEquals(tile.getMultiplier(), 1);
	}
}
