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
	 * Creates a SplashScreen instance.
	 * @param splashScreen 
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
		
		try {
			this.image = ImageIO.read(this.splashScreen);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.repaint();
		//add(, gbc_lblSixesWild);
		
		/*
		// Game title label
		JLabel lblSixesWild = new JLabel("Sixes Wild");
		lblSixesWild.setFont(new Font("Tahoma", Font.PLAIN, 48));

		

		// Instructions to proceed label
		JLabel lblPressEnter = new JLabel("**** PRESS ENTER ****");

		// Layout for instructions to proceed label
		GridBagConstraints gbc_lblPressEnter = new GridBagConstraints();
		gbc_lblPressEnter.insets = new Insets(0, 0, 0, 0);
		gbc_lblPressEnter.gridx = 0;
		gbc_lblPressEnter.gridy = 4;
		add(lblPressEnter, gbc_lblPressEnter);

		// Team names label
		JLabel lblTeamMimas = new JLabel(
				"Team Mimas: Marco Duran, Cameron Jones, Yahel Nachum, Aditya Nivarthi, Joey Perez");
		lblTeamMimas.setFont(new Font("Tahoma", Font.PLAIN, 11));

		// Layout for team names label
		GridBagConstraints gbc_lblTeamMimas = new GridBagConstraints();
		gbc_lblTeamMimas.fill = GridBagConstraints.VERTICAL;
		gbc_lblTeamMimas.gridx = 0;
		gbc_lblTeamMimas.gridy = 7;
		add(lblTeamMimas, gbc_lblTeamMimas);
		*/
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
