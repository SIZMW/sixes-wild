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
import SixesWild.com.mimas.sixeswild.controllers.OptionsMenuButtonController;
import SixesWild.com.mimas.sixeswild.controllers.PlayButtonController;
import SixesWild.com.mimas.sixeswild.controllers.StoryMenuButtonController;
import SixesWild.com.mimas.sixeswild.controllers.UserLevelMenuButtonController;
import SixesWild.com.mimas.sixeswild.controllers.TitleViewController;

/**
 * This class represents the Game application that will run and handle the
 * player playing the game Sixes Wild.
 * 
 * @author Aditya Nivarthi
 */
public class GameApplication {

	JFrame frame;
	MainPanel mainPanel;
	LevelView levelView;

	// BadgesPanel badgePanel;
	// ArrayList<String> listOfBadges;
	// int highestLevel;
	// TODO Add LevelPanel attribute when it is created.

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

		mainPanel = new MainPanel();
		levelView = new LevelView();
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		frame.setPreferredSize(new Dimension(800, 600));

		// TODO Add splash screen on startup
		// frame.getContentPane().add(new SplashScreen());

		// frame.getContentPane().removeAll();
		frame.getContentPane().add(mainPanel);
		this.setUpControllers();
	}

	/**
	 * Set up the controllers on the various components in the game.
	 */
	private void setUpControllers() {
		this.mainPanel.getStoryLevelMenuButton().addActionListener(
				new StoryMenuButtonController(this));
		this.mainPanel.getOptionsMenuButton().addActionListener(
				new OptionsMenuButtonController(this));
		this.mainPanel.getUserLevelMenuButton().addActionListener(
				new UserLevelMenuButtonController(this));
		this.mainPanel.getCreditsMenuButton().addActionListener(
				new CreditsMenuButtonController(this));
		this.mainPanel.getBadgesMenuButton().addActionListener(
				new BadgesMenuButtonController(this));
		//this.mainPanel.titleMenuView.addKeyListener(new TitleViewController());
		this.mainPanel.getStoryMenuView().getPlayButton()
				.addActionListener(new PlayButtonController(this));
		this.mainPanel.getUserMenuView().getPlayButton()
		.addActionListener(new PlayButtonController(this));
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
	 * Returns the game MainPanel.
	 * 
	 * @return this.mainPanel The game MainPanel.
	 */
	public MainPanel getMainPanel() {
		return this.mainPanel;
	}

	/**
	 * Returns the game levelPanel.
	 * 
	 * @return this.levelPanel The game LevelPanel.
	 */
	public LevelView getLevelPanel() {
		return this.levelView;
	}

	public void setLevelPanel(LevelView newLevel){
		this.levelView = newLevel;
	}
}
