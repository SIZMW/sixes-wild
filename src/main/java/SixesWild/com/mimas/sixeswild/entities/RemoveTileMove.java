package SixesWild.com.mimas.sixeswild.entities;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * The RemoveTileMove is one type of move that can be executed in the game. It
 * allows a tile to be removed from the board.
 * 
 * @author Aditya Nivarthi
 */
public class RemoveTileMove extends GameMove {

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
		return selection.isRemoveStillValid();
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
		return selection.isRemoveValid();
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
		if (!this.isStillValidMove(app)) {
			app.getLevelPanel().getBoardViewPanel().clearGameSelection();
			app.getLevelPanel().getLevel().getSpecialMoves()
					.updateRemoveTileCount(-1);
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
		if (!this.isValidMove(app)) {
			app.getLevelPanel().getBoardViewPanel().clearGameSelection();
			return false;
		} else {
			app.getLevelPanel().getBoardViewPanel().doRemoveTileMove();
			app.getLevelPanel().getBoardViewPanel().clearGameSelection();
			app.getLevelPanel().getLevel().getSpecialMoves()
					.updateRemoveTileCount(-1);
			return true;
		}
	}

}
