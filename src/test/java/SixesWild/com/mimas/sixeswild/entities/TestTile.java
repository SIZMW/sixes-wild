package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

public class TestTile extends TestCase {
	public void testTileMethods() {
		Tile tile = new Tile(1, "Tile", 1);
		assertEquals(tile.getNumber(), 1);
		assertEquals(tile.getType(), "Tile");
		assertEquals(tile.getMultiplier(), 1);
	}
}
