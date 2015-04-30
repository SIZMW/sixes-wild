package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import SixesWild.com.mimas.sixeswild.entities.Aesthetic;
import SixesWild.com.mimas.sixeswild.entities.Board;
import SixesWild.com.mimas.sixeswild.entities.LevelType;
import SixesWild.com.mimas.sixeswild.entities.NullTile;
import SixesWild.com.mimas.sixeswild.entities.NumberTile;
import SixesWild.com.mimas.sixeswild.entities.Selection;
import SixesWild.com.mimas.sixeswild.entities.SixTile;
import SixesWild.com.mimas.sixeswild.entities.Square;
import SixesWild.com.mimas.sixeswild.entities.TargetTile;
import SixesWild.com.mimas.sixeswild.entities.TileType;

/**
 * This class represents the view used to display the game board in the level
 * view of the game and the builder. It handles calling the logic on the Board
 * entity based on the given input.
 *
 * @author Aditya Nivarthi
 */
public class BoardViewPanel extends JPanel {

	private static final Logger logger = Logger.getGlobal();
	private static final long serialVersionUID = 1L;

	// Panel attributes
	protected Aesthetic aesthetic;
	protected Board gameBoard;
	protected JLabel boardView[][];
	protected Selection currentSelection;
	protected Border boardViewborder;
	protected GridBagConstraints gbc_boardViewPanel;

	// Square attributes
	protected final String htmlFormat1 = "<html><font size=";
	protected final String htmlFormat2 = ">";
	protected final String htmlFormat3 = "    </font><font size=";
	protected final String htmlFormat4 = "</font></html>";
	protected Border squareBorder;
	protected Border squareSelectedBorder;
	protected Font squareFont;
	protected int squareSizeOffset;
	protected int squareFontOneSize;
	protected int squareFontTwoSize;

	/**
	 * Creates a BoardViewPanel instance with the specified board and aesthetic.
	 *
	 * @param board
	 *            The game board to display.
	 * @param aesthetic
	 *            The aesthetic to use for tile colors.
	 */
	public BoardViewPanel(Board board, Aesthetic aesthetic) {
		super();

		// Attributes
		gameBoard = board;
		this.aesthetic = aesthetic;

		currentSelection = new Selection();

		// Square attributes
		squareBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
		squareSelectedBorder = BorderFactory.createLineBorder(Color.YELLOW, 2);
		squareFont = new Font("Monospace", Font.BOLD, 18);
		squareSizeOffset = 10;
		squareFontOneSize = 6;
		squareFontTwoSize = 2;

		boardView = new JLabel[gameBoard.SIZE_X][gameBoard.SIZE_Y];
		boardViewborder = BorderFactory.createLineBorder(Color.BLACK, 2);

		setBackground(this.aesthetic.getBackgroundColor());
		setVisible(true);

		// Layout for panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1 };
		gridBagLayout.rowHeights = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, 1.0, 1.0, 1.0, 1.0 };
		setLayout(gridBagLayout);
		gbc_boardViewPanel = new GridBagConstraints();
		gbc_boardViewPanel.gridheight = 1;
		gbc_boardViewPanel.fill = GridBagConstraints.BOTH;

		logger.log(Level.FINE, "Board and layout initialized");

