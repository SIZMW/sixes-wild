package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * This test case handles all coverage of the EliminationLevel class.
 *
 * @author Joey Perez
 */
public class TestEliminationLevel extends TestCase {

	EliminationLevel toTest;

	/**
	 * Test all EliminationLevel methods
	 */
	public void testEliminationLevel() {
		ArrayList<Double> tileFreq = new ArrayList<Double>();
		ArrayList<Double> multFreq = new ArrayList<Double>();
		String name = "the test level";
		Tile tiles[][] = new Tile[9][9];
		PointThresholds pointThresholds = new PointThresholds();
		int moveCount = 100;
		SpecialMoves specialMoves = new SpecialMoves();
		int levelNumber = 1;

		tileFreq.add(.1);
		tileFreq.add(.1);
		tileFreq.add(.2);
		tileFreq.add(.2);
		tileFreq.add(.2);
		tileFreq.add(.2);

		multFreq.add(.3);
		multFreq.add(.4);
		multFreq.add(.3);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				tiles[i][j] = new NumberTile(2, 2);
			}
		}
		try {
			toTest = new EliminationLevel(tileFreq, multFreq, name, tiles,
					pointThresholds, moveCount, specialMoves, levelNumber);
			assertEquals(name, toTest.name);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail();
		}

		tiles[0][0] = null;
		try {
			new EliminationLevel(tileFreq, multFreq, name, tiles,
					pointThresholds, 9, specialMoves, levelNumber);
			fail("Missing Exception");
		} catch (Exception e) {
			assertTrue(true);
		}

		try {
			new EliminationLevel(tileFreq, multFreq, name, null,
					pointThresholds, 9, specialMoves, levelNumber);
			fail("Missing Exception");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	/**
	 * Tests the methods in GameLevel through an EliminationLevel.
	 *
	 * @throws Exception
	 *             If board construction throws an exception
	 */
	public void testGameLevelMethods() throws Exception {
		ArrayList<Double> tileFreq = new ArrayList<Double>();
		ArrayList<Double> multFreq = new ArrayList<Double>();
		String name = "the test level";
		Tile tiles[][] = new Tile[9][9];
		PointThresholds pointThresholds = new PointThresholds();
		int moveCount = 100;
		SpecialMoves specialMoves = new SpecialMoves();
		int levelNumber = 1;

		tileFreq.add(.1);
		tileFreq.add(.1);
		tileFreq.add(.2);
		tileFreq.add(.2);
		tileFreq.add(.2);
		tileFreq.add(.2);

		multFreq.add(.3);
		multFreq.add(.4);
		multFreq.add(.3);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				tiles[i][j] = new NumberTile(2, 2);
			}
		}

		toTest = new EliminationLevel(tileFreq, multFreq, name, tiles,
				pointThresholds, moveCount, specialMoves, levelNumber);
		assertEquals(name, toTest.name);
		Board newBoard = new Board();
		toTest.setBoard(newBoard);
		assertEquals(newBoard, toTest.getBoard());
		toTest.setLevelNumber(100);
		assertEquals(100, toTest.getLevelNumber());
		toTest.setMoveCount(1);
		assertEquals(1, toTest.getMoveCount());
		toTest.setName("I Hate Testing");
		assertEquals("I Hate Testing", toTest.getName());
		toTest.setPointThresholds(pointThresholds);
		SpecialMoves newSpecialMoves = new SpecialMoves();
		toTest.setSpecialMoves(newSpecialMoves);
		int newTimer = 10;
		toTest.setTimer(newTimer);

		assertEquals(newTimer, toTest.getTimer());
		assertEquals(newSpecialMoves, toTest.getSpecialMoves());
		assertEquals(pointThresholds, toTest.getPointThresholds());

		toTest.updateMoveCount(-1);
		assertEquals(toTest.getMoveCount(), 0);
	}
}
