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
import java.util.ArrayList;

import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * @author Joey Perez
 *
 */
public class GameSplashScreenController implements KeyListener {
	GameApplication app;

	/**
	 * Constructor for the OptionsMenuButtonController class.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 */
	public GameSplashScreenController(GameApplication app) {
		this.app = app;
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
			JPanel currPanel = app.getMainPanel().getSubMenuPanel();
			currPanel.removeAll();
			contentContainer.removeAll();

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
			

//			GridBagLayout gridBagLayout = new GridBagLayout();
//			gridBagLayout.columnWidths = new int[] { 0 };
//			gridBagLayout.rowHeights = new int[] { 0 };
//			gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
//			gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
//			currentPanel.setLayout(gridBagLayout);
//
//			GridBagConstraints gbc_list = new GridBagConstraints();
//			gbc_list.insets = new Insets(0, 0, 0, 0);
//			gbc_list.fill = GridBagConstraints.BOTH;
//			gbc_list.gridx = 0;
//			gbc_list.gridy = 0;

			currPanel.add(this.app.getMainPanel().getTitleMenuView(), gbc_list);
			currPanel.updateUI();
			
			currentPanel.add(this.app.getMainPanel(), gbc_list);
			contentContainer.add(currentPanel);
			contentContainer.revalidate();
			contentContainer.repaint();
			
		}
	}
}
