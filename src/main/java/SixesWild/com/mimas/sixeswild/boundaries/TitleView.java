package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 * This class represents the title view in the game.
 * 
 * @author Cameron Jones
 */
public class TitleView extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for the TitleView class.
	 */
	public TitleView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 16, 0, 16, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Sixes wild label
		JLabel gameTitleLabel = new JLabel("Sixes Wild");
		gameTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_gameTitleLabel = new GridBagConstraints();
		gbc_gameTitleLabel.fill = GridBagConstraints.VERTICAL;
		gbc_gameTitleLabel.gridx = 0;
		gbc_gameTitleLabel.gridy = 0;
		add(gameTitleLabel, gbc_gameTitleLabel);

		// Separator
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		add(separator, gbc_separator);

		// Basic rules
		JLabel infoLabel = new JLabel(
				"This is where the basic rules and stuff go");
		GridBagConstraints gbc_infoLabel = new GridBagConstraints();
		gbc_infoLabel.fill = GridBagConstraints.VERTICAL;
		gbc_infoLabel.gridx = 0;
		gbc_infoLabel.gridy = 2;
		add(infoLabel, gbc_infoLabel);
	}
}
