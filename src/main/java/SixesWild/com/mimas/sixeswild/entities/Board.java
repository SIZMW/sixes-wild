package SixesWild.com.mimas.sixeswild.entities;

/**
 * This class is used as a representation of the game board for Sixes Wild.
 * @author Aditya Nivarthi
 */
public class Board {
	Square squares[][];
	public final int SIZE_X = 9;
	public final int SIZE_Y = 9;
	
	/**
	 * Constructor for Board class.
	 */
	public Board() {
		//TODO initialize with multipliers and frequencies
		//TODO The other methods for Board.
	}
	
	/**
	 * Initializes the board for the game.
	 * @return true
	 */
	public boolean initialize() {
		for (int i = 0; i < SIZE_X; i++) {
			for (int j = 0; j < SIZE_Y; j++) {
				squares[i][j] = new Square(new NumberTile(1, 1), i, j, false);
			}
		}
		return true;
	}
	
	/**
	 * Returns the square at the x and y location.
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @return squares[x][y] The requested square.
	 */
	public Square getSquare(int x, int y) {
		return squares[x][y];
	}
	
	public boolean resetBoard() {
		return true;
	}
	
	public boolean fillEmptySquares() {
		return true;
	}
	
	public boolean removeSelection() {
		return true;
	}
}
