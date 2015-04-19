package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test case handles testing the Square methods.
 * 
 * @author Aditya Nivarthi
 */
public class TestSquare extends TestCase {

	Square square;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	public void setUp() {
		square = new Square(new NumberTile(1, 1), 0, 0, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	public void tearDown() {

	}

	/**
	 * Tests all the Square methods.
	 */
	public void testSquareMethods() {
		assertEquals(square.getX(), 0);
		assertEquals(square.getY(), 0);
		assertEquals(square.getTile().getType(), TileType.NUMBER);
		assertEquals(square.isMarked(), false);
	}

	/**
	 * Tests all the Square's tile methods
	 */
	public void testSquareTileMethods() {
		square.removeTile();
		assertNull(square.getTile());
		square.addTile(new NumberTile(2, 1));
		assertEquals(square.getTile().getNumber(), 2);
		assertEquals(square.getTile().getMultiplier(), 1);
	}

	/**
	 * Tests all the Square marked methods.
	 */
	public void testSquareMarkedMethods() {
		assertEquals(square.isMarked(), false);
		square.setMarked(true);
		assertEquals(square.isMarked(), true);
	}
}
