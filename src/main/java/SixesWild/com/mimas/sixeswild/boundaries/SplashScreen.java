package SixesWild.com.mimas.sixeswild.boundaries;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Insets;
import java.awt.Font;

public class SplashScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public SplashScreen() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblSixesWild = new JLabel("Sixes Wild");
		lblSixesWild.setFont(new Font("Tahoma", Font.PLAIN, 48));
		GridBagConstraints gbc_lblSixesWild = new GridBagConstraints();
		gbc_lblSixesWild.insets = new Insets(0, 0, 0, 0);
		gbc_lblSixesWild.gridx = 0;
		gbc_lblSixesWild.gridy = 2;
		add(lblSixesWild, gbc_lblSixesWild);
		
		JLabel lblPressEnter = new JLabel("**** PRESS ENTER ****");
		GridBagConstraints gbc_lblPressEnter = new GridBagConstraints();
		gbc_lblPressEnter.insets = new Insets(0, 0, 0, 0);
		gbc_lblPressEnter.gridx = 0;
		gbc_lblPressEnter.gridy = 4;
		add(lblPressEnter, gbc_lblPressEnter);
		
		JLabel lblTeamMimas = new JLabel("Team Mimas: Marco Duran, Cameron Jones, Yahel Nachum, Aditya Nivarthi, Joey Perez");
		lblTeamMimas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTeamMimas = new GridBagConstraints();
		gbc_lblTeamMimas.fill = GridBagConstraints.VERTICAL;
		gbc_lblTeamMimas.gridx = 0;
		gbc_lblTeamMimas.gridy = 7;
		add(lblTeamMimas, gbc_lblTeamMimas);

	}

}
