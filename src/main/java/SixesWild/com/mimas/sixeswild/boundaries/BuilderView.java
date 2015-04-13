package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.entities.Board;

public class BuilderView extends JPanel {
	BuilderTopPanel builderTopPanel;
	LevelSettingsPanel levelSettingsPanel;
	BoardViewPanel boardViewPanel;
	
	/**
	 * Constructor for level view
	 */
	public BuilderView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{5.0, 1.0, 15.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 10.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		// Level settings panel
		levelSettingsPanel = new LevelSettingsPanel();
		levelSettingsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		levelSettingsPanel.setPreferredSize(new Dimension(100, 519));
		GridBagConstraints gbc_levelSettingsPanel = new GridBagConstraints();
		gbc_levelSettingsPanel.gridheight = 2;
		gbc_levelSettingsPanel.insets = new Insets(0, 0, 0, 0);
		gbc_levelSettingsPanel.fill = GridBagConstraints.BOTH;
		gbc_levelSettingsPanel.gridx = 0;
		gbc_levelSettingsPanel.gridy = 0;
		add(levelSettingsPanel, gbc_levelSettingsPanel);
		
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
		GridBagConstraints gbc_boardView = new GridBagConstraints();
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
	public BuilderTopPanel getBuilderTopPanel(){
		return this.builderTopPanel;
	}
	
	/**
	 * Returns the level settings panel.
	 * 
	 * @return this.levelSettingsPanel The level settings panel.
	 */
	public LevelSettingsPanel getLevelSettingsPanel(){
		return this.levelSettingsPanel;
	}
	
	/**
	 * Returns the board view panel.
	 * 
	 * @return this.boardViewPanel The board view panel.
	 */
	public BoardViewPanel getBoardViewPanel(){
		return this.boardViewPanel;
	}

}
