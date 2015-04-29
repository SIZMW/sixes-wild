package SixesWild.com.mimas.sixeswild.entities;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * This class defines the abstract methods that every move sub class will need.
 *
 * @author Aditya Nivarthi
 */
public abstract class GameMove {

	/**
	 * Creates a GameMove instance.
	 */
	protected GameMove() {
	}

	/**
	 * Returns whether the move is valid to continue as a move.
	 *
	 * @param app
	 *            The GameApplication currently running.
	 * @return true if valid; false otherwise.
	 */
	public abstract boolean isStillValidMove(GameApplication app);

	/**
	 * Returns whether the move is valid to be executed.
	 *
	 * @param app
	 *            The GameApplication currently running.
	 * @return true if valid; false otherwise.
	 */
	public abstract boolean isValidMove(GameApplication app);

	/**
	 * Returns whether the move is valid to continue as a move, and resets it if
	 * not valid.
	 *
	 * @param app
	 *            The GameApplication currently running.
	 * @return true if valid; false otherwise.
	 */
	public abstract boolean processCurrentMove(GameApplication app);

	/**
	 * Returns whether the move is valid to be executed, and executes if if
	 * valid. If not, it resets the move.
	 *
	 * @param app
	 *            The GameApplication currently running.
	 * @return true if valid; false otherwise.
	 */
	public abstract boolean doMove(GameApplication app);
}
