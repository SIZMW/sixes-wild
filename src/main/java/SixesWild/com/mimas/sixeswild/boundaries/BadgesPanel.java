package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class BadgesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	DefaultListModel<String> badgeListModel;
	JScrollPane badgeScrollPane;
	JPanel previewPanel;
	ArrayList<String> badgeNames;
	int highestBadge;
	
	/**
	 * Create the panel.
	 */
	public BadgesPanel(ArrayList<String> badgeNames,int highestBadge) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		this.badgeNames = badgeNames;
		this.highestBadge = highestBadge;
		// TODO Remove when we populate level list
		badgeListModel = new DefaultListModel<String>();
		for (int i = 0; i < badgeNames.size(); i++) {
			badgeListModel.addElement(badgeNames.get(i));
			//badgeListModel.s
		}
		for (int i = 0; i < highestBadge; i++){
			//badgeListModel.
		}
		
		// Badge list scroll pane
		badgeScrollPane = new JScrollPane();
		JList<String> list = new JList<String>(badgeListModel);
		badgeScrollPane.setViewportView(list);

		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		add(badgeScrollPane, gbc_list);

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
		
		JLabel lblBadgepreview = new JLabel("BadgePreview");
		GridBagConstraints gbc_lblBadgepreview = new GridBagConstraints();
		gbc_lblBadgepreview.insets = new Insets(0, 0, 5, 0);
		gbc_lblBadgepreview.gridx = 2;
		gbc_lblBadgepreview.gridy = 0;
		previewPanel.add(lblBadgepreview, gbc_lblBadgepreview);

	}
	/**
	 * Returns the scroll pane of level names.
	 * 
	 * @return this.levelScrollPane The scrolling level pane.
	 */
	public JScrollPane getLevelScrollPane() {
		return this.badgeScrollPane;
	}

	/**
	 * Returns the level selection preview panel.
	 * 
	 * @return this.previewPanel The level preview panel.
	 */
	public JPanel getPreviewPanel() {
		return this.previewPanel;
	}
	/**
	 * Returns the badge list
	 * @return this.badgeListModel The list of badges 
	 */
	public DefaultListModel<String> getBadgeListModel() {
		return this.badgeListModel;
	}
	/**
	 * Returns the badge scroll pane
	 * @return this.badgeScrollPane The scrolling panel with the list of badges
	 */
	public JScrollPane getBadgeScrollPane() {
		return this.badgeScrollPane;
	}
	
}
