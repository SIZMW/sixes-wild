package SixesWild.com.mimas.sixeswild.sixeswild;

import java.util.ArrayList;

import junit.framework.TestCase;
import SixesWild.com.mimas.sixeswild.entities.Level;
import SixesWild.com.mimas.sixeswild.entities.LevelType;
import SixesWild.com.mimas.sixeswild.entities.NullTile;
import SixesWild.com.mimas.sixeswild.entities.NumberTile;
import SixesWild.com.mimas.sixeswild.entities.PointThresholds;
import SixesWild.com.mimas.sixeswild.entities.PuzzleLevel;
import SixesWild.com.mimas.sixeswild.entities.SpecialMoves;
import SixesWild.com.mimas.sixeswild.entities.Tile;
import SixesWild.com.mimas.sixeswild.entities.TileType;
import SixesWild.com.mimas.sixeswild.entities.UserProfile;

public class TestXMLParser extends TestCase{

	public void testXMLParserFileToLevel(){
		// tests reading from file and creating a level out of the xml
		PuzzleLevel level = (PuzzleLevel) XMLParser.fileToLevel(XMLParser.USER_DIR + "2.xml");
		
		assertEquals(level.getName(), "Supercalifragilisticexpialidocious");
		assertEquals(level.getMoveCount(), 5);
		assertEquals(level.getPointThresholds().getOneStarThreshold(), 100);
		assertEquals(level.getPointThresholds().getTwoStarThreshold(), 200);
		assertEquals(level.getPointThresholds().getThreeStarThreshold(), 300);
		assertEquals(level.getBoard().getSquare(0, 0).getTile().getType(), TileType.NUMBER);
		assertEquals(level.getBoard().getSquare(6, 1).getTile().getType(), TileType.TARGET);
		assertEquals(level.getBoard().getSquare(1, 4).getTile().getType(), TileType.NULL);
		assertEquals(level.getBoard().getSquare(1, 8).getTile().getType(), TileType.NULL);
		assertEquals(level.getBoard().getSquare(6, 7).getTile().getType(), TileType.SIX);
	}
	
	public void testXMLParserFileToUserProfile(){
		// tests reading from a file and creating a user profile out of the xml
		UserProfile userProfile = XMLParser.fileToUserProfile("TestProfile.xml");
		
		assertEquals(userProfile.getUserName(), "Rihanna");
		assertEquals(userProfile.getHighestUnlockedLevel(), 10);
		assertEquals(userProfile.getAestheticName(), "Rainbow Unicorns");
		assertEquals(userProfile.getHighScoreOfLevel(1), 5);
		assertEquals(userProfile.getHighScoreOfLevel(3), 25);
		assertEquals(userProfile.getBadgesEarned().get(2), "Obama");
	}
	
	public void testXMLParserUserProfileToFile(){
		// make userProfile1
		UserProfile userProfile1 = new UserProfile("Iggy");
		
		userProfile1.setHighestLevel(20);
		userProfile1.setAestheticName("Tire Marks");
		
		userProfile1.addBadgeEarned("Fancy");
		userProfile1.addBadgeEarned("Black Widow");
		userProfile1.addBadgeEarned("Jiggy");
		
		userProfile1.addLevelHighScore(1, 2, 1);
		userProfile1.addLevelHighScore(2, 3, 2);
		userProfile1.addLevelHighScore(3, 4, 3);
		
		// convert user profile to xml file, then take the xml file to userProfile2
		XMLParser.userProfileToFile(userProfile1);
		UserProfile userProfile2 = XMLParser.fileToUserProfile("IggyProfile.xml");
		
		// test to make sure userProfile1 is equal to userProfile 2
		assertEquals(userProfile1.getUserName(), userProfile2.getUserName());
		assertEquals(userProfile1.getAestheticName(), userProfile2.getAestheticName());
		assertEquals(userProfile1.getHighestUnlockedLevel(), userProfile2.getHighestUnlockedLevel());
		
		assertEquals(userProfile1.hasBadge("Fancy"), userProfile2.hasBadge("Fancy"));
		assertEquals(userProfile1.hasBadge("Black Widow"), userProfile2.hasBadge("Black Widow"));
		assertEquals(userProfile1.hasBadge("Jiggy"), userProfile2.hasBadge("Jiggy"));
		
		assertEquals(userProfile1.getHighScoreOfLevel(1), userProfile2.getHighScoreOfLevel(1));
		assertEquals(userProfile1.getHighScoreOfLevel(2), userProfile2.getHighScoreOfLevel(2));
		assertEquals(userProfile1.getHighScoreOfLevel(3), userProfile2.getHighScoreOfLevel(3));
		
		assertEquals(userProfile1.getStarsOfLevel(1), userProfile2.getStarsOfLevel(1));
		assertEquals(userProfile1.getStarsOfLevel(2), userProfile2.getStarsOfLevel(2));
		assertEquals(userProfile1.getStarsOfLevel(3), userProfile2.getStarsOfLevel(3));
		
	}	
	
