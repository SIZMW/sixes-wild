package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

import javax.swing.Timer;

import junit.framework.TestCase;

/**
 * 
 * @author Joey Perez
 * 
 */

public class TestLevel extends TestCase {
	EliminationLevel toTest;

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
		
		toTest = new EliminationLevel(tileFreq, multFreq, type, name,
					tiles, pointThresholds, moveCount, specialMoves, levelNumber);
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
		toTest.setSpecialMoves(newSpecialMoves );
		Timer newTimer = new Timer(10, null);
		toTest.setTimer(newTimer);
		toTest.setType(LevelType.LIGHTNING);
		assertEquals(LevelType.LIGHTNING, toTest.getType());
		assertEquals(newTimer, toTest.getTimer());
		assertEquals(newSpecialMoves, toTest.getSpecialMoves());
		assertEquals(pointThresholds, toTest.getPointThresholds());

		
	}
}
