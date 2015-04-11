package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.boundaries.OptionsPanel;

/**
 * @author Aditya Nivarthi
 * @brief This class is the controller to handle redrawing the menu window when
 *        the options sub menu is requested.
 */
public class OptionsMenuButtonController implements ActionListener {
	GameApplication app;
	
	/**
	 * @brief Constructor for the OptionsMenuButtonController class.
	 * @param app
	 *            The GameApplication currently running.
	 */
	public OptionsMenuButtonController(GameApplication app) {
		this.app = app;
	}

	/**
	 * @brief Processes the request to show the options sub menu.
	 */
	public void actionPerformed(ActionEvent e) {
		JPanel currPanel = app.getMainPanel().getSubMenuPanel();
		currPanel.removeAll();
		currPanel.add(new OptionsPanel());
		currPanel.updateUI();
	}
}
