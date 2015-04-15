package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.BorderLayout;
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

/**
 * This class represents the Game application that will run and handle the
 * player playing the game Sixes Wild.
 * 
 * @author Aditya Nivarthi
 */
public class GameApplication {

	JFrame frame;
	GameMenuView gameMenuView;
	LevelView levelView;

	// BadgesPanel badgePanel;
	// ArrayList<String> listOfBadges;
	// UserProfile currentProfile;

	/**
	 * Constructor for GameApplication class.
	 */
	public GameApplication() {
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
			userLevelList.add("Custom Level " + i + levelType);
		}

		ArrayList<String> badgesList = new ArrayList<String>();
		for (int i = 1; i <= 20; i++) {
			badgesList.add("Badge " + i);
		}

		// Initialize panels and views.
		gameMenuView = new GameMenuView(storyLevelList, userLevelList,
				badgesList);
		levelView = new LevelView();
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setMinimumSize(new Dimension(470, 350));
		frame.getContentPane().add(new SplashScreen());
		this.setUpControllers();
	}

	/**
	 * Set up the controllers on the various components in the game.
	 */
	private void setUpControllers() {
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
	 * @return this.frame The game frame.
	 */
	public JFrame getFrame() {
		return this.frame;
	}

	/**
	 * Returns the game GameMenuView.
	 * 
	 * @return this.mainPanel The game GameMenuView.
	 */
	public GameMenuView getMainPanel() {
		return this.gameMenuView;
	}

	/**
	 * Returns the game levelPanel.
	 * 
	 * @return this.levelPanel The game LevelPanel.
	 */
	public LevelView getLevelPanel() {
		return this.levelView;
	}

	public void setLevelPanel(LevelView newLevel) {
		this.levelView = newLevel;
	}
}
