package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * This class is the controller to handle what badges get drawn when a selection
 * is made in the badge submenu
 * 
 * @author MarcoDuran
 *
 */
public class BadgesListPanelController implements ActionListener {
	GameApplication app;
	ArrayList<String> badgeList;

	/**
	 * Constructor for BadgesListPanelController class.
	 * 
	 * @param app
	 *            The GameApplication that is currently running
	 */
	public BadgesListPanelController(GameApplication app) {
		this.app = app;
		badgeList = new ArrayList<String>();

	}

	// The action of viewing the badges
	public void actionPerformed(ActionEvent e) {
		// if a badge is clicked, preview it
		// JPanel currentPanel = app.getBadgePanel();
		for (int i = 0; i < 50; i++) {
			// TODO insert images of badges with descriptions
		}

	}

}
