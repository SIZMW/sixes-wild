package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * This class represents the controller used to handle dragging on the
 * BoardViewPanel for selecting tiles.
 * 
 * @author Aditya Nivarthi
 */
public class GameBoardViewMouseMotionController extends MouseAdapter {

	GameApplication app;

	/**
	 * Constructor for GameBoardViewMouseMotionController class.
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
				.updateSelection(me.getX(), me.getY());
		app.getLevelPanel().getBoardViewPanel().updateUI();
	}
}
