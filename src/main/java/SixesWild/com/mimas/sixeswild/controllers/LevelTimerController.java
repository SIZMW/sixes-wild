package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * This controller handles creating and updating the timer for levels that
 * require a timer.
 *
 * @author Aditya Nivarthi
 */
public class LevelTimerController implements ActionListener {

	protected GameApplication app;

	/**
	 * Creates a LevelTimerController instance with the specified
	 * GameApplication.
	 *
	 * @param app
	 *            The GameApplication currently running.
	 */
	public LevelTimerController(GameApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		// Decrease timer amount
		app.getLevelPanel().getLevel().updateRestrictionCount(-1);
		if (app.getLevelPanel().getLevel().getRestrictionCount() > 0) {
			app.getLevelPanel().updateLevelStats();
		} else {
			app.getLevelPanel().updateLevelStats();
			app.getLevelPanel().endLevel("Timer ended.", true);
			app.getLevelPanel().getTimer().stop();
		}
	}
}
