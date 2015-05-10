package SixesWild.com.mimas.sixeswild.entities;

import java.util.logging.Level;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * The RemoveTileMove is one type of move that can be executed in the game. It
 * allows a tile to be removed from the board.
 *
 * @author Aditya Nivarthi
 */
public class RemoveTileMove extends GameMove {

	private static final Logger logger = Logger.getGlobal();

	protected Selection selection;
	protected GameLevel level;

	/**
	 * Creates a RemoveTileMove instance with the specified selection and level.
	 *
	 * @param selection
	 *            The selection to verify for validity.
	 * @param level
	 *            The GameLevel currently being played.
	 */
	public RemoveTileMove(Selection selection, GameLevel level) {
		this.selection = selection;
		this.level = level;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SixesWild.com.mimas.sixeswild.entities.GameMove#isStillValidMove(SixesWild
	 * .com.mimas.sixeswild.boundaries.GameApplication)
	 */
	@Override
	public boolean isStillValidMove(GameApplication app) {

		// If selection does not have one tile
		if (selection.size() > 1) {
			return false;
		}

		for (Square e : selection.getSelectionAsArrayList()) {

			// Check for invalid types in selection
			if (!e.getTile().getType().equals(TileType.NUMBER)) {
				return false;
			}
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SixesWild.com.mimas.sixeswild.entities.GameMove#isValidMove(SixesWild
	 * .com.mimas.sixeswild.boundaries.GameApplication)
	 */
	@Override
	public boolean isValidMove(GameApplication app) {

		// If selection does not have one tile
		if (selection.size() != 1) {
			return false;
		}

		for (Square e : selection.getSelectionAsArrayList()) {

			// Check for invalid types in selection
			if (!e.getTile().getType().equals(TileType.NUMBER)) {
				return false;
			}
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SixesWild.com.mimas.sixeswild.entities.GameMove#processCurrentMove(SixesWild
	 * .com.mimas.sixeswild.boundaries.GameApplication)
	 */
	@Override
	public boolean processCurrentMove(GameApplication app) {
		if (!isStillValidMove(app)) {
			app.getLevelPanel().getBoardViewPanel().clearGameSelection();
			logger.log(Level.INFO, "Processed a failed remove tile move.");
			return false;
		}

		logger.log(Level.INFO, "Processed a successful remove tile move.");
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SixesWild.com.mimas.sixeswild.entities.GameMove#doMove(SixesWild.com.
	 * mimas.sixeswild.boundaries.GameApplication)
	 */
	@Override
	public boolean doMove(GameApplication app) {
		if (!isValidMove(app)) {
			app.getLevelPanel().getBoardViewPanel().clearGameSelection();
			logger.log(Level.INFO, "Executed a failed remove tile move.");
			return false;
		} else {

			// Save the previous state of the square
			boolean marked = app
					.getLevelPanel()
					.getBoardViewPanel()
					.getBoard()
					.getSquare(
							selection.getSelectionAsArrayList().get(0).getX(),
							selection.getSelectionAsArrayList().get(0).getY())
					.getMarked();

			app.getLevelPanel().getLevel().processSelection(selection);

			// Set the square marked state to the previous state
			app.getLevelPanel()
					.getBoardViewPanel()
					.getBoard()
					.getSquare(
							selection.getSelectionAsArrayList().get(0).getX(),
							selection.getSelectionAsArrayList().get(0).getY())
					.setMarked(marked);

			app.getLevelPanel().getBoardViewPanel().clearGameSelection();
			app.getLevelPanel().getLevel().getSpecialMoves()
					.updateRemoveTileCount(-1);

			logger.log(Level.INFO, "Executed a successful remove tile move.");
			return true;
		}
	}
}
