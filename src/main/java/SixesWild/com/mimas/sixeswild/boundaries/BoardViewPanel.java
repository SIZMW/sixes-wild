package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.entities.Board;

/**
 * This class is used to view the board entity within a panel in the game.
 * @author Aditya Nivarthi
 */
public class BoardViewPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	Board board;
	
	/**
	 * Constructor for BoardViewPanel class.
	 */
	public BoardViewPanel(Board board) {
		super();
		this.board = board;
		this.setBackground(Color.RED);
		this.setSize(new Dimension(669, 429));
		this.setVisible(true);
	}
	
	//TODO Draw board based on actual board parameter.
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Rectangle rect = new Rectangle((((this.getWidth() - (((int)this.getWidth() / 9) * 9)) + 10) / 2) + (this.getWidth() / 9 * i), (((this.getHeight() - (((int)this.getHeight() / 9) * 9 )) + 10) / 2) + (this.getHeight() / 9 * j), this.getWidth() / 9 - 10, this.getHeight() / 9 - 10);
				g2.fill(rect);
				g2.draw(rect);
			}
		}
	}

}
