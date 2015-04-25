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
	protected final String htmlFormat1 = "<html><font size=6>";
	protected final String htmlFormat2 = "    </font><font size=2>";
	protected final String htmlFormat3 = "</font></html>";
	protected Border squareBorder;
	protected Border squareSelectedBorder;
	protected Font squareFont;

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
		this.squareBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
		this.squareSelectedBorder = BorderFactory.createLineBorder(
				Color.YELLOW, 2);
		this.squareFont = new Font("Monospace", Font.BOLD, 18);
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
		setLayout(gridBagLayout);
		this.gbc_boardViewPanel = new GridBagConstraints();
		this.gbc_boardViewPanel.gridheight = 1;
		this.gbc_boardViewPanel.fill = GridBagConstraints.BOTH;

		logger.log(Level.FINE, "Board and layout initialized");

		// Initialize board view
		this.initializeBoardView();
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
			return this.aesthetic.getTileSixColor();
		default:
			return this.aesthetic.getBackgroundColor();
		}
	}

	/**
	 * Initializes the board view with all its squares and adds it to the panel.
	 */
	protected void initializeBoardView() {
		for (int i = 0; i < this.gameBoard.SIZE_X; i++) {
			for (int j = 0; j < this.gameBoard.SIZE_Y; j++) {

				// Initialize the JLabel
				boardView[i][j] = new JLabel();
				boardView[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				boardView[i][j].setOpaque(true);
				boardView[i][j].setFont(this.squareFont);
				boardView[i][j].setBorder(this.squareBorder);
				boardView[i][j].setBackground(this
						.getSquareColor(this.gameBoard.getSquare(i, j)));

				// Determine text
				switch (this.gameBoard.getSquare(i, j).getTile().getType()) {
				case NULL:
					boardView[i][j].setText(htmlFormat1
							+ this.gameBoard.getSquare(i, j).getTile()
									.getNumber()
							+ htmlFormat2
							+ "x"
							+ this.gameBoard.getSquare(i, j).getTile()
									.getMultiplier() + htmlFormat3);
					boardView[i][j].setForeground(boardView[i][j]
							.getBackground());
					break;
				case TARGET:
					boardView[i][j].setText(htmlFormat1 + "&nbsp;" + "X"
							+ htmlFormat2 + htmlFormat3);
					break;
				case SIX:
					boardView[i][j].setText(htmlFormat1
							+ this.gameBoard.getSquare(i, j).getTile()
									.getNumber() + htmlFormat2 + "T"
							+ htmlFormat3);
					break;
				default:
					boardView[i][j].setText(htmlFormat1
							+ this.gameBoard.getSquare(i, j).getTile()
									.getNumber()
							+ htmlFormat2
							+ "x"
							+ this.gameBoard.getSquare(i, j).getTile()
									.getMultiplier() + htmlFormat3);
					break;
				}

				// Determine the position and size
				boardView[i][j]
						.setLocation(
								(((this.getWidth() - (((int) this.getWidth() / 9) * 9)) + 10) / 2)
										+ (this.getWidth() / 9 * this.gameBoard
												.getSquare(i, j).getX()),
								(((this.getHeight() - (((int) this.getHeight() / 9) * 9)) + 10) / 2)
										+ (this.getHeight() / 9 * this.gameBoard
												.getSquare(i, j).getY()));
				boardView[i][j].setSize(new Dimension(this
						.getMinOfHeightAndWidth() / 9 - 20, this
						.getMinOfHeightAndWidth() / 9 - 20));

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.removeAll();
		this.initializeBoardView();
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
		outerloop: for (int i = 0; i < gameBoard.SIZE_X; i++) {
			for (int j = 0; j < gameBoard.SIZE_Y; j++) {

				// If the square is validly selected, update the view and add
				// the square to the selection.
				if (this.validateMouseSelection(mx, my, boardView[i][j])) {
					this.gameBoard.getSquare(i, j).setSelected(true);
					this.currentSelection.add(gameBoard.getSquare(i, j));

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
		outerloop: for (int i = 0; i < gameBoard.SIZE_X; i++) {
			for (int j = 0; j < gameBoard.SIZE_Y; j++) {
				// If the SquareView is selected in a valid manner, update the
				// selected tile to the new tile type.
				if (this.validateMouseSelection(mx, my, boardView[i][j])) {
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
		this.gameBoard.removeSelection(this.currentSelection);
		this.gameBoard.shiftTilesDownward();
		this.gameBoard.fillEmptySquares();

		logger.log(Level.INFO, "Selection move processed.");
		return score;
	}

	/**
	 * Executes the reset board move.
	 * 
	 * @return true
	 */
	public boolean doResetBoardMove() {
		this.gameBoard.resetBoard();

		logger.log(Level.INFO, "Reset board move processed.");
		return true;
	}
}
