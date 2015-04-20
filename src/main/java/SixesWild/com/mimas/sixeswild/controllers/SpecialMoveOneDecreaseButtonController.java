package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;

/**
 * This class is the controller to handle decreasing the number of special moves
 * for special move on in the builder settings panel.
 * 
 * @author Aditya Nivarthi
 */
public class SpecialMoveOneDecreaseButtonController implements ActionListener {
	BuilderApplication app;

	/**
	 * Constructor for the SpecialMoveOneDecreaseButtonController class.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 */
	public SpecialMoveOneDecreaseButtonController(BuilderApplication app) {
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
		if (value <= 0) {
			value = 0;
		} else {
			value--;
		}

		this.app.getBuilderView().getBuilderSettingsPanel()
				.getSpecialMoveOneLabel().setText(Integer.toString(value));
		this.app.getBuilderView().getBuilderSettingsPanel().updateUI();
	}
}
