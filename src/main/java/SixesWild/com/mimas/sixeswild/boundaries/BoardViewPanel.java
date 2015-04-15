package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import SixesWild.com.mimas.sixeswild.entities.Board;

/**
 * This class is used to view the board entity within a panel in the game.
 * @author Aditya Nivarthi
 */
public class BoardViewPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Board gameBoard;
	SquareView squareViewBoard[][];
	
	Border border;
	GridBagConstraints gbc_panel;
	
	/**
	 * Constructor for BoardViewPanel class.
	 */
	public BoardViewPanel(Board board) {
		super();
		this.setGameBoard(board);
		this.getGameBoard().initialize();
		this.setVisible(true);
		squareViewBoard = new SquareView[9][9];
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		gridBagLayout.rowHeights = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		setLayout(gridBagLayout);

		border = BorderFactory.createLineBorder(Color.BLACK, 2);
		gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 1;
		gbc_panel.fill = GridBagConstraints.BOTH;
		
		for (int i = 0; i < 9 ; i++) {
			for (int j = 0; j < 9; j++) {
				squareViewBoard[i][j] = new SquareView(this.getGameBoard().getSquare(i, j), this.getWidth(), this.getHeight());
				
				gbc_panel.gridx = i + 1;
				gbc_panel.gridy = j + 1;
				
				this.add(squareViewBoard[i][j], gbc_panel);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i = 0; i < 9 ; i++) {
			for (int j = 0; j < 9; j++) {
				squareViewBoard[i][j].updateSquareView(this.getWidth(), this.getHeight());
				
				gbc_panel.gridx = i + 1;
				gbc_panel.gridy = j + 1;
			}
		}
		
		this.updateUI();
	}

	public Board getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}
}
