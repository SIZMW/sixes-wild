package SixesWild.com.mimas.sixeswild.entities;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

/**
 * This test case handles testing all methods for the Board class.
 *
 * @author Aditya Nivarthi
 */
public class TestBoard extends TestCase {

	Board board;
	Board numberBoard;
	Board sixBoard;
	Board nullBoard;
	Board targetBoard;

	Tile numberTiles[][];
	Tile sixTiles[][];
	Tile nullTiles[][];
	Tile targetTiles[][];

	ArrayList<Double> tileFrequencies;
	ArrayList<Double> multiplierFrequencies;

	Selection selection;

	/*
	 * (non-Javadoc)
	 *
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	public void setUp() {
		board = new Board();

		tileFrequencies = new ArrayList<Double>(Arrays.asList(.1, .2, .3, .3,
				.05, .05));
		multiplierFrequencies = new ArrayList<Double>(Arrays.asList(.5, .25,
				.25));

		numberTiles = new Tile[9][9];
		sixTiles = new Tile[9][9];
		nullTiles = new Tile[9][9];
		targetTiles = new Tile[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				numberTiles[i][j] = new NumberTile(2, 2);
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sixTiles[i][j] = new SixTile();
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				nullTiles[i][j] = new NullTile();
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				targetTiles[i][j] = new TargetTile();
			}
		}

		try {
			numberBoard = new Board(numberTiles, tileFrequencies,
					multiplierFrequencies);
			sixBoard = new Board(sixTiles, tileFrequencies,
					multiplierFrequencies);
			nullBoard = new Board(nullTiles, tileFrequencies,
					multiplierFrequencies);
			targetBoard = new Board(targetTiles, tileFrequencies,
					multiplierFrequencies);
		} catch (Exception e) {
		}

		selection = new Selection();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	public void tearDown() {

	}

	/**
	 * Test setting a square and getting a square in the board.
	 */
	public void testSquareSetAndGet() {
		// Setup
		board.initialize();
		Square square = new Square(new NumberTile(1, 1), 0, 0, false);
		board.setSquare(square.getTile(), square.getX(), square.getY(),
				square.getMarked());

		// Verify result
		assertEquals(square.getTile(),
				board.getSquare(square.getX(), square.getY()).getTile());
		assertEquals(square.getX(),
				board.getSquare(square.getX(), square.getY()).getX());
		assertEquals(square.getY(),
				board.getSquare(square.getX(), square.getY()).getY());
		assertFalse(board.setSquare(null, 0, 0, false));
	}

	/**
	 * Tests randomization for number numberTiles and multipliers.
	 */
	public void testRandomizationMethods() {
		// Setup
		board.initialize();
		int number = board.getNumber();
		int multiplier = board.getMultiplier();
		int randNumber = board.getRandomNumber();
		int randMultiplier = board.getRandomMultiplier();

		// Verify result
		assertTrue(number < 7);
		assertTrue(number > 0);
		assertTrue(multiplier < 4);
		assertTrue(multiplier > 0);

		assertTrue(randNumber < 7);
		assertTrue(randNumber > 0);
		assertTrue(randMultiplier < 4);
		assertTrue(randMultiplier > 0);
	}

