package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * This controller displays the preview for the selected badge in the badges
 * list menu.
 *
 * @author Marco Duran
 */
public class BadgesListPanelController implements ActionListener {

	protected GameApplication app;

	/**
	 * Creates a BadgesListPanelController instance with the specified
	 * GameApplication.
	 *
	 * @param app
	 *            The GameApplication that is currently running
	 */
	public BadgesListPanelController(GameApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO insert images of badges with descriptions
	}
}
