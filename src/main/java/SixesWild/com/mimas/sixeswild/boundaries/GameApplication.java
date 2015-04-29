package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import SixesWild.com.mimas.sixeswild.controllers.BadgesMenuButtonController;
import SixesWild.com.mimas.sixeswild.controllers.CreditsMenuButtonController;
import SixesWild.com.mimas.sixeswild.controllers.GameCloseWindowController;
import SixesWild.com.mimas.sixeswild.controllers.GameSplashScreenController;
import SixesWild.com.mimas.sixeswild.controllers.OptionsMenuButtonController;
import SixesWild.com.mimas.sixeswild.controllers.PlayButtonController;
import SixesWild.com.mimas.sixeswild.controllers.StoryLevelListController;
import SixesWild.com.mimas.sixeswild.controllers.StoryMenuButtonController;
import SixesWild.com.mimas.sixeswild.controllers.UserLevelListController;
import SixesWild.com.mimas.sixeswild.controllers.UserLevelMenuButtonController;
import SixesWild.com.mimas.sixeswild.entities.Aesthetic;
import SixesWild.com.mimas.sixeswild.entities.MenuTypes;
import SixesWild.com.mimas.sixeswild.entities.UserProfile;
import SixesWild.com.mimas.sixeswild.util.XMLParser;

/**
 * This class represents the Game application that will run and handle the
 * player playing the game.
 *
 * @author Aditya Nivarthi
 */
public class GameApplication {

	private static final Logger logger = Logger.getGlobal();

	protected JFrame frame;
	protected GameMenuView gameMenuView;
	protected LevelView levelView;

	protected ArrayList<Aesthetic> aestheticList;
	protected Aesthetic currentAesthetic;
	protected UserProfile currentUserProfile;

	protected ArrayList<String> storyLevelList;
	protected ArrayList<String> userLevelList;
	protected ArrayList<String> badgesList;

	// TODO Populate the list of badges

	/**
	 * Creates a GameApplication instance and initializes it.
	 */
	public GameApplication() {
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {

		// Set look and feel to system interface
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			logger.log(Level.WARNING, "System look and feel failed to load.", e);
		}

		// Set up aesthetics
		aestheticList = new ArrayList<Aesthetic>();
		this.setUpAesthetics();

		// Initialize lists for GameMenuView
		storyLevelList = XMLParser.getLevelFileNames(XMLParser.STORY_DIR);
		userLevelList = XMLParser.getLevelFileNames(XMLParser.USER_DIR);

		// Temporary generation of badge listing
		badgesList = new ArrayList<String>();
		for (int i = 1; i <= 20; i++) {
			badgesList.add("Badge " + i);
		}

		// Set up user profile
		this.setCurrentUserProfile("Default");

		// Initialize panels and views.
		gameMenuView = new GameMenuView(storyLevelList, userLevelList,
				badgesList, aestheticList,
				currentUserProfile.getHighestStoryLevelUnlocked(),
				currentUserProfile.getHighestUserLevelUnlocked());
		levelView = new LevelView(currentAesthetic);

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
		URL splashScreen = getClass().getClassLoader().getResource(
				"SixesWildSplashScreenGameFINAL.png");
		frame.getContentPane().add(new SplashScreen(splashScreen));

		logger.log(Level.FINE, "GameApplication frame initialized.");

		// Set up controllers
		this.setUpControllers();
	}

