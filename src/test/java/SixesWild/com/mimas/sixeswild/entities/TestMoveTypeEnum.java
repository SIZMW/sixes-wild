package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test case handles testing the MoveType enumerated type.
 *
 * @author Aditya Nivarthi
 */
public class TestMoveTypeEnum extends TestCase {

	/**
	 * Tests the verify the type values in the MoveType class.
	 */
	public void testTileTypeEnum() {
		MoveType types[] = MoveType.values();
		assertEquals(types.length, 3);
		assertEquals(types[0], MoveType.SELECTION);
		assertEquals(types[1], MoveType.SWAP);
		assertEquals(types[2], MoveType.REMOVE);
	}
}
