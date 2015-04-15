package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;

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
		squares = new Square[SIZE_X][SIZE_Y];
	}
	
	/**
	 * Initializes the board for the game.
	 * @return true
	 */
	public boolean initialize() {
		for (int i = 0; i < SIZE_X; i++) {
			for (int j = 0; j < SIZE_Y; j++) {
				squares[i][j] = new Square(new NumberTile(this.getRandomNumber(), 1), i, j, false);
			}
		}
		return true;
	}
	
	/**
	 * Generates a random number for NumberTile for random board generation.
	 * @return Random value from 1 to 6.
	 */
	private int getRandomNumber() {
		return 1 + (int)(Math.random() * 6);
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
	
	// TODO
	/**
	 * Resets the board.
	 * @return true
	 */
	public boolean resetBoard() {
		return true;
	}
	
	// TODO
	/**
	 * Fills empty squares once a move has been completed.
	 * @return true
	 */
	public boolean fillEmptySquares() {
		return true;
	}
	
	// TODO
	/**
	 * Removes the selection of Tiles from the board.
	 * @param selection The selection of tiles.
	 * @return true
	 */
	public boolean removeSelection(ArrayList<Tile> selection) {
		return true;
	}
}
