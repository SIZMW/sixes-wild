package SixesWild.com.mimas.sixeswild.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import SixesWild.com.mimas.sixeswild.entities.Board;
import SixesWild.com.mimas.sixeswild.entities.EliminationLevel;
import SixesWild.com.mimas.sixeswild.entities.GameLevel;
import SixesWild.com.mimas.sixeswild.entities.LevelHighScore;
import SixesWild.com.mimas.sixeswild.entities.LevelType;
import SixesWild.com.mimas.sixeswild.entities.LightningLevel;
import SixesWild.com.mimas.sixeswild.entities.MenuTypes;
import SixesWild.com.mimas.sixeswild.entities.NullTile;
import SixesWild.com.mimas.sixeswild.entities.NumberTile;
import SixesWild.com.mimas.sixeswild.entities.PointThresholds;
import SixesWild.com.mimas.sixeswild.entities.PuzzleLevel;
import SixesWild.com.mimas.sixeswild.entities.ReleaseLevel;
import SixesWild.com.mimas.sixeswild.entities.SixTile;
import SixesWild.com.mimas.sixeswild.entities.SpecialMoves;
import SixesWild.com.mimas.sixeswild.entities.TargetTile;
import SixesWild.com.mimas.sixeswild.entities.Tile;
import SixesWild.com.mimas.sixeswild.entities.TileType;
import SixesWild.com.mimas.sixeswild.entities.UserProfile;

/**
 * This class handles parsing the level and user profile files into usable
 * objects in the builder or game.
 *
 * @author Yahel Nachum, Aditya Nivarthi
 */
public final class XMLParser {

	public static final String STORY_DIR = "./storylevels/";
	public static final String USER_DIR = "./userlevels/";
	public static final String PROFILE_DIR = "./userprofiles/";
	public static final String PROFILE_CONST = "Profile";
	public static final String XML_EXT = ".xml";

	private static final Logger logger = Logger.getGlobal();

	/**
	 * Returns the character representation of the tile based on its type.
	 *
	 * @param tile
	 *            The tile to represent as a character.
	 * @return A character for representation
	 * @throws Exception
	 *             on invalid type
	 */
	protected static char instanceToChar(Tile tile) throws Exception {
		if (tile.getType().equals(TileType.NUMBER)) {
			return 'N';
		} else if (tile.getType().equals(TileType.NULL)) {
			return 'U';
		} else if (tile.getType().equals(TileType.SIX)) {
			return 'S';
		} else if (tile.getType().equals(TileType.TARGET)) {
			return 'T';
		} else {
			logger.log(Level.SEVERE,
					"Invalid tile type requested for character conversion.");
			throw new Exception("Invalid tile type!");
		}
	}

	/**
	 * Gets the level name of the specified file.
	 *
	 * @param fileName
	 *            The string containing the directory and XML file name that
	 *            contains all the information for a singular level.
	 * @return a String if level exists; null otherwise
	 */
	protected static String fileToLevelName(String fileName) {
		try {

			// Set up XML file for reading
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			// Get level name
			String levelName = doc.getElementsByTagName("Name").item(0)
					.getTextContent();

			return levelName;

		} catch (Exception e) {
			logger.log(Level.WARNING, "File: " + fileName + " not found.");
		}

		return null;
	}

	/**
	 * Gets the user profile name of the specified file.
	 *
	 * @param fileName
	 *            The string containing the directory and XML file name that
	 *            contains all the information for a singular user profile.
	 * @return a String for user name if exists; null otherwise
	 */
	protected static String fileToUserProfileName(String fileName) {
		try {

			// Set up XML file for reading
			File uXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(uXmlFile);
			doc.getDocumentElement().normalize();

			// Get user profile name
			String userProfileName = doc.getElementsByTagName("UserProfile")
					.item(0).getAttributes().getNamedItem("user")
					.getTextContent();

			return userProfileName;

		} catch (Exception e) {
			logger.log(Level.WARNING, "File: " + fileName + " not found.");
		}

		return null;
	}

