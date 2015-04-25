/**
 * 
 */
package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;

/**
 * This controller displays the splash screen prior to displaying the level
 * builder when the application is started.
 * 
 * @author Joey Perez
 */
public class BuilderSplashScreenController extends KeyAdapter {

	protected BuilderApplication app;

	/**
	 * Creates a GameSplashScreenController with the specified
	 * BuilderApplication.
	 * 
	 * @param app
	 *            The BuilderApplication currently running.
	 */
	public BuilderSplashScreenController(BuilderApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @Override Acts when the "Enter" key is pressed and continues past the
	 * splash screen.
	 */
	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();

		// Enter key
		if (key == 10) {
			Container contentContainer = app.getFrame().getContentPane();
			JPanel currentPanel = new JPanel();
			contentContainer.removeAll();

			// Layout for panel
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[] { 0 };
			gridBagLayout.rowHeights = new int[] { 0 };
			gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
			gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
			currentPanel.setPreferredSize(new Dimension(800, 600));
			currentPanel.setLayout(gridBagLayout);

			GridBagConstraints gbc_list = new GridBagConstraints();
			gbc_list.insets = new Insets(0, 0, 0, 0);
			gbc_list.fill = GridBagConstraints.BOTH;
			gbc_list.gridx = 0;
			gbc_list.gridy = 0;

			// Add panel to view
			currentPanel.add(this.app.getBuilderView(), gbc_list);
			contentContainer.add(currentPanel);
			contentContainer.revalidate();
			contentContainer.repaint();
		}
	}
}
