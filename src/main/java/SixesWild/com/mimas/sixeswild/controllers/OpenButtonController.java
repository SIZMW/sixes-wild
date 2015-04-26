package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.BoardViewPanel;
import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;
import SixesWild.com.mimas.sixeswild.entities.Board;
import SixesWild.com.mimas.sixeswild.entities.GameLevel;
import SixesWild.com.mimas.sixeswild.entities.Tile;
import SixesWild.com.mimas.sixeswild.sixeswild.XMLParser;

/**
 * This controller handles opening a level from a file when the open button is
 * pressed.
 * 
 * @author Cameron Jones
 */
public class OpenButtonController implements ActionListener {

	private static final Logger logger = Logger.getGlobal();

	protected BuilderApplication app;

	/**
	 * Creates a OpenButtonController instance with the specified
	 * BuilderApplication.
	 * 
	 * @param app
	 *            The BuilderApplication currently running.
	 */
	public OpenButtonController(BuilderApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		// Create level from file
		GameLevel openedLevel = XMLParser.fileToLevel(XMLParser.USER_DIR
				+ (app.getBuilderView().getBuilderTopPanel().getOpenComboBox()
						.getSelectedIndex() + 1) + ".xml");

		// Populate board
		Board newBoard = new Board();
		Tile newTiles[][] = new Tile[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				newTiles[i][j] = openedLevel.getBoard().getSquare(i, j)
						.getTile();
			}
		}

		// Create tile frequencies
		ArrayList<Double> tileFreq = openedLevel.getBoard()
				.getTileFrequencies();

		// Create multiplier frequencies
		ArrayList<Double> multFreq = openedLevel.getBoard()
				.getMultiplierFrequencies();

		try {
			newBoard = new Board(newTiles, tileFreq, multFreq);
		} catch (Exception exc) {
			logger.log(Level.WARNING,
					"Board failed to be initialized on builder level loading.");
		}

		// Add panel to view
		this.app.getBuilderView().updateBoardViewPanel(
				new BoardViewPanel(newBoard, app.getAesthetic()));
		this.app.getBuilderView()
				.getBoardViewPanel()
				.addMouseListener(new BuilderBoardViewMouseController(this.app));

		// Settings Panel
		app.getBuilderView().getBuilderSettingsPanel()
				.getUserLevelNameTextField().setText(openedLevel.getName());
		app.getBuilderView().getBuilderSettingsPanel().getLevelTypeComboBox()
				.setSelectedItem(openedLevel.getType().toString());
		app.getBuilderView().getBuilderSettingsPanel().getMovesTextField()
				.setText(Integer.toString(openedLevel.getMoveCount()));

		// app.getBuilderView().getBuilderSettingsPanel().getTimerTextField().setText(Integer.toString(openedLevel.getTimer()));

		app.getBuilderView()
				.getBuilderSettingsPanel()
				.getOnesTextField()
				.setText(
						Double.toString(openedLevel.getBoard()
								.getTileFrequencies().get(0)));
		app.getBuilderView()
				.getBuilderSettingsPanel()
				.getTwosTextField()
				.setText(
						Double.toString(openedLevel.getBoard()
								.getTileFrequencies().get(1)));
		app.getBuilderView()
				.getBuilderSettingsPanel()
				.getThreesTextField()
				.setText(
						Double.toString(openedLevel.getBoard()
								.getTileFrequencies().get(2)));
		app.getBuilderView()
				.getBuilderSettingsPanel()
				.getFoursTextField()
				.setText(
						Double.toString(openedLevel.getBoard()
								.getTileFrequencies().get(3)));
		app.getBuilderView()
				.getBuilderSettingsPanel()
				.getFivesTextField()
				.setText(
						Double.toString(openedLevel.getBoard()
								.getTileFrequencies().get(4)));
		app.getBuilderView()
				.getBuilderSettingsPanel()
				.getSixesTextField()
				.setText(
						Double.toString(openedLevel.getBoard()
								.getTileFrequencies().get(5)));
		app.getBuilderView()
				.getBuilderSettingsPanel()
				.getTwoMultiplierTextField()
				.setText(
						Double.toString(openedLevel.getBoard()
								.getMultiplierFrequencies().get(1)));
		app.getBuilderView()
				.getBuilderSettingsPanel()
				.getThreeMultiplierTextField()
				.setText(
						Double.toString(openedLevel.getBoard()
								.getMultiplierFrequencies().get(2)));
		app.getBuilderView()
				.getBuilderSettingsPanel()
				.getSpecialMoveOneLabel()
				.setText(
						Integer.toString(openedLevel.getSpecialMoves()
								.getResetBoardCount()));
		app.getBuilderView()
				.getBuilderSettingsPanel()
				.getSpecialMoveTwoLabel()
				.setText(
						Integer.toString(openedLevel.getSpecialMoves()
								.getSwapTileCount()));
		app.getBuilderView()
				.getBuilderSettingsPanel()
				.getSpecialMoveThreeLabel()
				.setText(
						Integer.toString(openedLevel.getSpecialMoves()
								.getRemoveTileCount()));
		app.getBuilderView()
				.getBuilderSettingsPanel()
				.getSpecialMoveFourLabel()
				.setText(
						Integer.toString(openedLevel.getSpecialMoves()
								.getXStacySpecialMoveCount()));
		app.getBuilderView()
				.getBuilderSettingsPanel()
				.getOneStarScoreTextField()
				.setText(
						Integer.toString(openedLevel.getPointThresholds()
								.getOneStarThreshold()));
		app.getBuilderView()
				.getBuilderSettingsPanel()
				.getTwoStarScoreTextField()
				.setText(
						Integer.toString(openedLevel.getPointThresholds()
								.getTwoStarThreshold()));
		app.getBuilderView()
				.getBuilderSettingsPanel()
				.getThreeStarScoreTextField()
				.setText(
						Integer.toString(openedLevel.getPointThresholds()
								.getThreeStarThreshold()));

		// Refresh Everything
		this.app.getBuilderView().repaint();
	}
}
