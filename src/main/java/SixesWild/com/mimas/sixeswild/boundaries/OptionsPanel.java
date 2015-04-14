package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * This class represents the options sub menu in the game.
 * 
 * @author Yahel Nachum
 */
public class OptionsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	JButton changeAestheticButton;
	JButton switchUserButton;
	JButton resetBadgesButton;
	JComboBox<String> aestheticDropDownMenu;
	JPanel upperOptionsPanel;
	JPanel rulesPanel;
	JTextField userNameTextField;
	JTextPane rulesTextPane;
	JSeparator rulesSeparator;

	private String rulesText = "Rule 01: Don't talk about the fight club.";

	/**
	 * Constructor for the OptionsPanel class.
	 */
	public OptionsPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Upper options panel
		upperOptionsPanel = new JPanel();
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
		GridBagConstraints gbc_switchUserButton = new GridBagConstraints();
		gbc_switchUserButton.insets = new Insets(0, 0, 5, 5);
		gbc_switchUserButton.gridx = 1;
		gbc_switchUserButton.gridy = 1;
		upperOptionsPanel.add(switchUserButton, gbc_switchUserButton);

		// User name text field
		userNameTextField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		upperOptionsPanel.add(userNameTextField, gbc_textField);
		userNameTextField.setColumns(10);

		// Change aesthetic button
		changeAestheticButton = new JButton("Change Style");
		GridBagConstraints gbc_changeStyleButton = new GridBagConstraints();
		gbc_changeStyleButton.insets = new Insets(0, 0, 5, 5);
		gbc_changeStyleButton.gridx = 1;
		gbc_changeStyleButton.gridy = 3;
		upperOptionsPanel.add(changeAestheticButton, gbc_changeStyleButton);

		// Aesthetic drop down menu
		aestheticDropDownMenu = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 3;
		upperOptionsPanel.add(aestheticDropDownMenu, gbc_comboBox);

		// Reset badges button
		resetBadgesButton = new JButton("Reset Badges");
		GridBagConstraints gbc_resetBadgesButton = new GridBagConstraints();
		gbc_resetBadgesButton.insets = new Insets(0, 0, 5, 5);
		gbc_resetBadgesButton.gridx = 1;
		gbc_resetBadgesButton.gridy = 5;
		upperOptionsPanel.add(resetBadgesButton, gbc_resetBadgesButton);

		// Rules separator
		rulesSeparator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		add(rulesSeparator, gbc_separator);

		// Rules panel
		rulesPanel = new JPanel();
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
		rulesTextPane = new JTextPane();
		rulesTextPane.setText(rulesText);
		rulesTextPane.setEditable(false);
		GridBagConstraints gbc_txtpnRules = new GridBagConstraints();
		gbc_txtpnRules.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnRules.fill = GridBagConstraints.BOTH;
		gbc_txtpnRules.gridx = 1;
		gbc_txtpnRules.gridy = 1;
		rulesTextPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		rulesPanel.add(rulesTextPane, gbc_txtpnRules);
	}

	/**
	 * Returns the aesthetic button.
	 * 
	 * @return this.changeAestheticButton The aesthetic button.
	 */
	public JButton getAestheticButton() {
		return this.changeAestheticButton;
	}

	/**
	 * Returns the switch user button.
	 * 
	 * @return this.switchUserButton The switch user button.
	 */
	public JButton getSwitchUserButton() {
		return this.switchUserButton;
	}

	/**
	 * Returns the reset badges button.
	 * 
	 * @return this.resetBadgesButton The reset badges button.
	 */
	public JButton getResetBadgesButton() {
		return this.resetBadgesButton;
	}

	/**
	 * Returns the aesthetic drop down menu.
	 * 
	 * @return this.aestheticDropDownMenu The aesthetic drop down menu.
	 */
	public JComboBox<String> getAestheticDropDownMenu() {
		return this.aestheticDropDownMenu;
	}

	/**
	 * Returns the user name text field.
	 * 
	 * @return this.userNameTextField The user name text field.
	 */
	public JTextField getUserNameTextField() {
		return this.userNameTextField;
	}
}
