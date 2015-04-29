package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * This class represents the view used to show the splash screen before starting
 * the game or level builder.
 *
 * @author Cameron Jones
 */
public class SplashScreen extends JPanel {

	private static final long serialVersionUID = 1L;

	protected BufferedImage image;
	protected URL splashScreen;

	/**
	 * Creates a SplashScreen instance with the specified resource path for a
	 * splash screen.
	 *
	 * @param splashScreen
	 *            The resource path to the specified splash screen to display.
	 */
	public SplashScreen(URL splashScreen) {

		// Layout for panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Layout for game title label
		GridBagConstraints gbc_lblSixesWild = new GridBagConstraints();
		gbc_lblSixesWild.insets = new Insets(0, 0, 0, 0);
		gbc_lblSixesWild.gridx = 0;
		gbc_lblSixesWild.gridy = 0;

		this.splashScreen = splashScreen;

		if (splashScreen != null) {
			try {
				image = ImageIO.read(this.splashScreen);
				this.repaint();
			} catch (IOException e) {
			}
		}
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
}
