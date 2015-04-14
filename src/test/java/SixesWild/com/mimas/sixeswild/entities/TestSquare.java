package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

public class TestSquare extends TestCase {
	
	Square square;
	public void setUp() {
		square = new Square(new NumberTile(1, 1), 0, 0, false);
	}
	
	public void tearDown() {
		
	}
	
	public void testSquareMethods() {
		assertEquals(square.getX(), 0);
		assertEquals(square.getY(), 0);
		assertEquals(square.getTile().getType(), TileType.NUMBER);
		assertEquals(square.isMarked(), false);
	}
	
	public void testSquareTileMethods() {
		square.removeTile();
		square.addTile(new NumberTile(2, 1));
		assertEquals(square.getTile().getNumber(), 2);
		assertEquals(square.getTile().getMultiplier(), 1);
	}
	
	public void testSquareMarkedMethods() {
		assertEquals(square.isMarked(), false);
		square.setMarked(true);
		assertEquals(square.isMarked(), true);
	}
}
