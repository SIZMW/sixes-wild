package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;
import SixesWild.com.mimas.sixeswild.boundaries.BuilderSettingsPanel;
import SixesWild.com.mimas.sixeswild.entities.EliminationLevel;
import SixesWild.com.mimas.sixeswild.entities.GameLevel;
import SixesWild.com.mimas.sixeswild.entities.LevelType;
import SixesWild.com.mimas.sixeswild.entities.LightningLevel;
import SixesWild.com.mimas.sixeswild.entities.PointThresholds;
import SixesWild.com.mimas.sixeswild.entities.PuzzleLevel;
import SixesWild.com.mimas.sixeswild.entities.ReleaseLevel;
import SixesWild.com.mimas.sixeswild.entities.SpecialMoves;
import SixesWild.com.mimas.sixeswild.entities.Tile;
import SixesWild.com.mimas.sixeswild.util.XMLParser;

/**
 * This controller handles saving the builder level to a file when the save
 * button is pressed.
 *
 * @author Cameron Jones, Aditya Nivarthi
 */
public class SaveButtonController implements ActionListener {

	private static final Logger logger = Logger.getGlobal();

	protected BuilderApplication app;

	/**
	 * Creates a SaveButtonController instance with the specified
	 * BuilderApplication.
	 *
	 * @param app
	 *            The BuilderApplication currently running.
	 */
	public SaveButtonController(BuilderApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		BuilderSettingsPanel bsp = app.getBuilderView()
				.getBuilderSettingsPanel();
		GameLevel newLevel;

		// Level name
		String levelName = bsp.getUserLevelNameTextField().getText();

		// Determine the level number
		int levelNumber;
		if (app.getBuilderView().getBuilderTopPanel().getUserLevelList()
				.contains(levelName)) {
			levelNumber = app.getBuilderView().getBuilderTopPanel()
					.getUserLevelList().indexOf(levelName) + 1;
		} else {
			levelNumber = app.getBuilderView().getBuilderTopPanel()
					.getUserLevelList().size() + 1;
		}

		// Level type
		String levelType = bsp.getLevelTypeComboBox().getSelectedItem()
				.toString();

		// Move count
		int moveCount = 5;

		try {
			moveCount = (Math.abs(Integer.parseInt(bsp.getMovesTextField()
					.getText())) > 0) ? Math.abs(Integer.parseInt(bsp
					.getMovesTextField().getText())) : moveCount;
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse move count. Reverting to stock value of: "
							+ moveCount);
		}

		// Timer
		int timerCount = 5;

