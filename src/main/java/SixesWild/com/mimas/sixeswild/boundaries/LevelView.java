package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.entities.Aesthetic;
import SixesWild.com.mimas.sixeswild.entities.Board;
import SixesWild.com.mimas.sixeswild.entities.GameLevel;
import SixesWild.com.mimas.sixeswild.entities.LevelType;
import SixesWild.com.mimas.sixeswild.entities.NumberTile;
import SixesWild.com.mimas.sixeswild.entities.Tile;

/**
 * This class represents the overall view for the level playing view.
 * 
 * @author Cameron Jones
 */
public class LevelView extends JPanel {

	private static final Logger logger = Logger.getGlobal();
	private static final long serialVersionUID = 1L;

	protected LevelTopPanel levelTopPanel;
	protected LevelStatsPanel levelStatsPanel;
	protected BoardViewPanel boardViewPanel;
	protected Aesthetic levelViewAesthetic;
	protected GameLevel currentLevel;
	protected int currentScore;

	/**
	 * Creates a LevelView instance with the specified aesthetic.
	 * 
	 * @param aesthetic
	 *            The aesthetic to use for this view.
	 */
	public LevelView(Aesthetic aesthetic) {

		// Attributes
		this.currentLevel = null;
		logger.log(Level.INFO, "Current level set to NULL");
		this.levelViewAesthetic = aesthetic;

		// Layout for view
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 5.0, 15.0, 5.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 10.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Top menu panel
		levelTopPanel = new LevelTopPanel();

		// Layout for top menu panel
		GridBagLayout gridBagLayout_1 = (GridBagLayout) levelTopPanel
				.getLayout();
		gridBagLayout_1.columnWeights = new double[] { 0.0, 10000.0, 0.0, 20.0,
				0.0, 20.0, 0.0, 20.0, 0.0, 20.0, 0.0, 20.0, 0.0 };
		gridBagLayout_1.columnWidths = new int[] { 10, 0, 10, 0, 10, 0, 10, 0,
				10, 0, 10, 0, 10 };
		levelTopPanel.getExitLevelButton().setPreferredSize(
				new Dimension(100, 20));
		levelTopPanel.getXStacyMoveButton().setPreferredSize(
				new Dimension(100, 20));
		levelTopPanel.getRemoveTileButton().setPreferredSize(
				new Dimension(100, 20));
		levelTopPanel.getSwapTileButton().setPreferredSize(
				new Dimension(100, 20));
		levelTopPanel.getResetBoardButton().setPreferredSize(
				new Dimension(100, 20));
		levelTopPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		GridBagConstraints gbc_topMenuPanel = new GridBagConstraints();
		gbc_topMenuPanel.gridwidth = 4;
		gbc_topMenuPanel.insets = new Insets(0, 0, 0, 0);
		gbc_topMenuPanel.fill = GridBagConstraints.BOTH;
		gbc_topMenuPanel.gridx = 0;
		gbc_topMenuPanel.gridy = 0;
		add(levelTopPanel, gbc_topMenuPanel);

		// Level stats panel
		levelStatsPanel = new LevelStatsPanel();
		levelStatsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		// Layout for level stats panel
		GridBagConstraints gbc_leftMenuPanel = new GridBagConstraints();
		gbc_leftMenuPanel.insets = new Insets(0, 0, 0, 0);
		gbc_leftMenuPanel.fill = GridBagConstraints.BOTH;
		gbc_leftMenuPanel.gridx = 0;
		gbc_leftMenuPanel.gridy = 1;
		add(levelStatsPanel, gbc_leftMenuPanel);

		// Temporary generation for frequency based board.
		ArrayList<Double> tileFrequencies = new ArrayList<Double>(
				Arrays.asList(.1, .2, .3, .3, .05, .05));
		ArrayList<Double> multiplierFrequencies = new ArrayList<Double>(
				Arrays.asList(.5, .25, .25));
		Tile tiles[][] = new Tile[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				tiles[i][j] = new NumberTile(3, 2);
			}
		}

