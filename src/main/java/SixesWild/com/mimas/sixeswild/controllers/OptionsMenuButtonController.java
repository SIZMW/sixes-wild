package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.boundaries.OptionsPanel;

/**
 * This class is the controller to handle redrawing the menu window when the
 * options sub menu is requested.
 * 
 * @author Aditya Nivarthi
 */
public class OptionsMenuButtonController implements ActionListener {
	GameApplication app;

	/**
	 * Constructor for the OptionsMenuButtonController class.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 */
	public OptionsMenuButtonController(GameApplication app) {
		this.app = app;
	}

	/**
	 * Processes the request to show the options sub menu.
	 */
	public void actionPerformed(ActionEvent e) {
		JPanel currPanel = app.getMainPanel().getSubMenuPanel();
		currPanel.removeAll();
		currPanel.add(new OptionsPanel());
		currPanel.updateUI();
	}
}
