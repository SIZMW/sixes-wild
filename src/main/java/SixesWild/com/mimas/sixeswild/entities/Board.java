package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/**
 * This class is used as a representation of the game board for Sixes Wild.
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
	 * Constructor for Board class.
	 */
	public Board() {
		this.squares = new Square[SIZE_X][SIZE_Y];
		this.multiplierFrequencies = null;
		this.tileFrequencies = null;

		this.randomInitialize();
	}

	/**
	 * Parameterized constructor for Board class.
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

		for (Square e : squareList) {
			if (e.equals(null)) {
				throw new Exception("Null square on board construction");
			}
		}

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
	 * @return Integer to represent bounds on frequency probability.
	 */
	protected int getFrequencyProbability(double freq) {
		return (100 / (int) (this.tileFrequencies.get(0) * 100));
	}

	/**
	 * Generates a random number for a NumberTile for random board generation.
	 * 
	 * @return Random value from 1 to 6.
	 */
	protected int getRandomNumber() {
		return 1 + (int) (Math.random() * 6);
	}

	/**
	 * Initializes the board for the game.
	 * 
	 * @return true
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
	 * @return true
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
	 * @param x
	 * @param y
	 * @param marked
	 * @return true or false
	 */
	public boolean setSquare(Tile tile, int x, int y, boolean marked) {
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
	 * @return true
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

		// Seed for shuffling
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
	 * @return true
	 */
	public boolean fillEmptySquares() {
		return true;
	}

	/**
	 * Returns whether the given selection is valid or not.
	 * 
	 * @param selection
	 *            The selection to verify.
	 * @return true or false
	 */
	public boolean isValidSelection(ArrayList<Square> selection) {
		if (selection.equals(null)) {
			return false;
		}

		for (Square e : selection) {
			if (e.equals(null)) {
				return false;
			}
		}

		boolean nextTo = false;

		for (int i = 0; i < selection.size(); i++) {
			for (int j = 0; j < selection.size(); j++) {
				if (i != j
						&& this.isSquareNextTo(selection.get(i),
								selection.get(j))) {
					nextTo = true;
				}
			}

			if (!nextTo) {
				return false;
			}

			nextTo = false;
		}

		int sum = 0;
		for (Square e : selection) {
			if (!e.getTile().getType().equals(TileType.NUMBER)) {
				return false;
			}
			sum += e.getTile().getNumber();
		}

		if (sum > 6) {
			return false;
		}

		return true;
	}

	/**
	 * Returns whether two squares are next to each other.
	 * 
	 * @param squareOne
	 *            First square to compare.
	 * @param squareTwo
	 *            Second square to compare.
	 * @return true or false
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
	 * @return true
	 */
	public boolean removeSelection(ArrayList<Square> selection) {
		if (selection.equals(null)) {
			return false;
		}

		for (Square e : selection) {
			if (e.equals(null)) {
				return false;
			}
		}

		for (Square e : selection) {
			squares[e.getX()][e.getY()] = null;
		}
		return true;
	}
}
