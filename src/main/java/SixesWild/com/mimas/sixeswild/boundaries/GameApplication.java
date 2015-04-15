package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.BorderLayout;
import java.awt.Dimension;

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
	GameMenuPanel gameMenuPanel;
	LevelView levelView;

	// BadgesPanel badgePanel;
	// ArrayList<String> listOfBadges;
	// UserProfile currentProfile;

	/**
	 * Constructor for GameApplication class.
	 */
	public GameApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		gameMenuPanel = new GameMenuPanel();
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

		// TODO Add splash screen on startup
		frame.getContentPane().add(new SplashScreen());

		this.setUpControllers();
	}

	/**
	 * Set up the controllers on the various components in the game.
	 */
	private void setUpControllers() {
		this.gameMenuPanel.getStoryLevelMenuButton().addActionListener(
				new StoryMenuButtonController(this));
		this.gameMenuPanel.getOptionsMenuButton().addActionListener(
				new OptionsMenuButtonController(this));
		this.gameMenuPanel.getUserLevelMenuButton().addActionListener(
				new UserLevelMenuButtonController(this));
		this.gameMenuPanel.getCreditsMenuButton().addActionListener(
				new CreditsMenuButtonController(this));
		this.gameMenuPanel.getBadgesMenuButton().addActionListener(
				new BadgesMenuButtonController(this));
		// this.mainPanel.titleMenuView.addKeyListener(new
		// TitleViewController());
		this.gameMenuPanel.getStoryMenuView().getPlayButton()
				.addActionListener(new PlayButtonController(this));
		this.gameMenuPanel.getUserMenuView().getPlayButton()
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
	 * Returns the game GameMenuPanel.
	 * 
	 * @return this.mainPanel The game GameMenuPanel.
	 */
	public GameMenuPanel getMainPanel() {
		return this.gameMenuPanel;
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
