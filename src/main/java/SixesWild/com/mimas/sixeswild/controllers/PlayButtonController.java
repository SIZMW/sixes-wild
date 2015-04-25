package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.boundaries.LevelView;
import SixesWild.com.mimas.sixeswild.entities.GameLevel;
import SixesWild.com.mimas.sixeswild.entities.MenuTypes;
import SixesWild.com.mimas.sixeswild.sixeswild.XMLParser;

/**
 * This controller creates and displays the level when the play button is
 * pressed in a specified level preview panel.
 * 
 * @author Cameron Jones
 */
public class PlayButtonController implements ActionListener {

	private static final Logger logger = Logger.getGlobal();

	protected GameApplication app;
	protected MenuTypes menuType;

	/**
	 * Creates a PlayButtonController instance with the specified
	 * GameApplication.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 * @param menuType
	 *            The menu type for the currently selected game menu.
	 */
	public PlayButtonController(GameApplication app, MenuTypes menuType) {
		this.app = app;
		this.menuType = menuType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		Container contentContainer = app.getFrame().getContentPane();
		JPanel currentPanel = new JPanel();

		// Layout for panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		currentPanel.setPreferredSize(new Dimension(800, 600));
		currentPanel.setLayout(gridBagLayout);

		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;

		// Create new view
		// Find the Current Selection
		int levelNumber;
		GameLevel newLevel;

		if (menuType.equals(MenuTypes.STORY)) {
			levelNumber = app.getGameMenuView().getStoryMenuView()
					.getLevelList().getSelectedIndex() + 1;
			newLevel = XMLParser.fileToLevel(XMLParser.STORY_DIR
					+ Integer.toString(levelNumber) + ".xml");
		} else {
			levelNumber = app.getGameMenuView().getUserMenuView()
					.getLevelList().getSelectedIndex() + 1;
			newLevel = XMLParser.fileToLevel(XMLParser.USER_DIR
					+ Integer.toString(levelNumber) + ".xml");
		}

		if (newLevel == null) {
			logger.log(Level.WARNING, "Level selected was not found.");
		} else {
			contentContainer.removeAll();
			LevelView newLevelView = new LevelView(app.getCurrentAesthetic(),
					newLevel);
			this.app.setLevelPanel(newLevelView);
			this.setUpControllers();

			// Add panel to view
			currentPanel.add(this.app.getLevelPanel(), gbc_list);
			contentContainer.add(currentPanel);
			contentContainer.revalidate();
			contentContainer.repaint();
		}

		logger.log(Level.FINE,
				"Level view requested, level loaded and displayed.");
	}

	/**
	 * Set up controllers for the level view.
	 */
	protected void setUpControllers() {
		app.getLevelPanel().getTopMenuPanel().getExitLevelButton()
				.addActionListener(new ExitButtonController(app));
		app.getLevelPanel().getBoardViewPanel()
				.addMouseListener(new GameBoardViewMouseController(app));
		app.getLevelPanel()
				.getBoardViewPanel()
				.addMouseMotionListener(
						new GameBoardViewMouseMotionController(app));

		logger.log(Level.FINE, "Level view controllers initialized.");
	}
}
