package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import SixesWild.com.mimas.sixeswild.controllers.OptionsMenuButtonController;
import SixesWild.com.mimas.sixeswild.controllers.StoryMenuButtonController;

/**
 * This class represents the Game application that will run and handle the
 * player playing the game Sixes Wild.
 * 
 * @author Aditya Nivarthi
 */
public class GameApplication {

	JFrame frame;
	MainPanel mainPanel;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);

		// TODO Add splash screen on startup

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
}
