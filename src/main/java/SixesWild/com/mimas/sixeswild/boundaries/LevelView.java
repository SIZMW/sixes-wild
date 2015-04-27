package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.Timer;

import SixesWild.com.mimas.sixeswild.entities.Aesthetic;
import SixesWild.com.mimas.sixeswild.entities.Board;
import SixesWild.com.mimas.sixeswild.entities.GameLevel;
import SixesWild.com.mimas.sixeswild.entities.LevelType;
import SixesWild.com.mimas.sixeswild.entities.MenuTypes;
import SixesWild.com.mimas.sixeswild.entities.MoveType;
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

	protected GameApplication app;
	protected LevelTopPanel levelTopPanel;
	protected LevelStatsPanel levelStatsPanel;
	protected BoardViewPanel boardViewPanel;
	protected Aesthetic levelViewAesthetic;

	protected GameLevel currentLevel;
	protected int currentScore;
	protected MoveType currentMove;
	protected Timer levelTimer = null;
	protected MenuTypes currentMenuType;

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
		this.setLayout(gridBagLayout);

		// Top menu panel
		this.levelTopPanel = new LevelTopPanel();

		// Layout for top menu panel
		GridBagLayout gridBagLayout_1 = (GridBagLayout) this.levelTopPanel
				.getLayout();
		gridBagLayout_1.columnWeights = new double[] { 0.0, 10000.0, 0.0, 20.0,
				0.0, 20.0, 0.0, 20.0, 0.0, 20.0, 0.0, 20.0, 0.0 };
		gridBagLayout_1.columnWidths = new int[] { 10, 0, 10, 0, 10, 0, 10, 0,
				10, 0, 10, 0, 10 };
		this.levelTopPanel.getExitLevelButton().setPreferredSize(
				new Dimension(100, 20));
		this.levelTopPanel.getXStacyMoveButton().setPreferredSize(
				new Dimension(100, 20));
		this.levelTopPanel.getRemoveTileButton().setPreferredSize(
				new Dimension(100, 20));
		this.levelTopPanel.getSwapTileButton().setPreferredSize(
				new Dimension(100, 20));
		this.levelTopPanel.getResetBoardButton().setPreferredSize(
				new Dimension(100, 20));
		this.levelTopPanel.setBorder(BorderFactory
				.createLineBorder(Color.black));

		GridBagConstraints gbc_topMenuPanel = new GridBagConstraints();
		gbc_topMenuPanel.gridwidth = 4;
		gbc_topMenuPanel.insets = new Insets(0, 0, 0, 0);
		gbc_topMenuPanel.fill = GridBagConstraints.BOTH;
		gbc_topMenuPanel.gridx = 0;
		gbc_topMenuPanel.gridy = 0;
		this.add(this.levelTopPanel, gbc_topMenuPanel);

		// Level stats panel
		this.levelStatsPanel = new LevelStatsPanel();
		this.levelStatsPanel.setBorder(BorderFactory
				.createLineBorder(Color.black));

		// Layout for level stats panel
		GridBagConstraints gbc_leftMenuPanel = new GridBagConstraints();
		gbc_leftMenuPanel.insets = new Insets(0, 0, 0, 0);
		gbc_leftMenuPanel.fill = GridBagConstraints.BOTH;
		gbc_leftMenuPanel.gridx = 0;
		gbc_leftMenuPanel.gridy = 1;
		this.add(this.levelStatsPanel, gbc_leftMenuPanel);

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
			this.boardViewPanel = new BoardViewPanel(board,
					this.levelViewAesthetic);
			this.boardViewPanel.setBorder(BorderFactory
					.createLineBorder(Color.black));

			// Layout for board view panel
			GridBagConstraints gbc_boardView = new GridBagConstraints();
			gbc_boardView.insets = new Insets(0, 0, 0, 0);
			gbc_boardView.fill = GridBagConstraints.BOTH;
			gbc_boardView.gridx = 2;
			gbc_boardView.gridy = 1;
			this.add(this.boardViewPanel, gbc_boardView);
		} catch (Exception e) {
			logger.log(Level.WARNING, "Received null error on board creation.",
					e);
		}
	}

	/**
	 * Creates a LevelView instance with the specified GameApplication,
	 * aesthetic and level.
	 *
	 * @param app
	 *            The GameApplication currently running.
	 * @param aesthetic
	 *            The aesthetic to use for this view.
	 * @param newLevel
	 *            The level to populate in this view.
	 * @param type
	 *            The menu type that the level is being selected from.
	 */
	public LevelView(GameApplication app, Aesthetic aesthetic,
			GameLevel newLevel, MenuTypes type) {

		// Attributes
		this.app = app;
		this.levelViewAesthetic = aesthetic;
		this.currentLevel = newLevel;
		this.currentScore = 0;
		this.currentMove = MoveType.SELECTION;
		this.currentMenuType = type;

		// Layout for view
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 5.0, 15.0, 5.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 10.0, Double.MIN_VALUE };
		this.setLayout(gridBagLayout);

		// Top menu panel
		this.levelTopPanel = new LevelTopPanel();
		this.levelTopPanel.setLevelNameTextField(newLevel.getName());

		// Layout for top menu panel
		GridBagLayout gridBagLayout_1 = (GridBagLayout) this.levelTopPanel
				.getLayout();
		gridBagLayout_1.columnWeights = new double[] { 0.0, 10000.0, 0.0, 20.0,
				0.0, 20.0, 0.0, 20.0, 0.0, 20.0, 0.0, 20.0, 0.0 };
		gridBagLayout_1.columnWidths = new int[] { 10, 0, 10, 0, 10, 0, 10, 0,
				10, 0, 10, 0, 10 };
		this.levelTopPanel.getExitLevelButton().setPreferredSize(
				new Dimension(100, 20));
		this.levelTopPanel.getXStacyMoveButton().setPreferredSize(
				new Dimension(100, 20));
		this.levelTopPanel.getRemoveTileButton().setPreferredSize(
				new Dimension(100, 20));
		this.levelTopPanel.getSwapTileButton().setPreferredSize(
				new Dimension(100, 20));
		this.levelTopPanel.getResetBoardButton().setPreferredSize(
				new Dimension(100, 20));
		this.levelTopPanel.setBorder(BorderFactory
				.createLineBorder(Color.black));

		GridBagConstraints gbc_topMenuPanel = new GridBagConstraints();
		gbc_topMenuPanel.gridwidth = 4;
		gbc_topMenuPanel.insets = new Insets(0, 0, 0, 0);
		gbc_topMenuPanel.fill = GridBagConstraints.BOTH;
		gbc_topMenuPanel.gridx = 0;
		gbc_topMenuPanel.gridy = 0;
		this.add(this.levelTopPanel, gbc_topMenuPanel);

		// Level stats panel
		this.levelStatsPanel = new LevelStatsPanel(newLevel.getMoveCount());
		this.levelStatsPanel.setBorder(BorderFactory
				.createLineBorder(Color.black));

		// Layout for level stats panel
		GridBagConstraints gbc_leftMenuPanel = new GridBagConstraints();
		gbc_leftMenuPanel.insets = new Insets(0, 0, 0, 0);
		gbc_leftMenuPanel.fill = GridBagConstraints.BOTH;
		gbc_leftMenuPanel.gridx = 0;
		gbc_leftMenuPanel.gridy = 1;
		this.add(this.levelStatsPanel, gbc_leftMenuPanel);

		Board board = newLevel.getBoard();
		// Board view panel
		this.boardViewPanel = new BoardViewPanel(board, this.levelViewAesthetic);
		this.boardViewPanel.setBorder(BorderFactory
				.createLineBorder(Color.black));

		// Layout for board view panel
		GridBagConstraints gbc_boardView = new GridBagConstraints();
		gbc_boardView.insets = new Insets(0, 0, 0, 0);
		gbc_boardView.fill = GridBagConstraints.BOTH;
		gbc_boardView.gridx = 2;
		gbc_boardView.gridy = 1;
		this.add(this.boardViewPanel, gbc_boardView);

		// Set up Lightning level timer
		if (this.currentLevel.getType().equals(LevelType.LIGHTNING)) {

			// Create a new timer
			this.levelTimer = new Timer(1000, new ActionListener() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see
				 * java.awt.event.ActionListener#actionPerformed(java.awt.event
				 * .ActionEvent)
				 */
				public void actionPerformed(ActionEvent e) {

					// Decrease timer amount
					currentLevel.updateTimerCount(-1);
					if (currentLevel.getTimer() >= 0) {
						updateLevelStats();
					} else {
						endLevel("Timer ended.");
						levelTimer.stop();
					}
				}
			});
			this.levelTimer.setRepeats(true);
			this.levelTimer.start();
		}

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
	 * Returns the currentLevel object for this panel.
	 *
	 * @return the currentLevel property
	 */
	public GameLevel getLevel() {
		return this.currentLevel;
	}

	/**
	 * Sets the currentLevel object with the specified level.
	 *
	 * @param newLevel
	 *            The new level to set as the current level.
	 */
	public void setLevel(GameLevel newLevel) {
		this.currentLevel = newLevel;
	}

	/**
	 * Update all the level display views
	 */
	public void updateLevelStats() {

		// Update the stats Panel
		this.levelStatsPanel.pointsLabel.setText(Integer
				.toString(this.currentScore));
		if (this.currentLevel.getType() != LevelType.LIGHTNING) {
			this.levelStatsPanel.movesAndTimerLabel.setText(this.currentLevel
					.getMoveCount() + "");
		} else {
			this.levelStatsPanel.movesAndTimerLabel.setText(this.currentLevel
					.getTimer() + "");
		}

		// TODO: Update star graphics Here

		// Update the special moves
		this.levelTopPanel.resetBoardButton.setText(LevelTopPanel.RESET + " "
				+ this.currentLevel.getSpecialMoves().getResetBoardCount());

		this.levelTopPanel.swapTileButton.setText(LevelTopPanel.SWAP + " "
				+ this.currentLevel.getSpecialMoves().getSwapTileCount());

		this.levelTopPanel.removeTileButton.setText(LevelTopPanel.REMOVE + " "
				+ this.currentLevel.getSpecialMoves().getRemoveTileCount());

		this.levelTopPanel.xStacyMoveButton.setText(LevelTopPanel.XSTACY
				+ " "
				+ this.currentLevel.getSpecialMoves()
						.getXStacySpecialMoveCount());
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

	/**
	 * Sets the current move type to the specified move type.
	 *
	 * @param type
	 *            The new move type for the current move.
	 */
	public void setMoveType(MoveType type) {
		this.currentMove = type;
	}

	/**
	 * Returns the current move type.
	 *
	 * @return a MoveType
	 */
	public MoveType getMoveType() {
		return this.currentMove;
	}

	/**
	 * Displays the end level pop up before returning to the menu.
	 *
	 * @param message
	 *            The game status message to display.
	 */
	public void endLevel(String message) {

		// Add the high score to the current user profile
		this.app.getCurrentUserProfile().addLevelHighScore(
				this.currentLevel.getLevelNumber(),
				this.currentScore,
				this.currentLevel.getPointThresholds().getStarsForScore(
						this.currentScore));

		// Check the star score for this level and determine if the next level
		// is unlocked
		if (this.currentLevel.getPointThresholds().getStarsForScore(
				this.currentScore) > 0) {
			if (this.currentMenuType.equals(MenuTypes.STORY)) {
				this.app.getCurrentUserProfile().setHighestStoryLevel(
						this.currentLevel.getLevelNumber() + 1);
			} else if (this.currentMenuType.equals(MenuTypes.USER)) {
				this.app.getCurrentUserProfile().setHighestUserLevel(
						this.currentLevel.getLevelNumber() + 1);
			}
		}

		// Display the pop up to end the level
		JDialog dialog = new EndLevelPopUpPane(this.app, message).createDialog(
				this.app.getFrame(), "");
		dialog.setVisible(true);

		// Refresh the game menu view to reflect the new user profile status
		this.app.refreshView();

		logger.log(Level.INFO, "Level ended. Returning to menu.");
	}
	
	/**
	 * Returns a the current level timer.
	 * 
	 * @return a Timer
	 */
	public Timer getTimer(){
		return this.levelTimer;
	}
}
