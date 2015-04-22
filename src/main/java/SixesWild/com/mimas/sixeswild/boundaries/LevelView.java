package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.entities.Aesthetic;
import SixesWild.com.mimas.sixeswild.entities.Board;

/**
 * This class represents the overall view for the level playing view.
 * 
 * @author Cameron Jones
 */
public class LevelView extends JPanel {

	private static final long serialVersionUID = 1L;

	LevelTopPanel levelTopPanel;
	LevelStatsPanel levelStatsPanel;
	BoardViewPanel boardViewPanel;
	Aesthetic levelViewAesthetic;

	/**
	 * Creates a LevelView instance with the specified Aesthetic.
	 * 
	 * @param aesthetic
	 *            The aesthetic to use for this view.
	 */
	public LevelView(Aesthetic aesthetic) {

		// Attributes
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
		levelTopPanel.getSpecialMoveButton4().setPreferredSize(
				new Dimension(100, 20));
		levelTopPanel.getSpecialMoveButton3().setPreferredSize(
				new Dimension(100, 20));
		levelTopPanel.getSpecialMoveButton2().setPreferredSize(
				new Dimension(100, 20));
		levelTopPanel.getSpecialMoveButton1().setPreferredSize(
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

		// Board view panel
		boardViewPanel = new BoardViewPanel(new Board(),
				this.levelViewAesthetic);
		boardViewPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		// Layout for board view panel
		GridBagConstraints gbc_boardView = new GridBagConstraints();
		gbc_boardView.insets = new Insets(0, 0, 0, 0);
		gbc_boardView.fill = GridBagConstraints.BOTH;
		gbc_boardView.gridx = 2;
		gbc_boardView.gridy = 1;
		add(boardViewPanel, gbc_boardView);

	}

	/**
	 * Returns top menu panel.
	 * 
	 * @return LevelTopPanel for the level view
	 */
	public LevelTopPanel getTopMenuPanel() {
		return this.levelTopPanel;
	}

	/**
	 * Returns the left menu panel.
	 * 
	 * @return LevelStatsPanel for the level view
	 */
	public LevelStatsPanel getLeftMenuPanel() {
		return this.levelStatsPanel;
	}

	/**
	 * Returns the board view panel.
	 * 
	 * @return BoardViewPanel for the level view
	 */
	public BoardViewPanel getBoardViewPanel() {
		return this.boardViewPanel;
	}

	/**
	 * Refresh this panel using the application to get new data.
	 * 
	 * @param app
	 *            The game application to refresh from.
	 */
	public void refresh(GameApplication app) {
		// TODO Refresh this panel.
	}
}
