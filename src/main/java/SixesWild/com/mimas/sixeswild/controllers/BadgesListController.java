package SixesWild.com.mimas.sixeswild.controllers;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.entities.Badge;
import SixesWild.com.mimas.sixeswild.entities.ScoreBadge;

/**
 * This controller displays the preview for the selected badge in the badges
 * list menu.
 *
 * @author Aditya Nivarthi
 */
public class BadgesListController implements ListSelectionListener {

	protected GameApplication app;

	/**
	 * Creates a BadgesListController instance with the specified
	 * GameApplication.
	 *
	 * @param app
	 *            The GameApplication that is currently running
	 */
	public BadgesListController(GameApplication app) {
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
			String badgeName = app.getGameMenuView().getBadgeMenuView()
					.getBadgeSelectionList().getSelectedValue();
			for (String b : app.getCurrentUserProfile().getBadgesEarned()) {
				if (b.equals(badgeName)) {
					for (Badge d : app.getBadgesList()) {
						if (d.getName().equals(b)) {
							app.getGameMenuView().getBadgeMenuView()
									.getbBadgesPreviewLabel()
									.setText(d.getDescription());
							app.getGameMenuView().getBadgeMenuView()
									.getBadgePreviewPanel().refreshView(d);
						}
					}
					return;
				}
			}

			app.getGameMenuView().getBadgeMenuView().getBadgePreviewPanel()
					.refreshView(new ScoreBadge("-", "-", 0));
			app.getGameMenuView().getBadgeMenuView().getbBadgesPreviewLabel()
					.setText("???");
		}
	}
}
