package SixesWild.com.mimas.sixeswild.boundaries;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;

public class TitleView extends JPanel {

	/**
	 * Create the panel.
	 */
	public TitleView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{16, 0, 16, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblSixesWild = new JLabel("Sixes Wild");
		lblSixesWild.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_lblSixesWild = new GridBagConstraints();
		gbc_lblSixesWild.fill = GridBagConstraints.VERTICAL;
		gbc_lblSixesWild.gridx = 0;
		gbc_lblSixesWild.gridy = 0;
		add(lblSixesWild, gbc_lblSixesWild);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		add(separator, gbc_separator);
		
		JLabel lblThisIsWhere = new JLabel("This is where the Basic Rules and Stuff Go");
		GridBagConstraints gbc_lblThisIsWhere = new GridBagConstraints();
		gbc_lblThisIsWhere.fill = GridBagConstraints.VERTICAL;
		gbc_lblThisIsWhere.gridx = 0;
		gbc_lblThisIsWhere.gridy = 2;
		add(lblThisIsWhere, gbc_lblThisIsWhere);

	}

}
