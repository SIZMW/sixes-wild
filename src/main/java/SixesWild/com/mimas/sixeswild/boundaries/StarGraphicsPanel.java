package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * This class represents the score panel used to display score and star
 * thresholds for the player in the game.
 *
 * @author Marco Duran
 */
public class StarGraphicsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected BufferedImage image;
	protected int currentStars;
	protected URL noStars = getClass().getClassLoader().getResource(
			"StarGraphicNOStars.png");
	protected URL oneStars = getClass().getClassLoader().getResource(
			"StarGraphicOneStars.png");
	protected URL twoStars = getClass().getClassLoader().getResource(
			"StarGraphicTwoStars.png");
	protected URL threeStars = getClass().getClassLoader().getResource(
			"StarGraphicThreeStars.png");

	/**
	 * Creates a StarGraphicsPanel with the specified score value.
	 */
	public StarGraphicsPanel() {

		// Attributes
		this.currentStars = 0;
		this.setNewStarImage();

		// Layout of panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
	}

	/**
	 * Refreshes the star count to display with the specified star count.
	 *
	 * @param stars
	 *            The number of stars to display.
	 */
	public void refreshStars(int stars) {
		if (stars != this.currentStars) {
			this.currentStars = stars;
			this.setNewStarImage();
		}
	}

	/**
	 * Sets the new star image to display when the score changes to a higher
	 * threshold.
	 */
	protected void setNewStarImage() {
		try {
			switch (this.currentStars) {
			case 0:
				this.image = ImageIO.read(noStars);
				break;
			case 1:
				this.image = ImageIO.read(oneStars);
				break;
			case 2:
				this.image = ImageIO.read(twoStars);
				break;
			case 3:
				this.image = ImageIO.read(threeStars);
				break;
			default:
				this.image = ImageIO.read(noStars);
				break;
			}
		} catch (Exception e) {

		}

		this.repaint();
	}
}
