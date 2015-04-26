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
		this.app.getLevelPanel().getBoardViewPanel()
				.updateGameSelection(me.getX(), me.getY());

		SelectionMove move = new SelectionMove(this.app.getLevelPanel()
				.getBoardViewPanel().getCurrentSelection(), this.app
				.getLevelPanel().getLevel());
		move.processCurrentMove(this.app);

		logger.log(Level.INFO, "Processed a move type of: "
				+ this.app.getLevelPanel().getMoveType().toString());

		this.app.getLevelPanel().updateLevelStats();

		if (!this.app.getLevelPanel().getLevel().getType()
				.equals(LevelType.LIGHTNING)
				&& this.app.getLevelPanel().getLevel().getMoveCount() <= 0) {
			this.app.getLevelPanel().endLevel("You have run out of moves.");
		}

		this.app.getLevelPanel().getBoardViewPanel().updateUI();

	}
}
