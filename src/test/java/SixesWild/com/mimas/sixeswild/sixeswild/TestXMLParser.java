package SixesWild.com.mimas.sixeswild.sixeswild;

import java.util.ArrayList;

import junit.framework.TestCase;
import SixesWild.com.mimas.sixeswild.entities.GameLevel;
import SixesWild.com.mimas.sixeswild.entities.MenuTypes;
import SixesWild.com.mimas.sixeswild.entities.NullTile;
import SixesWild.com.mimas.sixeswild.entities.NumberTile;
import SixesWild.com.mimas.sixeswild.entities.PointThresholds;
import SixesWild.com.mimas.sixeswild.entities.PuzzleLevel;
import SixesWild.com.mimas.sixeswild.entities.ReleaseLevel;
import SixesWild.com.mimas.sixeswild.entities.SpecialMoves;
import SixesWild.com.mimas.sixeswild.entities.Tile;
import SixesWild.com.mimas.sixeswild.entities.TileType;
import SixesWild.com.mimas.sixeswild.entities.UserProfile;

/**
 * This test case handles all coverage for the XMLParser class.
 *
 * @author Yahel Nachum
 */
public class TestXMLParser extends TestCase {

	/**
	 * Tests reading a file to a level object.
	 */
	public void testXMLParserFileToLevel() {
		ReleaseLevel level = (ReleaseLevel) XMLParser
				.fileToLevel(XMLParser.USER_DIR + "2.xml");

		assertEquals(level.getName(), "Supercalifragilisticexpialidocious");
		assertEquals(level.getMoveCount(), 15);
		assertEquals(level.getPointThresholds().getOneStarThreshold(), 100);
		assertEquals(level.getPointThresholds().getTwoStarThreshold(), 200);
		assertEquals(level.getPointThresholds().getThreeStarThreshold(), 300);
		assertEquals(level.getBoard().getSquare(0, 0).getTile().getType(),
				TileType.NUMBER);
		assertEquals(level.getBoard().getSquare(6, 1).getTile().getType(),
				TileType.NUMBER);
		assertEquals(level.getBoard().getSquare(1, 4).getTile().getType(),
				TileType.NULL);
		assertEquals(level.getBoard().getSquare(1, 8).getTile().getType(),
				TileType.NULL);
		assertEquals(level.getBoard().getSquare(6, 7).getTile().getType(),
				TileType.NUMBER);
	}

	/**
	 * Tests reading a file to a user profile object.
	 */
	public void testXMLParserFileToUserProfile() {
		UserProfile userProfile = XMLParser
				.fileToUserProfile("TestProfile.xml");

		assertEquals(userProfile.getUserName(), "Rihanna");
		assertEquals(userProfile.getHighestStoryLevelUnlocked(), 10);
		assertEquals(userProfile.getAestheticName(), "Rainbow Unicorns");
		assertEquals(userProfile.getHighScoreOfLevel(1), 5);
		assertEquals(userProfile.getHighScoreOfLevel(3), 25);
		assertEquals(userProfile.getBadgesEarned().get(2), "Obama");
	}

