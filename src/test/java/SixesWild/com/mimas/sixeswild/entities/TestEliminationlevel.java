package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * 
 * @author Joey Perez
 * 
 */

public class TestEliminationLevel extends TestCase {
	EliminationLevel toTest;

	public void testEliminationLevel() {
		ArrayList<Double> tileFreq = new ArrayList<Double>();
		ArrayList<Double> multFreq = new ArrayList<Double>();
		LevelType type = LevelType.ELIMINATION;
		String name = "the test level";
		Tile tiles[][] = new Tile[9][9];
		PointThresholds pointThresholds = new PointThresholds();
		int moveCount = 100;

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
			toTest = new EliminationLevel(tileFreq, multFreq, type, name,
					tiles, pointThresholds, moveCount);
			assertEquals(name, toTest.name);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail();
		}

		tiles[0][0] = null;
		try {
			new EliminationLevel(tileFreq, multFreq, type, name, tiles,
					pointThresholds, 9);
			fail("Missing Exception");
		} catch (Exception e) {
			assertTrue(true);
		}

		try {
			new EliminationLevel(tileFreq, multFreq, type, name, null,
					pointThresholds, 9);
			fail("Missing Exception");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
}