	public void testXMLParserFileToLevelName(){
		String levelName = XMLParser.fileToLevelName(XMLParser.USER_DIR + "2.xml");
		assertEquals(levelName, "Supercalifragilisticexpialidocious");
	}
	
	public void testXMLParserLevelToFile(){
		// make a level
		ArrayList<Double> tileFreq = new ArrayList<Double>(); // DONE
		ArrayList<Double> multFreq = new ArrayList<Double>(); // DONE
		LevelType levelType = LevelType.PUZZLE; // DONE
		String levelName = "testPuzzle"; // DONE
		Tile tiles[][] = new Tile[9][9];
		PointThresholds pointThresholds = new PointThresholds(); // DONE
		SpecialMoves specialMoves = new SpecialMoves();
		int levelNumber = 5;
		
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
				if(j < 2){
					tiles[i][j] = new NullTile();
				}
				else{
					tiles[i][j] = new NumberTile(3, 2);
				}
			}
		}
		PuzzleLevel level1;
		try {
			level1 = new PuzzleLevel(tileFreq, multFreq, levelType, levelName,
					tiles, pointThresholds, 50, specialMoves, levelNumber);
			
			// change the level to a file and then turn it back into a level
			XMLParser.levelToFile(level1);
			Level level2 = XMLParser.fileToLevel(XMLParser.USER_DIR + "1.xml");
			
			// make sure the two levels have the same attributes
			assertEquals(level1.getLevelNumber(), level2.getLevelNumber());
			assertEquals(level1.getMoveCount(), level2.getMoveCount());
			assertEquals(level1.getName(), level2.getName());
			assertEquals(level1.getType(), level2.getType());
			
			assertEquals(level1.getPointThresholds().getOneStarThreshold(), level2.getPointThresholds().getOneStarThreshold());
			assertEquals(level1.getPointThresholds().getTwoStarThreshold(), level2.getPointThresholds().getTwoStarThreshold());
			assertEquals(level1.getPointThresholds().getThreeStarThreshold(), level2.getPointThresholds().getThreeStarThreshold());
			
			assertEquals(level1.getSpecialMoves().getRemoveTileCount(), level2.getSpecialMoves().getRemoveTileCount());
			assertEquals(level1.getSpecialMoves().getResetBoardCount(), level2.getSpecialMoves().getResetBoardCount());
			assertEquals(level1.getSpecialMoves().getSwapTileCount(), level2.getSpecialMoves().getSwapTileCount());
			assertEquals(level1.getSpecialMoves().getXStacySpecialMoveCount(), level2.getSpecialMoves().getXStacySpecialMoveCount());
			
			assertEquals(level1.getBoard().getSquare(1, 7).getTile().getType(), level2.getBoard().getSquare(1, 7).getTile().getType());
		} catch (Exception e1){
			
		}	
	}
}
