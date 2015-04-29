package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * This controller handles resetting the badges in the user profile.
 *
 * @author Aditya Nivarthi
 */
public class ResetBadgesController implements ActionListener {

	private static final Logger logger = Logger.getGlobal();

	protected GameApplication app;

	/**
	 * Creates a ResetBadgesController instance with the specified
	 * GameApplication.
	 *
	 * @param app
	 */
	public ResetBadgesController(GameApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		app.getCurrentUserProfile().getBadgesEarned().clear();
		logger.log(Level.INFO, "Badges cleared for: "
				+ app.getCurrentUserProfile().getUserName());
	}
}
