package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class represents the view used to show the splash screen before starting
 * the game or level builder.
 * 
 * @author Cameron Jones
 */
public class SplashScreen extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for SplashScreen class.
	 */
	public SplashScreen() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, 1.0,
				1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Game title label
		JLabel lblSixesWild = new JLabel("Sixes Wild");
		lblSixesWild.setFont(new Font("Tahoma", Font.PLAIN, 48));
		GridBagConstraints gbc_lblSixesWild = new GridBagConstraints();
		gbc_lblSixesWild.insets = new Insets(0, 0, 0, 0);
		gbc_lblSixesWild.gridx = 0;
		gbc_lblSixesWild.gridy = 2;
		add(lblSixesWild, gbc_lblSixesWild);

		// Instructions to proceed label
		JLabel lblPressEnter = new JLabel("**** PRESS ENTER ****");
		GridBagConstraints gbc_lblPressEnter = new GridBagConstraints();
		gbc_lblPressEnter.insets = new Insets(0, 0, 0, 0);
		gbc_lblPressEnter.gridx = 0;
		gbc_lblPressEnter.gridy = 4;
		add(lblPressEnter, gbc_lblPressEnter);

		// Team names label
		JLabel lblTeamMimas = new JLabel(
				"Team Mimas: Marco Duran, Cameron Jones, Yahel Nachum, Aditya Nivarthi, Joey Perez");
		lblTeamMimas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTeamMimas = new GridBagConstraints();
		gbc_lblTeamMimas.fill = GridBagConstraints.VERTICAL;
		gbc_lblTeamMimas.gridx = 0;
		gbc_lblTeamMimas.gridy = 7;
		add(lblTeamMimas, gbc_lblTeamMimas);
	}
}
