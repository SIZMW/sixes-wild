package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;

/**
 * This controller decrements the count of special move three for a level in the
 * level builder.
 * 
 * @author Aditya Nivarthi
 */
public class SpecialMoveThreeDecreaseButtonController implements ActionListener {

	protected BuilderApplication app;

	/**
	 * Creates a SpecialMoveThreeDecreaseButtonController with the specified
	 * BuilderApplication.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 */
	public SpecialMoveThreeDecreaseButtonController(BuilderApplication app) {
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
		if (value <= 0) {
			value = 0;
		} else {
			value--;
		}

		this.app.getBuilderView().getBuilderSettingsPanel()
				.getSpecialMoveThreeLabel().setText(Integer.toString(value));
		this.app.getBuilderView().getBuilderSettingsPanel().updateUI();
	}
}
