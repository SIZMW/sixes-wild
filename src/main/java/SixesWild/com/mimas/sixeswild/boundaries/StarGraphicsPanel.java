package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StarGraphicsPanel extends JPanel {

	/**
	 * Make it happy :)
	 */
	private static final long serialVersionUID = 7331708843505367214L;
	
	Panel starGraphic;
	int scoreNumber;
	/**
	 * Create the panel.
	 */
	public StarGraphicsPanel(int scoreNumber) {
		this.scoreNumber = scoreNumber;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		//Score for JLabel
		JLabel lblScore = new JLabel("Score: " + scoreNumber);
		GridBagConstraints gbc_lblScore = new GridBagConstraints();
		gbc_lblScore.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblScore.insets = new Insets(0, 0, 5, 0);
		gbc_lblScore.gridx = 4;
		gbc_lblScore.gridy = 0;
		add(lblScore, gbc_lblScore);
		
		starGraphic = new Panel();//add graphic here
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		add(starGraphic, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		starGraphic.setLayout(gbl_panel);

	}

}
