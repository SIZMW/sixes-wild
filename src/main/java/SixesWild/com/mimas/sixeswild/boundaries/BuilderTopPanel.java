package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.sixeswild.XMLParser;

/**
 * This class represents the top panel of the level builder. It contains the
 * level editing options.
 * 
 * @author Yahel Nachum
 */
public class BuilderTopPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	JButton newButton;
	JButton saveButton;

	JButton openButton;
	JComboBox<String> openComboBox;

	JButton deleteButton;
	JComboBox<String> deleteComboBox;

	ArrayList<String> userLevelList;

	/**
	 * Creates a BuilderTopPanel instance.
	 */
	public BuilderTopPanel() {

		// Attributes
		userLevelList = XMLParser.getLevelFileNames(XMLParser.USER_DIR);

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

		for (String e : userLevelList) {
			openComboBox.addItem(e);
		}

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

		for (String e : userLevelList) {
			deleteComboBox.addItem(e);
		}

		// Layout for delete level combo box
		GridBagConstraints gbc_deleteComboBox = new GridBagConstraints();
		gbc_deleteComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_deleteComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_deleteComboBox.gridx = 10;
		gbc_deleteComboBox.gridy = 0;
		add(deleteComboBox, gbc_deleteComboBox);
	}

	/**
	 * Returns the new button.
	 * 
	 * @return JButton for creating a new level
	 */
	public JButton getNewButton() {
		return this.newButton;
	}

	/**
	 * Returns the save button.
	 * 
	 * @return JButton for saving a level
	 */
	public JButton getSaveButton() {
		return this.saveButton;
	}

	/**
	 * Returns the open button.
	 * 
	 * @return JButton for opening a level
	 */
	public JButton getOpenButton() {
		return this.openButton;
	}

	/**
	 * Returns the open combo box.
	 * 
	 * @return JComboBox for open level list
	 */
	public JComboBox<String> getOpenComboBox() {
		return this.openComboBox;
	}

	/**
	 * Returns the delete button.
	 * 
	 * @return JButton for deleting a level
	 */
	public JButton getDeleteButton() {
		return this.deleteButton;
	}

	/**
	 * Returns the delete combo box.
	 * 
	 * @return JComboBox for delete level list
	 */
	public JComboBox<String> getDeleteComboBox() {
		return this.deleteComboBox;
	}
}
