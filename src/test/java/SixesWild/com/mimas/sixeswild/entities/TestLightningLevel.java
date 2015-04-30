package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * This test case handles all coverage of the LightningLevel class.
 *
 * @author Joey Perez
 */
public class TestLightningLevel extends TestCase {

	/**
	 * Test all methods for LightningLevel.
	 */
	public void testLightningLevel() {
		ArrayList<Double> tileFreq = new ArrayList<Double>();
		ArrayList<Double> multFreq = new ArrayList<Double>();
		String levelName = "testLightning";
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

		LightningLevel level;
		try {
			level = new LightningLevel(tileFreq, multFreq, levelName, tiles,
					pointThresholds, specialMoves, levelNumber, 50);
			assertEquals(levelName, level.getName());
			assertEquals(LevelType.LIGHTNING, level.getType());
			assertEquals(tileFreq, level.board.getTileFrequencies());
			assertEquals(pointThresholds, level.getPointThresholds());
			assertEquals(multFreq, level.board.getMultiplierFrequencies());

			level.updateTimerCount(-1);
			assertFalse(level.hasBeenCompleted());

			assertEquals(level.getTimer(), 49);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail();
		}

		tiles[0][0] = null;
		try {
			new PuzzleLevel(tileFreq, multFreq, levelName, tiles,
					pointThresholds, 9, specialMoves, levelNumber);
			fail("Missing Exception");
		} catch (Exception e) {
			assertTrue(true);
		}

		try {
			new PuzzleLevel(tileFreq, multFreq, levelName, null,
					pointThresholds, 9, specialMoves, levelNumber);
			fail("Missing Exception");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
}
