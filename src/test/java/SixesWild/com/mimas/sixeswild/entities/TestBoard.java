package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test case handles testing all methods for the Board class.
 * 
 * @author Aditya Nivarthi
 */
public class TestBoard extends TestCase {

	Board board;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	public void setUp() {
		board = new Board();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	public void tearDown() {

	}

	/**
	 * Test setting a square and getting a square in the board.
	 */
	public void testSquareSetAndGet() {
		// Setup
		board.initialize();
		Square square = new Square(new NumberTile(1, 1), 0, 0, false);
		board.setSquare(square.getTile(), square.getX(), square.getY(), square.getMarked());

		// Verify result
		assertEquals(square.getTile(), board.getSquare(square.getX(), square.getY()).getTile());
		assertEquals(square.getX(), board.getSquare(square.getX(), square.getY()).getX());
		assertEquals(square.getY(), board.getSquare(square.getX(), square.getY()).getY());
	}

	/**
	 * Tests randomization for number tiles and multipliers.
	 */
	public void testRandomizationMethods() {
		// Setup
		board.initialize();
		int number = board.getNumber();
		int multiplier = board.getMultiplier();

		// Verify result
		assertTrue(number < 7);
		assertTrue(number > 0);
		assertTrue(multiplier < 4);
		assertTrue(multiplier > 0);
	}
}
