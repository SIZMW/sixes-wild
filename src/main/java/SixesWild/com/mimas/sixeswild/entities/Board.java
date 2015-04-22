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
	public Board(Tile tiles[][], ArrayList<Double> tileFreq,
			ArrayList<Double> multFreq) throws Exception {
		this.tileFrequencies = tileFreq;
		this.multiplierFrequencies = multFreq;
		this.squares = new Square[SIZE_X][SIZE_Y];

		if (tiles == null) {
			throw new Exception("Null tile list for board construction.");
		}

		for (int i = 0; i < this.SIZE_X; i++) {
			for (int j = 0; j < this.SIZE_Y; j++) {
				if (tiles[i][j] == null) {
					throw new Exception(
							"Null tile in list for board construction.");
				}
			}
		}

		for (int i = 0; i < this.SIZE_X; i++) {
			for (int j = 0; j < this.SIZE_Y; j++) {
				this.squares[i][j] = new Square(tiles[i][j], i, j, false);
			}
		}

		this.initialize();
	}

	/**
	 * Returns a random number for NumberTile for random board generation.
	 * Generates a random value from 0 up to 100 and determines the number based
	 * on the value's location in the generated ranges. The ranges are
	 * determined by the frequencies of the tiles.
	 * 
	 * @return Random value from 1 to 6.
	 */
	protected int getNumber() {
		int value = new Random().nextInt(100);

		int rangeOne = (int) (this.tileFrequencies.get(0) * 100);
		int rangeTwo = rangeOne + (int) (this.tileFrequencies.get(1) * 100);
		int rangeThree = rangeTwo + (int) (this.tileFrequencies.get(2) * 100);
		int rangeFour = rangeThree + (int) (this.tileFrequencies.get(3) * 100);
		int rangeFive = rangeFour + (int) (this.tileFrequencies.get(4) * 100);

		if (value < rangeOne) {
			return 1;
		} else if (value < rangeTwo) {
			return 2;
		} else if (value < rangeThree) {
			return 3;
		} else if (value < rangeFour) {
			return 4;
		} else if (value < rangeFive) {
			return 5;
		} else {
			return 6;
		}
	}

	/**
	 * Returns a multiplier value based on the frequencies of the board.
	 * Generates a random value from 0 up to 100 and determines the number based
	 * on the value's location in the generated ranges. The ranges are
	 * determined by the frequencies of the multipliers.
	 * 
	 * @return Multiplier value from 1 to 3.
	 */
	protected int getMultiplier() {
		int value = new Random().nextInt(100);

		int rangeOne = (int) (this.tileFrequencies.get(0) * 100);
		int rangeTwo = rangeOne + (int) (this.tileFrequencies.get(1) * 100);

		if (value < rangeOne) {
			return 1;
		} else if (value < rangeTwo) {
			return 2;
		} else {
			return 3;
		}
	}

	/**
	 * Generates a random number for a NumberTile for random board generation.
	 * 
	 * @return Random value from 1 to 6.
	 */
	public int getRandomNumber() {
		return 1 + (int) (Math.random() * 6);
	}

	/**
	 * Generates a random number for a multiplier for random board generation.
	 * 
	 * @return Random value from 1 to 3.
	 */
	public int getRandomMultiplier() {
		return 1 + (int) (Math.random() * 3);
	}

	/**
	 * Initializes the board for the game.
	 * 
	 * @return true if successfully initialized; false otherwise.
	 */
	protected boolean initialize() {
		// TileFrequencies and MultiplierFrequencies have not been initialized
		// properly
		if ((this.tileFrequencies == null && this.multiplierFrequencies == null)
				|| (this.tileFrequencies.size() < 3 || this.multiplierFrequencies
						.size() < 3)) {
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
					} else if (squares[i][j].getTile().getType()
							.equals(TileType.NULL)) {
						squares[i][j] = new Square(new NullTile(), i, j, false);
					} else if (squares[i][j].getTile().getType()
							.equals(TileType.TARGET)) {
						squares[i][j] = new Square(new TargetTile(), i, j,
								false);
					} else if (squares[i][j].getTile().getType()
							.equals(TileType.SIX)) {
						squares[i][j] = new Square(new SixTile(), i, j, false);
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
	 * Returns the tile frequencies for the board.
	 * 
	 * @return ArrayList<Double> of frequencies
	 */
	public ArrayList<Double> getTileFrequencies() {
		return this.tileFrequencies;
	}

	/**
	 * Returns the multiplier frequencies for the board.
	 * 
	 * @return ArrayList<Double> of frequencies
	 */
	public ArrayList<Double> getMultiplierFrequencies() {
		return this.multiplierFrequencies;
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
