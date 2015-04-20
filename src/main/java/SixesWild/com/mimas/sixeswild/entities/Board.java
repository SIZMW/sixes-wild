package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/**
 * Board is the playing area that stores Squares and Tiles. It represents the
 * area where moves are made, validated, processed and executed. It handles
 * regeneration of new Tiles based on frequencies and probabilities.
 * 
 * @author Aditya Nivarthi
 */
public class Board {

	public final int SIZE_X = 9;
	public final int SIZE_Y = 9;

	Square squares[][];
	ArrayList<Double> multiplierFrequencies;
	ArrayList<Double> tileFrequencies;

	/**
	 * Creates a Board instance with an empty board, null tile frequencies and
	 * null multiplier frequencies.
	 */
	public Board() {
		this.squares = new Square[SIZE_X][SIZE_Y];
		this.multiplierFrequencies = null;
		this.tileFrequencies = null;

		this.randomInitialize();
	}

	/**
	 * Creates a Board instance with a populated board, specified tile
	 * frequencies and specified multiplier frequencies.
	 * 
	 * @param squareList
	 *            List of squares to populate the board
	 * @param tileFreq
	 *            Frequencies of tiles for generation of new tiles.
	 * @param multFreq
	 *            Frequencies of multipliers for generation of new tiles.
	 * @throws Exception
	 *             squareList has a null Square and therefore board cannot be
	 *             populated.
	 */
	public Board(ArrayList<Square> squareList, ArrayList<Double> tileFreq,
			ArrayList<Double> multFreq) throws Exception {
		this.tileFrequencies = tileFreq;
		this.multiplierFrequencies = multFreq;
		this.squares = new Square[SIZE_X][SIZE_Y];

		// Verify all squares exist
		for (Square e : squareList) {
			if (e.equals(null)) {
				throw new Exception("Null square on board construction");
			}
		}

		// Add squares into internal board
		for (Square e : squareList) {
			this.squares[e.getX()][e.getY()] = e;
		}

		this.initialize();
	}

	/**
	 * Generates a random number for NumberTile for random board generation.
	 * 
	 * @return Random value from 1 to 6.
	 */
	protected int getNumber() {
		if (new Random().nextInt(this
				.getFrequencyProbability(this.tileFrequencies.get(0))) == 0) {
			return 1;
		} else if (new Random().nextInt(this
				.getFrequencyProbability(this.tileFrequencies.get(1))) == 0) {
			return 2;
		} else if (new Random().nextInt(this
				.getFrequencyProbability(this.tileFrequencies.get(2))) == 0) {
			return 3;
		} else if (new Random().nextInt(this
				.getFrequencyProbability(this.tileFrequencies.get(3))) == 0) {
			return 4;
		} else if (new Random().nextInt(this
				.getFrequencyProbability(this.tileFrequencies.get(4))) == 0) {
			return 5;
		} else {
			return 6;
		}
	}

	/**
	 * Returns a multiplier value based on the frequencies of the board.
	 * 
	 * @return Multiplier value from 1 to 3.
	 */
	protected int getMultiplier() {
		if (new Random().nextInt(this
				.getFrequencyProbability(this.multiplierFrequencies.get(0))) == 0) {
			return 1;
		} else if (new Random().nextInt(this
				.getFrequencyProbability(this.multiplierFrequencies.get(1))) == 0) {
			return 2;
		} else {
			return 3;
		}
	}

	/**
	 * Returns an integer representation of the frequency. This integer
	 * represents the maximum of the range from 1 to this value to generate a
	 * random integer from that simulates the percentage of getting a value in
	 * the range.
	 * 
	 * @param freq
	 *            The percentage representation of the frequency.
	 * @return Integer to represent upper bound on frequency probability.
	 */
	protected int getFrequencyProbability(double freq) {
		return (100 / (int) (this.tileFrequencies.get(0) * 100));
	}

	/**
	 * Generates a random number for a NumberTile for random board generation.
	 * TODO Will be removed.
	 * 
	 * @return Random value from 1 to 6.
	 */
	protected int getRandomNumber() {
		return 1 + (int) (Math.random() * 6);
	}

	/**
	 * Initializes the board for the game.
	 * 
	 * @return true if successfully initialized; false otherwise.
	 */
	protected boolean initialize() {
		// TileFrequencies and MultiplierFrequencies have not been initialized
		if (this.tileFrequencies == null && this.multiplierFrequencies == null) {
			this.tileFrequencies = new ArrayList<Double>(Arrays.asList(.1, .2,
					.3, .3, .05, .05));
			this.multiplierFrequencies = new ArrayList<Double>(Arrays.asList(
					.5, .25, .35));

			for (int i = 0; i < SIZE_X; i++) {
				for (int j = 0; j < SIZE_Y; j++) {
					if (squares[i][j].getTile().getType()
							.equals(TileType.NUMBER)) {
						squares[i][j] = new Square(new NumberTile(
								this.getNumber(), this.getMultiplier()), i, j,
								false);
					}
				}
			}
		} else { // TileFrequencies and MultiplierFrequencies have been
					// initialized
			for (int i = 0; i < SIZE_X; i++) {
				for (int j = 0; j < SIZE_Y; j++) {
					if (squares[i][j].getTile().getType()
							.equals(TileType.NUMBER)) {
						squares[i][j] = new Square(new NumberTile(
								this.getNumber(), this.getMultiplier()), i, j,
								false);
					}
				}
			}
		}

		return true;
	}

