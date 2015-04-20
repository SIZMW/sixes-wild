package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class represents the score panel used to display score and star
 * thresholds for the player in the game.
 * 
 * @author Marco Duran
 */
public class StarGraphicsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	JPanel starGraphicPanel;
	JLabel scoreLabel;
	int scoreNumber;

	/**
	 * Constructor for StarGraphicsPanel class.
	 */
	public StarGraphicsPanel(int scoreNumber) {

		// Attributes
		this.scoreNumber = scoreNumber;

		// Layout of panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Score label
		scoreLabel = new JLabel("Score: " + scoreNumber);

		// Layout for score label
		GridBagConstraints gbc_scoreLabel = new GridBagConstraints();
		gbc_scoreLabel.anchor = GridBagConstraints.SOUTHEAST;
		gbc_scoreLabel.insets = new Insets(0, 0, 5, 0);
		gbc_scoreLabel.gridx = 4;
		gbc_scoreLabel.gridy = 0;
		add(scoreLabel, gbc_scoreLabel);

		// TODO Add graphic image
		// Star graphic
		starGraphicPanel = new JPanel();

		// Layout for star graphic
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		add(starGraphicPanel, gbc_panel);

		GridBagLayout gbc_starGraphicPanel = new GridBagLayout();
		gbc_starGraphicPanel.columnWidths = new int[] { 0 };
		gbc_starGraphicPanel.rowHeights = new int[] { 0 };
		gbc_starGraphicPanel.columnWeights = new double[] { Double.MIN_VALUE };
		gbc_starGraphicPanel.rowWeights = new double[] { Double.MIN_VALUE };
		starGraphicPanel.setLayout(gbc_starGraphicPanel);
	}
}
