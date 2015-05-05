package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import SixesWild.com.mimas.sixeswild.controllers.SecretEasterEggController;

/**
 * This class represents the view used to display the credits in the main menu
 * area.
 *
 * @author Joey Perez
 */
public class CreditsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a CreditsPanel instance.
	 */
	public CreditsPanel() {

		// Layout for panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 187, 0 };
		gridBagLayout.rowHeights = new int[] { 47, 0, 0, 0, 0, 0, 14, 0, 0, 0,
				0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Credits label
		JLabel lblNewLabel = new JLabel("CREDITS");
		lblNewLabel.setFont(new Font("Monospace", Font.BOLD, 18));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);

		// Layout for credits label
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		// Joey Label
		JLabel lblNewLabel_1 = new JLabel("Joey Perez\r\n");
		lblNewLabel_1.addMouseListener(new SecretEasterEggController("Joey"));
		lblNewLabel_1.setFont(new Font("Monospace", Font.BOLD, 16));

		// Layout for Joey label
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		// Marco label
		JLabel lblNewLabel_2 = new JLabel("Marco Duran");
		lblNewLabel_2.setFont(new Font("Monospace", Font.BOLD, 16));

		// Layout for Marco label
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		// Cameron label
		JLabel lblNewLabel_3 = new JLabel("Cameron Jones");
		lblNewLabel_3.setFont(new Font("Monospace", Font.BOLD, 16));

		// Layout for Cameron label
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		// Aditya label
		JLabel lblNewLabel_4 = new JLabel("Aditya Nivarthi");
		lblNewLabel_4.setFont(new Font("Monospace", Font.BOLD, 16));

		// Layout for Aditya label
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		// Yahel label
		JLabel lblNewLabel_5 = new JLabel("Yahel Nachum");
		lblNewLabel_5.setFont(new Font("Monospace", Font.BOLD, 16));

		// Layout for Yahel label
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
	}
}
