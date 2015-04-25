package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;

/**
 * This controller increments the count of special move three for a level in the
 * level builder.
 * 
 * @author Aditya Nivarthi
 */
public class SpecialMoveThreeIncreaseButtonController implements ActionListener {

	protected BuilderApplication app;

	/**
	 * Creates a SpecialMoveThreeIncreaseButtonController with the specified
	 * BuilderApplication.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 */
	public SpecialMoveThreeIncreaseButtonController(BuilderApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		int value = Integer
				.parseInt(this.app.getBuilderView().getBuilderSettingsPanel()
						.getSpecialMoveThreeLabel().getText());

		// Modify value
		value++;

		this.app.getBuilderView().getBuilderSettingsPanel()
				.getSpecialMoveThreeLabel().setText(Integer.toString(value));
		this.app.getBuilderView().getBuilderSettingsPanel().updateUI();
	}
}
