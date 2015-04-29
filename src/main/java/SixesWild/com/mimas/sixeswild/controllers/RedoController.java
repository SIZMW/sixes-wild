package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;
import SixesWild.com.mimas.sixeswild.entities.Square;

/**
 * This controller handles redoing a board action in the level builder.
 *
 * @author Aditya Nivarthi
 */
public class RedoController extends AbstractAction {

	private static final long serialVersionUID = 1L;

	protected BuilderApplication app;

	/**
	 * Creates a RedoController instance with the specified BuilderApplication.
	 *
	 * @param app
	 *            The BuilderApplication currently running.
	 */
	public RedoController(BuilderApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (app.getRedoList().size() <= 0) {
		} else {
			Square replaceSquare = app.getRedoList().get(
					app.getRedoList().size() - 1);
			app.getRedoList().remove(app.getRedoList().size() - 1);
			Square undoSquare = app.getBuilderView().getBoardViewPanel()
					.getBoard()
					.getSquare(replaceSquare.getX(), replaceSquare.getY());
			Square undo = new Square(undoSquare.getTile(), undoSquare.getX(),
					undoSquare.getY(), undoSquare.getMarked());
			app.getUndoList().add(undo);
			app.getBuilderView()
					.getBoardViewPanel()
					.getBoard()
					.setSquare(replaceSquare.getTile(), replaceSquare.getX(),
							replaceSquare.getY(), replaceSquare.getMarked());
		}
	}

}
