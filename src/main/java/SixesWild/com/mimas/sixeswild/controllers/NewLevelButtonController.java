package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.boundaries.BoardViewPanel;
import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;
import SixesWild.com.mimas.sixeswild.entities.Board;

/**
 * This controller creates a new level to edit in the level builder when the new
 * button is pressed.
 * 
 * @author Cameron Jones
 */
public class NewLevelButtonController implements ActionListener {
	BuilderApplication app;

	/**
	 * Creates a NewLevelButtonController instance with the specified
	 * BuilderApplication.
	 * 
	 * @param app
	 *            The BuilderApplication currently running.
	 */
	public NewLevelButtonController(BuilderApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
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
		this.app.getBuilderView().updateBoardViewPanel(
				new BoardViewPanel(new Board()));
		this.app.getBuilderView().revalidate();
		this.app.getBuilderView().repaint();

		currentPanel.add(this.app.getBuilderView(), gbc_list);
		contentContainer.add(currentPanel);

		contentContainer.revalidate();
		contentContainer.repaint();
	}
}