		// Initialize board view
		drawBoardView();
	}

	/**
	 * Gets the smaller of the board height or width for resizing square views
	 * for this panel.
	 *
	 * @return an integer equal to the smaller dimension
	 */
	protected int getMinOfHeightAndWidth() {
		return (getWidth() < getHeight()) ? getWidth() : getHeight();
	}

	/**
	 * Returns the corresponding color based on the attributes of the square.
	 *
	 * @param square
	 *            The square to retrieve a Color for.
	 * @return the given square's corresponding tile color
	 */
	protected Color getSquareColor(Square square) {

		// Marked attribute
		if (square.getMarked()) {
			return aesthetic.getMarkedColor();
		}

		// Check by tile number
		switch (square.getTile().getNumber()) {
		case 0:
			// Check tile type
			if (square.getTile().getType().equals(TileType.NULL)) {
				return aesthetic.getNullTileColor();
			} else if (square.getTile().getType().equals(TileType.TARGET)) {
				return aesthetic.getTargetColor();
			}
		case 1:
			return aesthetic.getTileOneColor();
		case 2:
			return aesthetic.getTileTwoColor();
		case 3:
			return aesthetic.getTileThreeColor();
		case 4:
			return aesthetic.getTileFourColor();
		case 5:
			return aesthetic.getTileFiveColor();
		case 6:
			if (square.getTile().getType().equals(TileType.SIX)
					&& ((SixTile) square.getTile()).hasProcessed()) {
				return aesthetic.getTargetColor();
			}
			return aesthetic.getTileSixColor();
		default:
			return aesthetic.getBackgroundColor();
		}
	}

	/**
	 * Initializes the board view with all its squares and draws it to the
	 * panel.
	 */
	protected void drawBoardView() {
		for (int i = 0; i < gameBoard.SIZE_X; i++) {
			for (int j = 0; j < gameBoard.SIZE_Y; j++) {

				// Initialize the JLabel
				boardView[i][j] = new JLabel();
				boardView[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				boardView[i][j].setOpaque(true);
				boardView[i][j].setFont(squareFont);
				boardView[i][j].setBorder(squareBorder);
				boardView[i][j].setBackground(getSquareColor(gameBoard
						.getSquare(i, j)));

				// Determine text
				switch (gameBoard.getSquare(i, j).getTile().getType()) {
				case NULL:
					boardView[i][j].setText(htmlFormat1
							+ squareFontOneSize
							+ htmlFormat2
							+ gameBoard.getSquare(i, j).getTile().getNumber()
							+ htmlFormat3
							+ squareFontTwoSize
							+ htmlFormat2
							+ "x"
							+ gameBoard.getSquare(i, j).getTile()
									.getMultiplier() + htmlFormat4);
					boardView[i][j].setForeground(boardView[i][j]
							.getBackground());
					break;
				case TARGET:
					boardView[i][j].setText(htmlFormat1 + squareFontOneSize
							+ htmlFormat2 + "&nbsp;" + "X" + htmlFormat3
							+ squareFontTwoSize + htmlFormat2 + htmlFormat4);
					break;
				case SIX:
					boardView[i][j].setText(htmlFormat1 + squareFontOneSize
							+ htmlFormat2
							+ gameBoard.getSquare(i, j).getTile().getNumber()
							+ htmlFormat3 + squareFontTwoSize + htmlFormat2
							+ "T" + htmlFormat4);
					break;
				default:
					boardView[i][j].setText(htmlFormat1
							+ squareFontOneSize
							+ htmlFormat2
							+ gameBoard.getSquare(i, j).getTile().getNumber()
							+ htmlFormat3
							+ squareFontTwoSize
							+ htmlFormat2
							+ "x"
							+ gameBoard.getSquare(i, j).getTile()
									.getMultiplier() + htmlFormat4);
					break;
				}

				// Determine the position and size
				boardView[i][j].setLocation(
						getBoardWidthOffset() + (getSquareSideLength() * i)
								+ (getSquareMargin() * i),
						getBoardHeightOffset() + (getSquareSideLength() * j)
								+ (getSquareMargin() * j));

				boardView[i][j].setSize(new Dimension(getSquareSideLength(),
						getSquareSideLength()));

				// Determine border based on selected attribute
				if (gameBoard.getSquare(i, j).getSelected()) {
					boardView[i][j].setBorder(squareSelectedBorder);
				} else {
					boardView[i][j].setBorder(squareBorder);
				}

				// Update position and add to panel
				gbc_boardViewPanel.gridx = i + 1;
				gbc_boardViewPanel.gridy = j + 1;
				this.add(boardView[i][j], gbc_boardViewPanel);
			}
		}
	}

	/**
	 * Gets the square side length based on the size offset and the minimum of
	 * the height and width of the panel.
	 *
	 * @return an integer
	 */
	protected int getSquareSideLength() {
		return (getMinOfHeightAndWidth() / 9) - squareSizeOffset;
	}

	/**
	 * Gets the margin between squares from the height and width and the side
	 * length of the square.
	 *
	 * @return an integer
	 */
	protected int getSquareMargin() {
		return (getMinOfHeightAndWidth() - (getSquareSideLength() * 9)) / 10;
	}

	/**
	 * Gets the margin between the board of squares and the panel edges in the
	 * horizontal direction.
	 *
	 * @return an integer
	 */
	protected int getBoardWidthOffset() {
		return (getWidth() - ((getSquareSideLength() * 9) + (getSquareMargin() * 8))) / 2;
	}

	/**
	 * Gets the margin between the board of squares and the panel edges in the
	 * vertical direction.
	 *
	 * @return an integer
	 */
	protected int getBoardHeightOffset() {
		return (getHeight() - ((getSquareSideLength() * 9) + (getSquareMargin() * 8))) / 2;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		removeAll();

		// Redraw the board view
		drawBoardView();
		updateUI();
	}

	/**
	 * Validates the mouse selection over the specified square.
	 *
	 * @param mx
	 *            The horizontal position of the mouse.
	 * @param my
	 *            The vertical position of the mouse.
	 * @param square
	 *            The square image to verify for mouse selection.
	 * @return true if the square is selected; false otherwise.
	 */
	protected boolean validateMouseSelection(int mx, int my, JLabel square) {
		return mx - square.getX() > 0 && mx - square.getX() < square.getWidth()
				&& my - square.getY() > 0
				&& my - square.getY() < square.getHeight();
	}

	/**
	 * Sets the square size offset to the specified offset.
	 *
	 * @param offset
	 *            The new square size offset.
	 */
	public void setSquareOffset(int offset) {
		squareSizeOffset = offset;
	}

	/**
	 * Sets the board to the specified board.
	 *
	 * @param board
	 *            The new board to display.
	 */
	public void setBoard(Board board) {
		gameBoard = board;
	}

	/**
	 * Sets the aesthetic to the specified aesthetic.
	 *
	 * @param aesthetic
	 *            The new aesthetic to use for the board view.
	 */
	public void setAesthetic(Aesthetic aesthetic) {
		this.aesthetic = aesthetic;
		setBackground(this.aesthetic.getBackgroundColor());
	}

	/**
	 * Sets the font sizes for the square views to the specified values.
	 *
	 * @param large
	 *            The primary character font size.
	 * @param small
	 *            The secondary character font size.
	 */
	public void setFontSizes(int large, int small) {
		squareFontOneSize = large;
		squareFontTwoSize = small;
	}

	/**
	 * Returns the gameBoard object for this panel.
	 *
	 * @return the gameBoard property
	 */
	public Board getBoard() {
		return gameBoard;
	}

	/**
	 * Returns the currentSelection object for this panel.
	 *
	 * @return the currentSelection property
	 */
	public Selection getCurrentSelection() {
		return currentSelection;
	}

	/**
	 * Updates the current square selection based on mouse coordinates.
	 *
	 * @param mx
	 *            The horizontal position of the mouse.
	 * @param my
	 *            The vertical position of the mouse.
	 */
	public void updateGameSelection(int mx, int my) {
		outerloop: for (int i = 0; i < gameBoard.SIZE_X; i++) {
			for (int j = 0; j < gameBoard.SIZE_Y; j++) {

				// If the square is validly selected, update the view and add
				// the square to the selection.
				if (validateMouseSelection(mx, my, boardView[i][j])) {
					gameBoard.getSquare(i, j).setSelected(true);
					currentSelection.add(gameBoard.getSquare(i, j));

					logger.log(Level.FINE,
							"Updating selection. Square found at: {" + i + ", "
									+ j + "}");
					break outerloop;
				}
			}
		}
	}

	/**
	 * Clears the current selection.
	 */
	public void clearGameSelection() {
		for (int i = 0; i < gameBoard.SIZE_X; i++) {
			for (int j = 0; j < gameBoard.SIZE_Y; j++) {

				// Set all the squares to the normal state
				gameBoard.getSquare(i, j).setSelected(false);
			}
		}

		// Empty the current selection
		logger.log(Level.INFO, "Selection move cleared.");
		currentSelection.clear();
	}

	/**
	 * Updates the mouse press locations with the designated tiles when
	 * requested in the level builder. Returns the replaced Square.
	 *
	 * @param mx
	 *            The horizontal position of the mouse.
	 * @param my
	 *            The vertical position of the mouse.
	 * @param type
	 *            The type of tile to place.
	 * @return a Square
	 */
	public Square updateBuilderSelection(int mx, int my, TileType type) {

		Square oldSquare = null;
		Square oldReturn = null;

		outerloop: for (int i = 0; i < gameBoard.SIZE_X; i++) {
			for (int j = 0; j < gameBoard.SIZE_Y; j++) {

				// If the SquareView is validly selected, update the selected
				// tile to the new tile type.
				if (validateMouseSelection(mx, my, boardView[i][j])) {

					// Handle placing each type of tile
					switch (type) {
					case NULL:
						oldSquare = gameBoard.getSquare(i, j);
						oldReturn = new Square(oldSquare.getTile(),
								oldSquare.getX(), oldSquare.getY(),
								oldSquare.getMarked());
						gameBoard.setSquare(new NullTile(), i, j, false);
						break;
					case NUMBER:
						oldSquare = gameBoard.getSquare(i, j);
						oldReturn = new Square(oldSquare.getTile(),
								oldSquare.getX(), oldSquare.getY(),
								oldSquare.getMarked());
						gameBoard.setSquare(
								new NumberTile(gameBoard.getNumber(), gameBoard
										.getMultiplier()), i, j, false);
						break;
					case TARGET:
						oldSquare = gameBoard.getSquare(i, j);
						oldReturn = new Square(oldSquare.getTile(),
								oldSquare.getX(), oldSquare.getY(),
								oldSquare.getMarked());
						gameBoard.setSquare(new TargetTile(), i, j, false);
						break;
					case SIX:
						oldSquare = gameBoard.getSquare(i, j);
						oldReturn = new Square(oldSquare.getTile(),
								oldSquare.getX(), oldSquare.getY(),
								oldSquare.getMarked());
						gameBoard.setSquare(new SixTile(), i, j, false);
						break;
					default:
						oldSquare = gameBoard.getSquare(i, j);
						oldReturn = new Square(oldSquare.getTile(),
								oldSquare.getX(), oldSquare.getY(),
								oldSquare.getMarked());
						gameBoard.setSquare(new NullTile(), i, j, false);
						break;
					}

					logger.log(Level.FINE, "Updated mouse selection at: {" + i
							+ ", " + j + "} with tile type: " + type.toString());
					break outerloop;
				}
			}
		}

		return oldReturn;
	}

	/**
	 * Executes the selection in the current selection. Removes the tiles and
	 * fills the empty squares with newly generated tiles. Returns the current
	 * selection's calculated score.
	 *
	 * @return an integer
	 */
	public int doSelectionMove() {
		int score = currentSelection.getScore();
		gameBoard.processSelection(currentSelection);

		logger.log(Level.INFO, "Board processed a selection move.");
		return score;
	}

	/**
	 * Executes the selection in the current selection. Removes the tiles and
	 * fills the empty squares with newly generated tiles. Marks the squares
	 * that were regenerated. Returns the current selection's calculated score.
	 *
	 * @return an integer
	 */
	public int doEliminationSelectionMove() {
		int score = currentSelection.getScore();
		gameBoard.processEliminationSelection(currentSelection);

		logger.log(Level.INFO, "Board processed an elimination selection move.");
		return score;
	}

	/**
	 * Executes the selection in the current selection. Removes the tiles and
	 * fills the empty squares with newly generated tiles. Replaces the target
	 * tiles with the six tiles when they land above them. Returns the current
	 * selection's calculated score.
	 *
	 * @return an integer
	 */
	public int doReleaseSelectionMove() {
		int score = currentSelection.getScore();
		gameBoard.processReleaseSelection(currentSelection);

		logger.log(Level.INFO, "Board processed a release selection move.");
		return score;
	}

	/**
	 * Executes the reset board move.
	 *
	 * @return true
	 */
	public boolean doResetBoardMove() {
		gameBoard.resetBoard();

		logger.log(Level.INFO, "Board processed a reset board move.");
		return true;
	}

	/**
	 * Executes the swap tile move.
	 *
	 * @return true
	 */
	public boolean doSwapTileMove() {
		gameBoard.processSwapMove(currentSelection);

		logger.log(Level.INFO, "Board processed a swap tile move.");
		return true;
	}

	/**
	 * Executes the remove tile move.
	 *
	 * @param type
	 *            The type of level being played.
	 * @return true
	 */
	public boolean doRemoveTileMove(LevelType type) {
		if (type.equals(LevelType.RELEASE)) {
			gameBoard.processReleaseSelection(currentSelection);
		} else {
			gameBoard.processSelection(currentSelection);
		}

		logger.log(Level.INFO, "Board processed a remove tile move.");
		return true;
	}
}
