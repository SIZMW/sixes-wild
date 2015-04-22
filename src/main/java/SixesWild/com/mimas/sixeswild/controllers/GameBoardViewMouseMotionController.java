package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * This controller handles mouse dragging when selecting tiles on the Board in
 * the game.
 * 
 * @author Aditya Nivarthi
 */
public class GameBoardViewMouseMotionController extends MouseAdapter {

	GameApplication app;

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
	public void mouseDragged(MouseEvent me) {
		app.getLevelPanel().getBoardViewPanel()
				.updateGameSelection(me.getX(), me.getY());
		app.getLevelPanel().getBoardViewPanel().updateUI();
	}
}