	/**
	 * Gets the list of level names to load to the list selection from the given
	 * directory.
	 *
	 * @param directory
	 *            The directory to load levels from.
	 * @return A list of level names.
	 */
	public static ArrayList<String> getLevelFileNames(String directory) {
		File folder = new File(directory);
		File[] listFiles = folder.listFiles();
		ArrayList<String> fileNames = new ArrayList<String>();
		String extension = "xml";

		// Sort by file name numerically
		Arrays.sort(listFiles, new Comparator<File>() {
			public int compare(File f1, File f2) {
				int n1 = Integer.parseInt(f1.getName().substring(0,
						f1.getName().indexOf(".")));
				int n2 = Integer.parseInt(f2.getName().substring(0,
						f2.getName().indexOf(".")));
				return Integer.compare(n1, n2);
			}
		});

		for (int i = 0; i < listFiles.length; i++) {
			if (listFiles[i].isFile()
					&& listFiles[i]
							.getName()
							.substring(
									listFiles[i].getName().lastIndexOf(".") + 1,
									listFiles[i].getName().length())
							.equals(extension)) {
				fileNames.add(XMLParser.fileToLevelName(directory
						+ listFiles[i].getName()));
			}
		}

		logger.log(Level.INFO, "Level list loaded from disk. Directory: "
				+ directory);

		return fileNames;
	}

	/**
	 * Gets the list of user profile names to load.
	 *
	 * @return A list of user profile names.
	 */
	public static ArrayList<String> getUserProfileNames() {
		File folder = new File(XMLParser.PROFILE_DIR);
		File[] listFiles = folder.listFiles();
		ArrayList<String> fileNames = new ArrayList<String>();
		String extension = "xml";

		for (int i = 0; i < listFiles.length; i++) {
			if (listFiles[i].isFile()
					&& listFiles[i]
							.getName()
							.substring(
									listFiles[i].getName().lastIndexOf(".") + 1,
									listFiles[i].getName().length())
							.equals(extension)) {
				fileNames.add(XMLParser
						.fileToUserProfileName(XMLParser.PROFILE_DIR
								+ listFiles[i].getName()));
			}
		}

		logger.log(Level.INFO,
				"User profile name list loaded from disk. Directory: "
						+ XMLParser.PROFILE_DIR);

		return fileNames;
	}

