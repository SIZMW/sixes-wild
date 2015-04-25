package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class represents the top panel in the level for the game.
 * 
 * @author Yahel Nachum
 */
public class LevelTopPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final String RESET = "Reset";
	public static final String SWAP = "Swap";
	public static final String REMOVE = "Remove";
	public static final String XSTACY = "XStacy";

	protected JTextField levelNameTextField;
	protected JButton resetBoardButton;
	protected JButton swapTileButton;
	protected JButton removeTileButton;
	protected JButton xStacyMoveButton;
	protected JButton exitLevelButton;

	/**
	 * Creates a LevelTopPanel instance.
	 */
	public LevelTopPanel() {

		// Layout for panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 100.0, 1.0, 1.0, 1.0,
				1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 5.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Level name text field
		levelNameTextField = new JTextField();
		levelNameTextField.setEditable(false);

		// Layout for level name text field
		GridBagConstraints gbc_levelNameText = new GridBagConstraints();
		gbc_levelNameText.insets = new Insets(0, 0, 5, 5);
		gbc_levelNameText.fill = GridBagConstraints.HORIZONTAL;
		gbc_levelNameText.gridx = 1;
		gbc_levelNameText.gridy = 1;
		add(levelNameTextField, gbc_levelNameText);

		// Special move button 1
		resetBoardButton = new JButton(RESET);
		resetBoardButton.setPreferredSize(new Dimension(100, 100));

		// Layout for special move button 1
		GridBagConstraints gbc_specialMoveButton1 = new GridBagConstraints();
		gbc_specialMoveButton1.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveButton1.gridx = 3;
		gbc_specialMoveButton1.gridy = 1;
		add(resetBoardButton, gbc_specialMoveButton1);

		// Special move button 2
		swapTileButton = new JButton(SWAP);
		swapTileButton.setPreferredSize(new Dimension(100, 100));

		// Layout for special move button 2
		GridBagConstraints gbc_specialMoveButton2 = new GridBagConstraints();
		gbc_specialMoveButton2.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveButton2.gridx = 5;
		gbc_specialMoveButton2.gridy = 1;
		add(swapTileButton, gbc_specialMoveButton2);

		// Special move button 3
		removeTileButton = new JButton(REMOVE);
		removeTileButton.setPreferredSize(new Dimension(100, 100));

		// Layout for special move button 3
		GridBagConstraints gbc_specialMoveButton3 = new GridBagConstraints();
		gbc_specialMoveButton3.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveButton3.gridx = 7;
		gbc_specialMoveButton3.gridy = 1;
		add(removeTileButton, gbc_specialMoveButton3);

		// Special move button 4
		xStacyMoveButton = new JButton(XSTACY);
		xStacyMoveButton.setPreferredSize(new Dimension(100, 100));

		// Layout for special move button 4
		GridBagConstraints gbc_specialMoveButton4 = new GridBagConstraints();
		gbc_specialMoveButton4.insets = new Insets(0, 0, 5, 5);
		gbc_specialMoveButton4.gridx = 9;
		gbc_specialMoveButton4.gridy = 1;
		add(xStacyMoveButton, gbc_specialMoveButton4);

		// Exit level button
		exitLevelButton = new JButton("Exit Level");
		exitLevelButton.setPreferredSize(new Dimension(100, 100));

		// Layout for exit level button
		GridBagConstraints gbc_exitLevelButton = new GridBagConstraints();
		gbc_exitLevelButton.insets = new Insets(0, 0, 5, 5);
		gbc_exitLevelButton.gridx = 11;
		gbc_exitLevelButton.gridy = 1;
		add(exitLevelButton, gbc_exitLevelButton);
	}

	/**
	 * Returns the levelNameTextField object for this panel.
	 * 
	 * @return the levelNameTextField property
	 */
	public JTextField getLevelNameTextField() {
		return this.levelNameTextField;
	}

	/**
	 * Sets the name of the level.
	 * 
	 * @param levelName
	 *            The level name to set.
	 * @return true if successful
	 */
	public boolean setLevelNameTextField(String levelName) {
		this.levelNameTextField.setText(levelName);
		return true;
	}

	/**
	 * Returns the resetBoardButton object for this panel.
	 * 
	 * @return the resetBoardButton property
	 */
	public JButton getResetBoardButton() {
		return this.resetBoardButton;
	}

	/**
	 * Returns the swapTileButton object for this panel.
	 * 
	 * @return the swapTileButton property
	 */
	public JButton getSwapTileButton() {
		return this.swapTileButton;
	}

	/**
	 * Returns the removeTileButton object for this panel.
	 * 
	 * @return the removeTileButton property
	 */
	public JButton getRemoveTileButton() {
		return this.removeTileButton;
	}

	/**
	 * Returns the xStacyMoveButton object for this panel.
	 * 
	 * @return the xStacyMoveButton property
	 */
	public JButton getXStacyMoveButton() {
		return this.xStacyMoveButton;
	}

	/**
	 * Returns the exitLevelButton object for this panel.
	 * 
	 * @return the exitLevelButton property
	 */
	public JButton getExitLevelButton() {
		return this.exitLevelButton;
	}
}
