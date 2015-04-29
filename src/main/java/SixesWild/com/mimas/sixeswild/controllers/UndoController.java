package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;
import SixesWild.com.mimas.sixeswild.entities.Square;

/**
 * This controller handles undoing a board action in the level builder.
 *
 * @author Aditya Nivarthi
 */
public class UndoController extends AbstractAction {

	private static final long serialVersionUID = 1L;

	protected BuilderApplication app;

	/**
	 * Creates a UndoController instance with the specified BuilderApplication.
	 *
	 * @param app
	 *            The BuilderApplication currently running.
	 */
	public UndoController(BuilderApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (app.getUndoList().size() <= 0) {
		} else {
			Square oldSquare = app.getUndoList().get(
					app.getUndoList().size() - 1);
			app.getUndoList().remove(app.getUndoList().size() - 1);
			Square redoSquare = app.getBuilderView().getBoardViewPanel()
					.getBoard().getSquare(oldSquare.getX(), oldSquare.getY());
			Square redo = new Square(redoSquare.getTile(), redoSquare.getX(),
					redoSquare.getY(), redoSquare.getMarked());
			app.getRedoList().add(redo);
			app.getBuilderView()
					.getBoardViewPanel()
					.getBoard()
					.setSquare(oldSquare.getTile(), oldSquare.getX(),
							oldSquare.getY(), oldSquare.getMarked());
		}
	}
}
