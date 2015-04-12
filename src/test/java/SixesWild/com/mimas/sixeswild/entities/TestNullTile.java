package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

public class TestNullTile extends TestCase {
	public void testTileMethods() {
		NullTile tile = new NullTile("NullTile");
		assertEquals(tile.getType(), "NullTile");
	}
}
