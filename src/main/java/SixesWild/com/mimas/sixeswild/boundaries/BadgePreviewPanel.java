package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.entities.Badge;

/**
 * This class represents the preview panel used to display the badge images in
 * the badges menu.
 *
 * @author Aditya Nivarthi
 */
public class BadgePreviewPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected BufferedImage image;
	protected URL scoreBadge1 = getClass().getClassLoader().getResource(
			"scoreBadge1.png");
	protected URL scoreBadge2 = getClass().getClassLoader().getResource(
			"scoreBadge2.png");
	protected URL scoreBadge3 = getClass().getClassLoader().getResource(
			"scoreBadge3.png");
	protected URL scoreBadge4 = getClass().getClassLoader().getResource(
			"scoreBadge4.png");
	protected URL scoreBadge5 = getClass().getClassLoader().getResource(
			"scoreBadge5.png");

	protected URL starBadge1 = getClass().getClassLoader().getResource(
			"StarBadge1.png");
	protected URL starBadge2 = getClass().getClassLoader().getResource(
			"StarBadge2.png");
	protected URL starBadge3 = getClass().getClassLoader().getResource(
			"StarBadge3.png");

	protected URL unlockBadge = getClass().getClassLoader().getResource(
			"unlockBadge.png");

	/**
	 * Creates a StarGraphicsPanel with the specified score value.
	 */
	public BadgePreviewPanel() {
		super();

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
		g2.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

	/**
	 * Refreshes the badge image to display with the specified badge
	 * information.
	 *
	 * @param badge
	 *            The badge to update the preview with.
	 */
	public void refreshView(Badge badge) {
		try {
			if (badge.getName().contains("10000")) {
				image = ImageIO.read(scoreBadge2);
			} else if (badge.getName().contains("15000")) {
				image = ImageIO.read(scoreBadge3);
			} else if (badge.getName().contains("20000")) {
				image = ImageIO.read(scoreBadge4);
			} else if (badge.getName().contains("25000")) {
				image = ImageIO.read(scoreBadge5);
			} else if (badge.getName().contains("5000")) {
				image = ImageIO.read(scoreBadge1);
			} else if (badge.getName().contains("1 stars")) {
				image = ImageIO.read(starBadge1);
			} else if (badge.getName().contains("2 stars")) {
				image = ImageIO.read(starBadge2);
			} else if (badge.getName().contains("3 stars")) {
				image = ImageIO.read(starBadge3);
			} else if (badge.getName().contains("Unlock")) {
				image = ImageIO.read(unlockBadge);
			} else {
				image = null;
			}
		} catch (Exception e) {
		}

		repaint();
	}
}
