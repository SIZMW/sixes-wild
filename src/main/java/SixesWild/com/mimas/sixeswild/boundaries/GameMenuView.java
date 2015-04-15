package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class represents the main view for the menus in the game for Sixes Wild.
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
	 * Constructor for GameMenuView class.
	 */
	public GameMenuView(ArrayList<String> storyLevelList,
			ArrayList<String> userLevelList, ArrayList<String> badgesList) {

		// General Layout Settings
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 5, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 9.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Panel Setups
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
		storyMenuView = new LevelSelectionPanel(storyLevelList);
		userMenuView = new LevelSelectionPanel(userLevelList);
		badgeMenuView = new BadgesPanel(badgesList);
		optionsMenuView = new OptionsPanel();
		creditsMenuView = new CreditsPanel();

		// Button Setups
		// Story menu button
		storyLevelMenuButton = new JButton("Story Levels");
		storyLevelMenuButton.setPreferredSize(new Dimension(150, 23));
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
	 * Returns the right sub menu panel.
	 * 
	 * @return this.subMenuPanel The sub menu panel.
	 */
	public JPanel getSubMenuPanel() {
		return this.subMenuPanel;
	}

	/**
	 * Returns the story level menu button.
	 * 
	 * @return this.storyLevelMenuButton The story level menu button.
	 */
	public JButton getStoryLevelMenuButton() {
		return this.storyLevelMenuButton;
	}

	/**
	 * Returns the user level menu button.
	 * 
	 * @return this.userLevelMenuButton The user level menu button.
	 */
	public JButton getUserLevelMenuButton() {
		return this.userLevelMenuButton;
	}

	/**
	 * Returns the badges menu button.
	 * 
	 * @return this.badgesMenuButton The badges menu button.
	 */
	public JButton getBadgesMenuButton() {
		return this.badgesMenuButton;
	}

	/**
	 * Returns the options menu button.
	 * 
	 * @return this.optionsMenuButton The options menu button.
	 */
	public JButton getOptionsMenuButton() {
		return this.optionsMenuButton;
	}

	/**
	 * Returns the credits menu button.
	 * 
	 * @return this.creditsMenuButton The credits menu button.
	 */
	public JButton getCreditsMenuButton() {
		return this.creditsMenuButton;
	}

	/**
	 * Returns the badge menu view.
	 * 
	 * @return this.badgeMenuView The badge menu view.
	 */
	public BadgesPanel getBadgeMenuView() {
		return this.badgeMenuView;
	}

	/**
	 * Returns the option menu view.
	 * 
	 * @return this.optionMenuView The options menu view.
	 */
	public OptionsPanel getOptionsMenuView() {
		return this.optionsMenuView;
	}

	/**
	 * Returns the story menu view.
	 * 
	 * @return this.storyMenuView The story menu view.
	 */
	public LevelSelectionPanel getStoryMenuView() {
		return this.storyMenuView;
	}

	/**
	 * Returns the user menu view.
	 * 
	 * @return this.userMenuView The user menu view.
	 */
	public LevelSelectionPanel getUserMenuView() {
		return this.userMenuView;
	}

	/**
	 * Returns the credits menu view.
	 * 
	 * @return this.creditsMenuView The credits menu view.
	 */
	public CreditsPanel getCreditsMenuView() {
		return this.creditsMenuView;
	}

	/**
	 * Returns the title menu view.
	 * 
	 * @return this.titleMenuView The title menu view.
	 */
	public TitlePanel getTitleMenuView() {
		return this.titleMenuView;
	}

	/**
	 * Refresh this panel using the application to get new data.
	 * 
	 * @param app
	 *            The game application to refresh from.
	 */
	public void refresh(GameApplication app) {
		// TODO Refresh this panel.
	}
}
