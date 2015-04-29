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

		// Get the number of reset board moves remaining
		int moves = app.getLevelPanel().getLevel().getSpecialMoves()
				.getResetBoardCount();

		// Execute the move if there are moves of this type left
		if (moves > 0) {
			app.getLevelPanel().getBoardViewPanel().doResetBoardMove();
			app.getLevelPanel().getLevel().getSpecialMoves()
					.updateResetBoardCount(-1);
			logger.log(Level.INFO,
					"Reset board special move requested and completed.");
		} else {
			logger.log(Level.INFO,
					"Reset board special move cannot be completed. Moves left: "
							+ moves);
		}

		// Update the level display
		app.getLevelPanel().updateLevelStats();
		app.getLevelPanel().updateUI();
	}
}
