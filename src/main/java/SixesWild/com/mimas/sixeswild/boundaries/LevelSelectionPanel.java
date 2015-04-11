package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author Cameron Jones
 * @brief This class represents the inner view for selecting a level and
 *        displaying a preview to the player.
 */
public class LevelSelectionPanel extends JPanel {

	DefaultListModel<String> levelListModel;
	JScrollPane levelScrollPane;
	JPanel previewPanel;
	JButton playLevelButton;

	// TODO Add parameter for level list
	/**
	 * @brief Constructor for LevelSelectionPanel class.
	 */
	public LevelSelectionPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// TODO Remove when we populate level list
		levelListModel = new DefaultListModel<String>();
		for (int i = 0; i < 20; i++) {
			levelListModel.addElement("Level " + i);
		}

		// Level list scroll pane
		levelScrollPane = new JScrollPane();
		JList<String> list = new JList<String>(levelListModel);
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
	 * @brief Returns the scroll pane of level names.
	 * @return this.levelScrollPane The scrolling level pane.
	 */
	public JScrollPane getLevelScrollPane() {
		return this.levelScrollPane;
	}

	/**
	 * @brief Returns the "Play Level" button.
	 * @return this.playLevelButton The "Play Level" button.
	 */
	public JButton getPlayButton() {
		return this.playLevelButton;
	}

	/**
	 * @brief Returns the level selection preview panel.
	 * @return this.previewPanel The level preview panel.
	 */
	public JPanel getPreviewPanel() {
		return this.previewPanel;
	}
}
