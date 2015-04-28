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
		this.gameBoard = board;
		this.aesthetic = aesthetic;

		this.currentSelection = new Selection();

		// Square attributes
		this.squareBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
		this.squareSelectedBorder = BorderFactory.createLineBorder(
				Color.YELLOW, 2);
		this.squareFont = new Font("Monospace", Font.BOLD, 18);
		this.squareSizeOffset = 10;
		this.squareFontOneSize = 6;
		this.squareFontTwoSize = 2;

		this.boardView = new JLabel[this.gameBoard.SIZE_X][this.gameBoard.SIZE_Y];
		this.boardViewborder = BorderFactory.createLineBorder(Color.BLACK, 2);

		this.setBackground(this.aesthetic.getBackgroundColor());
		this.setVisible(true);

		// Layout for panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1 };
		gridBagLayout.rowHeights = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, 1.0, 1.0, 1.0, 1.0 };
		this.setLayout(gridBagLayout);
		this.gbc_boardViewPanel = new GridBagConstraints();
		this.gbc_boardViewPanel.gridheight = 1;
		this.gbc_boardViewPanel.fill = GridBagConstraints.BOTH;

		logger.log(Level.FINE, "Board and layout initialized");

		// Initialize board view
		this.drawBoardView();
	}

	/**
	 * Gets the smaller of the board height or width for resizing square views
	 * for this panel.
	 *
	 * @return an integer equal to the smaller dimension
	 */
	protected int getMinOfHeightAndWidth() {
		return (this.getWidth() < this.getHeight()) ? this.getWidth() : this
				.getHeight();
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
			return this.aesthetic.getMarkedColor();
		}

		// Check by tile number
		switch (square.getTile().getNumber()) {
		case 0:
			// Check tile type
			if (square.getTile().getType().equals(TileType.NULL)) {
				return this.aesthetic.getNullTileColor();
			} else if (square.getTile().getType().equals(TileType.TARGET)) {
				return this.aesthetic.getTargetColor();
			}
		case 1:
			return this.aesthetic.getTileOneColor();
		case 2:
			return this.aesthetic.getTileTwoColor();
		case 3:
			return this.aesthetic.getTileThreeColor();
		case 4:
			return this.aesthetic.getTileFourColor();
		case 5:
			return this.aesthetic.getTileFiveColor();
		case 6:
			if (square.getTile().getType().equals(TileType.SIX)
					&& ((SixTile) square.getTile()).hasProcessed()) {
				return this.aesthetic.getTargetColor();
			}
			return this.aesthetic.getTileSixColor();
		default:
			return this.aesthetic.getBackgroundColor();
		}
	}

	/**
	 * Initializes the board view with all its squares and draws it to the
	 * panel.
	 */
	protected void drawBoardView() {
		for (int i = 0; i < this.gameBoard.SIZE_X; i++) {
			for (int j = 0; j < this.gameBoard.SIZE_Y; j++) {

				// Initialize the JLabel
				this.boardView[i][j] = new JLabel();
				this.boardView[i][j]
						.setHorizontalAlignment(SwingConstants.CENTER);
				this.boardView[i][j].setOpaque(true);
				this.boardView[i][j].setFont(this.squareFont);
				this.boardView[i][j].setBorder(this.squareBorder);
				this.boardView[i][j].setBackground(this
						.getSquareColor(this.gameBoard.getSquare(i, j)));

				// Determine text
				switch (this.gameBoard.getSquare(i, j).getTile().getType()) {
				case NULL:
					this.boardView[i][j].setText(this.htmlFormat1
							+ this.squareFontOneSize
							+ htmlFormat2
							+ this.gameBoard.getSquare(i, j).getTile()
									.getNumber()
							+ this.htmlFormat3
							+ this.squareFontTwoSize
							+ htmlFormat2
							+ "x"
							+ this.gameBoard.getSquare(i, j).getTile()
									.getMultiplier() + this.htmlFormat4);
					this.boardView[i][j].setForeground(this.boardView[i][j]
							.getBackground());
					break;
				case TARGET:
					this.boardView[i][j].setText(this.htmlFormat1
							+ this.squareFontOneSize + htmlFormat2 + "&nbsp;"
							+ "X" + this.htmlFormat3 + this.squareFontTwoSize
							+ htmlFormat2 + this.htmlFormat4);
					break;
				case SIX:
					this.boardView[i][j].setText(this.htmlFormat1
							+ this.squareFontOneSize
							+ htmlFormat2
							+ this.gameBoard.getSquare(i, j).getTile()
									.getNumber() + this.htmlFormat3
							+ this.squareFontTwoSize + htmlFormat2 + "T"
							+ this.htmlFormat4);
					break;
				default:
					this.boardView[i][j].setText(this.htmlFormat1
							+ this.squareFontOneSize
							+ htmlFormat2
							+ this.gameBoard.getSquare(i, j).getTile()
									.getNumber()
							+ this.htmlFormat3
							+ this.squareFontTwoSize
							+ htmlFormat2
							+ "x"
							+ this.gameBoard.getSquare(i, j).getTile()
									.getMultiplier() + this.htmlFormat4);
					break;
				}

				// Determine the position and size
				this.boardView[i][j].setLocation(
						this.getBoardWidthOffset()
								+ (this.getSquareSideLength() * i)
								+ (this.getSquareMargin() * i),
						this.getBoardHeightOffset()
								+ (this.getSquareSideLength() * j)
								+ (this.getSquareMargin() * j));

				this.boardView[i][j].setSize(new Dimension(this
						.getSquareSideLength(), this.getSquareSideLength()));

				// Determine border based on selected attribute
				if (this.gameBoard.getSquare(i, j).getSelected()) {
					this.boardView[i][j].setBorder(this.squareSelectedBorder);
				} else {
					this.boardView[i][j].setBorder(this.squareBorder);
				}

				// Update position and add to panel
				this.gbc_boardViewPanel.gridx = i + 1;
				this.gbc_boardViewPanel.gridy = j + 1;
				this.add(this.boardView[i][j], this.gbc_boardViewPanel);
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
		return (this.getMinOfHeightAndWidth() / 9) - squareSizeOffset;
	}

	/**
	 * Gets the margin between squares from the height and width and the side
	 * length of the square.
	 *
	 * @return an integer
	 */
	protected int getSquareMargin() {
		return (this.getMinOfHeightAndWidth() - (this.getSquareSideLength() * 9)) / 10;
	}

	/**
	 * Gets the margin between the board of squares and the panel edges in the
	 * horizontal direction.
	 *
	 * @return an integer
	 */
	protected int getBoardWidthOffset() {
		return (this.getWidth() - ((this.getSquareSideLength() * 9) + (this
				.getSquareMargin() * 8))) / 2;
	}

	/**
	 * Gets the margin between the board of squares and the panel edges in the
	 * vertical direction.
	 *
	 * @return an integer
	 */
	protected int getBoardHeightOffset() {
		return (this.getHeight() - ((this.getSquareSideLength() * 9) + (this
				.getSquareMargin() * 8))) / 2;
	}

	/**
	 * Sets the square size offset to the specified offset.
	 *
	 * @param offset
	 *            The new square size offset.
	 */
	public void setSquareOffset(int offset) {
		this.squareSizeOffset = offset;
	}

	/**
	 * Sets the board to the specified board.
	 *
	 * @param board
	 *            The new board to display.
	 */
	public void setBoard(Board board) {
		this.gameBoard = board;
	}

	/**
	 * Sets the aesthetic to the specified aesthetic.
	 *
	 * @param aesthetic
	 *            The new aesthetic to use for the board view.
	 */
	public void setAesthetic(Aesthetic aesthetic) {
		this.aesthetic = aesthetic;
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
		this.squareFontOneSize = large;
		this.squareFontTwoSize = small;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.removeAll();

		// Redraw the board view
		this.drawBoardView();
		this.updateUI();
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
	 * Updates the current square selection based on mouse coordinates.
	 *
	 * @param mx
	 *            The horizontal position of the mouse.
	 * @param my
	 *            The vertical position of the mouse.
	 */
	public void updateGameSelection(int mx, int my) {
		outerloop: for (int i = 0; i < this.gameBoard.SIZE_X; i++) {
			for (int j = 0; j < this.gameBoard.SIZE_Y; j++) {

				// If the square is validly selected, update the view and add
				// the square to the selection.
				if (this.validateMouseSelection(mx, my, this.boardView[i][j])) {
					this.gameBoard.getSquare(i, j).setSelected(true);
					this.currentSelection.add(this.gameBoard.getSquare(i, j));

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
		for (int i = 0; i < this.gameBoard.SIZE_X; i++) {
			for (int j = 0; j < this.gameBoard.SIZE_Y; j++) {

				// Set all the squares to the normal state
				this.gameBoard.getSquare(i, j).setSelected(false);
			}
		}

		// Empty the current selection
		logger.log(Level.INFO, "Selection move cleared.");
		this.currentSelection.clear();
	}

	/**
	 * Updates the mouse press locations with the designated tiles when
	 * requested in the level builder.
	 *
	 * @param mx
	 *            The horizontal position of the mouse.
	 * @param my
	 *            The vertical position of the mouse.
	 * @param type
	 *            The type of tile to place.
	 */
	public void updateBuilderSelection(int mx, int my, TileType type) {
		outerloop: for (int i = 0; i < this.gameBoard.SIZE_X; i++) {
			for (int j = 0; j < this.gameBoard.SIZE_Y; j++) {

				// If the SquareView is validly selected, update the selected
				// tile to the new tile type.
				if (this.validateMouseSelection(mx, my, this.boardView[i][j])) {

					// Handle placing each type of tile
					switch (type) {
					case NULL:
						this.gameBoard.setSquare(new NullTile(), i, j, false);
						break;
					case NUMBER:
						this.gameBoard.setSquare(
								new NumberTile(
										this.gameBoard.getRandomNumber(),
										this.gameBoard.getRandomMultiplier()),
								i, j, false);
						break;
					case TARGET:
						this.gameBoard.setSquare(new TargetTile(), i, j, false);
						break;
					case SIX:
						this.gameBoard.setSquare(new SixTile(), i, j, false);
						break;
					default:
						this.gameBoard.setSquare(new NullTile(), i, j, false);
						break;
					}

					logger.log(Level.FINE, "Updated mouse selection at: {" + i
							+ ", " + j + "} with tile type: " + type.toString());
					break outerloop;
				}
			}
		}
	}

	/**
	 * Returns the gameBoard object for this panel.
	 *
	 * @return the gameBoard property
	 */
	public Board getBoard() {
		return this.gameBoard;
	}

	/**
	 * Returns the currentSelection object for this panel.
	 *
	 * @return the currentSelection property
	 */
	public Selection getCurrentSelection() {
		return this.currentSelection;
	}

	/**
	 * Executes the selection in the current selection. Removes the tiles and
	 * fills the empty squares with newly generated tiles. Returns the current
	 * selection's calculated score.
	 *
	 * @return an integer
	 */
	public int doSelectionMove() {
		int score = this.currentSelection.getScore();
		this.gameBoard.processSelection(this.currentSelection);

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
		int score = this.currentSelection.getScore();
		this.gameBoard.processEliminationSelection(this.currentSelection);

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
		int score = this.currentSelection.getScore();
		this.gameBoard.processReleaseSelection(this.currentSelection);

		logger.log(Level.INFO, "Board processed a release selection move.");
		return score;
	}

	/**
	 * Executes the reset board move.
	 *
	 * @return true
	 */
	public boolean doResetBoardMove() {
		this.gameBoard.resetBoard();

		logger.log(Level.INFO, "Board processed a reset board move.");
		return true;
	}

	/**
	 * Executes the swap tile move.
	 *
	 * @return true
	 */
	public boolean doSwapTileMove() {
		this.gameBoard.processSwapMove(this.currentSelection);

		logger.log(Level.INFO, "Board processed a swap tile move.");
		return true;
	}

	/**
	 * Executes the remove tile move.
	 *
	 * @return true
	 */
	public boolean doRemoveTileMove() {
		this.gameBoard.processSelection(this.currentSelection);

		logger.log(Level.INFO, "Board processed a remove tile move.");
		return true;
	}
}