	/**
	 * Takes in a file name and extracts the information from it to create a
	 * level.
	 *
	 * @param fileName
	 *            A String of the directory and file name.
	 * @return Level object for the level if exists; null otherwise
	 */
	public static GameLevel fileToLevel(String fileName) {
		try {
			// Set up XML file for reading
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			// Get level number
			int levelNumber = Integer.parseInt(doc
					.getElementsByTagName("Level").item(0).getAttributes()
					.item(0).getNodeValue());

			// Get level name
			String levelName = doc.getElementsByTagName("Name").item(0)
					.getTextContent();

			// Get level type
			String levelType = doc.getElementsByTagName("Type").item(0)
					.getTextContent();

			// Get list of tile frequencies
			ArrayList<Double> tileFrequencies = new ArrayList<Double>();
			NodeList tileFrequenciesNodeList = ((Element) doc
					.getElementsByTagName("TileFrequency").item(0))
					.getElementsByTagName("Tile");
			for (int i = 0; i < tileFrequenciesNodeList.getLength(); i++) {
				tileFrequencies.add(Double.parseDouble(tileFrequenciesNodeList
						.item(i).getAttributes().item(0).getNodeValue()));
			}

			// Get list of multiplier frequencies
			ArrayList<Double> multiplierFrequencies = new ArrayList<Double>();
			NodeList multiplierFrequenciesNodeList = ((Element) doc
					.getElementsByTagName("TileFrequency").item(0))
					.getElementsByTagName("Multiplier");
			for (int i = 0; i < multiplierFrequenciesNodeList.getLength(); i++) {
				multiplierFrequencies.add(Double
						.parseDouble(multiplierFrequenciesNodeList.item(i)
								.getAttributes().item(0).getNodeValue()));
			}

			// Get special move constraints
			int resetBoardMoves = Integer.parseInt(doc
					.getElementsByTagName("ResetBoard").item(0)
					.getTextContent());
			int swapTileMoves = Integer.parseInt(doc
					.getElementsByTagName("SwapTile").item(0).getTextContent());
			int removeTileMoves = Integer.parseInt(doc
					.getElementsByTagName("RemoveTile").item(0)
					.getTextContent());
			int otherMoveMoves = Integer
					.parseInt(doc.getElementsByTagName("OtherMove").item(0)
							.getTextContent());
			SpecialMoves specialMoves = new SpecialMoves(resetBoardMoves,
					swapTileMoves, removeTileMoves, otherMoveMoves);

			// Get point thresholds
			ArrayList<Integer> points = new ArrayList<Integer>();
			NodeList pointThresholdNodeList = ((Element) doc
					.getElementsByTagName("PointThresholds").item(0))
					.getElementsByTagName("Point");
			for (int i = 0; i < pointThresholdNodeList.getLength(); i++) {
				points.add(Integer.parseInt(pointThresholdNodeList.item(i)
						.getTextContent()));
			}

			PointThresholds pointThresholds = new PointThresholds(
					points.get(0), points.get(1), points.get(2));

			// Get regular move constraints
			int moveCount = Integer
					.parseInt(doc.getElementsByTagName("MoveCount").item(0)
							.getTextContent());
			int timer = Integer.parseInt(doc.getElementsByTagName("Timer")
					.item(0).getTextContent());

			// Get board shape and attributes
			Tile tiles[][] = new Tile[9][9];
			NodeList boardRowsNodeList = ((Element) doc.getElementsByTagName(
					"Board").item(0)).getElementsByTagName("Row");

			for (int i = 0; i < boardRowsNodeList.getLength(); i++) {
				String row = boardRowsNodeList.item(i).getTextContent();
				StringTokenizer rowTokenized = new StringTokenizer(row);
				int j = 0;
				while (rowTokenized.hasMoreTokens()) {
					char c = rowTokenized.nextToken().charAt(0);
					Tile t;
					if (c == 'N') {
						t = new NumberTile(1, 1);
					} else if (c == 'U') {
						t = new NullTile();
					} else if (c == 'T') {
						t = new TargetTile();
					} else if (c == 'S') {
						t = new SixTile();
					} else {
						throw new Exception("Invalid tile type.");
					}
					tiles[j][i] = t;
					j++;
				}
			}

			// Create level using all the information read
			if (levelType.toUpperCase().equals(LevelType.PUZZLE.toString())) {
				return new PuzzleLevel(tileFrequencies, multiplierFrequencies,
						levelName, tiles, pointThresholds, moveCount,
						specialMoves, levelNumber);
			} else if (levelType.toUpperCase().equals(
					LevelType.RELEASE.toString())) {
				return new ReleaseLevel(tileFrequencies, multiplierFrequencies,
						levelName, tiles, pointThresholds, moveCount,
						specialMoves, levelNumber);
			} else if (levelType.toUpperCase().equals(
					LevelType.LIGHTNING.toString())) {
				return new LightningLevel(tileFrequencies,
						multiplierFrequencies, levelName, tiles,
						pointThresholds, specialMoves, levelNumber, timer);
			} else if (levelType.toUpperCase().equals(
					LevelType.ELIMINATION.toString())) {
				return new EliminationLevel(tileFrequencies,
						multiplierFrequencies, levelName, tiles,
						pointThresholds, moveCount, specialMoves, levelNumber);
			} else {
				logger.log(Level.SEVERE,
						"Invalid level type on level file read.");
				throw new Exception("Invalid level type!");
			}

		} catch (Exception e) {
			logger.log(Level.WARNING, "Level file: " + fileName + " not found.");
		}

		return null;
	}

