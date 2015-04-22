package SixesWild.com.mimas.sixeswild.sixeswild;

import junit.framework.TestCase;
import SixesWild.com.mimas.sixeswild.entities.PuzzleLevel;
import SixesWild.com.mimas.sixeswild.entities.TileType;
import SixesWild.com.mimas.sixeswild.entities.UserProfile;

public class TestXMLParser extends TestCase{

	public void testXMLParserFileToLevel(){
		// tests reading from file and creating a level out of the xml
		PuzzleLevel level = (PuzzleLevel) XMLParser.fileToLevel("testLevelProfileXML.xml");
		
		assertEquals(level.getName(), "Supercalifragilisticexpialidocious");
		assertEquals(level.getMoveCount(), 5);
		assertEquals(level.getPointThresholds().getOneStarThreshold(), 100);
		assertEquals(level.getPointThresholds().getTwoStarThreshold(), 200);
		assertEquals(level.getPointThresholds().getThreeStarThreshold(), 300);
		assertEquals(level.getBoard().getSquare(0, 0).getTile().getType(), TileType.NUMBER);
		assertEquals(level.getBoard().getSquare(1, 6).getTile().getType(), TileType.TARGET);
		assertEquals(level.getBoard().getSquare(4, 1).getTile().getType(), TileType.NULL);
		assertEquals(level.getBoard().getSquare(8, 1).getTile().getType(), TileType.NULL);
		assertEquals(level.getBoard().getSquare(7, 6).getTile().getType(), TileType.SIX);
	}
	
	public void testXMLParserFileToUserProfile(){
		// tests reading from a file and creating a user profile out of the xml
		UserProfile userProfile = XMLParser.fileToUserProfile("testUserProfileXML.xml");
		
		assertEquals(userProfile.getUserName(), "Rihanna");
		assertEquals(userProfile.getHighestLevel(), 10);
		assertEquals(userProfile.getAestheticName(), "Rainbow Unicorns");
		assertEquals(userProfile.getHighScoreOfLevel(1), 5);
		assertEquals(userProfile.getHighScoreOfLevel(3), 25);
		assertEquals(userProfile.getBadgesEarned().get(2), "Obama");
	}
	
}
