package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * This test case handles coverage on the GameLevel methods using the GameLevel
 * sub classes.
 *
 * @author Cameron Jones
 */
public class TestGameLevel extends TestCase {

	EliminationLevel toTest;

	/**
	 * Tests GameLevel methods using EliminationLevel.
	 *
	 * @throws Exception
	 *             If board fails to create.
	 */
	public void testEliminationLevel() throws Exception {
		ArrayList<Double> tileFreq = new ArrayList<Double>();
		ArrayList<Double> multFreq = new ArrayList<Double>();
		LevelType type = LevelType.ELIMINATION;
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

		this.toTest = new EliminationLevel(tileFreq, multFreq, type, name,
				tiles, pointThresholds, moveCount, specialMoves, levelNumber);
		assertEquals(name, this.toTest.name);
		Board newBoard = new Board();
		this.toTest.setBoard(newBoard);
		assertEquals(newBoard, this.toTest.getBoard());
		this.toTest.setLevelNumber(100);
		assertEquals(100, this.toTest.getLevelNumber());
		this.toTest.setMoveCount(1);
		assertEquals(1, this.toTest.getMoveCount());
		this.toTest.setName("I Hate Testing");
		assertEquals("I Hate Testing", this.toTest.getName());
		this.toTest.setPointThresholds(pointThresholds);
		SpecialMoves newSpecialMoves = new SpecialMoves();
		this.toTest.setSpecialMoves(newSpecialMoves);
		int newTimer = 10;
		this.toTest.setTimer(newTimer);
		this.toTest.setType(LevelType.LIGHTNING);

		assertEquals(LevelType.LIGHTNING, this.toTest.getType());
		assertEquals(newTimer, this.toTest.getTimer());
		assertEquals(newSpecialMoves, this.toTest.getSpecialMoves());
		assertEquals(pointThresholds, this.toTest.getPointThresholds());

		this.toTest.updateMoveCount(-1);
		assertEquals(this.toTest.getMoveCount(), 0);
	}
}
