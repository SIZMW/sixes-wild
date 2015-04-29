package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.util.XMLParser;

/**
 * This class represents the top panel of the level builder. It contains the
 * level editing options.
 *
 * @author Yahel Nachum
 */
public class BuilderTopPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected JButton newButton;
	protected JButton saveButton;

	protected JButton openButton;
	protected JComboBox<String> openComboBox;

	protected JButton deleteButton;
	protected JComboBox<String> deleteComboBox;

	protected ArrayList<String> userLevelList;

	/**
	 * Creates a BuilderTopPanel instance.
	 */
	public BuilderTopPanel() {

		// Layout for panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 89, 0, 89, 0, 89, 0, 0, 0,
				0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 23, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 5.0, 1.0, 5.0, 20.0,
				5.0, 20.0, 5.0, 5.0, 1.0, 20.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// New level button
		newButton = new JButton("NEW");

		// Layout for new level button
		GridBagConstraints gbc_newButton = new GridBagConstraints();
		gbc_newButton.insets = new Insets(0, 0, 0, 5);
		gbc_newButton.gridx = 1;
		gbc_newButton.gridy = 0;
		add(newButton, gbc_newButton);

		// Save level button
		saveButton = new JButton("SAVE");

		// Layout for save level button
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.insets = new Insets(0, 0, 0, 5);
		gbc_saveButton.gridx = 3;
		gbc_saveButton.gridy = 0;
		add(saveButton, gbc_saveButton);

		// Open level button
		openButton = new JButton("OPEN");

		// Layout for open level button
		GridBagConstraints gbc_openButton = new GridBagConstraints();
		gbc_openButton.insets = new Insets(0, 0, 0, 5);
		gbc_openButton.gridx = 5;
		gbc_openButton.gridy = 0;
		add(openButton, gbc_openButton);

		// Open level combo box
		openComboBox = new JComboBox<String>();

		// Layout for open level combo box
		GridBagConstraints gbc_openComboBox = new GridBagConstraints();
		gbc_openComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_openComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_openComboBox.gridx = 6;
		gbc_openComboBox.gridy = 0;
		add(openComboBox, gbc_openComboBox);

		// Delete level button
		deleteButton = new JButton("DELETE");

		// Layout for delete level button
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.insets = new Insets(0, 0, 0, 5);
		gbc_deleteButton.gridx = 8;
		gbc_deleteButton.gridy = 0;
		add(deleteButton, gbc_deleteButton);

		// Delete level combo box
		deleteComboBox = new JComboBox<String>();

		// Layout for delete level combo box
		GridBagConstraints gbc_deleteComboBox = new GridBagConstraints();
		gbc_deleteComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_deleteComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_deleteComboBox.gridx = 10;
		gbc_deleteComboBox.gridy = 0;
		add(deleteComboBox, gbc_deleteComboBox);

		this.updateComboBoxes();
	}

	/**
	 * Returns the newButton object for this panel.
	 *
	 * @return the newButton property
	 */
	public JButton getNewButton() {
		return this.newButton;
	}

	/**
	 * Returns the saveButton object for this panel.
	 *
	 * @return the saveButton property
	 */
	public JButton getSaveButton() {
		return this.saveButton;
	}

	/**
	 * Returns the openButton object for this panel.
	 *
	 * @return the openButton property
	 */
	public JButton getOpenButton() {
		return this.openButton;
	}

	/**
	 * Returns the openComboBox object for this panel.
	 *
	 * @return the openComboBox property
	 */
	public JComboBox<String> getOpenComboBox() {
		return this.openComboBox;
	}

	/**
	 * Returns the deleteButton object for this panel.
	 *
	 * @return the deleteButton property
	 */
	public JButton getDeleteButton() {
		return this.deleteButton;
	}

	/**
	 * Returns the deleteComboBox object for this panel.
	 *
	 * @return the deleteComboBox property
	 */
	public JComboBox<String> getDeleteComboBox() {
		return this.deleteComboBox;
	}

	/**
	 * Returns the userLevelList object for this panel.
	 *
	 * @return the userLevelList property
	 */
	public ArrayList<String> getUserLevelList() {
		return this.userLevelList;
	}

	/**
	 * Removes all entries from the combo boxes for updating them with new level
	 * lists.
	 */
	public void clearComboBoxes() {

		// Clear both lists for refresh
		openComboBox.removeAllItems();
		deleteComboBox.removeAllItems();
	}

	/**
	 * Updates the drop down menus with the list of user levels.
	 */
	public void updateComboBoxes() {
		userLevelList = XMLParser.getLevelFileNames(XMLParser.USER_DIR);

		// Add the same file list to both drop down menus for consistency
		for (String e : userLevelList) {
			openComboBox.addItem(e);
			deleteComboBox.addItem(e);
		}
	}
}
