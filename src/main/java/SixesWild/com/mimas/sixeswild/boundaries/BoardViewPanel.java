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

import SixesWild.com.mimas.sixeswild.entities.Board;

/**
 * This class is used to view the board entity within a panel in the game.
 * @author Aditya Nivarthi
 */
public class BoardViewPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	Board gameBoard;
	JLabel labelBoard[][];
	
	/**
	 * Constructor for BoardViewPanel class.
	 */
	public BoardViewPanel(Board board) {
		super();
		this.gameBoard = board;
		this.gameBoard.initialize();
		this.setVisible(true);
		labelBoard = new JLabel[9][9];
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		gridBagLayout.rowHeights = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		setLayout(gridBagLayout);

		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 1;
		gbc_panel.fill = GridBagConstraints.BOTH;
		
		// TODO Need to revisit this display code.
		
		for (int i = 0; i < 9 ; i++) {
			for (int j = 0; j < 9; j++) {
				labelBoard[i][j] = new JLabel(gameBoard.getSquare(i, j).getTile().getNumber() + "", SwingConstants.CENTER);
				labelBoard[i][j].setLocation((((this.getMinOfHeightAndWidth() - (((int)this.getMinOfHeightAndWidth() / 9) * 9)) + 10) / 2) + (this.getMinOfHeightAndWidth() / 9 * i), (((this.getMinOfHeightAndWidth() - (((int)this.getMinOfHeightAndWidth() / 9) * 9 )) + 10) / 2) + (this.getMinOfHeightAndWidth() / 9 * j));
				labelBoard[i][j].setSize(new Dimension(this.getWidth() / 9 - 20, this.getHeight() / 9 - 20));
				
				labelBoard[i][j].setBackground(Color.WHITE);
				labelBoard[i][j].setFont(new Font("Verdana", Font.BOLD, 14));
				labelBoard[i][j].setOpaque(true);
				labelBoard[i][j].setBorder(border);
				
				gbc_panel.gridx = i + 1;
				gbc_panel.gridy = j + 1;
				
				this.add(labelBoard[i][j], gbc_panel);
			}
		}
	}
	
	/**
	 * Returns the smaller of the height or width dimensions
	 * @return this.getWidth() or this.getHeight() The dimension that is smaller.
	 */
	private int getMinOfHeightAndWidth() {
		return (this.getWidth() < this.getHeight()) ? this.getWidth() : this.getHeight();
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setSize(new Dimension(this.getMinOfHeightAndWidth(), this.getMinOfHeightAndWidth()));
	}
}
