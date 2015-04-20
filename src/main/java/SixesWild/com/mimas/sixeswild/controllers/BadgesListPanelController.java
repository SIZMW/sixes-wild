package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * This controller displays the preview for the selected badge in the badges
 * list menu.
 * 
 * @author Marco Duran
 *
 */
public class BadgesListPanelController implements ActionListener {
	GameApplication app;
	ArrayList<String> badgeList;

	/**
	 * Creates a BadgesListPanelController instance with the specified
	 * GameApplication.
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
