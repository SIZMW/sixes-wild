package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.entities.Board;

public class LevelView extends JPanel {

	/**
	 * Create the panel.
	 */
	public LevelView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 5.0, 15.0, 5.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 10.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel topMenuPanel = new TopMenuPanel();
		topMenuPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_topMenuPanel = new GridBagConstraints();
		gbc_topMenuPanel.gridwidth = 4;
		gbc_topMenuPanel.insets = new Insets(0, 0, 0, 0);
		gbc_topMenuPanel.fill = GridBagConstraints.BOTH;
		gbc_topMenuPanel.gridx = 0;
		gbc_topMenuPanel.gridy = 0;
		add(topMenuPanel, gbc_topMenuPanel);
		
		JPanel leftMenuPanel = new LeftMenuPanel();
		leftMenuPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_leftMenuPanel = new GridBagConstraints();
		gbc_leftMenuPanel.insets = new Insets(0, 0, 0, 0);
		gbc_leftMenuPanel.fill = GridBagConstraints.BOTH;
		gbc_leftMenuPanel.gridx = 0;
		gbc_leftMenuPanel.gridy = 1;
		add(leftMenuPanel, gbc_leftMenuPanel);
		
		JPanel boardView = new BoardViewPanel(new Board());
		boardView.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_boardView = new GridBagConstraints();
		gbc_boardView.insets = new Insets(0, 0, 0, 0);
		gbc_boardView.fill = GridBagConstraints.BOTH;
		gbc_boardView.gridx = 2;
		gbc_boardView.gridy = 1;
		add(boardView, gbc_boardView);

	}

}
