package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import SixesWild.com.mimas.sixeswild.controllers.BuilderSplashScreenController;

/**
 * This class represents the Builder application that will run and handle the
 * player building the levels for Sixes Wild.
 * 
 * @author Aditya Nivarthi
 */
public class BuilderApplication {

	JFrame frame;
	BuilderView builderView;
	
	/**
	 * Constructor for BuilderApplication class.
	 */
	public BuilderApplication() {
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
		
		builderView = new BuilderView();
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
	private void setUpControllers() {
		this.getFrame().addKeyListener(new BuilderSplashScreenController(this));
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
	 * Returns the game BuilderView.
	 * 
	 * @return this.builderView The game BuilerView.
	 */
	public BuilderView getBuilderView() {
		return this.builderView;
	}
}
