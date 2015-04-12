package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.boundaries.OptionsPanel;

/**
 * This class is the controller to handle redrawing the menu window when the
 * options sub menu is requested.
 * 
 * @author Aditya Nivarthi
 */
public class OptionsMenuButtonController implements ActionListener {
	GameApplication app;

	/**
	 * Constructor for the OptionsMenuButtonController class.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 */
	public OptionsMenuButtonController(GameApplication app) {
		this.app = app;
	}

	/**
	 * Processes the request to show the options sub menu.
	 */
	public void actionPerformed(ActionEvent e) {
		JPanel currPanel = app.getMainPanel().getSubMenuPanel();
		currPanel.removeAll();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		currPanel.setLayout(gridBagLayout);
		
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		
		currPanel.add(new OptionsPanel(), gbc_list);
		currPanel.updateUI();
	}
}