		try {
			Board board = new Board(tiles, tileFrequencies,
					multiplierFrequencies);
			// Board view panel
			boardViewPanel = new BoardViewPanel(board, this.levelViewAesthetic);
			boardViewPanel.setBorder(BorderFactory
					.createLineBorder(Color.black));

			// Layout for board view panel
			GridBagConstraints gbc_boardView = new GridBagConstraints();
			gbc_boardView.insets = new Insets(0, 0, 0, 0);
			gbc_boardView.fill = GridBagConstraints.BOTH;
			gbc_boardView.gridx = 2;
			gbc_boardView.gridy = 1;
			add(boardViewPanel, gbc_boardView);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Received null error on board creation.",
					e);
		}

	}

	/**
	 * Creates a LevelView instance with the specified aesthetic and level.
	 * 
	 * @param aesthetic
	 *            The aesthetic to use for this view.
	 * @param newLevel
	 *            The level to populate in this view.
	 */
	public LevelView(Aesthetic aesthetic, GameLevel newLevel) {

		// Attributes
		this.levelViewAesthetic = aesthetic;
		this.currentLevel = newLevel;
		this.currentScore = 0;

		// Layout for view
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 5.0, 15.0, 5.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 10.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Top menu panel
		levelTopPanel = new LevelTopPanel();
		levelTopPanel.setLevelNameTextField(newLevel.getName());

		// Layout for top menu panel
		GridBagLayout gridBagLayout_1 = (GridBagLayout) levelTopPanel
				.getLayout();
		gridBagLayout_1.columnWeights = new double[] { 0.0, 10000.0, 0.0, 20.0,
				0.0, 20.0, 0.0, 20.0, 0.0, 20.0, 0.0, 20.0, 0.0 };
		gridBagLayout_1.columnWidths = new int[] { 10, 0, 10, 0, 10, 0, 10, 0,
				10, 0, 10, 0, 10 };
		levelTopPanel.getExitLevelButton().setPreferredSize(
				new Dimension(100, 20));
		levelTopPanel.getXStacyMoveButton().setPreferredSize(
				new Dimension(100, 20));
		levelTopPanel.getRemoveTileButton().setPreferredSize(
				new Dimension(100, 20));
		levelTopPanel.getSwapTileButton().setPreferredSize(
				new Dimension(100, 20));
		levelTopPanel.getResetBoardButton().setPreferredSize(
				new Dimension(100, 20));
		levelTopPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		GridBagConstraints gbc_topMenuPanel = new GridBagConstraints();
		gbc_topMenuPanel.gridwidth = 4;
		gbc_topMenuPanel.insets = new Insets(0, 0, 0, 0);
		gbc_topMenuPanel.fill = GridBagConstraints.BOTH;
		gbc_topMenuPanel.gridx = 0;
		gbc_topMenuPanel.gridy = 0;
		add(levelTopPanel, gbc_topMenuPanel);

		// Level stats panel
		levelStatsPanel = new LevelStatsPanel(newLevel.getMoveCount());
		levelStatsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		// Layout for level stats panel
		GridBagConstraints gbc_leftMenuPanel = new GridBagConstraints();
		gbc_leftMenuPanel.insets = new Insets(0, 0, 0, 0);
		gbc_leftMenuPanel.fill = GridBagConstraints.BOTH;
		gbc_leftMenuPanel.gridx = 0;
		gbc_leftMenuPanel.gridy = 1;
		add(levelStatsPanel, gbc_leftMenuPanel);

		Board board = newLevel.getBoard();
		// Board view panel
		boardViewPanel = new BoardViewPanel(board, this.levelViewAesthetic);
		boardViewPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		// Layout for board view panel
		GridBagConstraints gbc_boardView = new GridBagConstraints();
		gbc_boardView.insets = new Insets(0, 0, 0, 0);
		gbc_boardView.fill = GridBagConstraints.BOTH;
		gbc_boardView.gridx = 2;
		gbc_boardView.gridy = 1;
		add(boardViewPanel, gbc_boardView);

		this.updateLevelStats();
	}

	/**
	 * Returns the levelTopPanel object for this panel.
	 * 
	 * @return the levelTopPanel property
	 */
	public LevelTopPanel getTopMenuPanel() {
		return this.levelTopPanel;
	}

	/**
	 * Returns the levelStatsPanel object for this panel.
	 * 
	 * @return the levelStatsPanel property
	 */
	public LevelStatsPanel getLeftMenuPanel() {
		return this.levelStatsPanel;
	}

	/**
	 * Returns the boardViewPanel object for this panel.
	 * 
	 * @return the boardViewPanel property
	 */
	public BoardViewPanel getBoardViewPanel() {
		return this.boardViewPanel;
	}

	/**
	 * Returns the Current Level.
	 * 
	 * @return the currentLevel property
	 */
	public GameLevel getLevel() {
		return this.currentLevel;
	}

	/**
	 * Sets the Current Level to be the new Level.
	 * 
	 * @param newLevel
	 */
	public void setLevel(GameLevel newLevel) {
		this.currentLevel = newLevel;
	}

	/**
	 * This goes through each of the child View Elements and Updates them.
	 * 
	 */
	public void updateLevelStats() {
		// Update the Stats Panel
		levelStatsPanel.pointsLabel.setText(Integer.toString(currentScore));
		if (currentLevel.getType() != LevelType.LIGHTNING) {
			levelStatsPanel.movesSlashTimeLabel.setText(Integer
					.toString(currentLevel.getMoveCount()));
		} else {
			// TODO: this will need to actually address the timer correctly
			levelStatsPanel.movesSlashTimeLabel.setText(Integer.toString(0));
		}

		// TODO: Update Star Graphics Here

		// Update the Top Panel
		this.levelTopPanel.resetBoardButton
				.setText(LevelTopPanel.RESET
						+ " "
						+ this.currentLevel.getSpecialMoves()
								.getResetBoardCount());
		
		this.levelTopPanel.swapTileButton
		.setText(LevelTopPanel.SWAP
				+ " "
				+ this.currentLevel.getSpecialMoves()
						.getSwapTileCount());
		
		this.levelTopPanel.removeTileButton
		.setText(LevelTopPanel.REMOVE
				+ " "
				+ this.currentLevel.getSpecialMoves()
						.getRemoveTileCount());
		
		this.levelTopPanel.xStacyMoveButton
		.setText(LevelTopPanel.XSTACY
				+ " "
				+ this.currentLevel.getSpecialMoves()
						.getXStacySpecialMoveCount());
		// TODO: Currently nothing to Update Here but there should be the number
		// of moves indicated on each special move button.
	}

	/**
	 * Return the current score.
	 * 
	 * @return an integer
	 */
	public int getScore() {
		return this.currentScore;
	}

	/**
	 * Sets the score to the specified value.
	 * 
	 * @param newScore
	 *            The new integer score value.
	 */
	public void setScore(int newScore) {
		this.currentScore = newScore;
	}

	/**
	 * Updates the current score by the specified value.
	 * 
	 * @param delta
	 *            The integer value to update the score.
	 */
	public void updateScore(int delta) {
		this.currentScore += delta;
	}
}
