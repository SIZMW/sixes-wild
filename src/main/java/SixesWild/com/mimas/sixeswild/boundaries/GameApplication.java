package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import SixesWild.com.mimas.sixeswild.controllers.BadgesMenuButtonController;
import SixesWild.com.mimas.sixeswild.controllers.CreditsMenuButtonController;
import SixesWild.com.mimas.sixeswild.controllers.GameSplashScreenController;
import SixesWild.com.mimas.sixeswild.controllers.OptionsMenuButtonController;
import SixesWild.com.mimas.sixeswild.controllers.PlayButtonController;
import SixesWild.com.mimas.sixeswild.controllers.StoryMenuButtonController;
import SixesWild.com.mimas.sixeswild.controllers.UserLevelMenuButtonController;
import SixesWild.com.mimas.sixeswild.entities.Aesthetic;

/**
 * This class represents the Game application that will run and handle the
 * player playing the game.
 * 
 * @author Aditya Nivarthi
 */
public class GameApplication {

	JFrame frame;
	GameMenuView gameMenuView;
	LevelView levelView;
	Aesthetic aesthetic;

	// TODO
	// BadgesPanel badgePanel;
	// ArrayList<String> listOfBadges;
	// UserProfile currentProfile;

	/**
	 * Creates a GameApplication instance.
	 */
	public GameApplication() {
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		// TODO Read this from disk or user profile as necessary.
		// Initialize lists for GameMenuView
		ArrayList<String> storyLevelList = new ArrayList<String>();
		for (int i = 1; i <= 999; i++) {
			int type = i % 4;
			String levelType = (type == 1) ? ": Puzzle "
					: (type == 2) ? ": Elimination "
							: (type == 3) ? ": Lightning " : ": Release ";
			storyLevelList.add("Level " + i + levelType);
		}

		ArrayList<String> userLevelList = new ArrayList<String>();
		for (int i = 1; i <= 666; i++) {
			int type = i % 4;
			String levelType = (type == 1) ? ": Puzzle "
					: (type == 2) ? ": Elimination "
							: (type == 3) ? ": Lightning " : ": Release ";
			userLevelList.add("Level " + i + levelType);
		}

		ArrayList<String> badgesList = new ArrayList<String>();
		for (int i = 1; i <= 20; i++) {
			badgesList.add("Badge " + i);
		}

		aesthetic = new Aesthetic("ROYGBIV", Color.white, Color.RED, new Color(
				0xFF7F00), Color.YELLOW, Color.GREEN, Color.CYAN,
				Color.MAGENTA, new Color(0x7D26CD), Color.lightGray);

		// TODO Get from user profile.
		int highestLevelUnlocked = 10;

		// Initialize panels and views.
		gameMenuView = new GameMenuView(storyLevelList, userLevelList,
				badgesList, highestLevelUnlocked);
		levelView = new LevelView(this.aesthetic);

		// Initialize frame
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		frame.setPreferredSize(new Dimension(1000, 700));
		frame.setMinimumSize(new Dimension(1000, 700));
		frame.getContentPane().add(new SplashScreen());
		this.setUpControllers();
	}

	/**
	 * Set up the controllers on the various components in the game.
	 */
	protected void setUpControllers() {
		this.gameMenuView.getStoryLevelMenuButton().addActionListener(
				new StoryMenuButtonController(this));
		this.gameMenuView.getOptionsMenuButton().addActionListener(
				new OptionsMenuButtonController(this));
		this.gameMenuView.getUserLevelMenuButton().addActionListener(
				new UserLevelMenuButtonController(this));
		this.gameMenuView.getCreditsMenuButton().addActionListener(
				new CreditsMenuButtonController(this));
		this.gameMenuView.getBadgesMenuButton().addActionListener(
				new BadgesMenuButtonController(this));
		this.gameMenuView.getStoryMenuView().getPlayButton()
				.addActionListener(new PlayButtonController(this));
		this.gameMenuView.getUserMenuView().getPlayButton()
				.addActionListener(new PlayButtonController(this));
		this.getFrame().addKeyListener(new GameSplashScreenController(this));
	}

	/**
	 * Returns the game frame.
	 * 
	 * @return JFrame for the game application
	 */
	public JFrame getFrame() {
		return this.frame;
	}

	/**
	 * Returns the game GameMenuView.
	 * 
	 * @return GameMenuView for the game application
	 */
	public GameMenuView getMainPanel() {
		return this.gameMenuView;
	}

	/**
	 * Returns the game levelPanel.
	 * 
	 * @return LevelView for the game application
	 */
	public LevelView getLevelPanel() {
		return this.levelView;
	}

	/**
	 * Sets the LevelPanel to the given levelView.
	 * 
	 * @param newLevel
	 *            The LevelView to display.
	 */
	public void setLevelPanel(LevelView newLevel) {
		this.levelView = newLevel;
	}

	/**
	 * Returns the aesthetic of this application.
	 * 
	 * @return Aesthetic for game application
	 */
	public Aesthetic getAesthetic() {
		return this.aesthetic;
	}
}
