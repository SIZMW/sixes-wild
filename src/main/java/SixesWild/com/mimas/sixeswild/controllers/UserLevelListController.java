package SixesWild.com.mimas.sixeswild.controllers;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.entities.GameLevel;
import SixesWild.com.mimas.sixeswild.entities.MenuTypes;

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
			GameLevel level = app.getGameMenuView().getUserMenuView()
					.getLevelList().getSelectedValue();

			// Set the board from the level
			app.getGameMenuView().getUserMenuView().getLevelPreviewPanel()
					.setBoard(level.getBoard());

			// Pass the current aesthetic
			app.getGameMenuView().getUserMenuView().getLevelPreviewPanel()
					.setAesthetic(app.getCurrentAesthetic());

			// Update the star preview
			app.getGameMenuView()
					.getUserMenuView()
					.getStarGraphicsPanel()
					.refreshStars(
							app.getCurrentUserProfile().getStarsOfLevel(
									level.getLevelNumber(), MenuTypes.USER));
		}
	}
}
