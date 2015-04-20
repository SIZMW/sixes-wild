/**
 * 
 */
package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;

/**
 * This class represents the splash screen controller for the builder view when
 * it first opens.
 * 
 * @author Joey Perez
 */
public class BuilderSplashScreenController implements KeyListener {
	BuilderApplication app;

	/**
	 * Constructor for the BuilderSplashScreenController class.
	 * 
	 * @param builderApplication
	 *            The GameApplication currently running.
	 */
	public BuilderSplashScreenController(BuilderApplication builderApplication) {
		this.app = builderApplication;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent arg0) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(KeyEvent arg0) {

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
