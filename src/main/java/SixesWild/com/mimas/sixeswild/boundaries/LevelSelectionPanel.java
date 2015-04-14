package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 * This class represents the inner view for selecting a level and displaying a
 * preview to the player.
 * 
 * @author Cameron Jones
 */
public class LevelSelectionPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	DefaultListModel<String> levelListModel;
	JScrollPane levelScrollPane;
	JPanel previewPanel;
	JButton playLevelButton;
	ArrayList<String> levelNames;

	// TODO Add parameter for level list
	/**
	 * Constructor for LevelSelectionPanel class.
	 * 
	 * @param levelNames The names of levels to populate the list.
	 */
	public LevelSelectionPanel(ArrayList<String> levelNames) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		this.levelNames = levelNames;
		
		levelListModel = new DefaultListModel<String>();
		for (int i = 0; i < levelNames.size(); i++) {
			levelListModel.addElement(levelNames.get(i));
		}

		// Level list scroll pane
		levelScrollPane = new JScrollPane();
		JList<String> list = new JList<String>(levelListModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// TODO Make renderer its own class and use as needed.
		
		list.setCellRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				if (((String)value).contains("0")) {
					super.getListCellRendererComponent(list, value, index, false, false);
				} else {
					super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				}
		        return this;
			}
		});
		
		levelScrollPane.setViewportView(list);

		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		add(levelScrollPane, gbc_list);

		// Preview panel
		JPanel previewPanel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(previewPanel, gbc_panel);

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		previewPanel.setLayout(gbl_panel);

		// Play level button
		playLevelButton = new JButton("Play Level");
		GridBagConstraints gbc_btnPlay = new GridBagConstraints();
		gbc_btnPlay.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnPlay.gridx = 2;
		gbc_btnPlay.gridy = 9;
		previewPanel.add(playLevelButton, gbc_btnPlay);
	}

	/**
	 * Returns the scroll pane of level names.
	 * 
	 * @return this.levelScrollPane The scrolling level pane.
	 */
	public JScrollPane getLevelScrollPane() {
		return this.levelScrollPane;
	}

	/**
	 * Returns the "Play Level" button.
	 * 
	 * @return this.playLevelButton The "Play Level" button.
	 */
	public JButton getPlayButton() {
		return this.playLevelButton;
	}

	/**
	 * Returns the level selection preview panel.
	 * 
	 * @return this.previewPanel The level preview panel.
	 */
	public JPanel getPreviewPanel() {
		return this.previewPanel;
	}
}
