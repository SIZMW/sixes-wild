package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
			final JOptionPane optionPane = new JOptionPane();
		    optionPane.setMessage("Out of Moves");
		    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		    final JButton okButton = new JButton("OK");
			okButton.addActionListener(new ExitButtonController(this.app));
			ActionListener actionListener = new ActionListener() {
			      public void actionPerformed(ActionEvent actionEvent) {
			        // Return current text label, instead of argument to method
			    	  SwingUtilities.getWindowAncestor(okButton).dispose();
			      }
			    };
			    okButton.addActionListener(actionListener);
		    optionPane.setOptions(new Object[] { okButton });
		    JDialog dialog = optionPane.createDialog(this.app.getFrame(), "");
		    dialog.setVisible(true);
		}
		else{
			app.getLevelPanel().getBoardViewPanel().updateUI();
		}
		
	}
}
