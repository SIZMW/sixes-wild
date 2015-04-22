package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;
import SixesWild.com.mimas.sixeswild.entities.TileType;

/**
 * This controller handles mouse presses and releases when selecting tiles on
 * the Board in the level builder.
 * 
 * @author Aditya Nivarthi
 */
public class BuilderBoardViewMouseController extends MouseAdapter {

	BuilderApplication app;

	/**
	 * Creates a BuilderBoardViewMouseController instance with the specified
	 * BuilderApplication.
	 * 
	 * @param app
	 *            The currently running BuilderApplication.
	 */
	public BuilderBoardViewMouseController(BuilderApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent me) {
		TileType type = TileType.valueOf((String) app.getBuilderView()
				.getBuilderSettingsPanel().getTileTypeComboBox()
				.getSelectedItem());
		app.getBuilderView().getBoardViewPanel()
				.updateBuilderSelection(me.getX(), me.getY(), type);
		app.getBuilderView().getBoardViewPanel().updateUI();
	}
}
