package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.entities.Board;

/**
 * This class represents the overall view for the level builder.
 * 
 * @author Cameron Jones
 */
public class BuilderView extends JPanel {

	private static final long serialVersionUID = 1L;

	BuilderTopPanel builderTopPanel;
	BuilderSettingsPanel builderSettingsPanel;
	BoardViewPanel boardViewPanel;

	private GridBagConstraints gbc_boardView;

	/**
	 * Constructor for level view
	 */
	public BuilderView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 5.0, 5.0, 15.0, 5.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 10.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Level settings panel
		builderSettingsPanel = new BuilderSettingsPanel();
		builderSettingsPanel.setBorder(BorderFactory
				.createLineBorder(Color.black));
		builderSettingsPanel.setPreferredSize(new Dimension(100, 519));
		GridBagConstraints gbc_levelSettingsPanel = new GridBagConstraints();
		gbc_levelSettingsPanel.gridheight = 2;
		gbc_levelSettingsPanel.insets = new Insets(0, 0, 0, 0);
		gbc_levelSettingsPanel.fill = GridBagConstraints.BOTH;
		gbc_levelSettingsPanel.gridx = 0;
		gbc_levelSettingsPanel.gridy = 0;
		add(builderSettingsPanel, gbc_levelSettingsPanel);

		// Builder top panel
		builderTopPanel = new BuilderTopPanel();
		builderTopPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_builderTopPanel = new GridBagConstraints();
		gbc_builderTopPanel.gridwidth = 3;
		gbc_builderTopPanel.insets = new Insets(0, 0, 0, 0);
		gbc_builderTopPanel.fill = GridBagConstraints.BOTH;
		gbc_builderTopPanel.gridx = 1;
		gbc_builderTopPanel.gridy = 0;
		add(builderTopPanel, gbc_builderTopPanel);

		// Board view panel
		boardViewPanel = new BoardViewPanel(new Board());
		boardViewPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		gbc_boardView = new GridBagConstraints();
		gbc_boardView.insets = new Insets(0, 0, 0, 0);
		gbc_boardView.fill = GridBagConstraints.BOTH;
		gbc_boardView.gridx = 2;
		gbc_boardView.gridy = 1;
		add(boardViewPanel, gbc_boardView);

	}

	/**
	 * Returns builder top panel.
	 * 
	 * @return this.builderTopPanel The builder top panel.
	 */
	public BuilderTopPanel getBuilderTopPanel() {
		return this.builderTopPanel;
	}

	/**
	 * Returns the level settings panel.
	 * 
	 * @return this.levelSettingsPanel The level settings panel.
	 */
	public BuilderSettingsPanel getLevelSettingsPanel() {
		return this.builderSettingsPanel;
	}

	/**
	 * Returns the board view panel.
	 * 
	 * @return this.boardViewPanel The board view panel.
	 */
	public BoardViewPanel getBoardViewPanel() {
		return this.boardViewPanel;
	}

	/**
	 * Updates the BoardViewPanel with a new panel. Redraws the panel in the
	 * same space as the previous one.
	 * 
	 * @param newBoardViewPanel
	 *            The new board view to draw.
	 */
	public void updateBoardViewPanel(BoardViewPanel newBoardViewPanel) {
		this.remove(this.boardViewPanel);
		this.boardViewPanel = newBoardViewPanel;
		this.add(newBoardViewPanel, gbc_boardView);
		this.updateUI();
	}
}
