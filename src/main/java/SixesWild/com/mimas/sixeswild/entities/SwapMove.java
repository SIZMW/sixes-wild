package SixesWild.com.mimas.sixeswild.entities;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * The SwapMove is one type of move that can be executed in the game. It allows
 * two tiles to switch places on the board.
 *
 * @author Aditya Nivarthi
 */
public class SwapMove extends GameMove {

	protected Selection selection;
	protected GameLevel level;

	/**
	 * Creates a SwapMove instance with the specified selection and level.
	 *
	 * @param selection
	 *            The selection to verify for validity.
	 * @param level
	 *            The GameLevel currently being played.
	 */
	public SwapMove(Selection selection, GameLevel level) {
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
		return selection.isSwapStillValid();
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
		return selection.isSwapValid();
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
			return false;
		}
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
			return false;
		} else {
			app.getLevelPanel().getBoardViewPanel().doSwapTileMove();
			app.getLevelPanel().getBoardViewPanel().clearGameSelection();
			app.getLevelPanel().getLevel().getSpecialMoves()
					.updateSwapTileCount(-1);
			return true;
		}
	}

}
