package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.boundaries.LevelView;

/**
 * This class is the controller to handle redrawing the menu window when the
 * story mode sub menu is requested.
 * 
 * @author Cameron Jones
 */
public class PlayButtonController implements ActionListener {
	GameApplication app;

	/**
	 * Constructor for the PlayButtonController class.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 */
	public PlayButtonController(GameApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		Container contentContainer = app.getFrame().getContentPane();
		JPanel currentPanel = new JPanel();
		contentContainer.removeAll();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		currentPanel.setPreferredSize(new Dimension(800, 600));
		currentPanel.setLayout(gridBagLayout);

		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;

		LevelView newLevel = new LevelView();
		this.app.setLevelPanel(newLevel);
		app.getLevelPanel().getTopMenuPanel().getExitLevelButton()
				.addActionListener(new ExitButtonController(app));

		currentPanel.add(this.app.getLevelPanel(), gbc_list);
		contentContainer.add(currentPanel);
		contentContainer.revalidate();
		contentContainer.repaint();
	}
}