	/**
	 * Set up the controllers on the various components in the game.
	 */
	protected void setUpControllers() {

		// Closing window
		this.frame.addWindowListener(new GameCloseWindowController(this));

		// Menu buttons
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

		// Level play button
		this.gameMenuView
				.getStoryMenuView()
				.getPlayButton()
				.addActionListener(
						new PlayButtonController(this, MenuTypes.STORY));
		this.gameMenuView
				.getUserMenuView()
				.getPlayButton()
				.addActionListener(
						new PlayButtonController(this, MenuTypes.USER));

		// Splash screen
		this.getFrame().addKeyListener(new GameSplashScreenController(this));

		// Level list previews
		this.gameMenuView.getStoryMenuView().levelList
				.addListSelectionListener(new StoryLevelListController(this));
		this.gameMenuView.getUserMenuView().levelList
				.addListSelectionListener(new UserLevelListController(this));

		logger.log(Level.FINE, "GameApplication controllers initialized.");
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
		aestheticList.add(new Aesthetic("SupahRed", Color.white, Color.RED,
				new Color(0xFF7F00), new Color(0xCC0000), new Color(0x990000),
				new Color(0xCC3300), new Color(0xCC6600), new Color(0x800000),
				Color.lightGray));
		aestheticList.add(new Aesthetic("FunColors", Color.GREEN, new Color(
				0x2352FF), new Color(0xDFE80C), new Color(0xFF0084), new Color(
				0x0BE8B3), new Color(0xFFAE27), new Color(0xFF0027), new Color(
				0x800000), Color.lightGray));

		aestheticList.add(new Aesthetic("Blooregard Q. Kazoo", Color.white,
				new Color(0xE417E5), new Color(0x820EF0), new Color(0x0800D9),
				new Color(0x0066F0), new Color(0x11808E), new Color(0xD9006D),
				new Color(0x00D9C9), Color.GRAY));

		currentAesthetic = aestheticList.get(0);

		logger.log(Level.FINE, "GameApplication aesthetic listing initialized.");
	}

	/**
	 * Returns the frame object for this class.
	 *
	 * @return the frame property
	 */
	public JFrame getFrame() {
		return this.frame;
	}

	/**
	 * Returns the gameMenuView object for this class.
	 *
	 * @return the gameMenuView property
	 */
	public GameMenuView getGameMenuView() {
		return this.gameMenuView;
	}

	/**
	 * Returns the levelView object for this class.
	 *
	 * @return the levelView property
	 */
	public LevelView getLevelPanel() {
		return this.levelView;
	}

	/**
	 * Sets the levelView object to the specified LevelView.
	 *
	 * @param newLevel
	 *            The levelView object for this class.
	 * @return true
	 */
	public boolean setLevelPanel(LevelView newLevel) {
		this.levelView = newLevel;
		return true;
	}

	/**
	 * Returns the currentAesthetic object for this class.
	 *
	 * @return the currentAesthetic property
	 */
	public Aesthetic getCurrentAesthetic() {
		return this.currentAesthetic;
	}

	/**
	 * Returns the currentUserProfile object for this class.
	 *
	 * @return the currentUserProfile property
	 */
	public UserProfile getCurrentUserProfile() {
		return this.currentUserProfile;
	}

	/**
	 * Sets the current aesthetic based on the given name.
	 *
	 * @param name
	 *            The name of the aesthetic to load.
	 * @return true if aesthetic is found and set; false if a new profile was
	 *         created.
	 */
	public boolean setCurrentAesthetic(String name) {
		for (Aesthetic e : aestheticList) {
			if (e.getName().equals(name)) {
				currentAesthetic = e;
				logger.log(Level.FINE, "GameApplication aesthetic changed to: "
						+ e.getName());
				return true;
			}
		}

		logger.log(Level.WARNING, "GameApplication aesthetic failed to change.");
		return false;
	}

	/**
	 * Sets the current user profile.
	 *
	 * @param name
	 *            The name of the user to load.
	 * @return true if profile was found and set; false if a new profile was
	 *         created.
	 */
	public boolean setCurrentUserProfile(String name) {
		for (String e : XMLParser.getUserProfileNames()) {
			if (name.equals(e)) {
				this.currentUserProfile = XMLParser.fileToUserProfile(name
						+ XMLParser.PROFILE_CONST + XMLParser.XML_EXT);
				logger.log(Level.INFO, "User profile found for: " + name);
				this.refreshView();
				this.setCurrentAesthetic(this.currentUserProfile
						.getAestheticName());
				return true;
			}
		}

		// If profile not found, create a new one
		logger.log(Level.INFO, "User profile created for: " + name);
		this.currentUserProfile = new UserProfile(name);
		return false;
	}

	/**
	 * Refreshes the game menu view with the updated unlocked levels from the
	 * user profile.
	 */
	public void refreshView() {
		if (gameMenuView != null) {
			this.gameMenuView.refreshView(
					currentUserProfile.getHighestStoryLevelUnlocked(),
					currentUserProfile.getHighestUserLevelUnlocked());
		}

		logger.log(Level.INFO,
				"Game menu view is being refreshed with new unlocked level values.");
	}
}
