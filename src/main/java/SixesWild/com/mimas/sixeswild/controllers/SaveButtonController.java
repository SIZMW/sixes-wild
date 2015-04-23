package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;
import SixesWild.com.mimas.sixeswild.boundaries.BuilderSettingsPanel;
import SixesWild.com.mimas.sixeswild.entities.EliminationLevel;
import SixesWild.com.mimas.sixeswild.entities.Level;
import SixesWild.com.mimas.sixeswild.entities.LevelType;
import SixesWild.com.mimas.sixeswild.entities.LightningLevel;
import SixesWild.com.mimas.sixeswild.entities.PointThresholds;
import SixesWild.com.mimas.sixeswild.entities.PuzzleLevel;
import SixesWild.com.mimas.sixeswild.entities.ReleaseLevel;
import SixesWild.com.mimas.sixeswild.entities.SpecialMoves;
import SixesWild.com.mimas.sixeswild.entities.Tile;
import SixesWild.com.mimas.sixeswild.sixeswild.XMLParser;

public class SaveButtonController implements ActionListener {

	private static final Logger logger = Logger.getGlobal();
	BuilderApplication app;

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
		Level newLevel;

		// Print Out the Level Name
		String levelName = bsp.getUserLevelNameTextField().getText();

		// Determine the levelNumber
		int levelNumber;
		if (app.getBuilderView().getBuilderTopPanel().getUserLevelList()
				.contains(levelName)) {
			levelNumber = app.getBuilderView().getBuilderTopPanel()
					.getUserLevelList().indexOf(levelName) + 1;
		} else {
			levelNumber = app.getBuilderView().getBuilderTopPanel()
					.getUserLevelList().size() + 1;
		}

		// Print Out the Level Type
		String levelType = bsp.getLevelTypeComboBox().getSelectedItem()
				.toString();

		// Print Out the Moves
		int moveCount = Integer.parseInt(bsp.getMovesTextField().getText());

		// Print Out Timer
		int timerCount = Integer.parseInt(bsp.getTimerTextField().getText());

		// Print Out Frequency of Tiles Grid
		Double tf1, tf2, tf3, tf4, tf5, tf6;
		tf1 = Double.parseDouble(bsp.getOnesTextField().getText());
		tf2 = Double.parseDouble(bsp.getTwosTextField().getText());
		tf3 = Double.parseDouble(bsp.getThreesTextField().getText());
		tf4 = Double.parseDouble(bsp.getFoursTextField().getText());
		tf5 = Double.parseDouble(bsp.getFivesTextField().getText());
		tf6 = Double.parseDouble(bsp.getSixesTextField().getText());
		ArrayList<Double> tileFreq = new ArrayList<Double>();
		tileFreq.add(tf1);
		tileFreq.add(tf2);
		tileFreq.add(tf3);
		tileFreq.add(tf4);
		tileFreq.add(tf5);
		tileFreq.add(tf6);

		// Print Out Frequency of Multiplier Grid
		Double mf1, mf2, mf3;
		mf2 = Double.parseDouble(bsp.xtwoMultiplierTextField().getText());
		mf3 = Double.parseDouble(bsp.xthreeMultiplierTextField().getText());
		mf1 = (1.00 - ((mf2) + (mf3)));
		ArrayList<Double> multFreq = new ArrayList<Double>();
		multFreq.add(mf1);
		multFreq.add(mf2);
		multFreq.add(mf3);

		// Print Out Special Moves Counts
		int m1, m2, m3, m4;
		m1 = Integer.parseInt(bsp.getSpecialMoveOneLabel().getText());
		m2 = Integer.parseInt(bsp.getSpecialMoveTwoLabel().getText());
		m3 = Integer.parseInt(bsp.getSpecialMoveThreeLabel().getText());
		m4 = Integer.parseInt(bsp.getSpecialMoveFourLabel().getText());
		SpecialMoves specialMoves = new SpecialMoves(m1, m2, m3, m4);

		// Print Out Score CutOffs
		int s1, s2, s3;
		s1 = Integer.parseInt(bsp.getOneStarScoreTextField().getText());
		s2 = Integer.parseInt(bsp.getTwoStarScoreTextField().getText());
		s3 = Integer.parseInt(bsp.getThreeStarScoreTextField().getText());
		PointThresholds pointThresholds = new PointThresholds(s1, s2, s3);

		// Print Out a Grid Version of the Level
		// N - Number
		// U - Null
		// T - Target
		// S - Six
		Tile tiles[][] = new Tile[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				tiles[i][j] = app.getBuilderView().getBoardViewPanel()
						.getBoard().getSquare(i, j).getTile();
			}
		}

		if (levelType.equals(LevelType.PUZZLE.toString())) {
			try {
				newLevel = new PuzzleLevel(tileFreq, multFreq,
						LevelType.PUZZLE, levelName, tiles, pointThresholds,
						moveCount, specialMoves, levelNumber);
				XMLParser.levelToFile(newLevel);
			} catch (Exception e1) {
				logger.log(java.util.logging.Level.WARNING,
						"Level creation failed.");
				e1.printStackTrace();
			}
		} else if (levelType.equals(LevelType.ELIMINATION.toString())) {
			try {
				newLevel = new EliminationLevel(tileFreq, multFreq,
						LevelType.ELIMINATION, levelName, tiles,
						pointThresholds, moveCount, specialMoves, levelNumber);
				XMLParser.levelToFile(newLevel);
			} catch (Exception e1) {
				logger.log(java.util.logging.Level.WARNING,
						"Level creation failed.");
				e1.printStackTrace();
			}
		} else if (levelType.equals(LevelType.RELEASE.toString())) {
			try {
				newLevel = new ReleaseLevel(tileFreq, multFreq,
						LevelType.RELEASE, levelName, tiles, pointThresholds,
						moveCount, specialMoves, levelNumber);
				XMLParser.levelToFile(newLevel);
			} catch (Exception e1) {
				logger.log(java.util.logging.Level.WARNING,
						"Level creation failed.");
				e1.printStackTrace();
			}
		} else {
			try {
				newLevel = new LightningLevel(tileFreq, multFreq,
						LevelType.LIGHTNING, levelName, tiles, pointThresholds,
						timerCount, specialMoves, levelNumber);
				XMLParser.levelToFile(newLevel);
			} catch (Exception e1) {
				logger.log(java.util.logging.Level.WARNING,
						"Level creation failed.");
				e1.printStackTrace();
			}
		}

		// Update the level lists
		this.app.getBuilderView().getBuilderTopPanel().clearComboBoxes();
		this.app.getBuilderView().getBuilderTopPanel().updateComboBoxes();
	}
}
