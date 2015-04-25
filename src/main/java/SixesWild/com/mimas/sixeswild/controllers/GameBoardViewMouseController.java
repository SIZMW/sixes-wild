package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * This controller handles mouse presses and releases when selecting tiles on
 * the Board during the game.
 * 
 * @author Aditya Nivarthi
 */
public class GameBoardViewMouseController extends MouseAdapter {

	private static final Logger logger = Logger.getGlobal();

	protected GameApplication app;

	/**
	 * Creates a GameBoardViewMouseController instance with the specified
	 * GameApplication.
	 * 
	 * @param app
	 *            The currently running GameApplication.
	 */
	public GameBoardViewMouseController(GameApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent me) {
		app.getLevelPanel().getBoardViewPanel()
				.updateGameSelection(me.getX(), me.getY());
		if (!app.getLevelPanel().getBoardViewPanel().getCurrentSelection()
				.isSelectionSumStillValid()
				|| !app.getLevelPanel().getBoardViewPanel()
						.getCurrentSelection().isValidPositionSelection()) {
			app.getLevelPanel().getBoardViewPanel().clearGameSelection();
		}
		app.getLevelPanel().getBoardViewPanel().updateUI();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent me) {
		if (!app.getLevelPanel().getBoardViewPanel().getCurrentSelection()
				.isValidSelection()) {
			app.getLevelPanel().getBoardViewPanel().clearGameSelection();
		} else {
			int score = app.getLevelPanel().getBoardViewPanel()
					.doSelectionMove();
			app.getLevelPanel().getBoardViewPanel().clearGameSelection();

			logger.log(Level.INFO, "Selection move score was: " + score);
		}
		app.getLevelPanel().getBoardViewPanel().updateUI();
	}
}
