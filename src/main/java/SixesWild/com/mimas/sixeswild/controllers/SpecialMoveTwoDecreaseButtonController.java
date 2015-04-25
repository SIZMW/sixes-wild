package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;

/**
 * This controller decrements the count of special move two for a level in the
 * level builder.
 * 
 * @author Aditya Nivarthi
 */
public class SpecialMoveTwoDecreaseButtonController implements ActionListener {

	protected BuilderApplication app;

	/**
	 * Creates a SpecialMoveTwoDecreaseButtonController with the specified
	 * BuilderApplication.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 */
	public SpecialMoveTwoDecreaseButtonController(BuilderApplication app) {
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
				.getBuilderSettingsPanel().getSpecialMoveTwoLabel().getText());

		// Modify value
		if (value <= 0) {
			value = 0;
		} else {
			value--;
		}

		this.app.getBuilderView().getBuilderSettingsPanel()
				.getSpecialMoveTwoLabel().setText(Integer.toString(value));
		this.app.getBuilderView().getBuilderSettingsPanel().updateUI();
	}
}
