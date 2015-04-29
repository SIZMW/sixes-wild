package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * This test case handles testing all the methods for ReleaseLevel.
 *
 * @author Cameron Jones
 */
public class TestReleaseLevel extends TestCase {

	/**
	 * Test all methods for ReleaseLevel.
	 */
	public void testReleaseLevel() {
		ArrayList<Double> tileFreq = new ArrayList<Double>();
		ArrayList<Double> multFreq = new ArrayList<Double>();
		String levelName = "testRelease";
		Tile tiles[][] = new Tile[9][9];
		PointThresholds pointThresholds = new PointThresholds();
		SpecialMoves specialMoves = new SpecialMoves();
		int levelNumber = 1;

		tileFreq.add(.10);
		tileFreq.add(.20);
		tileFreq.add(.30);
		tileFreq.add(.30);
		tileFreq.add(.05);
		tileFreq.add(.05);

		multFreq.add(.95);
		multFreq.add(.025);
		multFreq.add(.025);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				tiles[i][j] = new NumberTile(3, 2);
			}
		}

		ReleaseLevel level;
		try {
			level = new ReleaseLevel(tileFreq, multFreq, levelName, tiles,
					pointThresholds, 50, specialMoves, levelNumber);
			assertEquals(levelName, level.name);
			assertEquals(LevelType.RELEASE, level.type);
			assertEquals(tileFreq, level.board.tileFrequencies);
			assertEquals(pointThresholds, level.pointThresholds);
			assertEquals(multFreq, level.board.multiplierFrequencies);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail();
		}

		tiles[0][0] = null;
		try {
			new ReleaseLevel(tileFreq, multFreq, levelName, tiles,
					pointThresholds, 9, specialMoves, levelNumber);
			fail("Missing Exception");
		} catch (Exception e) {
			assertTrue(true);
		}

		try {
			new ReleaseLevel(tileFreq, multFreq, levelName, null,
					pointThresholds, 9, specialMoves, levelNumber);
			fail("Missing Exception");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
}
