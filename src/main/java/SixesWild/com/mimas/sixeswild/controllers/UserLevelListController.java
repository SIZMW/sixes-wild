package SixesWild.com.mimas.sixeswild.controllers;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.entities.GameLevel;
import SixesWild.com.mimas.sixeswild.sixeswild.XMLParser;

/**
 * This controller handles updating the user level preview when a selected user
 * level is requested.
 *
 * @author Aditya Nivarthi
 */
public class UserLevelListController implements ListSelectionListener {

	protected GameApplication app;

	/**
	 * Creates a UserLevelListController instance with the specified
	 * GameApplication.
	 *
	 * @param app
	 *            The GameApplication currently running.
	 */
	public UserLevelListController(GameApplication app) {
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
			int index = this.app.getGameMenuView().getUserMenuView()
					.getLevelList().getSelectedIndex();
			GameLevel level = XMLParser.fileToLevel(XMLParser.STORY_DIR
					+ (index + 1) + XMLParser.XML_EXT);

			// Set the board from the level
			this.app.getGameMenuView().getUserMenuView().getLevelPreviewPanel()
					.setBoard(level.getBoard());

			// Pass the current aesthetic
			this.app.getGameMenuView().getUserMenuView().getLevelPreviewPanel()
					.setAesthetic(this.app.getCurrentAesthetic());
		}
	}

}
