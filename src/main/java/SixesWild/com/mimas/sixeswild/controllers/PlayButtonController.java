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
 * This controller creates and displays the level when the play button is
 * pressed in a specified level preview panel.
 * 
 * @author Cameron Jones
 */
public class PlayButtonController implements ActionListener {
	GameApplication app;

	/**
	 * Creates a PlayButtonController instance with the specified
	 * GameApplication.
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

		// Layout for panel
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

		// Create new view
		LevelView newLevel = new LevelView();
		this.app.setLevelPanel(newLevel);
		this.setUpControllers();

		// Add panel to view
		currentPanel.add(this.app.getLevelPanel(), gbc_list);
		contentContainer.add(currentPanel);
		contentContainer.revalidate();
		contentContainer.repaint();
	}

	/**
	 * Set up controllers for the level view.
	 */
	protected void setUpControllers() {
		app.getLevelPanel().getTopMenuPanel().getExitLevelButton()
				.addActionListener(new ExitButtonController(app));
		app.getLevelPanel().getBoardViewPanel()
				.addMouseListener(new GameBoardViewMouseController(app));
		app.getLevelPanel()
				.getBoardViewPanel()
				.addMouseMotionListener(
						new GameBoardViewMouseMotionController(app));
	}
}
