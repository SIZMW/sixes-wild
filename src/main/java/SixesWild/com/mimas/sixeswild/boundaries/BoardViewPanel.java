package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import SixesWild.com.mimas.sixeswild.entities.Board;
import SixesWild.com.mimas.sixeswild.entities.Square;

/**
 * This class represents the view used to display the game board in the level
 * view of the game and the builder.
 * 
 * @author Aditya Nivarthi
 */
public class BoardViewPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	Board gameBoard;
	SquareView squareViewBoard[][];
	ArrayList<SquareView> currentSelection;
	Border border;
	GridBagConstraints gbc_panel;

	/**
	 * Constructor for BoardViewPanel class.
	 * 
	 * @param board
	 *            The game board to display.
	 */
	public BoardViewPanel(Board board) {
		super();

		// Attributes
		this.gameBoard = board;
		this.gameBoard.randomInitialize();
		this.setVisible(true);
		squareViewBoard = new SquareView[9][9];
		border = BorderFactory.createLineBorder(Color.BLACK, 2);
		currentSelection = new ArrayList<SquareView>();

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
		gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 1;
		gbc_panel.fill = GridBagConstraints.BOTH;

		this.draw();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Update each SquareView in the board
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				squareViewBoard[i][j].updateSquareView(this.getWidth(),
						this.getHeight());
			}
		}

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
			SquareView squareView) {
		return mx - squareView.getX() > 0
				&& mx - squareView.getX() < squareView.getWidth()
				&& my - squareView.getY() > 0
				&& my - squareView.getY() < squareView.getHeight();
	}

	/**
	 * Validates that the currently selected squares are a valid running
	 * selection.
	 * 
	 * @return true or false
	 */
	protected boolean validateSquareSelection() {

		// Verify there is more than one SquareView in the list
		if (currentSelection.size() > 1) {

			// Convert SquareViews to Squares before passing to the board
			ArrayList<Square> squares = new ArrayList<Square>();
			for (SquareView e : this.currentSelection) {
				squares.add(e.getSquare());
			}

			// Board checks for valid selection
			return this.gameBoard.isValidSelection(squares);
		}
		return true;
	}

	/**
	 * Adds the given SquareView to the current selection only if it does not
	 * already exist.
	 * 
	 * @param squareView
	 *            The SquareView to add.
	 * @return true or false
	 */
	protected boolean addToCurrentSelection(SquareView squareView) {
		if (!currentSelection.contains(squareView)) {
			currentSelection.add(squareView);
			return true;
		}
		return false;
	}

	/**
	 * Draws the board of SquareViews to the panel.
	 */
	public void draw() {
		for (int i = 0; i < gameBoard.SIZE_X; i++) {
			for (int j = 0; j < gameBoard.SIZE_Y; j++) {
				squareViewBoard[i][j] = new SquareView(
						this.gameBoard.getSquare(i, j), this.getWidth(),
						this.getHeight());

				gbc_panel.gridx = i + 1;
				gbc_panel.gridy = j + 1;

				this.add(squareViewBoard[i][j], gbc_panel);
			}
		}
	}

	/**
	 * Redraws the board of SquareViews to the panel.
	 */
	public void redraw() {
		this.removeAll();
		this.draw();
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
					this.squareViewBoard[i][j].setSelected(true);
					this.addToCurrentSelection(squareViewBoard[i][j]);
				}
			}
		}

		// If the selection is not valid, clear the entire selection
		if (!this.validateSquareSelection()) {
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
				this.squareViewBoard[i][j].setSelected(false);
			}
		}

		// Empty the current selection
		this.currentSelection.clear();
	}
}