	/**
	 * Initializes the board for the game. TODO Will be removed.
	 * 
	 * @return true if successfully initialized; false otherwise.
	 */
	public boolean randomInitialize() {
		for (int i = 0; i < SIZE_X; i++) {
			for (int j = 0; j < SIZE_Y; j++) {
				squares[i][j] = new Square(new NumberTile(
						this.getRandomNumber(), 1), i, j, false);
			}
		}
		return true;
	}

	/**
	 * Sets the square in the x, y location with the given Tile and marked
	 * attributes.
	 * 
	 * @param tile
	 *            The tile to set.
	 * @param x
	 *            X coordinate of the Square to set.
	 * @param y
	 *            Y coordinate of the Square to set.
	 * @param marked
	 *            Marked attribute to set on the Square.
	 * @return true if successfully set; false otherwise.
	 */
	public boolean setSquare(Tile tile, int x, int y, boolean marked) {

		// Verify tile exists
		if (tile.equals(null)) {
			return false;
		}

		this.squares[x][y] = new Square(tile, x, y, marked);
		return true;
	}

	/**
	 * Returns the square at the x and y location.
	 * 
	 * @param x
	 *            The x coordinate.
	 * @param y
	 *            The y coordinate.
	 * @return squares[x][y] The requested square.
	 */
	public Square getSquare(int x, int y) {
		return squares[x][y];
	}

	/**
	 * Resets the board. Gets all the current squares on the board, shuffles the
	 * list and replaces the squares on the board.
	 * 
	 * @return true if successfully reset; false otherwise.
	 */
	public boolean resetBoard() {
		ArrayList<Square> squaresList = new ArrayList<Square>();

		// Save all the number tiles to list
		for (int i = 0; i < SIZE_X; i++) {
			for (int j = 0; j < SIZE_Y; j++) {
				if (squares[i][j].getTile().getType().equals(TileType.NUMBER)) {
					squaresList.add(squares[i][j]);
				}
			}
		}

		// Shuffle the list of tiles
		long seed = System.nanoTime();
		Collections.shuffle(squaresList, new Random(seed));
		Iterator<Square> squareIterator = squaresList.iterator();

		// Replace the number tiles with the shuffled list of number tiles
		for (int i = 0; i < SIZE_X; i++) {
			for (int j = 0; j < SIZE_Y; j++) {
				if (squares[i][j].getTile().getType().equals(TileType.NUMBER)) {
					squares[i][j] = squareIterator.next();
				}
			}
		}

		return true;
	}

	// TODO
	/**
	 * Fills empty squares once a move has been completed.
	 * 
	 * @return true if successfully filled Board; false otherwise.
	 */
	public boolean fillEmptySquares() {
		return true;
	}

	/**
	 * Returns whether the given selection is valid or not.
	 * 
	 * @param selection
	 *            The selection to verify.
	 * @return true if selection is valid; false otherwise.
	 */
	public boolean isValidSelection(ArrayList<Square> selection) {

		// Verify selection exists
		if (selection.equals(null)) {
			return false;
		}

		// Verify squares exist
		for (Square e : selection) {
			if (e.equals(null)) {
				return false;
			}
		}

		// Check if each square is next to at least one other square in the
		// selection. This allows for the "T" move.
		boolean nextTo = false;

		for (int i = 0; i < selection.size(); i++) {
			for (int j = 0; j < selection.size(); j++) {

				// Don't check square against itself
				if (i != j
						&& this.isSquareNextTo(selection.get(i),
								selection.get(j))) {
					nextTo = true;
				}
			}

			// If a square was not next to any other ones
			if (!nextTo) {
				return false;
			}

			// Reset boolean
			nextTo = false;
		}

		// Check sum of selection of squares
		int sum = 0;
		for (Square e : selection) {

			// Check for invalid types in selection
			if (!e.getTile().getType().equals(TileType.NUMBER)) {
				return false;
			}
			sum += e.getTile().getNumber();
		}

		// Invalid sum
		if (sum > 6) {
			return false;
		}

		return true;
	}

	/**
	 * Returns whether two squares are next to each other. Checks if squares are
	 * vertically or horizontally adjacent, but not diagonally next to each
	 * other.
	 * 
	 * @param squareOne
	 *            First square to compare.
	 * @param squareTwo
	 *            Second square to compare.
	 * @return true if Squares are next to each other; false otherwise.
	 */
	protected boolean isSquareNextTo(Square squareOne, Square squareTwo) {
		return (Math.abs(squareOne.getX() - squareTwo.getX()) == 1 && Math
				.abs(squareOne.getY() - squareTwo.getY()) == 0)
				|| (Math.abs(squareOne.getX() - squareTwo.getX()) == 0 && Math
						.abs(squareOne.getY() - squareTwo.getY()) == 1);
	}

	/**
	 * Removes the selection of Tiles from the board.
	 * 
	 * @param selection
	 *            The selection of tiles.
	 * @return true if successfully removed selection from Board; false
	 *         otherwise.
	 */
	public boolean removeSelection(ArrayList<Square> selection) {

		// Verify selection exists
		if (selection.equals(null)) {
			return false;
		}

		// Verify squares exist
		for (Square e : selection) {
			if (e.equals(null)) {
				return false;
			}
		}

		// Remove square
		// TODO Need to revise this
		for (Square e : selection) {
			squares[e.getX()][e.getY()] = null;
		}
		return true;
	}
}