	/**
	 * Writes a level to an output file. File is stored in the "/userlevel/"
	 * directory.
	 *
	 * @param level
	 *            The level object to save to file.
	 * @return true if successful; false otherwise
	 */
	public static boolean levelToFile(GameLevel level) {
		try {
			if (level == null) {
				logger.log(Level.SEVERE, "Requested to write out null level.");
				throw new Exception("Cannot pass null level");
			}

			// Set up for creating XML hierarchy
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			// Root level of the hierarchy for the level information
			Element levelElement = doc.createElement("Level");
			doc.appendChild(levelElement);

			// Level number attribute
			Attr levelNumberAttr = doc.createAttribute("number");
			levelNumberAttr.setValue("" + level.getLevelNumber());
			levelElement.setAttributeNode(levelNumberAttr);

			// Level name element
			Element levelNameElement = doc.createElement("Name");
			levelNameElement.appendChild(doc.createTextNode(level.getName()));
			levelElement.appendChild(levelNameElement);

			// Level type element
			Element levelTypeElement = doc.createElement("Type");
			levelTypeElement.appendChild(doc.createTextNode(""
					+ level.getType().toString()));
			levelElement.appendChild(levelTypeElement);

			// Tile frequency element
			Element tileFrequencyElement = doc.createElement("TileFrequency");
			levelElement.appendChild(tileFrequencyElement);

			// Tile element / frequency attributes
			int number = 1;
			for (Double numberTileFrequency : level.getBoard()
					.getTileFrequencies()) {
				Element numberTileFrequencyElement = doc.createElement("Tile");

				Attr numberTileFrequencyAttr = doc.createAttribute("frequency");
				numberTileFrequencyAttr.setValue("" + numberTileFrequency);

				Attr numberTileNumberAttr = doc.createAttribute("number");
				numberTileNumberAttr.setValue("" + number);

				numberTileFrequencyElement
						.setAttributeNode(numberTileFrequencyAttr);
				numberTileFrequencyElement
						.setAttributeNode(numberTileNumberAttr);

				tileFrequencyElement.appendChild(numberTileFrequencyElement);

				number++;
			}

			// Multiplier element / frequency attributes
			int times = 1;
			for (Double multiplierTileFrequency : level.getBoard()
					.getMultiplierFrequencies()) {
				Element multiplierTileFrequencyElement = doc
						.createElement("Multiplier");

				Attr multiplierTileFrequencyAttr = doc
						.createAttribute("frequency");
				multiplierTileFrequencyAttr.setValue(""
						+ multiplierTileFrequency);

				Attr multiplierTileNumberAttr = doc.createAttribute("times");
				multiplierTileNumberAttr.setValue("" + times);

				multiplierTileFrequencyElement
						.setAttributeNode(multiplierTileFrequencyAttr);
				multiplierTileFrequencyElement
						.setAttributeNode(multiplierTileNumberAttr);

				tileFrequencyElement
						.appendChild(multiplierTileFrequencyElement);
				times++;
			}

			// Special move constraints element
			Element specialMoveConstraintsElement = doc
					.createElement("SpecialMoveConstraints");
			levelElement.appendChild(specialMoveConstraintsElement);

			// Reset board element / value
			Element resetBoardElement = doc.createElement("ResetBoard");
			resetBoardElement.appendChild(doc.createTextNode(""
					+ level.getSpecialMoves().getResetBoardCount()));
			specialMoveConstraintsElement.appendChild(resetBoardElement);

			// Swap tile element / value
			Element swapTileElement = doc.createElement("SwapTile");
			swapTileElement.appendChild(doc.createTextNode(""
					+ level.getSpecialMoves().getSwapTileCount()));
			specialMoveConstraintsElement.appendChild(swapTileElement);

			// Remove tile element / value
			Element removeTileElement = doc.createElement("RemoveTile");
			removeTileElement.appendChild(doc.createTextNode(""
					+ level.getSpecialMoves().getRemoveTileCount()));
			specialMoveConstraintsElement.appendChild(removeTileElement);

			// Other move element / value
			Element otherMoveElement = doc.createElement("OtherMove");
			otherMoveElement.appendChild(doc.createTextNode(""
					+ level.getSpecialMoves().getXStacySpecialMoveCount()));
			specialMoveConstraintsElement.appendChild(otherMoveElement);

			// Point thresholds element
			Element pointThresholdsElement = doc
					.createElement("PointThresholds");
			levelElement.appendChild(pointThresholdsElement);

			// Point one threshold element / value
			Element point1Element = doc.createElement("Point");
			point1Element.appendChild(doc.createTextNode(""
					+ level.getPointThresholds().getOneStarThreshold()));
			pointThresholdsElement.appendChild(point1Element);

			// Point two threshold element / value
			Element point2Element = doc.createElement("Point");
			point2Element.appendChild(doc.createTextNode(""
					+ level.getPointThresholds().getTwoStarThreshold()));
			pointThresholdsElement.appendChild(point2Element);

			// Point three threshold element / value
			Element point3Element = doc.createElement("Point");
			point3Element.appendChild(doc.createTextNode(""
					+ level.getPointThresholds().getThreeStarThreshold()));
			pointThresholdsElement.appendChild(point3Element);

			// Playing constraints element
			Element playingConstraintsElement = doc
					.createElement("PlayingConstraints");
			levelElement.appendChild(playingConstraintsElement);

			// Move count element / value
			Element moveCountElement = doc.createElement("MoveCount");
			moveCountElement.appendChild(doc.createTextNode(""
					+ level.getMoveCount()));
			playingConstraintsElement.appendChild(moveCountElement);

			// Timer element / value
			Element timerElement = doc.createElement("Timer");
			timerElement.appendChild(doc.createTextNode("" + level.getTimer()));
			playingConstraintsElement.appendChild(timerElement);

			// Board element
			Element boardElement = doc.createElement("Board");
			levelElement.appendChild(boardElement);

			// Row element / value
			Board board = level.getBoard();
			for (int i = 0; i < 9; i++) {
				String row = "";
				for (int j = 0; j < 9; j++) {
					row += instanceToChar(board.getSquare(j, i).getTile());
					if (j != 8) {
						row += " ";
					}
				}
				Element rowElement = doc.createElement("Row");
				rowElement.appendChild(doc.createTextNode(row));
				boardElement.appendChild(rowElement);
			}

			/*
			 * Write out the XML hierarchy to an actual file XML file name is
			 * level's number + ".xml"
			 */
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(XMLParser.USER_DIR
					+ level.getLevelNumber() + XMLParser.XML_EXT));
			transformer.transform(source, result);

			logger.log(Level.INFO, "Level file saved successfully.");

			return true;

		} catch (Exception e) {
			logger.log(Level.WARNING, "Level file not saved successfully.");
		}

