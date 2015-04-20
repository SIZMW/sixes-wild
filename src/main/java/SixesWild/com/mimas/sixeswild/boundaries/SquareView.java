package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import SixesWild.com.mimas.sixeswild.entities.Square;

/**
 * This class represents the square view that is used to show tiles on the board
 * view panel for the game in Sixes Wild.
 * 
 * @author Aditya Nivarthi
 */
public class SquareView extends JLabel {

	private static final long serialVersionUID = 1L;

	Square square;
	int boardWidth;
	int boardHeight;
	boolean isSelected;

	Border border;
	Border selectedBorder;

	// TODO Integrate this with aesthetics and themes.
	// Default color constants
	final Color ONE_COLOR = Color.RED;
	final Color TWO_COLOR = new Color(0xFF7F00);
	final Color THREE_COLOR = Color.YELLOW;
	final Color FOUR_COLOR = Color.GREEN;
	final Color FIVE_COLOR = Color.CYAN;
	final Color SIX_COLOR = Color.MAGENTA;

	/**
	 * Constructor for SquareView class.
	 * 
	 * @param square
	 *            The square entity to represent.
	 * @param boardWidth
	 *            The width of the board view panel.
	 * @param boardHeight
	 *            The height of the board view panel.
	 */
	public SquareView(Square square, int boardWidth, int boardHeight) {
		this.square = square;
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;

		border = BorderFactory.createLineBorder(Color.BLACK, 2);
		selectedBorder = BorderFactory.createLineBorder(Color.YELLOW, 2);

		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setOpaque(true);
		this.setFont(new Font("Monospace", Font.BOLD, 18));
		this.setBorder(this.border);
		this.setBackground(this.getColorByNumber(this.square.getTile()
				.getNumber()));

		switch (this.square.getTile().getType()) {
		case NULL:
			this.setText("  ");
			break;
		default:
			this.setText(this.square.getTile().getNumber() + "");
			break;
		}

		this.setLocation(
				(((this.boardWidth - (((int) this.boardWidth / 9) * 9)) + 10) / 2)
						+ (this.boardWidth / 9 * this.square.getX()),
				(((this.boardHeight - (((int) this.boardHeight / 9) * 9)) + 10) / 2)
						+ (this.boardHeight / 9 * this.square.getY()));
		this.setSize(new Dimension(this.getMinOfHeightAndWidth() / 9 - 20, this
				.getMinOfHeightAndWidth() / 9 - 20));
	}

	/**
	 * Gets the smaller of the board height or width for resizing purposes.
	 * 
	 * @return The smaller value, height or width of the board.
	 */
	protected int getMinOfHeightAndWidth() {
		return (this.boardWidth < this.boardHeight) ? this.boardWidth
				: this.boardHeight;
	}

	/**
	 * Returns the corresponding color based on the number of the Tile.
	 * 
	 * @param number
	 *            The number of the Tile.
	 * @return One of the defined color constants.
	 */
	protected Color getColorByNumber(int number) {
		switch (number) {
		case 1:
			return ONE_COLOR;
		case 2:
			return TWO_COLOR;
		case 3:
			return THREE_COLOR;
		case 4:
			return FOUR_COLOR;
		case 5:
			return FIVE_COLOR;
		case 6:
			return SIX_COLOR;
		default:
			return Color.WHITE;
		}
	}

	/**
	 * Sets the selected state of this SquareView.
	 * 
	 * @param selected
	 *            State of selected.
	 */
	public void setSelected(boolean selected) {
		this.isSelected = selected;
	}

	/**
	 * Updates the position and scaling of the SquareView based on new board
	 * view panel sizing.
	 * 
	 * @param boardWidth
	 *            The new board width.
	 * @param boardHeight
	 *            The new board height.
	 */
	public void updateSquareView(int boardWidth, int boardHeight) {
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;

		this.setLocation(
				(((this.boardWidth - (((int) this.boardWidth / 9) * 9)) + 10) / 2)
						+ (this.boardWidth / 9 * this.square.getX()),
				(((this.boardHeight - (((int) this.boardHeight / 9) * 9)) + 10) / 2)
						+ (this.boardHeight / 9 * this.square.getY()));
		this.setSize(new Dimension(this.getMinOfHeightAndWidth() / 9 - 20, this
				.getMinOfHeightAndWidth() / 9 - 20));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (isSelected) {
			this.setBorder(selectedBorder);
		} else {
			this.setBorder(border);
		}
	}
}
