package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * This test case handles testing all the methods for Level.
 * 
 * @author Joey Perez
 */
public class TestPuzzleLevel extends TestCase {

	/**
	 * Test all methods for Level.
	 */
	public void testPuzzleLevel() {
		ArrayList<Double> tileFreq = new ArrayList<Double>();    //DONE
		ArrayList<Double> multFreq = new ArrayList<Double>();    //DONE
		LevelType levelType = LevelType.PUZZLE;                  //DONE
		String levelName = "testPuzzle";                         //DONE
		Tile tiles[][] = new Tile[9][9];
		PointThresholds pointThresholds = new PointThresholds(); //DONE
		
		tileFreq.add(.10);
		tileFreq.add(.20);
		tileFreq.add(.30);
		tileFreq.add(.30);
		tileFreq.add(.05);
		tileFreq.add(.05);

		multFreq.add(.95);
		multFreq.add(.025);
		multFreq.add(.025);
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				tiles[i][j] = new NumberTile(3, 2);
			}
		}
		
		PuzzleLevel level;
		try {
			level = new PuzzleLevel(tileFreq, multFreq, levelType, levelName, tiles, pointThresholds, 50);
			assertEquals(levelName, level.name);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail();
		}
		
		
		
		tiles[0][0] = null;
		try {
		     PuzzleLevel failure = new PuzzleLevel(tileFreq, multFreq, levelType, levelName, tiles, pointThresholds, 9);
		     fail( "Missing Exception" );
		} catch( Exception e ) {
		     assertTrue(true);
		}
		
		try {
		     PuzzleLevel failure = new PuzzleLevel(tileFreq, multFreq, levelType, levelName, null, pointThresholds, 9);
		     fail( "Missing Exception" );
		} catch( Exception e ) {
		     assertTrue(true);
		}
	}
}
