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
import SixesWild.com.mimas.sixeswild.entities.Selection;

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

	Aesthetic boardAesthetic;
	Board gameBoard;
	JLabel squareViewBoard[][];
	Selection currentSelection;
	Border boardViewborder;
	GridBagConstraints gbc_boardViewPanel;

	// Square view attributes
	Border squareViewBorder;
	Border squareViewSelectedBorder;

	/**
	 * Constructor for BoardViewPanel class.
	 * 
	 * @param board
	 *            The game board to display.
	 */
	public BoardViewPanel(Board board, Aesthetic aesthetic) {
		super();

		// Attributes
		this.gameBoard = board;
		this.boardAesthetic = aesthetic;
		
		this.currentSelection = new Selection();
		this.squareViewBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
		this.squareViewSelectedBorder = BorderFactory.createLineBorder(Color.YELLOW, 2);
		this.squareViewBoard = new JLabel[this.SIZE_X][this.SIZE_Y];
		this.boardViewborder = BorderFactory.createLineBorder(Color.BLACK, 2);
		this.gameBoard.randomInitialize();
		
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

		this.initializeBoardView();
	}
	
	protected int getMinOfHeightAndWidth() {
		return (this.getWidth() < this.getHeight()) ? this.getWidth()
				: this.getHeight();
	}

	protected Color getColorByNumber(int number) {
		switch (number) {
		case 1:
			return boardAesthetic.getTileOneColor();
		case 2:
			return boardAesthetic.getTileTwoColor();
		case 3:
			return boardAesthetic.getTileThreeColor();
		case 4:
			return boardAesthetic.getTileFourColor();
		case 5:
			return boardAesthetic.getTileFiveColor();
		case 6:
			return boardAesthetic.getTileSixColor();
		default:
			return Color.WHITE;
		}
	}
	
	protected void initializeBoardView() {
		for (int i = 0; i < this.SIZE_X; i++) {
			for (int j = 0; j < this.SIZE_Y; j++) {
				squareViewBoard[i][j] = new JLabel();
				squareViewBoard[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				squareViewBoard[i][j].setOpaque(true);
				squareViewBoard[i][j].setFont(new Font("Monospace", Font.BOLD, 18));
				squareViewBoard[i][j].setBorder(this.squareViewBorder);
				squareViewBoard[i][j].setBackground(this.getColorByNumber(this.gameBoard.getSquare(i, j).getTile().getNumber()));
				
				switch (this.gameBoard.getSquare(i, j).getTile().getType()) {
				case NULL:
					squareViewBoard[i][j].setText("  ");
					break;
				default:
					squareViewBoard[i][j].setText(this.gameBoard.getSquare(i, j).getTile().getNumber() + "");
					break;
				}

				squareViewBoard[i][j].setLocation(
						(((this.getWidth() - (((int) this.getWidth() / 9) * 9)) + 10) / 2)
								+ (this.getWidth() / 9 * this.gameBoard.getSquare(i, j).getX()),
						(((this.getHeight() - (((int) this.getHeight() / 9) * 9)) + 10) / 2)
								+ (this.getHeight() / 9 * this.gameBoard.getSquare(i, j).getY()));
				squareViewBoard[i][j].setSize(new Dimension(this.getMinOfHeightAndWidth() / 9 - 20, this
						.getMinOfHeightAndWidth() / 9 - 20));
				
				if (gameBoard.getSquare(i, j).getSelected()) {
					squareViewBoard[i][j].setBorder(squareViewSelectedBorder);
				} else {
					squareViewBoard[i][j].setBorder(squareViewBorder);
				}
				
				gbc_boardViewPanel.gridx = i + 1;
				gbc_boardViewPanel.gridy = j + 1;

				this.add(squareViewBoard[i][j], gbc_boardViewPanel);
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
	 * @return true or false
	 */
	protected boolean validateMouseSelection(int mx, int my,
			JLabel squareView) {
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
	public void updateSelection(int mx, int my) {
		for (int i = 0; i < gameBoard.SIZE_X; i++) {
			for (int j = 0; j < gameBoard.SIZE_Y; j++) {				
				// If the SquareView is selected in a valid manner, update the
				// SquareView and add it to the current selection
				if (this.validateMouseSelection(mx, my, squareViewBoard[i][j])) {
					this.gameBoard.getSquare(i, j).setSelected(true);
					this.currentSelection.add(gameBoard.getSquare(i, j));
				}
			}
		}

		// If the selection is not valid, clear the entire selection
		if (!this.currentSelection.isValidSelection()) {
			this.clearSelection();
		}
	}

	/**
	 * Clears the current selection.
	 */
	public void clearSelection() {
		for (int i = 0; i < gameBoard.SIZE_X; i++) {
			for (int j = 0; j < gameBoard.SIZE_Y; j++) {

				// Set all the SquareViews to the normal state
				this.gameBoard.getSquare(i, j).setSelected(false);
			}
		}

		// Empty the current selection
		this.currentSelection.clear();
	}
}
