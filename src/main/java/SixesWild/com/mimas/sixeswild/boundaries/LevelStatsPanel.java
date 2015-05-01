package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class represents the left menu that is displayed when playing the game.
 * It has the game information about the current level status for the player.
 *
 * @author Marco Duran
 */
public class LevelStatsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected StarGraphicsPanel starGraphicsPanel;

	protected final String POINTS_TEXT = "Points";
	protected JPanel pointsPanel;
	protected JLabel pointsTextLabel;
	protected JLabel pointsLabel;

	protected final String MOVES_SLASH_TIME_TEXT = "Moves/Time";
	protected JPanel movesAndTimerPanel;
	protected JLabel movesAndTimerTextLabel;
	protected JLabel movesAndTimerLabel;

	protected final String NEXT_THRESHOLD_TEXT = "Next Star Level At";
	protected JPanel nextThresholdPanel;
	protected JLabel nextThresholdTextLabel;
	protected JLabel nextThresholdLabel;

	/**
	 * Creates a LevelStatsPanel instance.
	 */
	public LevelStatsPanel() {

		// Layout for panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 3.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 20.0, 1.0, 5.0, 5.0,
				5.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Graphic for points and stars achieved
		starGraphicsPanel = new StarGraphicsPanel();
		starGraphicsPanel
				.setBorder(BorderFactory.createLineBorder(Color.black));

		// Layout for points and stars graphic
		GridBagConstraints gbc_starGraphicsPanel = new GridBagConstraints();
		gbc_starGraphicsPanel.insets = new Insets(0, 0, 5, 5);
		gbc_starGraphicsPanel.fill = GridBagConstraints.BOTH;
		gbc_starGraphicsPanel.gridx = 1;
		gbc_starGraphicsPanel.gridy = 1;
		add(starGraphicsPanel, gbc_starGraphicsPanel);

		// Points panel
		pointsPanel = new JPanel();
		pointsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		// Layout for points panel
		GridBagConstraints gbc_pointsPanel = new GridBagConstraints();
		gbc_pointsPanel.insets = new Insets(0, 0, 5, 5);
		gbc_pointsPanel.fill = GridBagConstraints.BOTH;
		gbc_pointsPanel.gridx = 1;
		gbc_pointsPanel.gridy = 3;
		add(pointsPanel, gbc_pointsPanel);

		GridBagLayout gbl_pointsPanel = new GridBagLayout();
		gbl_pointsPanel.columnWidths = new int[] { 0, 0 };
		gbl_pointsPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_pointsPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pointsPanel.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		pointsPanel.setLayout(gbl_pointsPanel);

		// Next threshold panel
		nextThresholdPanel = new JPanel();
		nextThresholdPanel.setBorder(BorderFactory
				.createLineBorder(Color.black));

		// Layout for next threshold panel
		GridBagConstraints gbc_nextThresholdPanel = new GridBagConstraints();
		gbc_nextThresholdPanel.insets = new Insets(0, 0, 5, 5);
		gbc_nextThresholdPanel.fill = GridBagConstraints.BOTH;
		gbc_nextThresholdPanel.gridx = 1;
		gbc_nextThresholdPanel.gridy = 4;
		add(nextThresholdPanel, gbc_nextThresholdPanel);

		GridBagLayout gbl_nextThresholdPanel = new GridBagLayout();
		gbl_nextThresholdPanel.columnWidths = new int[] { 0, 0 };
		gbl_nextThresholdPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_nextThresholdPanel.columnWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		gbl_nextThresholdPanel.rowWeights = new double[] { 1.0, 1.0,
				Double.MIN_VALUE };
		nextThresholdPanel.setLayout(gbl_nextThresholdPanel);

		// Next threshold text label
		nextThresholdTextLabel = new JLabel(NEXT_THRESHOLD_TEXT);

		// Layout for next threshold text label
		GridBagConstraints gbc_nextThresholdTextLabel = new GridBagConstraints();
		gbc_nextThresholdTextLabel.insets = new Insets(0, 0, 5, 0);
		gbc_nextThresholdTextLabel.gridx = 0;
		gbc_nextThresholdTextLabel.gridy = 0;
		nextThresholdPanel.add(nextThresholdTextLabel,
				gbc_nextThresholdTextLabel);

		// Numerical next threshold label
		nextThresholdLabel = new JLabel(Integer.toString(0));

		// Layout for numerical next threshold label
		GridBagConstraints gbc_nextThresholdLabel = new GridBagConstraints();
		gbc_nextThresholdLabel.gridx = 0;
		gbc_nextThresholdLabel.gridy = 1;
		nextThresholdPanel.add(nextThresholdLabel, gbc_nextThresholdLabel);

		// Points text label
		pointsTextLabel = new JLabel(POINTS_TEXT);

		// Layout for points text label
		GridBagConstraints gbc_pointsTextLabel = new GridBagConstraints();
		gbc_pointsTextLabel.insets = new Insets(0, 0, 5, 0);
		gbc_pointsTextLabel.gridx = 0;
		gbc_pointsTextLabel.gridy = 0;
		pointsPanel.add(pointsTextLabel, gbc_pointsTextLabel);

		// Numerical points label
		pointsLabel = new JLabel(Integer.toString(0));

		// Layout for numerical points label
		GridBagConstraints gbc_pointsLabel = new GridBagConstraints();
		gbc_pointsLabel.gridx = 0;
		gbc_pointsLabel.gridy = 1;
		pointsPanel.add(pointsLabel, gbc_pointsLabel);

		// Moves/time panel
		movesAndTimerPanel = new JPanel();
		movesAndTimerPanel.setBorder(BorderFactory
				.createLineBorder(Color.black));

		// Layout for moves/time panel
		GridBagConstraints gbc_moveSlashTimePanel = new GridBagConstraints();
		gbc_moveSlashTimePanel.insets = new Insets(0, 0, 5, 5);
		gbc_moveSlashTimePanel.fill = GridBagConstraints.BOTH;
		gbc_moveSlashTimePanel.gridx = 1;
		gbc_moveSlashTimePanel.gridy = 5;
		add(movesAndTimerPanel, gbc_moveSlashTimePanel);

		GridBagLayout gbl_moveSlashTimePanel = new GridBagLayout();
		gbl_moveSlashTimePanel.columnWidths = new int[] { 0, 0 };
		gbl_moveSlashTimePanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_moveSlashTimePanel.columnWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		gbl_moveSlashTimePanel.rowWeights = new double[] { 1.0, 1.0,
				Double.MIN_VALUE };
		movesAndTimerPanel.setLayout(gbl_moveSlashTimePanel);

		// Moves/time text label
		movesAndTimerTextLabel = new JLabel(MOVES_SLASH_TIME_TEXT);

		// Layout for moves/times text label
		GridBagConstraints gbc_movesSlashTimeTextLabel = new GridBagConstraints();
		gbc_movesSlashTimeTextLabel.insets = new Insets(0, 0, 5, 0);
		gbc_movesSlashTimeTextLabel.gridx = 0;
		gbc_movesSlashTimeTextLabel.gridy = 0;
		movesAndTimerPanel.add(movesAndTimerTextLabel,
				gbc_movesSlashTimeTextLabel);

		// Numerical moves/time label
		movesAndTimerLabel = new JLabel("XXX");

		// Layout for numerical moves/time label
		GridBagConstraints gbc_movesSlashTimeLabel = new GridBagConstraints();
		gbc_movesSlashTimeLabel.gridx = 0;
		gbc_movesSlashTimeLabel.gridy = 1;
		movesAndTimerPanel.add(movesAndTimerLabel, gbc_movesSlashTimeLabel);
	}

	/**
	 * Creates a LevelStatsPanel instance with the specified move count.
	 *
	 * @param moveCount
	 *            The move count to set in this panel.
	 */
	public LevelStatsPanel(int moveCount) {

		// Layout for panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 3.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 20.0, 1.0, 5.0, 5.0,
				5.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Graphic for points and stars achieved
		starGraphicsPanel = new StarGraphicsPanel();
		starGraphicsPanel
				.setBorder(BorderFactory.createLineBorder(Color.black));

		// Layout for points and stars graphic
		GridBagConstraints gbc_starGraphicsPanel = new GridBagConstraints();
		gbc_starGraphicsPanel.insets = new Insets(0, 0, 5, 5);
		gbc_starGraphicsPanel.fill = GridBagConstraints.BOTH;
		gbc_starGraphicsPanel.gridx = 1;
		gbc_starGraphicsPanel.gridy = 1;
		add(starGraphicsPanel, gbc_starGraphicsPanel);

		// Points panel
		pointsPanel = new JPanel();
		pointsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		// Layout for points panel
		GridBagConstraints gbc_pointsPanel = new GridBagConstraints();
		gbc_pointsPanel.insets = new Insets(0, 0, 5, 5);
		gbc_pointsPanel.fill = GridBagConstraints.BOTH;
		gbc_pointsPanel.gridx = 1;
		gbc_pointsPanel.gridy = 3;
		add(pointsPanel, gbc_pointsPanel);

		GridBagLayout gbl_pointsPanel = new GridBagLayout();
		gbl_pointsPanel.columnWidths = new int[] { 0, 0 };
		gbl_pointsPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_pointsPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pointsPanel.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		pointsPanel.setLayout(gbl_pointsPanel);

		// Next threshold panel
		nextThresholdPanel = new JPanel();
		nextThresholdPanel.setBorder(BorderFactory
				.createLineBorder(Color.black));

		// Layout for next threshold panel
		GridBagConstraints gbc_nextThresholdPanel = new GridBagConstraints();
		gbc_nextThresholdPanel.insets = new Insets(0, 0, 5, 5);
		gbc_nextThresholdPanel.fill = GridBagConstraints.BOTH;
		gbc_nextThresholdPanel.gridx = 1;
		gbc_nextThresholdPanel.gridy = 4;
		add(nextThresholdPanel, gbc_nextThresholdPanel);

		GridBagLayout gbl_nextThresholdPanel = new GridBagLayout();
		gbl_nextThresholdPanel.columnWidths = new int[] { 0, 0 };
		gbl_nextThresholdPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_nextThresholdPanel.columnWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		gbl_nextThresholdPanel.rowWeights = new double[] { 1.0, 1.0,
				Double.MIN_VALUE };
		nextThresholdPanel.setLayout(gbl_nextThresholdPanel);

		// Next threshold text label
		nextThresholdTextLabel = new JLabel(NEXT_THRESHOLD_TEXT);

		// Layout for next threshold text label
		GridBagConstraints gbc_nextThresholdTextLabel = new GridBagConstraints();
		gbc_nextThresholdTextLabel.insets = new Insets(0, 0, 5, 0);
		gbc_nextThresholdTextLabel.gridx = 0;
		gbc_nextThresholdTextLabel.gridy = 0;
		nextThresholdPanel.add(nextThresholdTextLabel,
				gbc_nextThresholdTextLabel);

		// Numerical next threshold label
		nextThresholdLabel = new JLabel(Integer.toString(0));

		// Layout for numerical next threshold label
		GridBagConstraints gbc_nextThresholdLabel = new GridBagConstraints();
		gbc_nextThresholdLabel.gridx = 0;
		gbc_nextThresholdLabel.gridy = 1;
		nextThresholdPanel.add(nextThresholdLabel, gbc_nextThresholdLabel);

		// Points text label
		pointsTextLabel = new JLabel(POINTS_TEXT);

		// Layout for points text label
		GridBagConstraints gbc_pointsTextLabel = new GridBagConstraints();
		gbc_pointsTextLabel.insets = new Insets(0, 0, 5, 0);
		gbc_pointsTextLabel.gridx = 0;
		gbc_pointsTextLabel.gridy = 0;
		pointsPanel.add(pointsTextLabel, gbc_pointsTextLabel);

		// Numerical points label
		pointsLabel = new JLabel(Integer.toString(0));

		// Layout for numerical points label
		GridBagConstraints gbc_pointsLabel = new GridBagConstraints();
		gbc_pointsLabel.gridx = 0;
		gbc_pointsLabel.gridy = 1;
		pointsPanel.add(pointsLabel, gbc_pointsLabel);

		// Moves/time panel
		movesAndTimerPanel = new JPanel();
		movesAndTimerPanel.setBorder(BorderFactory
				.createLineBorder(Color.black));

		// Layout for moves/time panel
		GridBagConstraints gbc_moveSlashTimePanel = new GridBagConstraints();
		gbc_moveSlashTimePanel.insets = new Insets(0, 0, 5, 5);
		gbc_moveSlashTimePanel.fill = GridBagConstraints.BOTH;
		gbc_moveSlashTimePanel.gridx = 1;
		gbc_moveSlashTimePanel.gridy = 5;
		add(movesAndTimerPanel, gbc_moveSlashTimePanel);

		GridBagLayout gbl_moveSlashTimePanel = new GridBagLayout();
		gbl_moveSlashTimePanel.columnWidths = new int[] { 0, 0 };
		gbl_moveSlashTimePanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_moveSlashTimePanel.columnWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		gbl_moveSlashTimePanel.rowWeights = new double[] { 1.0, 1.0,
				Double.MIN_VALUE };
		movesAndTimerPanel.setLayout(gbl_moveSlashTimePanel);

		// Moves/time text label
		movesAndTimerTextLabel = new JLabel(MOVES_SLASH_TIME_TEXT);

		// Layout for moves/times text label
		GridBagConstraints gbc_movesSlashTimeTextLabel = new GridBagConstraints();
		gbc_movesSlashTimeTextLabel.insets = new Insets(0, 0, 5, 0);
		gbc_movesSlashTimeTextLabel.gridx = 0;
		gbc_movesSlashTimeTextLabel.gridy = 0;
		movesAndTimerPanel.add(movesAndTimerTextLabel,
				gbc_movesSlashTimeTextLabel);

		// Numerical moves/time label
		movesAndTimerLabel = new JLabel(moveCount + "");

		// Layout for numerical moves/time label
		GridBagConstraints gbc_movesSlashTimeLabel = new GridBagConstraints();
		gbc_movesSlashTimeLabel.gridx = 0;
		gbc_movesSlashTimeLabel.gridy = 1;
		movesAndTimerPanel.add(movesAndTimerLabel, gbc_movesSlashTimeLabel);
	}

	/**
	 * Returns the starGraphicsPanel object for this panel.
	 *
	 * @return the starGraphicsPanel property
	 */
	public StarGraphicsPanel getStarGraphicsPanel() {
		return starGraphicsPanel;
	}

	/**
	 * Returns the pointsLabel object for this panel.
	 *
	 * @return the pointsLabel property
	 */
	public JLabel getPointsLabel() {
		return pointsLabel;
	}

	/**
	 * Returns the movesAndTimerLabel object for this panel.
	 *
	 * @return the movesAndTimerLabel property
	 */
	public JLabel getMovesAndTimerLabel() {
		return movesAndTimerLabel;
	}

	/**
	 * Returns the nextThresholdLabel object for this panel.
	 *
	 * @return the nextThresholdLabel property
	 */
	public JLabel getNextThresholdLabel() {
		return nextThresholdLabel;
	}
}
