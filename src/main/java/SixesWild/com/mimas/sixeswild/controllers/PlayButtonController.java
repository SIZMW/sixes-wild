package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.boundaries.BadgesPanel;
import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.boundaries.LevelView;

/**
 * This class is the controller to handle redrawing the menu window when the
 * story mode sub menu is requested.
 * 
 * @author Aditya Nivarthi
 */
public class PlayButtonController implements ActionListener {
	GameApplication app;

	// TODO Add list of levels as attribute

	/**
	 * Constructor for the StoryMenuButtonController class.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 */
	public PlayButtonController(GameApplication app) {
		this.app = app;
	}

	/**
	 * Processes the request to show the story mode sub menu.
	 */
	public void actionPerformed(ActionEvent e) {
		Container c = app.getFrame().getContentPane();
		JPanel currPanel = new JPanel();
		c.removeAll();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		currPanel.setPreferredSize(new Dimension(800,600));
		currPanel.setLayout(gridBagLayout);
		
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		currPanel.add(new LevelView(), gbc_list);
		
		c.add(currPanel);
		
		c.revalidate();
		c.repaint();
		
		//c.update(g);;
	}
}
