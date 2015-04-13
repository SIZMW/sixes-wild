package SixesWild.com.mimas.sixeswild.boundaries;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;


public class BuilderTopPanel extends JPanel {

	JButton newButton;
	JButton saveButton;
	
	JButton openButton;
	JComboBox<String> openComboBox;
	
	JButton deleteButton;
	JComboBox<String> deleteComboBox;
	
	/**
	 * Constructor for BuilderTopPanel class.
	 */
	public BuilderTopPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 89, 0, 89, 0, 89, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{23, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 5.0, 1.0, 5.0, 20.0, 5.0, 20.0, 5.0, 5.0, 1.0, 20.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		// button for creating a new level
		newButton = new JButton("NEW");
		GridBagConstraints gbc_newButton = new GridBagConstraints();
		gbc_newButton.insets = new Insets(0, 0, 0, 5);
		gbc_newButton.gridx = 1;
		gbc_newButton.gridy = 0;
		add(newButton, gbc_newButton);
		
		// button for saving a level
		saveButton = new JButton("SAVE");
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.insets = new Insets(0, 0, 0, 5);
		gbc_saveButton.gridx = 3;
		gbc_saveButton.gridy = 0;
		add(saveButton, gbc_saveButton);
		
		// button for opening a level
		openButton = new JButton("OPEN");
		GridBagConstraints gbc_openButton = new GridBagConstraints();
		gbc_openButton.insets = new Insets(0, 0, 0, 5);
		gbc_openButton.gridx = 5;
		gbc_openButton.gridy = 0;
		add(openButton, gbc_openButton);
		
		// comboBox for opening a level
		openComboBox = new JComboBox<String>();
		GridBagConstraints gbc_openComboBox = new GridBagConstraints();
		gbc_openComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_openComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_openComboBox.gridx = 6;
		gbc_openComboBox.gridy = 0;
		add(openComboBox, gbc_openComboBox);
		
		// button for deleting a level
		deleteButton = new JButton("DELETE");
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.insets = new Insets(0, 0, 0, 5);
		gbc_deleteButton.gridx = 8;
		gbc_deleteButton.gridy = 0;
		add(deleteButton, gbc_deleteButton);
		
		// comboBox for deleting a level
		deleteComboBox = new JComboBox<String>();
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
	 * @return this.newButton The new button.
	 */
	public JButton getNewButton(){
		return this.newButton;
	}
	
	/**
	 * Returns the save button.
	 * 
	 * @return this.saveButton The save button.
	 */
	public JButton getSaveButton(){
		return this.saveButton;
	}
	
	/**
	 * Returns the open button.
	 * 
	 * @return this.openButton The open button.
	 */
	public JButton getOpenButton(){
		return this.openButton;
	}
	
	/**
	 * Returns the open combo box.
	 * 
	 * @return this.openComboBox The open combo box.
	 */
	public JComboBox<String> getOpenComboBox(){
		return this.openComboBox;
	}
	
	/**
	 * Returns the delete button.
	 * 
	 * @return this.deleteButton The delete button.
	 */
	public JButton getDeleteButton(){
		return this.deleteButton;
	}
	
	/**
	 * Returns the delete combo box.
	 * 
	 * @return this.deleteComboBox The delete combo box.
	 */
	public JComboBox<String> getDeleteComboBox(){
		return this.deleteComboBox;
	}
}
