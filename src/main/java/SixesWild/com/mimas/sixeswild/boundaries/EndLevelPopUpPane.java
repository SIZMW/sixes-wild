package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import SixesWild.com.mimas.sixeswild.controllers.ExitButtonController;

/**
 * This class represents the view used as a pop up message when the level has
 * ended to notify that the game is over.
 *
 * @author Aditya Nivarthi
 */
public class EndLevelPopUpPane extends JOptionPane {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates an EndLevelPopUpPane with the specified GameApplication.
	 *
	 * @param app
	 *            The GameApplication currently running.
	 */
	public EndLevelPopUpPane(GameApplication app, String message) {
		this.setMessage("Game over. " + message);
		this.setMessageType(JOptionPane.INFORMATION_MESSAGE);

		final JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ExitButtonController(app));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.getWindowAncestor(exitButton).dispose();
			}
		});

		this.setOptions(new Object[] { exitButton });
	}
}
