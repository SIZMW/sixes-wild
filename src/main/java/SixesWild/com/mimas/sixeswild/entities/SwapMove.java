package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * The SwapMove is one type of move that can be executed in the game. It allows
 * two tiles to switch places on the board.
 *
 * @author Aditya Nivarthi
 */
public class SwapMove extends GameMove {

	private static final Logger logger = Logger.getGlobal();

	protected Selection selection;

	/**
	 * Creates a SwapMove instance with the specified selection and level.
	 *
	 * @param selection
	 *            The selection to verify for validity.
	 */
	public SwapMove(Selection selection, GameLevel level) {
		this.selection = selection;
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

		// If selection does not have only two tiles
		if (selection.size() > 2) {
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

		// If selection does not have only two tiles
		if (selection.size() != 2) {
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
			logger.log(Level.INFO, "Processed a failed swap tile move.");
			return false;
		}

		logger.log(Level.INFO, "Processed a successful swap tile move.");
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
			logger.log(Level.INFO, "Executed a failed swap tile move.");
			return false;
		} else {
			if (selection == null) {
				return false;
			}

			ArrayList<Square> squareArray = selection.getSelectionAsArrayList();

			// Get the first tile
			Tile tile = app
					.getLevelPanel()
					.getBoardViewPanel()
					.getBoard()
					.getSquare(squareArray.get(0).getX(),
							squareArray.get(0).getY()).getTile();

			// Remove the first tile
			app.getLevelPanel()
					.getBoardViewPanel()
					.getBoard()
					.getSquare(squareArray.get(0).getX(),
							squareArray.get(0).getY()).removeTile();

			// Add the second tile into the first square
			app.getLevelPanel()
					.getBoardViewPanel()
					.getBoard()
					.getSquare(squareArray.get(0).getX(),
							squareArray.get(0).getY())
					.addTile(
							app.getLevelPanel()
									.getBoardViewPanel()
									.getBoard()
									.getSquare(squareArray.get(1).getX(),
											squareArray.get(1).getY())
									.getTile());

			// Remove the second tile
			app.getLevelPanel()
					.getBoardViewPanel()
					.getBoard()
					.getSquare(squareArray.get(1).getX(),
							squareArray.get(1).getY()).removeTile();

			// Add the first tile into the second square
			app.getLevelPanel()
					.getBoardViewPanel()
					.getBoard()
					.getSquare(squareArray.get(1).getX(),
							squareArray.get(1).getY()).addTile(tile);

			app.getLevelPanel().getBoardViewPanel().clearGameSelection();
			app.getLevelPanel().getLevel().getSpecialMoves()
					.updateSwapTileCount(-1);

			logger.log(Level.INFO, "Executed a successful swap tile move.");
			return true;
		}
	}
}
