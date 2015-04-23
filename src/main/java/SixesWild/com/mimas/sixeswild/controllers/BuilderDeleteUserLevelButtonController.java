package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;
import SixesWild.com.mimas.sixeswild.sixeswild.XMLParser;

/**
 * This controller deletes the selected level in the builder delete level menu.
 * 
 * @author Aditya Nivarthi
 */
public class BuilderDeleteUserLevelButtonController implements ActionListener {

	private static final Logger logger = Logger.getGlobal();
	BuilderApplication app;

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
		String fileName = ((String) this.app.getBuilderView()
				.getBuilderTopPanel().getDeleteComboBox().getSelectedItem())
				.substring(3);
		fileName += ".xml";
		fileName = fileName.substring(fileName.indexOf(" ") + 1);
		logger.log(Level.INFO, fileName);

		// Open the file to delete
		try {
			File level = new File(XMLParser.USER_DIR + "/" + fileName);

			if (level.delete()) {
				logger.log(Level.INFO, "Deleted successfully.");
			} else {
				logger.log(Level.INFO, "Delete failed.");
			}
		} catch (Exception e) {
			logger.log(Level.WARNING, "File not found.");
		}

		// Update the level lists
		this.app.getBuilderView().getBuilderTopPanel().clearComboBoxes();
		this.app.getBuilderView().getBuilderTopPanel().updateComboBoxes();
	}

}
