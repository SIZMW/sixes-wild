package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;
import SixesWild.com.mimas.sixeswild.util.XMLParser;

/**
 * This controller deletes the selected level in the builder delete level menu.
 *
 * @author Aditya Nivarthi
 */
public class BuilderDeleteUserLevelButtonController implements ActionListener {

	private static final Logger logger = Logger.getGlobal();

	protected BuilderApplication app;

	/**
	 * Creates a BuilderDeleteUserLevelButtonController instance with the
	 * specified BuilderApplication.
	 *
	 * @param app
	 *            The BuilderApplication currently running.
	 */
	public BuilderDeleteUserLevelButtonController(BuilderApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {

		// Check if there are even files left to delete
		if (app.getBuilderView().getBuilderTopPanel().getDeleteComboBox()
				.getItemCount() > 0) {
			String fileName = app.getBuilderView().getBuilderTopPanel()
					.getDeleteComboBox().getSelectedIndex()
					+ 1 + ".xml";

			// Open the file to delete
			try {
				File level = new File(XMLParser.USER_DIR + fileName);

				if (level.delete()) {
					logger.log(Level.INFO, "Deleted successfully.");
				} else {
					logger.log(Level.WARNING, "Delete failed.");
				}
			} catch (Exception e) {
				logger.log(Level.WARNING, "File not found.");
			}
		}

		// Update the level lists
		app.getBuilderView().getBuilderTopPanel().clearComboBoxes();
		app.getBuilderView().getBuilderTopPanel().updateComboBoxes();
	}
}
