package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.entities.LevelType;
import SixesWild.com.mimas.sixeswild.entities.SelectionMove;

/**
 * This controller handles mouse dragging when selecting tiles on the Board in
 * the game.
 *
 * @author Aditya Nivarthi
 */
public class GameBoardViewMouseMotionController extends MouseAdapter {

	private static final Logger logger = Logger.getGlobal();

	protected GameApplication app;

	/**
	 * Creates a GameBoardViewMouseMotionController instance with the specified
	 * GameApplication.
	 *
	 * @param app
	 *            The currently running GameApplication.
	 */
	public GameBoardViewMouseMotionController(GameApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent me) {

		// Update the selection location
		app.getLevelPanel().getBoardViewPanel()
				.updateGameSelection(me.getX(), me.getY());

		// Process the selection move
		SelectionMove move = new SelectionMove(app.getLevelPanel()
				.getBoardViewPanel().getCurrentSelection(), app.getLevelPanel()
				.getLevel());
		move.processCurrentMove(app);

		logger.log(Level.INFO, "Processed a move type of: "
				+ app.getLevelPanel().getMoveType().toString());

		// Update the level display
		app.getLevelPanel().updateLevelStats();

		// Determine if level is over
		if (!app.getLevelPanel().getLevel().getType()
				.equals(LevelType.LIGHTNING)
				&& app.getLevelPanel().getLevel().getMoveCount() <= 0) {
			app.getLevelPanel().endLevel("You have run out of moves.");
		}

		app.getLevelPanel().getBoardViewPanel().updateUI();

	}
}
