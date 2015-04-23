package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import SixesWild.com.mimas.sixeswild.controllers.BuilderBoardViewMouseController;
import SixesWild.com.mimas.sixeswild.controllers.BuilderSplashScreenController;
import SixesWild.com.mimas.sixeswild.controllers.NewLevelButtonController;
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

/**
 * This class represents the Builder application that will run and handle the
 * player building the levels for the level builder.
 * 
 * @author Aditya Nivarthi
 */
public class BuilderApplication {

	private static final Logger logger = Logger.getGlobal();

	JFrame frame;
	BuilderView builderView;
	Aesthetic aesthetic;

	/**
	 * Constructor for BuilderApplication class.
	 */
	public BuilderApplication() {
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			logger.log(Level.WARNING, "System look and feel failed to load.", e);
		}

		// TODO Verify the creation of the aesthetic is valid here
		aesthetic = new Aesthetic("ROYGBIV", Color.white, Color.RED, new Color(
				0xFF7F00), Color.YELLOW, Color.GREEN, Color.CYAN,
				Color.MAGENTA, new Color(0x7D26CD), Color.lightGray);

		// Initialize panels and views
		builderView = new BuilderView(this.aesthetic);

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

		logger.log(Level.FINE, "BuilderApplication frame initialized.");

		// Set up controllers
		this.setUpControllers();
	}

	/**
	 * Set up the controllers on the various components in the game.
	 */
	protected void setUpControllers() {
		this.getFrame().addKeyListener(new BuilderSplashScreenController(this));

		this.builderView.builderTopPanel.newButton
				.addActionListener(new NewLevelButtonController(this));
		this.builderView.builderSettingsPanel.specialMoveOneMinusButton
				.addActionListener(new SpecialMoveOneDecreaseButtonController(
						this));

		// Special move decrease and increase buttons
		this.builderView.builderSettingsPanel.specialMoveOnePlusButton
				.addActionListener(new SpecialMoveOneIncreaseButtonController(
						this));
		this.builderView.builderSettingsPanel.specialMoveTwoMinusButton
				.addActionListener(new SpecialMoveTwoDecreaseButtonController(
						this));
		this.builderView.builderSettingsPanel.specialMoveTwoPlusButton
				.addActionListener(new SpecialMoveTwoIncreaseButtonController(
						this));
		this.builderView.builderSettingsPanel.specialMoveThreeMinusButton
				.addActionListener(new SpecialMoveThreeDecreaseButtonController(
						this));
		this.builderView.builderSettingsPanel.specialMoveThreePlusButton
				.addActionListener(new SpecialMoveThreeIncreaseButtonController(
						this));
		this.builderView.builderSettingsPanel.specialMoveFourMinusButton
				.addActionListener(new SpecialMoveFourDecreaseButtonController(
						this));
		this.builderView.builderSettingsPanel.specialMoveFourPlusButton
				.addActionListener(new SpecialMoveFourIncreaseButtonController(
						this));
		this.builderView.boardViewPanel
				.addMouseListener(new BuilderBoardViewMouseController(this));
		this.builderView.builderTopPanel.saveButton
				.addActionListener(new SaveButtonController(this));

		logger.log(Level.FINE, "BuilderApplication controllers initialized.");
	}

	/**
	 * Returns the game frame.
	 * 
	 * @return JFrame for builder application
	 */
	public JFrame getFrame() {
		return this.frame;
	}

	/**
	 * Returns the game BuilderView.
	 * 
	 * @return BuilderView for builder application
	 */
	public BuilderView getBuilderView() {
		return this.builderView;
	}

	/**
	 * Returns the aesthetic of this application.
	 * 
	 * @return Aesthetic for builder application
	 */
	public Aesthetic getAesthetic() {
		return this.aesthetic;
	}
}
