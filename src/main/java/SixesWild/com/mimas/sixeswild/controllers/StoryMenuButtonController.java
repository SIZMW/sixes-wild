package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.boundaries.LevelSelectionPanel;

/**
 * This class is the controller to handle redrawing the menu window when the
 * story mode sub menu is requested.
 * 
 * @author Aditya Nivarthi
 */
public class StoryMenuButtonController implements ActionListener {
	GameApplication app;

	// TODO Add list of levels as attribute

	/**
	 * Constructor for the StoryMenuButtonController class.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 */
	public StoryMenuButtonController(GameApplication app) {
		this.app = app;
	}

	/**
	 * Processes the request to show the story mode sub menu.
	 */
	public void actionPerformed(ActionEvent e) {
		JPanel currPanel = app.getMainPanel().getSubMenuPanel();
		currPanel.removeAll();
		currPanel.add(new LevelSelectionPanel());
		currPanel.updateUI();
	}
}
