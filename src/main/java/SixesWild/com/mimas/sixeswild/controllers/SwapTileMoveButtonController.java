package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.entities.MoveType;

/**
 * This controller handles swapping tiles when the swap tile button is pressed.
 * 
 * @author Aditya Nivarthi
 */
public class SwapTileMoveButtonController implements ActionListener {

	private static final Logger logger = Logger.getGlobal();

	protected GameApplication app;

	/**
	 * Creates a SwapTileMoveButtonController instance with the specified
	 * GameApplication.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 */
	public SwapTileMoveButtonController(GameApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		int moves = this.app.getLevelPanel().getLevel().getSpecialMoves()
				.getSwapTileCount();

		if (moves > 0) {
			this.app.getLevelPanel().setMoveType(MoveType.SWAP);
		} else {
			logger.log(Level.INFO,
					"Swap tile special move cannot be completed. Moves left: "
							+ moves);
		}

		this.app.getLevelPanel().updateLevelStats();
		this.app.getLevelPanel().updateUI();
	}
}
