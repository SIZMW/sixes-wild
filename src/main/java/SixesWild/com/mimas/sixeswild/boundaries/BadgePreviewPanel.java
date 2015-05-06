package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;

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

	public static final String BADGE_CNST = "Badge";

	protected BufferedImage image;

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
			String fileName = badge.getName().replace(" ", "") + BADGE_CNST;
			image = ImageIO.read(getClass().getClassLoader().getResource(
					"images/" + fileName + ".png"));
		} catch (Exception e) {
			image = null;
		}
		repaint();
	}
}
