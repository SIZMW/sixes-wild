package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

public class TestTile extends TestCase {
	public void testTileMethods() {
		Tile tile = new Tile("Tile");
		assertEquals(tile.getType(), "Tile");
	}
}
