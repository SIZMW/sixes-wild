package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

public class TestSpecialMoves extends TestCase {

	public void testSpecialMovesMethods(){
		SpecialMoves s = new SpecialMoves();
		
		assertEquals(s.getRemoveTileCount(), 0);
		assertEquals(s.getResetBoardCount(), 0);
		assertEquals(s.getSwapTileCount(), 0);
		assertEquals(s.getXStacySpecialMoveCount(), 0);
		
		s.setRemoveTileCount(5);
		s.setResetBoardCount(10);
		s.setSwapTileCount(15);
		s.setXStacySpecialMoveCount(20);
		
		assertEquals(s.getRemoveTileCount(), 5);
		assertEquals(s.getResetBoardCount(), 10);
		assertEquals(s.getSwapTileCount(), 15);
		assertEquals(s.getXStacySpecialMoveCount(), 20);
		
		SpecialMoves s1 = new SpecialMoves(1, 2, 3, 4);
		
		assertEquals(s1.getRemoveTileCount(), 3);
		assertEquals(s1.getResetBoardCount(), 1);
		assertEquals(s1.getSwapTileCount(), 2);
		assertEquals(s1.getXStacySpecialMoveCount(), 4);
	}
}
