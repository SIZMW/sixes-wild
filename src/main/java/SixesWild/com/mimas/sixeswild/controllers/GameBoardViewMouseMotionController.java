package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.entities.SelectionMove;

/**
 * This controller handles mouse dragging when selecting tiles on the Board in
 * the game.
 * 
 * @author Aditya Nivarthi
 */
public class GameBoardViewMouseMotionController extends MouseAdapter {

	private static final Logger logger = Logger.getGlobal();
	
	protected GameApplication app;

	/**
	 * Creates a GameBoardViewMouseMotionController instance with the specified
	 * GameApplication.
	 * 
	 * @param app
	 *            The currently running GameApplication.
	 */
	public GameBoardViewMouseMotionController(GameApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent me) {
		app.getLevelPanel().getBoardViewPanel()
				.updateGameSelection(me.getX(), me.getY());

		SelectionMove move = new SelectionMove(app.getLevelPanel()
				.getBoardViewPanel().getCurrentSelection(), this.app
				.getLevelPanel().getLevel());
		move.processCurrentMove(this.app);

		app.getLevelPanel().updateLevelStats();
		
		if(this.app.getLevelPanel().getLevel().getMoveCount() <= 0){
			//This is a direct Copy from the Exit Button. We should Find a Better Way
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
			currentPanel.add(this.app.getGameMenuView(), gbc_list);
			contentContainer.add(currentPanel);
			contentContainer.revalidate();
			contentContainer.repaint();

			logger.log(Level.INFO, "Exited level.");
		}
		
		app.getLevelPanel().getBoardViewPanel().updateUI();
	}
}
