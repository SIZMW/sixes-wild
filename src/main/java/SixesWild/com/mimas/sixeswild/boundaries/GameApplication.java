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
import SixesWild.com.mimas.sixeswild.controllers.MenuTypes;
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

	ArrayList<Aesthetic> aestheticList;
	Aesthetic currentAesthetic;

	// TODO Add these attributes to GameApplication
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

		// Set up aesthetics
		aestheticList = new ArrayList<Aesthetic>();
		this.setUpAesthetics();

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

		// TODO Get from user profile.
		int highestLevelUnlocked = 5;

		// Initialize panels and views.
		gameMenuView = new GameMenuView(storyLevelList, userLevelList,
				badgesList, aestheticList, highestLevelUnlocked);
		levelView = new LevelView(this.aestheticList.get(0));

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
				.addActionListener(new PlayButtonController(this, MenuTypes.STORY));
		this.gameMenuView.getUserMenuView().getPlayButton()
				.addActionListener(new PlayButtonController(this, MenuTypes.USER));
		this.getFrame().addKeyListener(new GameSplashScreenController(this));
	}

	/**
	 * Set up the aesthetic options to apply to the game.
	 */
	protected void setUpAesthetics() {
		aestheticList.add(new Aesthetic("ROYGBIV", Color.white, Color.RED,
				new Color(0xFF7F00), Color.YELLOW, Color.GREEN, Color.CYAN,
				Color.MAGENTA, new Color(0x7D26CD), Color.lightGray));
		aestheticList.add(new Aesthetic("CoolColor", Color.white, Color.BLUE,
				new Color(0x0099CC), new Color(0x99CCFF), Color.GREEN,
				Color.CYAN, new Color(0x9966FF), new Color(0x33CCFF),
				Color.lightGray));
		aestheticList.add(new Aesthetic("SuperRed", Color.white, Color.RED,
				new Color(0xFF7F00), new Color(0xCC0000), new Color(0x990000),
				new Color(0xCC3300), new Color(0xCC6600), new Color(0x800000),
				Color.lightGray));

		currentAesthetic = aestheticList.get(0);
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
	 * Returns the current aesthetic of this application.
	 * 
	 * @return Aesthetic for game application
	 */
	public Aesthetic getCurrentAesthetic() {
		return this.currentAesthetic;
	}

	/**
	 * Sets the current aesthetic based on the given name.
	 * 
	 * @param name
	 *            The name of the aesthetic.
	 * @return true if aesthetic is found and set; false otherwise.
	 */
	public boolean setCurrentAesthetic(String name) {
		for (Aesthetic e : aestheticList) {
			if (e.getName().equals(name)) {
				currentAesthetic = e;
				return true;
			}
		}

		return false;
	}
}
