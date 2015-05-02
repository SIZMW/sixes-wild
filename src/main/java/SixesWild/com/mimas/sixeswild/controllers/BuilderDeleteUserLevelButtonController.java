package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;
import SixesWild.com.mimas.sixeswild.entities.GameLevel;
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

			// Get all level files to rename
			ArrayList<String> fileNamesToUpdate = new ArrayList<String>();
			ArrayList<GameLevel> levelsToUpdate = new ArrayList<GameLevel>();

			// Add the level files that need the number to be updated and modify
			// the level object number
			for (int i = app.getBuilderView().getBuilderTopPanel()
					.getDeleteComboBox().getSelectedIndex() + 1, j = 0; i < app
					.getBuilderView().getBuilderTopPanel().getDeleteComboBox()
					.getItemCount(); i++, j++) {
				fileNamesToUpdate.add(i + 1 + ".xml");
				levelsToUpdate.add(XMLParser.fileToLevel(XMLParser.USER_DIR
						+ fileNamesToUpdate.get(j)));
				levelsToUpdate.get(j).setLevelNumber(
						levelsToUpdate.get(j).getLevelNumber() - 1);
			}

			logger.log(Level.INFO, "Deleting: " + fileName + ". There are: "
					+ fileNamesToUpdate.size() + " level files to update.");

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

			// Rename the rest of the level files
			for (int i = 0; i < levelsToUpdate.size(); i++) {

				// Open the file to delete
				try {
					File level = new File(XMLParser.USER_DIR
							+ fileNamesToUpdate.get(i));

					if (level.delete()) {
						logger.log(Level.INFO, "Deleted successfully.");
					} else {
						logger.log(Level.WARNING, "Delete failed.");
					}
				} catch (Exception e) {
					logger.log(Level.WARNING, "File not found.");
				}

				XMLParser.levelToFile(levelsToUpdate.get(i));
			}
		}

		// Update the level lists
		app.getBuilderView().getBuilderTopPanel().clearComboBoxes();
		app.getBuilderView().getBuilderTopPanel().updateComboBoxes();
	}
}
