package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Cameron Jones
 * @brief This class represents the main view for the menus in the game for
 *        Sixes Wild.
 */
public class MainPanel extends JPanel {

	JPanel subMenuPanel;
	JButton storyLevelMenuButton;
	JButton userLevelMenuButton;
	JButton badgesMenuButton;
	JButton optionsMenuButton;
	JButton creditsMenuButton;

	/**
	 * @brief Constructor for MainPanel class.
	 */
	public MainPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 5, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 9.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Sub menu panel
		subMenuPanel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 5;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(subMenuPanel, gbc_panel);

		// Story menu button
		storyLevelMenuButton = new JButton("Story Levels");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		add(storyLevelMenuButton, gbc_btnNewButton);

		// User menu button
		userLevelMenuButton = new JButton("User Levels");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		add(userLevelMenuButton, gbc_btnNewButton_1);

		// Badges menu button
		badgesMenuButton = new JButton("Badges");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 2;
		add(badgesMenuButton, gbc_btnNewButton_2);

		// Options menu button
		optionsMenuButton = new JButton("Options");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 3;
		add(optionsMenuButton, gbc_btnNewButton_3);

		// Credits menu button
		creditsMenuButton = new JButton("Credits");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 4;
		add(creditsMenuButton, gbc_btnNewButton_4);
	}

	/**
	 * @brief Returns the right sub menu panel.
	 * @return this.subMenuPanel The sub menu panel.
	 */
	public JPanel getSubMenuPanel() {
		return this.subMenuPanel;
	}

	/**
	 * @brief Returns the story level menu button.
	 * @return this.storyLevelMenuButton The story level menu button.
	 */
	public JButton getStoryLevelMenuButton() {
		return this.storyLevelMenuButton;
	}

	/**
	 * @brief Returns the user level menu button.
	 * @return this.userLevelMenuButton The user level menu button.
	 */
	public JButton getUserLevelMenuButton() {
		return this.userLevelMenuButton;
	}

	/**
	 * @brief Returns the badges menu button.
	 * @return this.badgesMenuButton The badges menu button.
	 */
	public JButton getBadgesMenuButton() {
		return this.badgesMenuButton;
	}

	/**
	 * @brief Returns the options menu button.
	 * @return this.optionsMenuButton The options menu button.
	 */
	public JButton getOptionsMenuButton() {
		return this.optionsMenuButton;
	}

	/**
	 * @brief Returns the credits menu button.
	 * @return this.creditsMenuButton The credits menu button.
	 */
	public JButton getCreditsMenuButton() {
		return this.creditsMenuButton;
	}
}
