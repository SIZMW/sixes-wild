package SixesWild.com.mimas.sixeswild.boundaries;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;


public class TopMenuPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TopMenuPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 60.0, 20.0, 5.0, 1.0, 5.0, 1.0, 5.0, 1.0, 5.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 5.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTextArea levelNameText = new JTextArea();
		levelNameText.setEditable(false);
		GridBagConstraints gbc_levelNameText = new GridBagConstraints();
		gbc_levelNameText.insets = new Insets(0, 0, 5, 5);
		gbc_levelNameText.fill = GridBagConstraints.BOTH;
		gbc_levelNameText.gridx = 1;
		gbc_levelNameText.gridy = 1;
		add(levelNameText, gbc_levelNameText);
		
		JButton specialMoveButton1 = new JButton("SpecialMoveButton1");
		specialMoveButton1.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_specialMoveButton1 = new GridBagConstraints();
		gbc_specialMoveButton1.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveButton1.gridx = 3;
		gbc_specialMoveButton1.gridy = 1;
		add(specialMoveButton1, gbc_specialMoveButton1);
		
		JButton specialMoveButton2 = new JButton("SpecialMoveButton2");
		specialMoveButton2.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_specialMoveButton2 = new GridBagConstraints();
		gbc_specialMoveButton2.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveButton2.gridx = 5;
		gbc_specialMoveButton2.gridy = 1;
		add(specialMoveButton2, gbc_specialMoveButton2);
		
		JButton specialMoveButton3 = new JButton("SpecialMoveButton3");
		specialMoveButton3.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_specialMoveButton3 = new GridBagConstraints();
		gbc_specialMoveButton3.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveButton3.gridx = 7;
		gbc_specialMoveButton3.gridy = 1;
		add(specialMoveButton3, gbc_specialMoveButton3);
		
		JButton specialMoveButton4 = new JButton("SpecialMoveButton4");
		specialMoveButton4.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_specialMoveButton4 = new GridBagConstraints();
		gbc_specialMoveButton4.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveButton4.gridx = 9;
		gbc_specialMoveButton4.gridy = 1;
		add(specialMoveButton4, gbc_specialMoveButton4);

	}

}
