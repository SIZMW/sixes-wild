package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import SixesWild.com.mimas.sixeswild.entities.Aesthetic;

/**
 * This class represents the options sub menu in the game.
 *
 * @author Yahel Nachum
 */
public class OptionsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected JButton changeAestheticButton;
	protected JButton switchUserButton;
	protected JButton resetBadgesButton;
	protected JComboBox<String> aestheticDropDownMenu;
	protected JPanel upperOptionsPanel;
	protected JPanel rulesPanel;
	protected JTextField userNameTextField;
	protected JLabel rulesLabel;
	protected JSeparator rulesSeparator;

	/**
	 * Creates an OptionsPanel instance with the specified aesthetic list.
	 *
	 * @param aestheticList
	 *            The list of aesthetics to populate in the aesthetic drop down
	 *            menu.
	 */
	public OptionsPanel(ArrayList<Aesthetic> aestheticList) {

		// Layout for panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Upper options panel
		upperOptionsPanel = new JPanel();

		// Layout for upper options panel
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(upperOptionsPanel, gbc_panel);

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 2.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, Double.MIN_VALUE };
		upperOptionsPanel.setLayout(gbl_panel);

		// Switch user button
		switchUserButton = new JButton("Switch User");

		// Layout for switch user button
		GridBagConstraints gbc_switchUserButton = new GridBagConstraints();
		gbc_switchUserButton.insets = new Insets(0, 0, 5, 5);
		gbc_switchUserButton.gridx = 1;
		gbc_switchUserButton.gridy = 1;
		upperOptionsPanel.add(switchUserButton, gbc_switchUserButton);

		// User name text field
		userNameTextField = new JTextField();

		// Layout for user name text field
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		upperOptionsPanel.add(userNameTextField, gbc_textField);
		userNameTextField.setColumns(10);

		// Change aesthetic button
		changeAestheticButton = new JButton("Change Aesthetic");

		// Layout for change aesthetic button
		GridBagConstraints gbc_changeStyleButton = new GridBagConstraints();
		gbc_changeStyleButton.insets = new Insets(0, 0, 5, 5);
		gbc_changeStyleButton.gridx = 1;
		gbc_changeStyleButton.gridy = 3;
		upperOptionsPanel.add(changeAestheticButton, gbc_changeStyleButton);

		// Aesthetic drop down menu
		aestheticDropDownMenu = new JComboBox<String>();

		// Add aesthetic names
		for (Aesthetic e : aestheticList) {
			aestheticDropDownMenu.addItem(e.getName());
		}

		// Layout for aesthetic drop down menu
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 3;
		upperOptionsPanel.add(aestheticDropDownMenu, gbc_comboBox);

		// Reset badges button
		resetBadgesButton = new JButton("Reset Badges");

		// Layout for reset badges button
		GridBagConstraints gbc_resetBadgesButton = new GridBagConstraints();
		gbc_resetBadgesButton.insets = new Insets(0, 0, 5, 5);
		gbc_resetBadgesButton.gridx = 1;
		gbc_resetBadgesButton.gridy = 5;
		upperOptionsPanel.add(resetBadgesButton, gbc_resetBadgesButton);

		// Rules separator
		rulesSeparator = new JSeparator();

		// Layout for rules separator
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		add(rulesSeparator, gbc_separator);

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

	/**
	 * Returns the changeAestheticButton object for this panel.
	 *
	 * @return the changeAestheticButton property
	 */
	public JButton getAestheticButton() {
		return changeAestheticButton;
	}

	/**
	 * Returns the switchUserButton object for this panel.
	 *
	 * @return the switchUserButton property
	 */
	public JButton getSwitchUserButton() {
		return switchUserButton;
	}

	/**
	 * Returns the resetBadgesButton object for this panel.
	 *
	 * @return the resetBadgesButton property
	 */
	public JButton getResetBadgesButton() {
		return resetBadgesButton;
	}

	/**
	 * Returns the aestheticDropDownMenu object for this panel.
	 *
	 * @return the aestheticDropDownMenu property
	 */
	public JComboBox<String> getAestheticDropDownMenu() {
		return aestheticDropDownMenu;
	}

	/**
	 * Returns the userNameTextField object for this panel.
	 *
	 * @return the userNameTextField property
	 */
	public JTextField getUserNameTextField() {
		return userNameTextField;
	}
}
