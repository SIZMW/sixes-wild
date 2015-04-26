package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.entities.LevelType;
import SixesWild.com.mimas.sixeswild.entities.MoveType;
import SixesWild.com.mimas.sixeswild.entities.RemoveTileMove;
import SixesWild.com.mimas.sixeswild.entities.SelectionMove;
import SixesWild.com.mimas.sixeswild.entities.SwapMove;

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
	@Override
	public void mousePressed(MouseEvent me) {
		this.app.getLevelPanel().getBoardViewPanel()
				.updateGameSelection(me.getX(), me.getY());

		if (this.app.getLevelPanel().getMoveType().equals(MoveType.SELECTION)) {
			SelectionMove move = new SelectionMove(this.app.getLevelPanel()
					.getBoardViewPanel().getCurrentSelection(), this.app
					.getLevelPanel().getLevel());
			move.processCurrentMove(this.app);
			logger.log(Level.INFO, "Processing a move type of: "
					+ MoveType.SELECTION);
		} else if (this.app.getLevelPanel().getMoveType().equals(MoveType.SWAP)) {
			SwapMove move = new SwapMove(this.app.getLevelPanel()
					.getBoardViewPanel().getCurrentSelection(), this.app
					.getLevelPanel().getLevel());
			move.processCurrentMove(this.app);
		} else if (this.app.getLevelPanel().getMoveType()
				.equals(MoveType.REMOVE)) {
			RemoveTileMove move = new RemoveTileMove(this.app.getLevelPanel()
					.getBoardViewPanel().getCurrentSelection(), this.app
					.getLevelPanel().getLevel());
			move.processCurrentMove(this.app);
		}

		logger.log(Level.INFO, "Processed a move type of: "
				+ this.app.getLevelPanel().getMoveType().toString());

		this.app.getLevelPanel().updateLevelStats();
		this.app.getLevelPanel().getBoardViewPanel().updateUI();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent me) {
		if (this.app.getLevelPanel().getMoveType().equals(MoveType.SELECTION)) {
			SelectionMove move = new SelectionMove(this.app.getLevelPanel()
					.getBoardViewPanel().getCurrentSelection(), this.app
					.getLevelPanel().getLevel());
			move.doMove(this.app);
		} else if (this.app.getLevelPanel().getMoveType().equals(MoveType.SWAP)) {
			SwapMove move = new SwapMove(this.app.getLevelPanel()
					.getBoardViewPanel().getCurrentSelection(), this.app
					.getLevelPanel().getLevel());
			if (move.isValidMove(this.app)) {
				move.doMove(this.app);
				this.app.getLevelPanel().setMoveType(MoveType.SELECTION);
			}
		} else if (this.app.getLevelPanel().getMoveType()
				.equals(MoveType.REMOVE)) {
			RemoveTileMove move = new RemoveTileMove(this.app.getLevelPanel()
					.getBoardViewPanel().getCurrentSelection(), this.app
					.getLevelPanel().getLevel());
			if (move.isValidMove(this.app)) {
				move.doMove(this.app);
				this.app.getLevelPanel().setMoveType(MoveType.SELECTION);
			}
		}

		logger.log(Level.INFO, "Completed a move type of: "
				+ this.app.getLevelPanel().getMoveType().toString());

		this.app.getLevelPanel().updateLevelStats();
		this.hasCompletedLevel();
		this.app.getLevelPanel().getBoardViewPanel().updateUI();
	}

	/**
	 * Determines completion status for each level type.
	 */
	protected void hasCompletedLevel() {
		if (this.app.getLevelPanel().getLevel().getType()
				.equals(LevelType.ELIMINATION)) {
			if (this.app.getLevelPanel().getBoardViewPanel().getBoard()
					.isEliminationComplete()) {
				this.app.getLevelPanel().endLevel(
						"Completed elimination level.");
			}
		} else if (this.app.getLevelPanel().getLevel().getType()
				.equals(LevelType.RELEASE)) {
			if (this.app.getLevelPanel().getBoardViewPanel().getBoard()
					.isReleaseComplete()) {
				this.app.getLevelPanel().endLevel("Completed release level.");
			}
		} else if (this.app.getLevelPanel().getLevel().getType()
				.equals(LevelType.LIGHTNING)) {
			if (this.app.getLevelPanel().getLevel().getTimer() <= 0) {
				this.app.getLevelPanel().endLevel("Completed lightning level.");
			}

		} else if (!this.app.getLevelPanel().getLevel().getType()
				.equals(LevelType.LIGHTNING)
				&& this.app.getLevelPanel().getLevel().getMoveCount() <= 0) {
			this.app.getLevelPanel().endLevel("You have run out of moves.");
		}
	}
}
