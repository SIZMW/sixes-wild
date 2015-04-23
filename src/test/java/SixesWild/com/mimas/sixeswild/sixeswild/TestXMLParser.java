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
		assertEquals(level.getBoard().getSquare(6, 1).getTile().getType(), TileType.TARGET);
		assertEquals(level.getBoard().getSquare(1, 4).getTile().getType(), TileType.NULL);
		assertEquals(level.getBoard().getSquare(1, 8).getTile().getType(), TileType.NULL);
		assertEquals(level.getBoard().getSquare(6, 7).getTile().getType(), TileType.SIX);
	}
	
	public void testXMLParserFileToUserProfile(){
		// tests reading from a file and creating a user profile out of the xml
		UserProfile userProfile = XMLParser.fileToUserProfile("testUserProfileXML.xml");
		
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
}
