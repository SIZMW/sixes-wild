package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;

import SixesWild.com.mimas.sixeswild.boundaries.EndLevelPopUpPane;
import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.entities.SelectionMove;

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

		SelectionMove move = new SelectionMove(app.getLevelPanel()
				.getBoardViewPanel().getCurrentSelection(), this.app
				.getLevelPanel().getLevel());
		move.processCurrentMove(this.app);

		app.getLevelPanel().updateLevelStats();
		app.getLevelPanel().getBoardViewPanel().updateUI();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent me) {
		SelectionMove move = new SelectionMove(app.getLevelPanel()
				.getBoardViewPanel().getCurrentSelection(), this.app
				.getLevelPanel().getLevel());
		move.doMove(this.app);

		app.getLevelPanel().updateLevelStats();

		if (this.app.getLevelPanel().getLevel().getMoveCount() <= 0) {
			JDialog dialog = new EndLevelPopUpPane(this.app).createDialog(
					this.app.getFrame(), "");
			dialog.setVisible(true);

			logger.log(Level.INFO, "Level ended. Returning to menu.");
		} else {
			app.getLevelPanel().getBoardViewPanel().updateUI();
		}
	}
}