		try {
			timerCount = (Math.abs(Integer.parseInt(bsp.getTimerTextField()
					.getText())) > 10) ? Math.abs(Integer.parseInt(bsp
					.getTimerTextField().getText())) : timerCount;
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse timer count. Reverting to stock value of: "
							+ timerCount);
		}

		// Tile frequencies
		Double tf1, tf2, tf3, tf4, tf5, tf6;
		tf1 = 0.0;
		tf2 = 0.0;
		tf3 = 0.0;
		tf4 = 0.0;
		tf5 = 0.0;
		tf6 = 0.0;

		try {
			tf1 = Math
					.abs(Double.parseDouble(bsp.getOnesTextField().getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse tile frequency 1. Reverting to stock value of: "
							+ tf1);
		}

		try {
			tf2 = Math
					.abs(Double.parseDouble(bsp.getTwosTextField().getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse tile frequency 2. Reverting to stock value of: "
							+ tf2);
		}

		try {
			tf3 = Math.abs(Double.parseDouble(bsp.getThreesTextField()
					.getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse tile frequency 3. Reverting to stock value of: "
							+ tf3);
		}

		try {
			tf4 = Math.abs(Double
					.parseDouble(bsp.getFoursTextField().getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse tile frequency 4. Reverting to stock value of: "
							+ tf4);
		}

		try {
			tf5 = Math.abs(Double
					.parseDouble(bsp.getFivesTextField().getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse tile frequency 5. Reverting to stock value of: "
							+ tf5);
		}

		try {
			tf6 = Math.abs(Double
					.parseDouble(bsp.getSixesTextField().getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse tile frequency 6. Reverting to stock value of: "
							+ tf6);
		}

		ArrayList<Double> tileFreq = new ArrayList<Double>();
		tileFreq.add(tf1);
		tileFreq.add(tf2);
		tileFreq.add(tf3);
		tileFreq.add(tf4);
		tileFreq.add(tf5);
		tileFreq.add(tf6);

		// Multiplier frequencies
		Double mf1, mf2, mf3;
		mf2 = 0.0;
		mf3 = 0.0;

		try {
			mf2 = Math.abs(Double.parseDouble(bsp.getTwoMultiplierTextField()
					.getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse multiplier frequency 2. Reverting to stock value of: "
							+ mf2);
		}

		try {
			mf3 = Math.abs(Double.parseDouble(bsp.getThreeMultiplierTextField()
					.getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse multiplier frequency 3. Reverting to stock value of: "
							+ mf3);
		}

		mf1 = (1.00 - ((mf2) + (mf3)));
		ArrayList<Double> multFreq = new ArrayList<Double>();
		multFreq.add(mf1);
		multFreq.add(mf2);
		multFreq.add(mf3);

		// Special move counts
		int m1, m2, m3, m4;
		m1 = Integer.parseInt(bsp.getSpecialMoveOneLabel().getText());
		m2 = Integer.parseInt(bsp.getSpecialMoveTwoLabel().getText());
		m3 = Integer.parseInt(bsp.getSpecialMoveThreeLabel().getText());
		m4 = Integer.parseInt(bsp.getSpecialMoveFourLabel().getText());
		SpecialMoves specialMoves = new SpecialMoves(m1, m2, m3, m4);

		// Point thresholds
		int s1, s2, s3;
		s1 = 100;
		s2 = 1000;
		s3 = 10000;

		try {
			s1 = Math.abs(Integer.parseInt(bsp.getOneStarScoreTextField()
					.getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse point threshold 1. Reverting to stock value of: "
							+ s1);
		}

		try {
			s2 = Math.abs(Integer.parseInt(bsp.getTwoStarScoreTextField()
					.getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse point threshold 2. Reverting to stock value of: "
							+ s2);
		}

		try {
			s3 = Math.abs(Integer.parseInt(bsp.getThreeStarScoreTextField()
					.getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse point threshold 3. Reverting to stock value of: "
							+ s3);
		}

		PointThresholds pointThresholds = new PointThresholds(s1, s2, s3);

		Tile tiles[][] = new Tile[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				tiles[i][j] = app.getBuilderView().getBoardViewPanel()
						.getBoard().getSquare(i, j).getTile();
			}
		}

		// Create the level object of the specified level type
		if (levelType.equals(LevelType.PUZZLE.toString())) {
			try {
				newLevel = new PuzzleLevel(tileFreq, multFreq, levelName,
						tiles, pointThresholds, moveCount, specialMoves,
						levelNumber);
				XMLParser.levelToFile(newLevel);
			} catch (Exception e1) {
				logger.log(Level.WARNING, "Puzzle level creation failed.");
			}
		} else if (levelType.equals(LevelType.ELIMINATION.toString())) {
			try {
				newLevel = new EliminationLevel(tileFreq, multFreq, levelName,
						tiles, pointThresholds, moveCount, specialMoves,
						levelNumber);
				XMLParser.levelToFile(newLevel);
			} catch (Exception e1) {
				logger.log(Level.WARNING, "Elimination level creation failed.");
			}
		} else if (levelType.equals(LevelType.RELEASE.toString())) {
			try {
				newLevel = new ReleaseLevel(tileFreq, multFreq, levelName,
						tiles, pointThresholds, moveCount, specialMoves,
						levelNumber);
				XMLParser.levelToFile(newLevel);
			} catch (Exception e1) {
				logger.log(Level.WARNING, "Release level creation failed.");
			}
		} else {
			try {
				newLevel = new LightningLevel(tileFreq, multFreq, levelName,
						tiles, pointThresholds, timerCount, specialMoves,
						levelNumber);
				XMLParser.levelToFile(newLevel);
			} catch (Exception e1) {
				logger.log(Level.WARNING, "Lightning level creation failed.");
			}
		}

		// Update the level lists
		app.getBuilderView().getBuilderTopPanel().clearComboBoxes();
		app.getBuilderView().getBuilderTopPanel().updateComboBoxes();
	}
}
