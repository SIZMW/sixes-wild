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
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.Timer;

import SixesWild.com.mimas.sixeswild.controllers.LevelTimerController;
import SixesWild.com.mimas.sixeswild.entities.Aesthetic;
import SixesWild.com.mimas.sixeswild.entities.Badge;
import SixesWild.com.mimas.sixeswild.entities.BadgeType;
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
	protected JDialog dialog;

	/**
	 * Creates a LevelView instance with the specified aesthetic.
	 *
	 * @param aesthetic
	 *            The aesthetic to use for this view.
	 */
	public LevelView(Aesthetic aesthetic) {

		// Attributes
		currentLevel = null;
		logger.log(Level.INFO, "Current level set to NULL.");

		levelViewAesthetic = aesthetic;

		logger.log(Level.INFO, "Dialog set to NULL.");
		dialog = null;

		// Layout for view
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 15.0,
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
		this.add(levelTopPanel, gbc_topMenuPanel);

		// Level stats panel
		levelStatsPanel = new LevelStatsPanel();
		levelStatsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		// Layout for level stats panel
		GridBagConstraints gbc_leftMenuPanel = new GridBagConstraints();
		gbc_leftMenuPanel.insets = new Insets(0, 0, 0, 0);
		gbc_leftMenuPanel.fill = GridBagConstraints.BOTH;
		gbc_leftMenuPanel.gridx = 0;
		gbc_leftMenuPanel.gridy = 1;
		this.add(levelStatsPanel, gbc_leftMenuPanel);

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
			boardViewPanel = new BoardViewPanel(board, levelViewAesthetic);
			boardViewPanel.setBorder(BorderFactory
					.createLineBorder(Color.black));

			// Layout for board view panel
			GridBagConstraints gbc_boardView = new GridBagConstraints();
			gbc_boardView.insets = new Insets(0, 0, 0, 0);
			gbc_boardView.fill = GridBagConstraints.BOTH;
			gbc_boardView.gridx = 2;
			gbc_boardView.gridy = 1;
			this.add(boardViewPanel, gbc_boardView);
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
		levelViewAesthetic = aesthetic;
		currentLevel = newLevel;
		currentScore = 0;
		currentMove = MoveType.SELECTION;
		currentMenuType = type;

		dialog = null;
		logger.log(Level.INFO, "Dialog set to NULL.");

		// Layout for view
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 3.0, 15.0,
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
		gbc_topMenuPanel.gridwidth = 2;
		gbc_topMenuPanel.insets = new Insets(0, 0, 5, 0);
		gbc_topMenuPanel.fill = GridBagConstraints.BOTH;
		gbc_topMenuPanel.gridx = 0;
		gbc_topMenuPanel.gridy = 0;
		this.add(levelTopPanel, gbc_topMenuPanel);

		// Level stats panel
		levelStatsPanel = new LevelStatsPanel(newLevel.getMoveCount());
		levelStatsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		// Layout for level stats panel
		GridBagConstraints gbc_leftMenuPanel = new GridBagConstraints();
		gbc_leftMenuPanel.insets = new Insets(0, 0, 0, 5);
		gbc_leftMenuPanel.fill = GridBagConstraints.BOTH;
		gbc_leftMenuPanel.gridx = 0;
		gbc_leftMenuPanel.gridy = 1;
		this.add(levelStatsPanel, gbc_leftMenuPanel);

		Board board = newLevel.getBoard();
		// Board view panel
		boardViewPanel = new BoardViewPanel(board, levelViewAesthetic);
		boardViewPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		// Layout for board view panel
		GridBagConstraints gbc_boardView = new GridBagConstraints();
		gbc_boardView.fill = GridBagConstraints.BOTH;
		gbc_boardView.gridx = 1;
		gbc_boardView.gridy = 1;
		this.add(boardViewPanel, gbc_boardView);

		// Set up Lightning level timer
		if (currentLevel.getType().equals(LevelType.LIGHTNING)) {

			// Create a new timer
			levelTimer = new Timer(1000, new LevelTimerController(app));
			levelTimer.setRepeats(true);
			levelTimer.start();
		}

		updateLevelStats();
	}

	/**
	 * Returns the levelTopPanel object for this panel.
	 *
	 * @return the levelTopPanel property
	 */
	public LevelTopPanel getTopMenuPanel() {
		return levelTopPanel;
	}

	/**
	 * Returns the levelStatsPanel object for this panel.
	 *
	 * @return the levelStatsPanel property
	 */
	public LevelStatsPanel getLeftMenuPanel() {
		return levelStatsPanel;
	}

	/**
	 * Returns the boardViewPanel object for this panel.
	 *
	 * @return the boardViewPanel property
	 */
	public BoardViewPanel getBoardViewPanel() {
		return boardViewPanel;
	}

	/**
	 * Returns the currentLevel object for this panel.
	 *
	 * @return the currentLevel property
	 */
	public GameLevel getLevel() {
		return currentLevel;
	}

	/**
	 * Sets the currentLevel object with the specified level.
	 *
	 * @param newLevel
	 *            The new level to set as the current level.
	 */
	public void setLevel(GameLevel newLevel) {
		currentLevel = newLevel;
	}

	/**
	 * Update all the level display views
	 */
	public void updateLevelStats() {

		// Update the stats Panel
		levelStatsPanel.pointsLabel.setText(Integer.toString(currentScore));
		if (currentLevel.getType() != LevelType.LIGHTNING) {
			levelStatsPanel.movesAndTimerLabel.setText(currentLevel
					.getMoveCount() + "");
			levelStatsPanel.movesAndTimerTextLabel.setText("Moves");
		} else {
			levelStatsPanel.movesAndTimerLabel.setText(currentLevel.getTimer()
					+ "");
			levelStatsPanel.movesAndTimerTextLabel.setText("Timer");
		}

		// Update next threshold points
		levelStatsPanel.nextThresholdLabel.setText(Integer
				.toString(currentLevel.getPointThresholds()
						.getNextThresholdForScore(currentScore)));

		// Update star graphics Here
		levelStatsPanel.getStarGraphicsPanel().refreshStars(
				currentLevel.getPointThresholds().getStarsForScore(getScore()));

		// Update the special moves
		levelTopPanel.resetBoardButton.setText(LevelTopPanel.RESET + " "
				+ currentLevel.getSpecialMoves().getResetBoardCount());

		levelTopPanel.swapTileButton.setText(LevelTopPanel.SWAP + " "
				+ currentLevel.getSpecialMoves().getSwapTileCount());

		levelTopPanel.removeTileButton.setText(LevelTopPanel.REMOVE + " "
				+ currentLevel.getSpecialMoves().getRemoveTileCount());

		levelTopPanel.xStacyMoveButton.setText(LevelTopPanel.XSTACY + " "
				+ currentLevel.getSpecialMoves().getXStacySpecialMoveCount());
	}

	/**
	 * Return the current score.
	 *
	 * @return an integer
	 */
	public int getScore() {
		return currentScore;
	}

	/**
	 * Sets the score to the specified value.
	 *
	 * @param newScore
	 *            The new integer score value.
	 */
	public void setScore(int newScore) {
		currentScore = newScore;
	}

	/**
	 * Updates the current score by the specified value.
	 *
	 * @param delta
	 *            The integer value to update the score.
	 */
	public void updateScore(int delta) {
		currentScore += delta;
	}

	/**
	 * Sets the current move type to the specified move type.
	 *
	 * @param type
	 *            The new move type for the current move.
	 */
	public void setMoveType(MoveType type) {
		currentMove = type;
	}

	/**
	 * Returns the current move type.
	 *
	 * @return a MoveType
	 */
	public MoveType getMoveType() {
		return currentMove;
	}

	/**
	 * Returns a the current level timer.
	 *
	 * @return a Timer
	 */
	public Timer getTimer() {
		return levelTimer;
	}

	/**
	 * Displays the end level pop up before returning to the menu.
	 *
	 * @param message
	 *            The game status message to display.
	 * @param hasCompleted
	 *            The state of how the level was completed.
	 */
	public void endLevel(String message, boolean hasCompleted) {

		// Remove board listeners to prevent more moves from being done
		try {
			boardViewPanel.removeMouseListener(boardViewPanel
					.getMouseListeners()[0]);
			boardViewPanel.removeMouseMotionListener(boardViewPanel
					.getMouseMotionListeners()[0]);
		} catch (Exception e) {
			logger.log(Level.INFO,
					"No listeners to remove from board view panel.");
		}

		// Add the high score to the current user profile
		app.getCurrentUserProfile().addLevelHighScore(
				currentLevel.getLevelNumber(),
				currentScore,
				currentLevel.getPointThresholds()
						.getStarsForScore(currentScore), currentMenuType);

		// Check the star score for this level and determine if the next level
		// is unlocked
		if (currentLevel.getPointThresholds().getStarsForScore(currentScore) > 0
				&& hasCompleted) {
			if (currentMenuType.equals(MenuTypes.STORY)) {
				app.getCurrentUserProfile().setHighestStoryLevel(
						(currentLevel.getLevelNumber() + 1));
			} else if (currentMenuType.equals(MenuTypes.USER)) {
				app.getCurrentUserProfile().setHighestUserLevel(
						(currentLevel.getLevelNumber() + 1));
			}
		}

		// Check if badges are unlocked
		for (Badge e : app.getBadgesList()) {
			if (e.getType().equals(BadgeType.SCORE)) {
				if (e.unlock(currentScore)) {
					app.getCurrentUserProfile().addBadgeEarned(e.getName());
				}
			} else if (e.getType().equals(BadgeType.STAR)) {
				if (e.unlock(currentLevel.getPointThresholds()
						.getStarsForScore(currentScore))) {
					app.getCurrentUserProfile().addBadgeEarned(e.getName());
				}
			} else if (e.getType().equals(BadgeType.UNLOCK)) {
				if (e.unlock(app.getCurrentUserProfile()
						.getHighestStoryLevelUnlocked())) {
					app.getCurrentUserProfile().addBadgeEarned(e.getName());
				}
			}
		}

		// Display the pop up to end the level
		if (dialog == null) {
			dialog = new EndLevelPopUpDialog(app, message);
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}

		// Refresh the game menu view to reflect the new user profile status
		app.refreshView();

		logger.log(Level.INFO, "Level ended. Returning to menu.");
	}
}
