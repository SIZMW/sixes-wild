package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class represents the top panel in the level builder.
 * 
 * @author Yahel Nachum
 */
public class TopMenuPanel extends JPanel {

	final String MOVE_TEXT = "Move ";
	JTextField levelNameTextField;
	JButton specialMoveButton1;
	JButton specialMoveButton2;
	JButton specialMoveButton3;
	JButton specialMoveButton4;
	JButton exitLevelButton;

	/**
	 * Constructor for the TopMenuPanel class.
	 */
	public TopMenuPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 100.0, 1.0, 1.0, 1.0,
				1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 5.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Level name text
		levelNameTextField = new JTextField();
		levelNameTextField.setEditable(false);
		GridBagConstraints gbc_levelNameText = new GridBagConstraints();
		gbc_levelNameText.insets = new Insets(0, 0, 5, 5);
		gbc_levelNameText.fill = GridBagConstraints.HORIZONTAL;
		gbc_levelNameText.gridx = 1;
		gbc_levelNameText.gridy = 1;
		add(levelNameTextField, gbc_levelNameText);

		// Special move button 1
		specialMoveButton1 = new JButton(MOVE_TEXT + 1);
		specialMoveButton1.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_specialMoveButton1 = new GridBagConstraints();
		gbc_specialMoveButton1.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveButton1.gridx = 3;
		gbc_specialMoveButton1.gridy = 1;
		add(specialMoveButton1, gbc_specialMoveButton1);

		// Special move button 2
		specialMoveButton2 = new JButton(MOVE_TEXT + 2);
		specialMoveButton2.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_specialMoveButton2 = new GridBagConstraints();
		gbc_specialMoveButton2.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveButton2.gridx = 5;
		gbc_specialMoveButton2.gridy = 1;
		add(specialMoveButton2, gbc_specialMoveButton2);

		// Special move button 3
		specialMoveButton3 = new JButton(MOVE_TEXT + 3);
		specialMoveButton3.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_specialMoveButton3 = new GridBagConstraints();
		gbc_specialMoveButton3.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveButton3.gridx = 7;
		gbc_specialMoveButton3.gridy = 1;
		add(specialMoveButton3, gbc_specialMoveButton3);

		// Special move button 4
		specialMoveButton4 = new JButton(MOVE_TEXT + 4);
		specialMoveButton4.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_specialMoveButton4 = new GridBagConstraints();
		gbc_specialMoveButton4.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveButton4.gridx = 9;
		gbc_specialMoveButton4.gridy = 1;
		add(specialMoveButton4, gbc_specialMoveButton4);
		
		// Exit level button
		exitLevelButton = new JButton("Exit Level");
		exitLevelButton.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_exitLevelButton = new GridBagConstraints();
		gbc_exitLevelButton.insets = new Insets(0, 0, 5, 5);
		gbc_exitLevelButton.gridx = 11;
		gbc_exitLevelButton.gridy = 1;
		add(exitLevelButton, gbc_exitLevelButton);
	}

	/**
	 * Returns the level name text field.
	 * 
	 * @return this.levelNameTextField The level name text field.
	 */
	public JTextField getLevelNameTextField() {
		return this.levelNameTextField;
	}

	/**
	 * Returns the special move button 1.
	 * 
	 * @return this.specialMoveButton1 The special move button 1.
	 */
	public JButton getSpecialMoveButton1() {
		return this.specialMoveButton1;
	}

	/**
	 * Returns the special move button 2.
	 * 
	 * @return this.specialMoveButton1 The special move button 2.
	 */
	public JButton getSpecialMoveButton2() {
		return this.specialMoveButton2;
	}

	/**
	 * Returns the special move button 3.
	 * 
	 * @return this.specialMoveButton1 The special move button 3.
	 */
	public JButton getSpecialMoveButton3() {
		return this.specialMoveButton3;
	}

	/**
	 * Returns the special move button 4.
	 * 
	 * @return this.specialMoveButton1 The special move button 4.
	 */
	public JButton getSpecialMoveButton4() {
		return this.specialMoveButton4;
	}
	
	/**
	 * Returns the exit level button.
	 * 
	 * @return this.exitLevelButton The exit level button
	 */
	public JButton getExitLevelButton(){
		return this.exitLevelButton;
	}
}
