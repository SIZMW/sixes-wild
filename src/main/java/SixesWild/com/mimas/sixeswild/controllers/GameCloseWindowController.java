package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.sixeswild.XMLParser;

/**
 * This controller handles all the saving that is required when the game
 * application is closed.
 *
 * @author Aditya Nivarthi
 */
public class GameCloseWindowController extends WindowAdapter {

	protected GameApplication app;

	/**
	 * Creates a GameCloseWindowController instance with the specified
	 * GameApplication.
	 *
	 * @param app
	 *            The GameApplication currently running.
	 */
	public GameCloseWindowController(GameApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosing(WindowEvent w) {

		// Save the current user profile
		XMLParser.userProfileToFile(this.app.getCurrentUserProfile());
	}
}