	/**
	 * Tests the exception when null tiles are given to the board.
	 */
	public void testBoardException() {
		try {
			numberBoard = new Board(null, tileFrequencies,
					multiplierFrequencies);
			fail("Missing exception");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	/**
	 * Tests whether each square has the board's corresponding tile when the
	 * board is constructed with frequencies.
	 */
	public void testBoardFrequencyInitialize() {
		for (int i = 0; i < numberBoard.SIZE_X; i++) {
			for (int j = 0; j < numberBoard.SIZE_Y; j++) {
				assertEquals(numberBoard.squares[i][j].getTile().getType(),
						TileType.NUMBER);
			}
		}

		for (int i = 0; i < sixBoard.SIZE_X; i++) {
			for (int j = 0; j < sixBoard.SIZE_Y; j++) {
				assertEquals(sixBoard.squares[i][j].getTile().getType(),
						TileType.SIX);
			}
		}

		for (int i = 0; i < nullBoard.SIZE_X; i++) {
			for (int j = 0; j < nullBoard.SIZE_Y; j++) {
				assertEquals(nullBoard.squares[i][j].getTile().getType(),
						TileType.NULL);
			}
		}

		for (int i = 0; i < targetBoard.SIZE_X; i++) {
			for (int j = 0; j < targetBoard.SIZE_Y; j++) {
				assertEquals(targetBoard.squares[i][j].getTile().getType(),
						TileType.TARGET);
			}
		}
	}

	/**
	 * Tests getting the tile and multiplier frequencies.
	 */
	public void testBoardGetMethods() {
		for (int i = 0; i < tileFrequencies.size(); i++) {
			assertEquals(numberBoard.getTileFrequencies().get(i),
					tileFrequencies.get(i));
		}

		for (int i = 0; i < multiplierFrequencies.size(); i++) {
			assertEquals(numberBoard.getMultiplierFrequencies().get(i),
					multiplierFrequencies.get(i));
		}
	}

	/**
	 * Tests removing a selection from the board and checking if the squares
	 * have null tiles.
	 */
	public void testRemoveSelection() {
		assertFalse(numberBoard.removeSelection(null));

		numberBoard.setSquare(new NumberTile(2, 1), 0, 0, false);
		numberBoard.setSquare(new NumberTile(2, 1), 0, 1, false);
		numberBoard.setSquare(new NumberTile(2, 1), 0, 2, false);

		selection.add(numberBoard.getSquare(0, 0));
		selection.add(numberBoard.getSquare(0, 1));
		selection.add(numberBoard.getSquare(0, 2));

		numberBoard.removeSelection(selection);

		assertEquals(numberBoard.getSquare(0, 0).getTile(), null);
		assertEquals(numberBoard.getSquare(0, 1).getTile(), null);
		assertEquals(numberBoard.getSquare(0, 2).getTile(), null);
	}

	/**
	 * Tests if the board after reset has all the squares from the state prior
	 * to the reset.
	 */
	public void testResetBoard() {
		Square oldSquare[][] = new Square[9][9];

		for (int i = 0; i < numberBoard.SIZE_X; i++) {
			for (int j = 0; j < numberBoard.SIZE_Y; j++) {
				oldSquare[i][j] = new Square(numberBoard.getSquare(i, j)
						.getTile(), i, j, numberBoard.getSquare(i, j)
						.getMarked());
			}
		}

		numberBoard.resetBoard();
		boolean allExist = false;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < numberBoard.SIZE_X; k++) {
					for (int l = 0; l < numberBoard.SIZE_Y; l++) {
						if (oldSquare[i][j].getTile().equals(
								numberBoard.getSquare(k, l).getTile())) {
							allExist = true;
						}
					}
				}

				assertTrue(allExist);
				allExist = false;
			}
		}
	}

	/**
	 * Tests filling the empty squares after a selection has been removed.
	 */
	public void testFillEmptySquares() {
		numberBoard.setSquare(new NumberTile(2, 1), 0, 0, false);
		numberBoard.setSquare(new NumberTile(2, 1), 0, 1, false);
		numberBoard.setSquare(new NumberTile(2, 1), 0, 2, false);

		selection.add(numberBoard.getSquare(0, 0));
		selection.add(numberBoard.getSquare(0, 1));
		selection.add(numberBoard.getSquare(0, 2));

		assertTrue(selection.isSelectionValid());
		numberBoard.removeSelection(selection);

		assertEquals(numberBoard.getSquare(0, 0).getTile(), null);
		assertEquals(numberBoard.getSquare(0, 1).getTile(), null);
		assertEquals(numberBoard.getSquare(0, 2).getTile(), null);

		numberBoard.fillEmptySquares();

		assertNotNull(numberBoard.getSquare(0, 0).getTile());
		assertNotNull(numberBoard.getSquare(0, 1).getTile());
		assertNotNull(numberBoard.getSquare(0, 2).getTile());
	}

	/**
	 * Test the new positions after a complete selection move is made
	 */
	public void testStandardSelectionMove() {
		int square5 = numberBoard.getSquare(0, 5).getTile().getNumber();
		int square4 = numberBoard.getSquare(0, 4).getTile().getNumber();
		int square3 = numberBoard.getSquare(0, 3).getTile().getNumber();
		int square2 = numberBoard.getSquare(0, 2).getTile().getNumber();
		int square1 = numberBoard.getSquare(0, 1).getTile().getNumber();
		int square0 = numberBoard.getSquare(0, 0).getTile().getNumber();

		numberBoard.setSquare(new NumberTile(2, 1), 0, 8, false);
		numberBoard.setSquare(new NumberTile(2, 1), 0, 7, false);
		numberBoard.setSquare(new NumberTile(2, 1), 0, 6, false);

		selection.add(numberBoard.getSquare(0, 8));
		selection.add(numberBoard.getSquare(0, 7));
		selection.add(numberBoard.getSquare(0, 6));

		assertTrue(selection.isSelectionValid());
		numberBoard.processSelection(selection);

		assertEquals(numberBoard.getSquare(0, 8).getTile().getNumber(), square5);
		assertEquals(numberBoard.getSquare(0, 7).getTile().getNumber(), square4);
		assertEquals(numberBoard.getSquare(0, 6).getTile().getNumber(), square3);
		assertEquals(numberBoard.getSquare(0, 5).getTile().getNumber(), square2);
		assertEquals(numberBoard.getSquare(0, 4).getTile().getNumber(), square1);
		assertEquals(numberBoard.getSquare(0, 3).getTile().getNumber(), square0);
	}

	/**
	 * Tests the processing of a swap selection.
	 */
	public void testProcessSwap() {
		assertFalse(numberBoard.processSwapMove(null));

		numberBoard.setSquare(new NumberTile(2, 1), 0, 0, false);
		numberBoard.setSquare(new NumberTile(3, 1), 0, 1, false);

		selection.add(numberBoard.getSquare(0, 0));
		selection.add(numberBoard.getSquare(0, 1));

		assertTrue(selection.isSwapValid());

		numberBoard.processSwapMove(selection);

		assertEquals(numberBoard.getSquare(0, 1).getTile().getNumber(), 2);
		assertEquals(numberBoard.getSquare(0, 0).getTile().getNumber(), 3);
	}

	/**
	 * Tests the processing of an elimination selection.
	 */
	public void testProcessElimination() {
		assertFalse(numberBoard.processSwapMove(null));

		numberBoard.setSquare(new NumberTile(3, 1), 0, 0, false);
		numberBoard.setSquare(new NumberTile(3, 1), 0, 1, false);

		selection.add(numberBoard.getSquare(0, 0));
		selection.add(numberBoard.getSquare(0, 1));

		assertTrue(selection.isSelectionValid());

		numberBoard.processEliminationSelection(selection);

		assertTrue(numberBoard.getSquare(0, 1).getMarked());
		assertTrue(numberBoard.getSquare(0, 0).getMarked());
	}
}
