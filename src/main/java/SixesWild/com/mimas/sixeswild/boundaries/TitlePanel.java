package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 * This class represents the title view in the game.
 *
 * @author Cameron Jones
 */
public class TitlePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected JPanel rulesPanel;
	protected JLabel rulesLabel;

	/**
	 * Creates a TitlePanel instance.
	 */
	public TitlePanel() {
		super();

		// Layout for panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 16, 0, 16, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Sixes Wild label
		JLabel gameTitleLabel = new JLabel("Sixes Wild");
		gameTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));

		// Layout for Sixes Wild label
		GridBagConstraints gbc_gameTitleLabel = new GridBagConstraints();
		gbc_gameTitleLabel.fill = GridBagConstraints.VERTICAL;
		gbc_gameTitleLabel.gridx = 0;
		gbc_gameTitleLabel.gridy = 0;
		add(gameTitleLabel, gbc_gameTitleLabel);

		// Separator
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);

		// Layout for separator
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		add(separator, gbc_separator);

		// Rules panel
		rulesPanel = new JPanel();

		// Layout for rules panel
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(rulesPanel, gbc_panel_2);

		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 5.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 1.0, 5.0, 1.0, Double.MIN_VALUE };
		rulesPanel.setLayout(gbl_panel_2);

		// Rules text pane
		rulesLabel = new JLabel();
		rulesLabel.setVerticalAlignment(SwingConstants.TOP);
		rulesLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rulesLabel.setPreferredSize(new Dimension(400, 100));
		rulesLabel.setMaximumSize(new Dimension(400, 100));

		// Rules text
		StringBuilder rulesLabelText = new StringBuilder();
		rulesLabelText.append("<html>");
		rulesLabelText.append("&nbsp;Basic Rules:<br>");
		rulesLabelText
				.append("&nbsp;1. Select tiles to create selections that have a total sum of six across the tiles.<br>");
		rulesLabelText
				.append("&nbsp;2. Tiles can be selected vertically and horizontally, but not diagonally.<br>");
		rulesLabelText.append("<br>&nbsp;Game Types:<br>");
		rulesLabelText
				.append("&nbsp;1. The Puzzle game type is where you must get as many points in the number of moves given.<br>");
		rulesLabelText
				.append("&nbsp;2. The Lightning game type is where you must get as many points in the time given.<br>");
		rulesLabelText
				.append("&nbsp;3. The Release game type is where you must guide the Six tiles into the Target buckets.<br>");
		rulesLabelText
				.append("&nbsp;4. The Elimination game type is where you must mark every square in the level.<br>");
		rulesLabelText.append("<br>&nbsp;Special Moves:<br>");
		rulesLabelText
				.append("&nbsp;1. The Reset board special move shuffles the tiles in the board if you get stuck.<br>");
		rulesLabelText
				.append("&nbsp;2. The Swap tile special move allows you to select two tiles which will switch places.<br>");
		rulesLabelText
				.append("&nbsp;3. The Remove tile special move allows you to select a tile to disappear.<br>");
		rulesLabelText
				.append("&nbsp;4. The XStacy special move grants ten more moves or twenty seconds on the clock.<br>");
		rulesLabelText.append("</html>");

		rulesLabel.setText(rulesLabelText.toString());

		// Layout for rules text pane
		GridBagConstraints gbc_txtpnRules = new GridBagConstraints();
		gbc_txtpnRules.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnRules.fill = GridBagConstraints.BOTH;
		gbc_txtpnRules.gridx = 1;
		gbc_txtpnRules.gridy = 1;
		rulesLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		rulesPanel.add(rulesLabel, gbc_txtpnRules);
	}
}
