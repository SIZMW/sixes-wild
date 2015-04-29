package SixesWild.com.mimas.sixeswild.controllers;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.entities.GameLevel;
import SixesWild.com.mimas.sixeswild.entities.MenuTypes;
import SixesWild.com.mimas.sixeswild.util.XMLParser;

/**
 * This controller handles updating the story level preview when a selected
 * story level is requested.
 *
 * @author Aditya Nivarthi
 */
public class StoryLevelListController implements ListSelectionListener {

	protected GameApplication app;

	/**
	 * Creates a StoryLevelListController instance with the specified
	 * GameApplication.
	 *
	 * @param app
	 *            The GameApplication currently running.
	 */
	public StoryLevelListController(GameApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event
	 * .ListSelectionEvent)
	 */
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int index = app.getGameMenuView().getStoryMenuView().getLevelList()
					.getSelectedIndex();
			GameLevel level = XMLParser.fileToLevel(XMLParser.STORY_DIR
					+ (index + 1) + XMLParser.XML_EXT);

			// Set the board from the level
			app.getGameMenuView().getStoryMenuView().getLevelPreviewPanel()
					.setBoard(level.getBoard());

			// Pass on the current aesthetic
			app.getGameMenuView().getStoryMenuView().getLevelPreviewPanel()
					.setAesthetic(app.getCurrentAesthetic());

			// Update the star preview
			app.getGameMenuView()
					.getStoryMenuView()
					.getStarGraphicsPanel()
					.refreshStars(
							app.getCurrentUserProfile().getStarsOfLevel(
									level.getLevelNumber(), MenuTypes.STORY));
		}
	}
}
