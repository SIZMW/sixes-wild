package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
 * view of the game and the builder.
 * 
 * @author Aditya Nivarthi
 */
public class BoardViewPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	final int SIZE_X = 9;
	final int SIZE_Y = 9;
	
	final String htmlFormat1 = "<html><font size=6>";
	final String htmlFormat2 = "    </font><font size=2>";
	final String htmlFormat3 = "</font></html>";
	//&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

	// Panel attributes
	Aesthetic boardAesthetic;
	Board gameBoard;
	JLabel squareViews[][];
	Selection currentSelection;
	Border boardViewborder;
	GridBagConstraints gbc_boardViewPanel;

	// Square view attributes
	Border squareViewBorder;
	Border squareViewSelectedBorder;

	/**
	 * Creates a BoardViewPanel instance with the specified Board and Aesthetic.
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
		this.boardAesthetic = aesthetic;

		this.currentSelection = new Selection();
		this.squareViewBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
		this.squareViewSelectedBorder = BorderFactory.createLineBorder(
				Color.YELLOW, 2);
		this.squareViews = new JLabel[this.SIZE_X][this.SIZE_Y];
		this.boardViewborder = BorderFactory.createLineBorder(Color.BLACK, 2);

		this.setBackground(this.boardAesthetic.getBackgroundColor());
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

		// Initialize board view
		this.initializeBoardView();
	}

	/**
	 * Gets the smaller of the board height or width for resizing purposes.
	 * 
	 * @return Integer value of the smaller dimension
	 */
	protected int getMinOfHeightAndWidth() {
		return (this.getWidth() < this.getHeight()) ? this.getWidth() : this
				.getHeight();
	}

	/**
	 * Returns the corresponding color based on the attributes of the Square.
	 * 
	 * @param square
	 *            The square to retrieve a Color for.
	 * @return Color based on aesthetic values
	 */
	protected Color getSquareColor(Square square) {

		// Marked attribute
		if (square.getMarked()) {
			return this.boardAesthetic.getMarkedColor();
		}

		// Check by tile number
		switch (square.getTile().getNumber()) {
		case 0:
			// Check tile type
			if (square.getTile().getType().equals(TileType.NULL)) {
				return this.boardAesthetic.getNullTileColor();
			} else if (square.getTile().getType().equals(TileType.TARGET)) {
				return this.boardAesthetic.getTargetColor();
			}
		case 1:
			return this.boardAesthetic.getTileOneColor();
		case 2:
			return this.boardAesthetic.getTileTwoColor();
		case 3:
			return this.boardAesthetic.getTileThreeColor();
		case 4:
			return this.boardAesthetic.getTileFourColor();
		case 5:
			return this.boardAesthetic.getTileFiveColor();
		case 6:
			return this.boardAesthetic.getTileSixColor();
		default:
			return Color.WHITE;
		}
	}

	/**
	 * Initializes the board view and adds it to the panel.
	 */
	protected void initializeBoardView() {
		for (int i = 0; i < this.SIZE_X; i++) {
			for (int j = 0; j < this.SIZE_Y; j++) {

				// Initialize the JLabel
				squareViews[i][j] = new JLabel();
				squareViews[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				squareViews[i][j].setOpaque(true);
				squareViews[i][j].setFont(new Font("Monospace", Font.BOLD, 18));
				squareViews[i][j].setBorder(this.squareViewBorder);
				squareViews[i][j].setBackground(this
						.getSquareColor(this.gameBoard.getSquare(i, j)));

				// Determine text
				switch (this.gameBoard.getSquare(i, j).getTile().getType()) {
				case NULL:
					squareViews[i][j].setText(htmlFormat1 + this.gameBoard.getSquare(i, j)
							.getTile().getNumber()
							+ htmlFormat2 + "x" + this.gameBoard.getSquare(i, j)
							.getTile().getMultiplier() + htmlFormat3);
					squareViews[i][j].setForeground(squareViews[i][j].getBackground());
					break;
				case TARGET:
					squareViews[i][j].setText(htmlFormat1 + "&nbsp;" + "X"
							+ htmlFormat2 + htmlFormat3);
					break;
				case SIX:
					squareViews[i][j].setText(htmlFormat1 + this.gameBoard.getSquare(i, j)
							.getTile().getNumber() + htmlFormat2 + "T" + htmlFormat3);
					break;
				default:
					squareViews[i][j].setText(htmlFormat1 + this.gameBoard.getSquare(i, j)
							.getTile().getNumber()
							+ htmlFormat2 + "x" + this.gameBoard.getSquare(i, j)
							.getTile().getMultiplier() + htmlFormat3);
					break;
				}

				// Determine the position and size
				squareViews[i][j]
						.setLocation(
								(((this.getWidth() - (((int) this.getWidth() / 9) * 9)) + 10) / 2)
										+ (this.getWidth() / 9 * this.gameBoard
												.getSquare(i, j).getX()),
								(((this.getHeight() - (((int) this.getHeight() / 9) * 9)) + 10) / 2)
										+ (this.getHeight() / 9 * this.gameBoard
												.getSquare(i, j).getY()));
				squareViews[i][j].setSize(new Dimension(this
						.getMinOfHeightAndWidth() / 9 - 20, this
						.getMinOfHeightAndWidth() / 9 - 20));

				// Determine border based on selected attribute
				if (gameBoard.getSquare(i, j).getSelected()) {
					squareViews[i][j].setBorder(squareViewSelectedBorder);
				} else {
					squareViews[i][j].setBorder(squareViewBorder);
				}

				// Update position and add to panel
				gbc_boardViewPanel.gridx = i + 1;
				gbc_boardViewPanel.gridy = j + 1;
				this.add(squareViews[i][j], gbc_boardViewPanel);
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
	 * Checks whether mouse coordinates are selecting the given SquareView by
	 * checking if the mouse coordinates are within the width and height of the
	 * given SquareView.
	 * 
	 * @param mx
	 *            X coordinate of mouse.
	 * @param my
	 *            Y coordinate of mouse.
	 * @param squareView
	 *            The SquareView to check selection on.
	 * @return true if the squareView is selected; false otherwise.
	 */
	protected boolean validateMouseSelection(int mx, int my, JLabel squareView) {
		return mx - squareView.getX() > 0
				&& mx - squareView.getX() < squareView.getWidth()
				&& my - squareView.getY() > 0
				&& my - squareView.getY() < squareView.getHeight();
	}

	/**
	 * Updates the current square selection based on mouse coordinates.
	 * 
	 * @param mx
	 *            X coordinate of mouse.
	 * @param my
	 *            Y coordinate of mouse.
	 */
	public void updateGameSelection(int mx, int my) {
		for (int i = 0; i < gameBoard.SIZE_X; i++) {
			for (int j = 0; j < gameBoard.SIZE_Y; j++) {
				// If the SquareView is selected in a valid manner, update the
				// corresponding Square and add the Square to the current
				// selection.
				if (this.validateMouseSelection(mx, my, squareViews[i][j])) {
					this.gameBoard.getSquare(i, j).setSelected(true);
					this.currentSelection.add(gameBoard.getSquare(i, j));
				}
			}
		}

		// If the selection is not valid, clear the entire selection
		if (!this.currentSelection.isValidSelection()) {
			this.clearGameSelection();
		}
	}

	/**
	 * Clears the current selection.
	 */
	public void clearGameSelection() {
		for (int i = 0; i < gameBoard.SIZE_X; i++) {
			for (int j = 0; j < gameBoard.SIZE_Y; j++) {

				// Set all the SquareViews to the normal state
				this.gameBoard.getSquare(i, j).setSelected(false);
			}
		}

		// Empty the current selection
		this.currentSelection.clear();
	}

	public void updateBuilderSelection(int mx, int my, TileType type) {
		for (int i = 0; i < gameBoard.SIZE_X; i++) {
			for (int j = 0; j < gameBoard.SIZE_Y; j++) {
				// If the SquareView is selected in a valid manner, update the
				// corresponding Square and add the Square to the current
				// selection.
				if (this.validateMouseSelection(mx, my, squareViews[i][j])) {
					switch (type) {
					case NULL:
						this.gameBoard.setSquare(new NullTile(), i, j, false);
						break;
					case NUMBER:
						this.gameBoard.setSquare(new NumberTile(this.gameBoard.getRandomNumber(), this.gameBoard.getRandomMultiplier()), i, j, false);
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

				}
			}
		}
	}

	public Board getBoard() {
		return this.gameBoard;
	}
}
