package SixesWild.com.mimas.sixeswild.sixeswild;

import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
import SixesWild.com.mimas.sixeswild.entities.Level;
import SixesWild.com.mimas.sixeswild.entities.LevelHighScore;
import SixesWild.com.mimas.sixeswild.entities.LevelType;
import SixesWild.com.mimas.sixeswild.entities.LightningLevel;
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

public final class XMLParser {

	/**
	 * Gets the level name of the specified file.
	 * 
	 * @param fileName
	 *            The xml file that contains all the information for a singular
	 *            level.
	 * @return A String that is the level name taken from the specified file.
	 */
	public static String fileToLevelName(String fileName) {
		try {

			// Set up xml file for reading
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
			System.out.println("File Not Found!");
		}

		return null;
	}

	/**
	 * Takes in a file name and extracts the information from it to create a
	 * level.
	 * 
	 * @param fileName
	 *            A String of the file name.
	 * @return A level with all the attributes taken from the xml file.
	 */
	public static Level fileToLevel(String fileName) {
		try {

			// Set up xml file for reading
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			// ******* level number not used anywhere ???? ******
			// Get level number
			int levelNumber = Integer.parseInt(doc.getElementsByTagName("Level").item(0)
					.getAttributes().item(0).getNodeValue());

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
						throw new Exception("Invalid tile type!");
					}
					tiles[j][i] = t;
					j++;
				}
			}

			// Create level using all the information read
			if (levelType.equals("Puzzle")) {
				return new PuzzleLevel(tileFrequencies, multiplierFrequencies,
						LevelType.PUZZLE, levelName, tiles, pointThresholds,
						moveCount, specialMoves, levelNumber);
			} else if (levelType.equals("Release")) {
				return new ReleaseLevel(tileFrequencies, multiplierFrequencies,
						LevelType.RELEASE, levelName, tiles, pointThresholds,
						moveCount, specialMoves, levelNumber);
			} else if (levelType.equals("Lightning")) {
				return new LightningLevel(tileFrequencies,
						multiplierFrequencies, LevelType.LIGHTNING, levelName,
						tiles, pointThresholds, timer, specialMoves, levelNumber);
			} else if (levelType.equals("Elimination")) {
				return new EliminationLevel(tileFrequencies,
						multiplierFrequencies, LevelType.ELIMINATION,
						levelName, tiles, pointThresholds, moveCount,
						specialMoves, levelNumber);
			} else {
				throw new Exception("Invalid Level Type!");
			}

		} catch (Exception e) {
			System.out.println("File Not Found!");
		}

		return null;
	}

	/**
	 * Writes a level to an output file.
	 * 
	 * @param level
	 *            The level object to save to file.
	 * @return true if successful; false otherwise.
	 */
	public static boolean levelToFile(Level level) {
		try {
			if (level == null) {
				throw new Exception("Cannot Pass Null Level!");
			}

			// Set up for creating xml hierarchy
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
			levelTypeElement.appendChild(doc.createTextNode(XMLParser.levelTypeToParserType(""+level.getType())));
			levelElement.appendChild(levelTypeElement);
			
			// Tile frequency element
			Element tileFrequencyElement = doc.createElement("TileFrequency");
			levelElement.appendChild(tileFrequencyElement);
			
			// Tile element / frequency attributes
			int number = 1;
			for(Double numberTileFrequency: level.getBoard().getTileFrequencies()){
				Element numberTileFrequencyElement = doc.createElement("Tile");
				
				Attr numberTileFrequencyAttr = doc.createAttribute("frequency");
				numberTileFrequencyAttr.setValue("" + numberTileFrequency);
				
				Attr numberTileNumberAttr = doc.createAttribute("number");
				numberTileNumberAttr.setValue("" + number);
				
				numberTileFrequencyElement.setAttributeNode(numberTileFrequencyAttr);
				numberTileFrequencyElement.setAttributeNode(numberTileNumberAttr);
				
				tileFrequencyElement.appendChild(numberTileFrequencyElement);
				
				number++;
			}
			
			// Multiplier element / frequency attributes
			int times = 1;
			for(Double multiplierTileFrequency: level.getBoard().getMultiplierFrequencies()){
				if(times!=1){
					Element multiplierTileFrequencyElement = doc.createElement("Multiplier");
					
					Attr multiplierTileFrequencyAttr = doc.createAttribute("frequency");
					multiplierTileFrequencyAttr.setValue("" + multiplierTileFrequency);
					
					Attr multiplierTileNumberAttr = doc.createAttribute("times");
					multiplierTileNumberAttr.setValue("" + times);
					
					multiplierTileFrequencyElement.setAttributeNode(multiplierTileFrequencyAttr);
					multiplierTileFrequencyElement.setAttributeNode(multiplierTileNumberAttr);
					
					tileFrequencyElement.appendChild(multiplierTileFrequencyElement);
				}
				times++;
			}
			
			// Special move constraints element
			Element specialMoveConstraintsElement = doc.createElement("SpecialMoveConstraints");
			levelElement.appendChild(specialMoveConstraintsElement);
			
			// Reset board element / value
			Element resetBoardElement = doc.createElement("ResetBoard");
			resetBoardElement.appendChild(doc.createTextNode("" + level.getSpecialMoves().getResetBoardCount()));
			specialMoveConstraintsElement.appendChild(resetBoardElement);

			// Swap tile element / value
			Element swapTileElement = doc.createElement("SwapTile");
			swapTileElement.appendChild(doc.createTextNode("" + level.getSpecialMoves().getSwapTileCount()));
			specialMoveConstraintsElement.appendChild(swapTileElement);
			
			// Remove tile element / value
			Element removeTileElement = doc.createElement("RemoveTile");
			removeTileElement.appendChild(doc.createTextNode("" + level.getSpecialMoves().getRemoveTileCount()));
			specialMoveConstraintsElement.appendChild(removeTileElement);
			
			// Other move element / value
			Element otherMoveElement = doc.createElement("OtherMove");
			otherMoveElement.appendChild(doc.createTextNode("" + level.getSpecialMoves().getXStacySpecialMoveCount()));
			specialMoveConstraintsElement.appendChild(otherMoveElement);
			
			// Point thresholds element
			Element pointThresholdsElement = doc.createElement("PointThresholds");
			levelElement.appendChild(pointThresholdsElement);
			
			// Point one threshold element / value
			Element point1Element = doc.createElement("Point");
			point1Element.appendChild(doc.createTextNode("" + level.getPointThresholds().getOneStarThreshold()));
			pointThresholdsElement.appendChild(point1Element);

			// Point two threshold element / value
			Element point2Element = doc.createElement("Point");
			point2Element.appendChild(doc.createTextNode("" + level.getPointThresholds().getTwoStarThreshold()));
			pointThresholdsElement.appendChild(point2Element);
			
			// Point three threshold element / value
			Element point3Element = doc.createElement("Point");
			point3Element.appendChild(doc.createTextNode("" + level.getPointThresholds().getThreeStarThreshold()));
			pointThresholdsElement.appendChild(point3Element);
			
			// Playing constraints element
			Element playingConstraintsElement = doc.createElement("PlayingConstraints");
			levelElement.appendChild(playingConstraintsElement);
			
			// Move count element / value
			Element moveCountElement = doc.createElement("MoveCount");
			moveCountElement.appendChild(doc.createTextNode("" + level.getMoveCount()));
			playingConstraintsElement.appendChild(moveCountElement);
			
			// Timer element / value
			Element timerElement = doc.createElement("Timer");
			if(level.getTimer() == null){
				timerElement.appendChild(doc.createTextNode("0"));
			}
			else{
				timerElement.appendChild(doc.createTextNode("" + level.getTimer().getDelay()));
			}
			playingConstraintsElement.appendChild(timerElement);
			
			// Board element
			Element boardElement = doc.createElement("Board");
			levelElement.appendChild(boardElement);
			
			// Row element / value
			Board board = level.getBoard();
			for(int i = 0; i < 9; i++){
				String row = "";
				for(int j = 0; j < 9; j++){
					row += instanceToChar(board.getSquare(j, i).getTile());
					if(j != 8){
						row += " ";
					}
				}
				Element rowElement = doc.createElement("Row");
				rowElement.appendChild(doc.createTextNode(row));
				boardElement.appendChild(rowElement);
			}
			
			/*
			 * Write out the xml hierarchy to an actual file xml file name is
			 * level's number + ".xml"
			 */
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(
					level.getLevelNumber() + ".xml"));
			transformer.transform(source, result);

			System.out.println("File saved!");
			
			return true;

		} catch (Exception e) {
			System.out.println("File Not Saved!");
		}

		return false;
	}

	/**
	 * Takes in a file name and extracts the information from it to create a
	 * user profile.
	 * 
	 * @param fileName
	 *            A String of the file name.
	 * @return A UserProfile with all the attributes taken from the xml file.
	 */
	public static UserProfile fileToUserProfile(String fileName) {
		try {
			// Set up xml file for reading
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			// Get user Name
			String userName = doc.getElementsByTagName("UserProfile").item(0)
					.getAttributes().item(0).getNodeValue();

			UserProfile userProfile = new UserProfile(userName);

			// Get highest level unlocked by user
			int highestLevelUnlocked = Integer.parseInt(doc
					.getElementsByTagName("HighestLevelUnlocked").item(0)
					.getTextContent());
			userProfile.setHighestLevel(highestLevelUnlocked);

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
								.item(2).getTextContent())));

				userProfile.addLevelHighScore(
						Integer.parseInt(levelScoreNodeList.item(i)
								.getAttributes().item(0).getTextContent()),
						Integer.parseInt(levelScoreNodeList.item(i)
								.getAttributes().item(1).getTextContent()),
						Integer.parseInt(levelScoreNodeList.item(i)
								.getAttributes().item(2).getTextContent()));
			}

			// Get the aesthetic the player uses
			String aesthetic = doc.getElementsByTagName("Aesthetic").item(0)
					.getTextContent();

			userProfile.setAestheticName(aesthetic);

			return userProfile;

		} catch (Exception e) {
			System.out.println("File Not Found!");
		}

		return null;
	}

	/**
	 * Writes a user profile to an output file.
	 * 
	 * @param userProfile
	 *            The user profile to save to file.
	 * @return true if successful; false otherwise.
	 * @throws Exception
	 */
	public static boolean userProfileToFile(UserProfile userProfile) {

		try {
			if (userProfile == null) {
				throw new Exception("Cannot Pass Null UserProfile!");
			}

			// Set up for creating xml hierarchy
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

			// Highest level unlocked tag/text
			Element highestLevelUnlockedElement = doc
					.createElement("HighestLevelUnlocked");
			highestLevelUnlockedElement.appendChild(doc.createTextNode(""
					+ userProfile.getHighestUnlockedLevel()));
			userProfileElement.appendChild(highestLevelUnlockedElement);

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
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(
					userProfile.getUserName() + "Profile.xml"));
			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (Exception e) {
			System.out.println("File Not Saved!");
		}

		return false;
	}
	
	private static String levelTypeToParserType(String type) throws Exception{
		if(type.equals("PUZZLE")){
			return "Puzzle";
		}
		else if(type.equals("RELEASE")){
			return "Release";
		}
		else if(type.equals("ELIMINATION")){
			return "Elimination";
		}
		else if(type.equals("LIGHTNING")){
			return "Lightning";
		}
		else{
			throw new Exception("Type Given Is Not Supported!");
		}
	}
	
	private static char instanceToChar(Tile tile) throws Exception{
		if(tile.getType().equals(TileType.NUMBER)){
			return 'N';
		}
		else if(tile.getType().equals(TileType.NULL)){
			return 'U';
		}
		else if(tile.getType().equals(TileType.SIX)){
			return 'S';
		}
		else if(tile.getType().equals(TileType.TARGET)){
			return 'T';
		}
		else{
			throw new Exception("Invalid Tile Type!");
		}
	}
	
	public static void main(String[] args) {
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
				tiles[i][j] = new NumberTile(3, 2);
			}
		}

		PuzzleLevel level;
		try {
			level = new PuzzleLevel(tileFreq, multFreq, levelType, levelName,
					tiles, pointThresholds, 50, specialMoves, levelNumber);
			XMLParser.levelToFile(level);
		} catch (Exception e1){
			
		}	
	}
}
