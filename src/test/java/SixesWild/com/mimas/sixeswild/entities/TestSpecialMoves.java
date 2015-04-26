package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test case handles testing all the methods on special moves.
 *
 * @author Aditya Nivarthi
 */
public class TestSpecialMoves extends TestCase {

	/**
	 * Tests all the methods on special moves.
	 */
	public void testSpecialMovesMethods() {
		SpecialMoves s = new SpecialMoves();

		// Test default values
		assertEquals(s.getRemoveTileCount(), 0);
		assertEquals(s.getResetBoardCount(), 0);
		assertEquals(s.getSwapTileCount(), 0);
		assertEquals(s.getXStacySpecialMoveCount(), 0);

		// Set values
		s.setRemoveTileCount(5);
		s.setResetBoardCount(10);
		s.setSwapTileCount(15);
		s.setXStacySpecialMoveCount(20);

		// Test new values
		assertEquals(s.getRemoveTileCount(), 5);
		assertEquals(s.getResetBoardCount(), 10);
		assertEquals(s.getSwapTileCount(), 15);
		assertEquals(s.getXStacySpecialMoveCount(), 20);

		// Set custom values
		SpecialMoves s1 = new SpecialMoves(1, 2, 3, 4);

		// Test custom values
		assertEquals(s1.getRemoveTileCount(), 3);
		assertEquals(s1.getResetBoardCount(), 1);
		assertEquals(s1.getSwapTileCount(), 2);
		assertEquals(s1.getXStacySpecialMoveCount(), 4);

		// Test the update move methods
		s1.updateRemoveTileCount(-1);
		s1.updateResetBoardCount(-1);
		s1.updateSwapTileCount(-1);
		s1.updateXStacySpecialMoveCount(-1);

		assertEquals(s1.getRemoveTileCount(), 2);
		assertEquals(s1.getResetBoardCount(), 0);
		assertEquals(s1.getSwapTileCount(), 1);
		assertEquals(s1.getXStacySpecialMoveCount(), 3);
	}
}