		return false;
	}

	/**
	 * Takes in a file name and extracts the information from it to create a
	 * user profile.
	 *
	 * @param fileName
	 *            A String of the file name.
	 * @return UserProfile object for the user profile if exists; null otherwise
	 */
	public static UserProfile fileToUserProfile(String fileName) {
		try {
			// Set up XML file for reading
			File fXmlFile = new File(XMLParser.PROFILE_DIR + fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			// Get user Name
			String userName = doc.getElementsByTagName("UserProfile").item(0)
					.getAttributes().item(0).getNodeValue();

			UserProfile userProfile = new UserProfile(userName);

			// Get highest levels unlocked by user
			int highestStoryLevelUnlocked = Integer.parseInt(doc
					.getElementsByTagName("HighestStoryLevelUnlocked").item(0)
					.getTextContent());
			userProfile.setHighestStoryLevel(highestStoryLevelUnlocked);

			int highestUserLevelUnlocked = Integer.parseInt(doc
					.getElementsByTagName("HighestUserLevelUnlocked").item(0)
					.getTextContent());
			userProfile.setHighestUserLevel(highestUserLevelUnlocked);

			// Get list of badges that the user has unlocked
			ArrayList<String> badges = new ArrayList<String>();
			NodeList badgeNodeList = ((Element) doc.getElementsByTagName(
					"Badges").item(0)).getElementsByTagName("Name");
			for (int i = 0; i < badgeNodeList.getLength(); i++) {
				badges.add(badgeNodeList.item(i).getTextContent());
				userProfile.addBadgeEarned(badgeNodeList.item(i)
						.getTextContent());
			}

			// Get list of levels, their high scores, and their star equivalents
			NodeList levelScoreNodeList = ((Element) doc.getElementsByTagName(
					"LevelScores").item(0)).getElementsByTagName("Level");
			ArrayList<LevelHighScore> levelHighScores = new ArrayList<LevelHighScore>();
			for (int i = 0; i < levelScoreNodeList.getLength(); i++) {

				levelHighScores.add(new LevelHighScore(Integer
						.parseInt(levelScoreNodeList.item(i).getAttributes()
								.item(0).getTextContent()), Integer
						.parseInt(levelScoreNodeList.item(i).getAttributes()
								.item(1).getTextContent()), Integer
						.parseInt(levelScoreNodeList.item(i).getAttributes()
								.item(2).getTextContent()), MenuTypes
						.valueOf(levelScoreNodeList.item(i).getAttributes()
								.item(3).getTextContent())));

				userProfile.addLevelHighScore(
						Integer.parseInt(levelScoreNodeList.item(i)
								.getAttributes().item(0).getTextContent()),
						Integer.parseInt(levelScoreNodeList.item(i)
								.getAttributes().item(1).getTextContent()),
						Integer.parseInt(levelScoreNodeList.item(i)
								.getAttributes().item(2).getTextContent()),
						MenuTypes.valueOf(levelScoreNodeList.item(i)
								.getAttributes().item(3).getTextContent()));
			}

			// Get the aesthetic the player uses
			String aesthetic = doc.getElementsByTagName("Aesthetic").item(0)
					.getTextContent();

			userProfile.setAestheticName(aesthetic);

			logger.log(Level.INFO, "User profile file found and returned.");
			return userProfile;

		} catch (Exception e) {
			logger.log(Level.INFO, "User profile file not found.");
		}

		return null;
	}

	/**
	 * Writes a user profile to an output file.
	 *
	 * @param userProfile
	 *            The user profile to save to file.
	 * @return true if successful; false otherwise
	 */
	public static boolean userProfileToFile(UserProfile userProfile) {

		try {
			if (userProfile == null) {
				logger.log(Level.SEVERE, "Requested to save null user profile.");
				throw new Exception("Cannot pass null user profile.");
			}

			// Set up for creating XML hierarchy
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			// UserProfile tag
			Element userProfileElement = doc.createElement("UserProfile");
			doc.appendChild(userProfileElement);

			// User's name attribute
			Attr userNameAttr = doc.createAttribute("user");
			userNameAttr.setValue(userProfile.getUserName());
			userProfileElement.setAttributeNode(userNameAttr);

			// Highest levels unlocked tag/text
			Element highestStoryLevelUnlockedElement = doc
					.createElement("HighestStoryLevelUnlocked");
			highestStoryLevelUnlockedElement.appendChild(doc.createTextNode(""
					+ userProfile.getHighestStoryLevelUnlocked()));
			userProfileElement.appendChild(highestStoryLevelUnlockedElement);

			Element highestUserLevelUnlockedElement = doc
					.createElement("HighestUserLevelUnlocked");
			highestUserLevelUnlockedElement.appendChild(doc.createTextNode(""
					+ userProfile.getHighestUserLevelUnlocked()));
			userProfileElement.appendChild(highestUserLevelUnlockedElement);

			// Badges tag
			Element badgesElement = doc.createElement("Badges");
			userProfileElement.appendChild(badgesElement);

			// Badge's name tag/text
			for (String badgeString : userProfile.getBadgesEarned()) {
				Element badgeElement = doc.createElement("Name");
				badgeElement.appendChild(doc.createTextNode(badgeString));
				badgesElement.appendChild(badgeElement);
			}

			// Level Scores tag
			Element levelScoresElement = doc.createElement("LevelScores");
			userProfileElement.appendChild(levelScoresElement);

			// Level tag and attributes
			for (LevelHighScore lhs : userProfile.getLevelHighScore()) {

				Element levelElement = doc.createElement("Level");
				levelScoresElement.appendChild(levelElement);

				Attr levelAttr = doc.createAttribute("level");
				levelAttr.setValue("" + lhs.getLevel());
				levelElement.setAttributeNode(levelAttr);

				Attr scoreAttr = doc.createAttribute("score");
				scoreAttr.setValue("" + lhs.getHighScore());
				levelElement.setAttributeNode(scoreAttr);

				Attr starsAttr = doc.createAttribute("stars");
				starsAttr.setValue("" + lhs.getStars());
				levelElement.setAttributeNode(starsAttr);

				Attr typeAttr = doc.createAttribute("type");
				typeAttr.setValue("" + lhs.getLevelType());
				levelElement.setAttributeNode(typeAttr);
			}

			// Aesthetic tag/text
			Element aestheticElement = doc.createElement("Aesthetic");
			aestheticElement.appendChild(doc.createTextNode(userProfile
					.getAestheticName()));
			userProfileElement.appendChild(aestheticElement);

			/*
			 * Write out the xml hierarchy to an actual file xml file name is
			 * user's name + "Profile.xml"
			 */
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(
					XMLParser.PROFILE_DIR + userProfile.getUserName()
							+ XMLParser.PROFILE_CONST + XMLParser.XML_EXT));
			transformer.transform(source, result);

			logger.log(Level.INFO, "User profile file saved successfully.");

		} catch (Exception e) {
			logger.log(Level.INFO, "User profile file not saved successfully.");
		}

		return false;
	}
}
