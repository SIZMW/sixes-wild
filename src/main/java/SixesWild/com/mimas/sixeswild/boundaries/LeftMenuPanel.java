package SixesWild.com.mimas.sixeswild.boundaries;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LeftMenuPanel extends JPanel {

	JPanel starGraphicsPanel;
	
	final String POINTS_TEXT = "Points";
	JPanel pointsPanel;
	JLabel pointsTextLabel;
	JLabel pointsLabel;
	
	final String MOVES_SLASH_TIME_TEXT = "Moves/Time";
	JPanel moveSlashTimePanel;
	JLabel movesSlashTimeTextLabel;
	JLabel movesSlashTimeLabel;
	
	/**
	 * Constructor for LeftMenuPanel class
	 */
	public LeftMenuPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 20.0, 1.0, 5.0, 1.0, 5.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		// Graphics for points and stars achieved
		starGraphicsPanel = new JPanel();
		starGraphicsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_starGraphicsPanel = new GridBagConstraints();
		gbc_starGraphicsPanel.insets = new Insets(0, 0, 5, 5);
		gbc_starGraphicsPanel.fill = GridBagConstraints.BOTH;
		gbc_starGraphicsPanel.gridx = 1;
		gbc_starGraphicsPanel.gridy = 1;
		add(starGraphicsPanel, gbc_starGraphicsPanel);
		
		// Panel for points
		pointsPanel = new JPanel();
		pointsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_pointsPanel = new GridBagConstraints();
		gbc_pointsPanel.insets = new Insets(0, 0, 5, 5);
		gbc_pointsPanel.fill = GridBagConstraints.BOTH;
		gbc_pointsPanel.gridx = 1;
		gbc_pointsPanel.gridy = 3;
		add(pointsPanel, gbc_pointsPanel);
		GridBagLayout gbl_pointsPanel = new GridBagLayout();
		gbl_pointsPanel.columnWidths = new int[]{0, 0};
		gbl_pointsPanel.rowHeights = new int[]{0, 0, 0};
		gbl_pointsPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pointsPanel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		pointsPanel.setLayout(gbl_pointsPanel);
		
		// Label for points text
		pointsTextLabel = new JLabel(POINTS_TEXT);
		GridBagConstraints gbc_pointsTextLabel = new GridBagConstraints();
		gbc_pointsTextLabel.insets = new Insets(0, 0, 5, 0);
		gbc_pointsTextLabel.gridx = 0;
		gbc_pointsTextLabel.gridy = 0;
		pointsPanel.add(pointsTextLabel, gbc_pointsTextLabel);
		
		// Label to display numerical points
		pointsLabel = new JLabel("XXX");
		GridBagConstraints gbc_pointsLabel = new GridBagConstraints();
		gbc_pointsLabel.gridx = 0;
		gbc_pointsLabel.gridy = 1;
		pointsPanel.add(pointsLabel, gbc_pointsLabel);
		
		// Panel for moves/time
		moveSlashTimePanel = new JPanel();
		moveSlashTimePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_moveSlashTimePanel = new GridBagConstraints();
		gbc_moveSlashTimePanel.insets = new Insets(0, 0, 5, 5);
		gbc_moveSlashTimePanel.fill = GridBagConstraints.BOTH;
		gbc_moveSlashTimePanel.gridx = 1;
		gbc_moveSlashTimePanel.gridy = 5;
		add(moveSlashTimePanel, gbc_moveSlashTimePanel);
		GridBagLayout gbl_moveSlashTimePanel = new GridBagLayout();
		gbl_moveSlashTimePanel.columnWidths = new int[]{0, 0};
		gbl_moveSlashTimePanel.rowHeights = new int[]{0, 0, 0};
		gbl_moveSlashTimePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_moveSlashTimePanel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		moveSlashTimePanel.setLayout(gbl_moveSlashTimePanel);
		
		// Label for moves/time text
		movesSlashTimeTextLabel = new JLabel(MOVES_SLASH_TIME_TEXT);
		GridBagConstraints gbc_movesSlashTimeTextLabel = new GridBagConstraints();
		gbc_movesSlashTimeTextLabel.insets = new Insets(0, 0, 5, 0);
		gbc_movesSlashTimeTextLabel.gridx = 0;
		gbc_movesSlashTimeTextLabel.gridy = 0;
		moveSlashTimePanel.add(movesSlashTimeTextLabel, gbc_movesSlashTimeTextLabel);
		
		// Label to display numerical moves/time
		movesSlashTimeLabel = new JLabel("XXX");
		GridBagConstraints gbc_movesSlashTimeLabel = new GridBagConstraints();
		gbc_movesSlashTimeLabel.gridx = 0;
		gbc_movesSlashTimeLabel.gridy = 1;
		moveSlashTimePanel.add(movesSlashTimeLabel, gbc_movesSlashTimeLabel);

	}
	
	/**
	 * Returns the star graphics panel.
	 * 
	 * @return this.starGraphicsPanel The star graphics panel.
	 */
	public JPanel getStarGraphicsPanel(){
		return this.starGraphicsPanel;
	}
	
	/**
	 * Returns the points label.
	 *
	 * @return this.pointsLabel The points label.
	 */
	public JLabel getPointsLabel(){
		return this.pointsLabel;
	}
	
	//TODO figure out specifics later
	/**
	 * Returns the moves/time label
	 * @return this.movesSlashTimeLabel The moves/time label.
	 */
	public JLabel getMovesSlashTimeLabel(){
		return this.movesSlashTimeLabel;
	}

}
