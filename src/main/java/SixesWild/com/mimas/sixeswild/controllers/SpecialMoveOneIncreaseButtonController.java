package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;

/**
 * This controller increments the count of special move one for a level in the
 * level builder.
 * 
 * @author Aditya Nivarthi
 */
public class SpecialMoveOneIncreaseButtonController implements ActionListener {
	BuilderApplication app;

	/**
	 * Creates a SpecialMoveOneIncreaseButtonController with the specified
	 * BuilderApplication.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 */
	public SpecialMoveOneIncreaseButtonController(BuilderApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		int value = Integer.parseInt(this.app.getBuilderView()
				.getBuilderSettingsPanel().getSpecialMoveOneLabel().getText());

		// Modify value
		value++;

		this.app.getBuilderView().getBuilderSettingsPanel()
				.getSpecialMoveOneLabel().setText(Integer.toString(value));
		this.app.getBuilderView().getBuilderSettingsPanel().updateUI();
	}
}
