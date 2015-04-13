package SixesWild.com.mimas.sixeswild.boundaries;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;


public class BuilderTopPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public BuilderTopPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 89, 0, 89, 0, 89, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{23, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 5.0, 1.0, 5.0, 20.0, 5.0, 20.0, 5.0, 5.0, 1.0, 20.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton newButton = new JButton("NEW");
		GridBagConstraints gbc_newButton = new GridBagConstraints();
		gbc_newButton.insets = new Insets(0, 0, 0, 5);
		gbc_newButton.gridx = 1;
		gbc_newButton.gridy = 0;
		add(newButton, gbc_newButton);
		
		JButton saveButton = new JButton("SAVE");
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.insets = new Insets(0, 0, 0, 5);
		gbc_saveButton.gridx = 3;
		gbc_saveButton.gridy = 0;
		add(saveButton, gbc_saveButton);
		
		JButton openButton = new JButton("OPEN");
		GridBagConstraints gbc_openButton = new GridBagConstraints();
		gbc_openButton.insets = new Insets(0, 0, 0, 5);
		gbc_openButton.gridx = 5;
		gbc_openButton.gridy = 0;
		add(openButton, gbc_openButton);
		
		JComboBox openComboBox = new JComboBox();
		GridBagConstraints gbc_openComboBox = new GridBagConstraints();
		gbc_openComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_openComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_openComboBox.gridx = 6;
		gbc_openComboBox.gridy = 0;
		add(openComboBox, gbc_openComboBox);
		
		JButton deleteButton = new JButton("DELETE");
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.insets = new Insets(0, 0, 0, 5);
		gbc_deleteButton.gridx = 8;
		gbc_deleteButton.gridy = 0;
		add(deleteButton, gbc_deleteButton);
		
		JComboBox deleteComboBox = new JComboBox();
		GridBagConstraints gbc_deleteComboBox = new GridBagConstraints();
		gbc_deleteComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_deleteComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_deleteComboBox.gridx = 10;
		gbc_deleteComboBox.gridy = 0;
		add(deleteComboBox, gbc_deleteComboBox);

	}
}
