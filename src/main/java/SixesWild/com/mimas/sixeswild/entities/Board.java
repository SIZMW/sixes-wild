package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/**
 * Board is the playing area that stores squares and tiles. It represents the
 * area where moves are made, validated, processed and executed. It handles
 * regeneration of new tiles based on frequencies and probabilities.
 *
 * @author Aditya Nivarthi
 */
public class Board {

	public final int SIZE_X = 9;
	public final int SIZE_Y = 9;

	protected Square squares[][];
	protected ArrayList<Double> multiplierFrequencies;
	protected ArrayList<Double> tileFrequencies;

	/**
	 * Creates a Board instance with an empty board, null tile frequencies and
	 * null multiplier frequencies, and randomly initializes the board.
	 */
	public Board() {
		this.squares = new Square[this.SIZE_X][this.SIZE_Y];
		this.multiplierFrequencies = null;
		this.tileFrequencies = null;

		this.randomInitialize();
	}

	/**
	 * Creates a Board instance with populated squares, the specified tile
	 * frequencies and the specified multiplier frequencies.
	 *
	 * @param tiles
	 *            List of tiles to populate the board.
	 * @param tileFrequencies
	 *            Frequencies of tiles for generation of new tiles.
	 * @param multiplierFrequencies
	 *            Frequencies of multipliers for generation of new tiles.
	 * @throws Exception
	 *             squareList has a null square and therefore board cannot be
	 *             populated.
	 */
	public Board(Tile tiles[][], ArrayList<Double> tileFrequencies,
			ArrayList<Double> multiplierFrequencies) throws Exception {
		this.tileFrequencies = tileFrequencies;
		this.multiplierFrequencies = multiplierFrequencies;
		this.squares = new Square[this.SIZE_X][this.SIZE_Y];

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
	 * Returns a random number for a number tile for random board generation.
	 * Generates a random value from 0 up to 100 and determines the number based
	 * on the value's location in the generated ranges. The ranges are
	 * determined by the frequencies of the tiles.
	 *
	 * @return an integer from 1 to 6.
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
	 * @return an integer from 1 to 3.
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
	 * Generates a random number for a number tile for random board generation.
	 *
	 * @return an integer from 1 to 6.
	 */
	public int getRandomNumber() {
		return 1 + (int) (Math.random() * 6);
	}

	/**
	 * Generates a random number for a multiplier for random board generation.
	 *
	 * @return an integer from 1 to 3.
	 */
	public int getRandomMultiplier() {
		return 1 + (int) (Math.random() * 3);
	}

	/**
	 * Initializes the board using frequencies for the game. If frequencies are
	 * invalid, creates generic frequencies and uses them to populate the board.
	 */
	protected void initialize() {
		// TileFrequencies and MultiplierFrequencies have not been initialized
		if (this.tileFrequencies == null || this.tileFrequencies.size() < 6) {
			this.tileFrequencies = new ArrayList<Double>(Arrays.asList(.1, .2,
					.3, .3, .05, .05));
		}

		if (this.multiplierFrequencies == null
				|| this.multiplierFrequencies.size() < 3) {
			this.multiplierFrequencies = new ArrayList<Double>(Arrays.asList(
					.5, .25, .35));
		}

		// TileFrequencies and MultiplierFrequencies have been initialized
		for (int i = 0; i < this.SIZE_X; i++) {
			for (int j = 0; j < this.SIZE_Y; j++) {
				if (this.squares[i][j].getTile().getType()
						.equals(TileType.NUMBER)) {
					this.squares[i][j] = new Square(new NumberTile(
							this.getNumber(), this.getMultiplier()), i, j,
							false);
				} else if (this.squares[i][j].getTile().getType()
						.equals(TileType.NULL)) {
					this.squares[i][j] = new Square(new NullTile(), i, j, false);
				} else if (this.squares[i][j].getTile().getType()
						.equals(TileType.TARGET)) {
					this.squares[i][j] = new Square(new TargetTile(), i, j,
							false);
				} else if (this.squares[i][j].getTile().getType()
						.equals(TileType.SIX)) {
					this.squares[i][j] = new Square(new SixTile(), i, j, false);
				}
			}

		}
	}

	/**
	 * Initializes the board for the game. TODO Will be removed.
	 */
	public void randomInitialize() {
		for (int i = 0; i < this.SIZE_X; i++) {
			for (int j = 0; j < this.SIZE_Y; j++) {
				this.squares[i][j] = new Square(new NumberTile(
						this.getRandomNumber(), 1), i, j, false);
			}
		}
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
	 * @return true if successful; false otherwise
	 */
	public boolean setSquare(Tile tile, int x, int y, boolean marked) {

		// Verify tile exists
		if (tile == null) {
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
	 * @return a Square
	 */
	public Square getSquare(int x, int y) {
		return this.squares[x][y];
	}

	/**
	 * Returns the tile frequencies for the board.
	 *
	 * @return the tileFrequencies property
	 */
	public ArrayList<Double> getTileFrequencies() {
		return this.tileFrequencies;
	}

	/**
	 * Returns the multiplier frequencies for the board.
	 *
	 * @return the multiplierFrequencies property
	 */
	public ArrayList<Double> getMultiplierFrequencies() {
		return this.multiplierFrequencies;
	}

	/**
	 * Resets the board. Gets all the current number tiles on the board,
	 * shuffles the list and replaces the tiles on the board.
	 */
	public void resetBoard() {
		ArrayList<Tile> tileList = new ArrayList<Tile>();

		// Save all the number tiles to list
		for (int i = 0; i < this.SIZE_X; i++) {
			for (int j = 0; j < this.SIZE_Y; j++) {
				if (this.squares[i][j].getTile().getType()
						.equals(TileType.NUMBER)) {
					tileList.add(this.squares[i][j].getTile());
					this.squares[i][j].removeTile();
				}
			}
		}

		// Shuffle the list of tiles
		long seed = System.nanoTime();
		Collections.shuffle(tileList, new Random(seed));
		Iterator<Tile> tileIterator = tileList.iterator();

		// Replace the number tiles with the shuffled list of number tiles
		for (int i = 0; i < this.SIZE_X; i++) {
			for (int j = 0; j < this.SIZE_Y; j++) {
				if (this.squares[i][j].getTile() == null) {
					this.squares[i][j].addTile(tileIterator.next());
				}
			}
		}
	}

	/**
	 * Gets the next non empty Square above a given board position. Recursively
	 * finds Square that has a tile. If no Square found, returns null.
	 *
	 * @param x
	 *            X coordinate of Square to search above.
	 * @param y
	 *            Y coordinate of Square to search above.
	 * @return a Square if it exists; null otherwise.
	 */
	protected Square getNextNonEmptySquare(int x, int y) {
		if (y <= 0) {
			return null;
		} else if (this.squares[x][y - 1].getTile() != null) {
			return this.squares[x][y - 1];
		} else {
			return this.getNextNonEmptySquare(x, y - 1);
		}
	}

	/**
	 * Moves tiles downward vertically to fill in any empty Squares.
	 */
	protected void shiftTilesDownward() {
		for (int i = 0; i < this.SIZE_X; i++) {
			for (int j = this.SIZE_Y - 1; j > 0; j--) {
				if (this.squares[i][j].getTile() == null) {
					Square square = this.getNextNonEmptySquare(i, j);

					if (square == null) {

					} else if (square.getTile().getType().equals(TileType.NULL)
							|| square.getTile().getType()
									.equals(TileType.TARGET)) {

					} else {
						this.squares[i][j].addTile(square.getTile());
						square.removeTile();
					}
				}
			}
		}
	}

	/**
	 * Fills empty squares once a move has been completed.
	 */
	protected void fillEmptySquares() {
		for (int i = 0; i < this.SIZE_X; i++) {
			for (int j = 0; j < this.SIZE_Y; j++) {
				if (this.squares[i][j].getTile() == null) {
					this.squares[i][j].addTile(new NumberTile(this.getNumber(),
							this.getMultiplier()));
				}
			}
		}
	}

	/**
	 * Removes the selection of Tiles from the board.
	 *
	 * @param selection
	 *            The selection of tiles.
	 * @return true if successful; false otherwise
	 */
	protected boolean removeSelection(Selection selection) {

		// Verify selection exists
		if (selection == null) {
			return false;
		}

		Object[] squareArray = selection.getArray();

		// Remove square
		for (int i = 0; i < squareArray.length; i++) {
			this.squares[((Square) squareArray[i]).getX()][((Square) squareArray[i])
					.getY()].removeTile();
		}
		return true;
	}

	/**
	 * Swaps two tiles in the given selection
	 *
	 * @param selection
	 *            The selection of tiles.
	 * @return true if successful; false otherwise
	 */
	public boolean processSwapMove(Selection selection) {

		// Verify selection exists
		if (selection == null) {
			return false;
		}

		Object[] squareArray = selection.getArray();

		Tile tile = this.squares[((Square) squareArray[0]).getX()][((Square) squareArray[0])
				.getY()].getTile();
		this.squares[((Square) squareArray[0]).getX()][((Square) squareArray[0])
				.getY()].removeTile();
		this.squares[((Square) squareArray[0]).getX()][((Square) squareArray[0])
				.getY()]
				.addTile(this.squares[((Square) squareArray[1]).getX()][((Square) squareArray[1])
						.getY()].getTile());
		this.squares[((Square) squareArray[1]).getX()][((Square) squareArray[1])
				.getY()].removeTile();
		this.squares[((Square) squareArray[1]).getX()][((Square) squareArray[1])
				.getY()].addTile(tile);

		return true;
	}

	/**
	 * Processes the six tile and target tile movement in the "Release" game
	 * type.
	 */
	protected void processReleaseTiles() {
		for (int i = 0; i < this.SIZE_X; i++) {
			for (int j = 0; j < this.SIZE_Y; j++) {
				if (this.squares[i][j].getTile().getType().equals(TileType.SIX)) {
					if (this.getNextNonEmptySquare(i, j) != null
							&& (j + 1) < this.SIZE_Y
							&& this.squares[i][j + 1].getTile().getType()
									.equals(TileType.TARGET)) {
						this.squares[i][j + 1].removeTile();
						this.squares[i][j + 1].addTile(this.squares[i][j]
								.getTile());
						this.squares[i][j].removeTile();
					}
				}
			}
		}
	}

	/**
	 * Processes the squares that have been used in a selection in the
	 * "Elimination" game type.
	 */
	protected void processEliminationSquares() {
		for (int i = 0; i < this.SIZE_X; i++) {
			for (int j = 0; j < this.SIZE_Y; j++) {
				if (this.squares[i][j].getTile() == null) {
					this.squares[i][j].setMarked(true);
				}
			}
		}
	}

	/**
	 * Processes a standard selection move with the specified selection.
	 *
	 * @param selection
	 *            The selection to remove and process.
	 */
	public void processSelection(Selection selection) {
		this.removeSelection(selection);
		this.shiftTilesDownward();
		this.fillEmptySquares();
	}

	/**
	 * Processes a selection move with the specified selection. Updates the
	 * squares affected by marking them for the "Elimination" game type.
	 *
	 * @param selection
	 *            The selection to remove and process.
	 */
	public void processEliminationSelection(Selection selection) {
		this.removeSelection(selection);
		this.processEliminationSquares();
		this.shiftTilesDownward();
		this.fillEmptySquares();
	}

	/**
	 * Processes a selection move with the specified selection. Updates the six
	 * tiles and target tiles affected for the "Release" game type.
	 *
	 * @param selection
	 *            The selection to remove and process.
	 */
	public void processReleaseSelection(Selection selection) {
		this.removeSelection(selection);
		this.shiftTilesDownward();
		this.fillEmptySquares();
		this.processReleaseTiles();
		this.shiftTilesDownward();
		this.fillEmptySquares();
	}

	public boolean isEliminationComplete() {
		int count = 0;
		for (int i = 0; i < this.SIZE_X; i++) {
			for (int j = 0; j < this.SIZE_Y; j++) {
				if (!this.squares[i][j].getMarked()) {
					count++;
				}
			}
		}
		return count <= 0;
	}

	public boolean isReleaseComplete() {
		int count = 0;
		for (int i = 0; i < this.SIZE_X; i++) {
			for (int j = 0; j < this.SIZE_Y; j++) {
				if (this.squares[i][j].getTile().equals(TileType.TARGET)) {
					count++;
				}
			}
		}
		return count <= 0;
	}
}
