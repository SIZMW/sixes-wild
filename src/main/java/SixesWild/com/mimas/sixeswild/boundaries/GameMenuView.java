package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.entities.Aesthetic;

/**
 * This class represents the main view for the menus in the game.
 * 
 * @author Cameron Jones
 */
public class GameMenuView extends JPanel {

	private static final long serialVersionUID = 1L;

	JPanel subMenuPanel;
	TitlePanel titleMenuView;
	LevelSelectionPanel storyMenuView;
	LevelSelectionPanel userMenuView;
	BadgesPanel badgeMenuView;
	OptionsPanel optionsMenuView;
	CreditsPanel creditsMenuView;
	JButton storyLevelMenuButton;
	JButton userLevelMenuButton;
	JButton badgesMenuButton;
	JButton optionsMenuButton;
	JButton creditsMenuButton;

	/**
	 * Creates a GameMenuView instance with the specified story level list, user
	 * level list, badges list and highest level unlocked.
	 * 
	 * @param storyLevelList
	 *            The list of story levels.
	 * @param userLevelList
	 *            The list of user levels.
	 * @param badgesList
	 *            The list of badges.
	 * @param aestheticList
	 * 			  The list of aesthetics that were created.
	 * @param highestLevelUnlocked
	 *            The highest number level that is unlocked to play.
	 */
	public GameMenuView(ArrayList<String> storyLevelList,
			ArrayList<String> userLevelList, ArrayList<String> badgesList,
			ArrayList<Aesthetic> aestheticList, int storyHighestUnlocked, int userHighestUnlocked) {

		// General Layout Settings
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 5, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 9.0, Double.MIN_VALUE };
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

		// Menu panels
		titleMenuView = new TitlePanel();
		storyMenuView = new LevelSelectionPanel(storyLevelList,
				storyHighestUnlocked);
		userMenuView = new LevelSelectionPanel(userLevelList,
				userHighestUnlocked);
		badgeMenuView = new BadgesPanel(badgesList);
		optionsMenuView = new OptionsPanel(aestheticList);
		creditsMenuView = new CreditsPanel();

		// Story menu button
		storyLevelMenuButton = new JButton("Story Levels");
		storyLevelMenuButton.setPreferredSize(new Dimension(150, 23));

		// Layout for story menu button
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		add(storyLevelMenuButton, gbc_btnNewButton);

		// User menu button
		userLevelMenuButton = new JButton("User Levels");

		// Layout for user menu button
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		add(userLevelMenuButton, gbc_btnNewButton_1);

		// Badges menu button
		badgesMenuButton = new JButton("Badges");

		// Layout for badges menu button
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 2;
		add(badgesMenuButton, gbc_btnNewButton_2);

		// Options menu button
		optionsMenuButton = new JButton("Options");

		// Layout for options menu button
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 3;
		add(optionsMenuButton, gbc_btnNewButton_3);

		// Credits menu button
		creditsMenuButton = new JButton("Credits");

		// Layout for credits menu button
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 4;
		add(creditsMenuButton, gbc_btnNewButton_4);
	}

	/**
	 * Returns the right sub menu panel.
	 * 
	 * @return JPanel for the sub menu panel
	 */
	public JPanel getSubMenuPanel() {
		return this.subMenuPanel;
	}

	/**
	 * Returns the story level menu button.
	 * 
	 * @return JButton for the story level menu
	 */
	public JButton getStoryLevelMenuButton() {
		return this.storyLevelMenuButton;
	}

	/**
	 * Returns the user level menu button.
	 * 
	 * @return JButton for the user level menu
	 */
	public JButton getUserLevelMenuButton() {
		return this.userLevelMenuButton;
	}

	/**
	 * Returns the badges menu button.
	 * 
	 * @return JButton for the badges menu
	 */
	public JButton getBadgesMenuButton() {
		return this.badgesMenuButton;
	}

	/**
	 * Returns the options menu button.
	 * 
	 * @return JButton for the options menu
	 */
	public JButton getOptionsMenuButton() {
		return this.optionsMenuButton;
	}

	/**
	 * Returns the credits menu button.
	 * 
	 * @return JButton for the credits menu
	 */
	public JButton getCreditsMenuButton() {
		return this.creditsMenuButton;
	}

	/**
	 * Returns the badge menu view.
	 * 
	 * @return BadgesPanel for the badges menu
	 */
	public BadgesPanel getBadgeMenuView() {
		return this.badgeMenuView;
	}

	/**
	 * Returns the option menu view.
	 * 
	 * @return OptionsPanel for the options menu
	 */
	public OptionsPanel getOptionsMenuView() {
		return this.optionsMenuView;
	}

	/**
	 * Returns the story menu view.
	 * 
	 * @return LevelSelectionPanel for the story level menu
	 */
	public LevelSelectionPanel getStoryMenuView() {
		return this.storyMenuView;
	}

	/**
	 * Returns the user menu view.
	 * 
	 * @return LevelSelectionPanel for the user level menu
	 */
	public LevelSelectionPanel getUserMenuView() {
		return this.userMenuView;
	}

	/**
	 * Returns the credits menu view.
	 * 
	 * @return CreditsPanel for the credits menu
	 */
	public CreditsPanel getCreditsMenuView() {
		return this.creditsMenuView;
	}

	/**
	 * Returns the title menu view.
	 * 
	 * @return TitlePanel for the title menu
	 */
	public TitlePanel getTitleMenuView() {
		return this.titleMenuView;
	}
}
