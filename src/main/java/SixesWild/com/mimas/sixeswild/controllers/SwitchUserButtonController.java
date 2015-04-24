package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * This controller switches the active user profile in the game.
 * 
 * @author Aditya Nivarthi
 */
public class SwitchUserButtonController implements ActionListener {

	private static final Logger logger = Logger.getGlobal();
	GameApplication app;

	/**
	 * Creates a SwitchUserButtonController instance with the specified
	 * GameApplication.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 */
	public SwitchUserButtonController(GameApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		String name = this.app.getMainPanel().getOptionsMenuView()
				.getUserNameTextField().getText();
		this.app.setCurrentUserProfile(name);
		logger.log(Level.FINE, "User profile requested to be loaded for: "
				+ name);
	}

}
