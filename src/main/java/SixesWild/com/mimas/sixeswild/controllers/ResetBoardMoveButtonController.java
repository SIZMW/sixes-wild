package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * This controller handles resetting the board when the reset board special move
 * button is pressed.
 * 
 * @author Aditya Nivarthi
 */
public class ResetBoardMoveButtonController implements ActionListener {

	private static final Logger logger = Logger.getGlobal();

	protected GameApplication app;

	/**
	 * Creates a ResetBoardMoveButtonController instance with the specified
	 * GameApplication.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 */
	public ResetBoardMoveButtonController(GameApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Decrease the number of reset moves left
		this.app.getLevelPanel().getBoardViewPanel().doResetBoardMove();
		this.app.getLevelPanel().updateUI();

		logger.log(Level.INFO,
				"Reset board special move requested and completed.");
	}
}