	/**
	 * Tests making a user profile into a file.
	 */
	public void testXMLParserUserProfileToFile() {
		// Make userProfile1
		UserProfile userProfile1 = new UserProfile("Iggy");

		userProfile1.setHighestStoryLevel(20);
		userProfile1.setHighestUserLevel(20);
		userProfile1.setAestheticName("SupahRed");

		userProfile1.addBadgeEarned("Fancy");
		userProfile1.addBadgeEarned("Black Widow");
		userProfile1.addBadgeEarned("Jiggy");

		userProfile1.addLevelHighScore(1, 2, 1, MenuTypes.STORY);
		userProfile1.addLevelHighScore(2, 3, 2, MenuTypes.STORY);
		userProfile1.addLevelHighScore(3, 4, 3, MenuTypes.STORY);

		// Convert user profile to xml file, then take the xml file to user
		// profile
		XMLParser.userProfileToFile(userProfile1);
		UserProfile userProfile2 = XMLParser
				.fileToUserProfile("IggyProfile.xml");

		// Test to make sure userProfile1 is equal to userProfile 2
		assertEquals(userProfile1.getUserName(), userProfile2.getUserName());
		assertEquals(userProfile1.getAestheticName(),
				userProfile2.getAestheticName());
		assertEquals(userProfile1.getHighestStoryLevelUnlocked(),
				userProfile2.getHighestStoryLevelUnlocked());
		assertEquals(userProfile1.getHighestUserLevelUnlocked(),
				userProfile2.getHighestUserLevelUnlocked());

		assertEquals(userProfile1.hasBadge("Fancy"),
				userProfile2.hasBadge("Fancy"));
		assertEquals(userProfile1.hasBadge("Black Widow"),
				userProfile2.hasBadge("Black Widow"));
		assertEquals(userProfile1.hasBadge("Jiggy"),
				userProfile2.hasBadge("Jiggy"));

		assertEquals(userProfile1.getHighScoreOfLevel(1),
				userProfile2.getHighScoreOfLevel(1));
		assertEquals(userProfile1.getHighScoreOfLevel(2),
				userProfile2.getHighScoreOfLevel(2));
		assertEquals(userProfile1.getHighScoreOfLevel(3),
				userProfile2.getHighScoreOfLevel(3));

		assertEquals(userProfile1.getStarsOfLevel(1),
				userProfile2.getStarsOfLevel(1));
		assertEquals(userProfile1.getStarsOfLevel(2),
				userProfile2.getStarsOfLevel(2));
		assertEquals(userProfile1.getStarsOfLevel(3),
				userProfile2.getStarsOfLevel(3));

	}

	/**
	 * Tests reading a file to the level name.
	 */
	public void testXMLParserFileToLevelName() {
		String levelName = XMLParser.fileToLevelName(XMLParser.USER_DIR
				+ "2.xml");
		assertEquals(levelName, "Supercalifragilisticexpialidocious");
	}

	/**
	 * Tests making a level into a file.
	 */
	public void testXMLParserLevelToFile() {

		// Make a level
		ArrayList<Double> tileFreq = new ArrayList<Double>();
		ArrayList<Double> multFreq = new ArrayList<Double>();
		String levelName = "Easy Puzzle";
		Tile tiles[][] = new Tile[9][9];
		PointThresholds pointThresholds = new PointThresholds(5, 10, 20);
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
				if (j < 2) {
					tiles[i][j] = new NullTile();
				} else {
					tiles[i][j] = new NumberTile(3, 2);
				}
			}
		}

		PuzzleLevel level1;
		try {
			level1 = new PuzzleLevel(tileFreq, multFreq, levelName, tiles,
					pointThresholds, 50, specialMoves, levelNumber);

			// Change the level to a file and then turn it back into a level
			XMLParser.levelToFile(level1);
			GameLevel level2 = XMLParser.fileToLevel(XMLParser.USER_DIR
					+ "1.xml");

			// Make sure the two levels have the same attributes
			assertEquals(level1.getLevelNumber(), level2.getLevelNumber());
			assertEquals(level1.getMoveCount(), level2.getMoveCount());
			assertEquals(level1.getName(), level2.getName());
			assertEquals(level1.getType(), level2.getType());

			assertEquals(level1.getPointThresholds().getOneStarThreshold(),
					level2.getPointThresholds().getOneStarThreshold());
			assertEquals(level1.getPointThresholds().getTwoStarThreshold(),
					level2.getPointThresholds().getTwoStarThreshold());
			assertEquals(level1.getPointThresholds().getThreeStarThreshold(),
					level2.getPointThresholds().getThreeStarThreshold());

			assertEquals(level1.getSpecialMoves().getRemoveTileCount(), level2
					.getSpecialMoves().getRemoveTileCount());
			assertEquals(level1.getSpecialMoves().getResetBoardCount(), level2
					.getSpecialMoves().getResetBoardCount());
			assertEquals(level1.getSpecialMoves().getSwapTileCount(), level2
					.getSpecialMoves().getSwapTileCount());
			assertEquals(level1.getSpecialMoves().getXStacySpecialMoveCount(),
					level2.getSpecialMoves().getXStacySpecialMoveCount());

			assertEquals(level1.getBoard().getSquare(1, 7).getTile().getType(),
					level2.getBoard().getSquare(1, 7).getTile().getType());
		} catch (Exception e1) {

		}
	}
}
