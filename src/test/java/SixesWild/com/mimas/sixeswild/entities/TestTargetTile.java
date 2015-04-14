package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

public class TestTargetTile extends TestCase {
	public void testTileMethods() {
		TargetTile tile = new TargetTile();
		assertEquals(tile.getType(), TileType.TARGET);
		assertEquals(tile.getNumber(), 6);
		assertEquals(tile.getMultiplier(), 0);
	}
}
