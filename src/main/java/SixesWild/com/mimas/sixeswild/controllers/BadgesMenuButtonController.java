package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * This controller displays the badges menu when the badges menu button is
 * pressed.
 * 
 * @author Aditya Nivarthi
 */
public class BadgesMenuButtonController implements ActionListener {
	
	private static final Logger logger = Logger.getGlobal();
	GameApplication app;

	/**
	 * Creates a BadgesMenuButtonController instance with the specified
	 * GameApplication.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 */
	public BadgesMenuButtonController(GameApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		JPanel currPanel = app.getGameMenuView().getSubMenuPanel();
		currPanel.removeAll();

		// Layout for panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		currPanel.setLayout(gridBagLayout);

		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;

		// Add panel to view
		currPanel.add(this.app.getGameMenuView().getBadgeMenuView(), gbc_list);
		currPanel.updateUI();
		
		logger.log(Level.FINE, "Badges menu requested and displayed.");
	}
}
