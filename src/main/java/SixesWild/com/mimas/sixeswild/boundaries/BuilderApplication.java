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

import SixesWild.com.mimas.sixeswild.controllers.BuilderBoardViewMouseController;
import SixesWild.com.mimas.sixeswild.controllers.BuilderDeleteUserLevelButtonController;
import SixesWild.com.mimas.sixeswild.controllers.BuilderSplashScreenController;
import SixesWild.com.mimas.sixeswild.controllers.NewLevelButtonController;
import SixesWild.com.mimas.sixeswild.controllers.OpenButtonController;
import SixesWild.com.mimas.sixeswild.controllers.SaveButtonController;
import SixesWild.com.mimas.sixeswild.controllers.SpecialMoveFourDecreaseButtonController;
import SixesWild.com.mimas.sixeswild.controllers.SpecialMoveFourIncreaseButtonController;
import SixesWild.com.mimas.sixeswild.controllers.SpecialMoveOneDecreaseButtonController;
import SixesWild.com.mimas.sixeswild.controllers.SpecialMoveOneIncreaseButtonController;
import SixesWild.com.mimas.sixeswild.controllers.SpecialMoveThreeDecreaseButtonController;
import SixesWild.com.mimas.sixeswild.controllers.SpecialMoveThreeIncreaseButtonController;
import SixesWild.com.mimas.sixeswild.controllers.SpecialMoveTwoDecreaseButtonController;
import SixesWild.com.mimas.sixeswild.controllers.SpecialMoveTwoIncreaseButtonController;
import SixesWild.com.mimas.sixeswild.entities.Aesthetic;
import SixesWild.com.mimas.sixeswild.entities.Square;

/**
 * This class represents the Builder application that will run and handle the
 * player building the levels for the level builder.
 *
 * @author Aditya Nivarthi
 */
public class BuilderApplication {

	private static final Logger logger = Logger.getGlobal();

	protected JFrame frame;
	protected BuilderView builderView;
	protected Aesthetic aesthetic;

	protected ArrayList<Square> undoList;
	protected ArrayList<Square> redoList;

	/**
	 * Creates a BuilderApplication instance and initializes it.
	 */
	public BuilderApplication() {
		initialize();
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

		// Set up undo and redo lists
		undoList = new ArrayList<Square>();
		redoList = new ArrayList<Square>();

		// Set up default aesthetic
		aesthetic = new Aesthetic("ROYGBIV", Color.white, Color.RED, new Color(
				0xFF7F00), Color.YELLOW, Color.GREEN, Color.CYAN,
				Color.MAGENTA, new Color(0x7D26CD), Color.lightGray);

		// Initialize panels and views
		builderView = new BuilderView(aesthetic);

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

		// Create splash screen
		URL splashScreen = getClass().getClassLoader().getResource(
				"SixesWildDefaultBuilderSplash.png");
		frame.getContentPane().add(new SplashScreen(splashScreen));

		logger.log(Level.FINE, "BuilderApplication frame initialized.");

		// Set up controllers
		setUpControllers();
	}

	/**
	 * Set up the controllers on the various components in the game.
	 */
	protected void setUpControllers() {

		// Splash screen
		getFrame().addKeyListener(new BuilderSplashScreenController(this));

		// File management
		builderView.builderTopPanel.newButton
				.addActionListener(new NewLevelButtonController(this));
		builderView.builderSettingsPanel.specialMoveOneMinusButton
				.addActionListener(new SpecialMoveOneDecreaseButtonController(
						this));
		builderView.builderTopPanel.deleteButton
				.addActionListener(new BuilderDeleteUserLevelButtonController(
						this));
		builderView.builderTopPanel.openButton
				.addActionListener(new OpenButtonController(this));
		builderView.builderTopPanel.saveButton
				.addActionListener(new SaveButtonController(this));

		// Special move decrease and increase buttons
		builderView.builderSettingsPanel.specialMoveOnePlusButton
				.addActionListener(new SpecialMoveOneIncreaseButtonController(
						this));
		builderView.builderSettingsPanel.specialMoveTwoMinusButton
				.addActionListener(new SpecialMoveTwoDecreaseButtonController(
						this));
		builderView.builderSettingsPanel.specialMoveTwoPlusButton
				.addActionListener(new SpecialMoveTwoIncreaseButtonController(
						this));
		builderView.builderSettingsPanel.specialMoveThreeMinusButton
				.addActionListener(new SpecialMoveThreeDecreaseButtonController(
						this));
		builderView.builderSettingsPanel.specialMoveThreePlusButton
				.addActionListener(new SpecialMoveThreeIncreaseButtonController(
						this));
		builderView.builderSettingsPanel.specialMoveFourMinusButton
				.addActionListener(new SpecialMoveFourDecreaseButtonController(
						this));
		builderView.builderSettingsPanel.specialMoveFourPlusButton
				.addActionListener(new SpecialMoveFourIncreaseButtonController(
						this));

		// Mouse press
		builderView.boardViewPanel
				.addMouseListener(new BuilderBoardViewMouseController(this));

		logger.log(Level.FINE, "BuilderApplication controllers initialized.");
	}

	/**
	 * Returns the frame object for this class.
	 *
	 * @return the frame property
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Returns the builderView object for this class.
	 *
	 * @return the builderView property
	 */
	public BuilderView getBuilderView() {
		return builderView;
	}

	/**
	 * Returns the aesthetic object for this class.
	 *
	 * @return the aesthetic property
	 */
	public Aesthetic getAesthetic() {
		return aesthetic;
	}

	/**
	 * Returns the list of undo actions.
	 * 
	 * @return an ArrayList
	 */
	public ArrayList<Square> getUndoList() {
		return undoList;
	}

	/**
	 * Returns the list of redo actions.
	 *
	 * @return an ArrayList
	 */
	public ArrayList<Square> getRedoList() {
		return undoList;
	}
}
