package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

import SixesWild.com.mimas.sixeswild.controllers.ExitButtonController;

/**
 * This class represents the view used as a pop up message when the level has
 * ended to notify that the game is over.
 *
 * @author Aditya Nivarthi
 */
public class EndLevelPopUpDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates an EndLevelPopUpDialog with the specified GameApplication and
	 * message.
	 *
	 * @param app
	 *            The GameApplication currently running.
	 * @param message
	 *            The custom text to display.
	 */
	public EndLevelPopUpDialog(GameApplication app, String message) {
		setTitle("Game Over");
		this.setSize(new Dimension(300, 100));

		// Set location to set of game application
		this.setLocation(app.getFrame().getX()
				+ (app.getFrame().getWidth() / 2) - (getWidth() / 2), app
				.getFrame().getY()
				+ (app.getFrame().getHeight() / 2)
				- (getHeight() / 2));

		// Layout for panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWeights = new double[] { Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		// Add message
		JLabel textMessage = new JLabel(message);
		textMessage.setFont(new Font("Monospace", Font.PLAIN, 18));
		this.add(textMessage);
		addWindowListener(new ExitButtonController(app));
	}
}
