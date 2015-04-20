package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * This class represents the controller for handling mouse events on the
 * BoardViewPanel.
 * 
 * @author Aditya Nivarthi
 */
public class GameBoardViewMouseController extends MouseAdapter {

	GameApplication app;

	/**
	 * Constructor for GameBoardViewMouseController class.
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
				.updateSelection(me.getX(), me.getY());
		app.getLevelPanel().getBoardViewPanel().updateUI();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent me) {
		app.getLevelPanel().getBoardViewPanel().applySelection();
		app.getLevelPanel().getBoardViewPanel().updateUI();
	}
}
