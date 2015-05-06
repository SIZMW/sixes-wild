package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import SixesWild.com.mimas.sixeswild.entities.Badge;

/**
 * This class represents the view used to show badges that the player has
 * completed or has not completed in the game menu.
 *
 * @author Yahel Nachum
 */
public class BadgesPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	// Panel attributes
	protected DefaultListModel<Badge> badgeListModel;
	protected JScrollPane badgeScrollPane;
	protected JPanel previewPanel;
	protected JLabel badgesPreviewLabel;
	protected JList<Badge> badgesSelectionList;
	private BadgePreviewPanel badgePreviewPanel;

	/**
	 * Creates a BadgesPanel instance with the specified list of badge names.
	 *
	 * @param badgeList
	 *            The list of badge names.
	 */
	public BadgesPanel(ArrayList<Badge> badgeList) {

		// Layout of badgePreviewPanel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Add the list of badge names
		badgeListModel = new DefaultListModel<Badge>();
		for (Badge e : badgeList) {
			badgeListModel.addElement(e);
		}

		// Badge list scroll pane
		badgeScrollPane = new JScrollPane();
		badgesSelectionList = new JList<Badge>(badgeListModel);
		badgesSelectionList.setPreferredSize(new Dimension(100, 100));
		badgesSelectionList.setMinimumSize(new Dimension(100, 100));
		badgesSelectionList.setMaximumSize(new Dimension(100, 100));
		badgeScrollPane.setViewportView(badgesSelectionList);

		// Layout for scroll pane
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		add(badgeScrollPane, gbc_list);

		// Preview badgePreviewPanel
		previewPanel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(previewPanel, gbc_panel);

		// Layout for preview badgePreviewPanel
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, 1.0, Double.MIN_VALUE };
		previewPanel.setLayout(gbl_panel);

		badgePreviewPanel = new BadgePreviewPanel();
		GridBagConstraints gbc_badgePreviewPanel = new GridBagConstraints();
		gbc_badgePreviewPanel.insets = new Insets(0, 0, 5, 5);
		gbc_badgePreviewPanel.fill = GridBagConstraints.BOTH;
		gbc_badgePreviewPanel.gridx = 1;
		gbc_badgePreviewPanel.gridy = 1;
		badgePreviewPanel.setMaximumSize(new Dimension(350, 300));
		badgePreviewPanel.setPreferredSize(new Dimension(350, 300));
		badgePreviewPanel.setMinimumSize(new Dimension(350, 300));
		badgePreviewPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		previewPanel.add(badgePreviewPanel, gbc_badgePreviewPanel);

		// Badges preview label
		badgesPreviewLabel = new JLabel("", SwingConstants.CENTER);
		badgesPreviewLabel.setBackground(Color.WHITE);
		badgesPreviewLabel.setPreferredSize(new Dimension(32, 14));
		badgesPreviewLabel.setMinimumSize(new Dimension(32, 14));
		badgesPreviewLabel.setMaximumSize(new Dimension(32, 14));
		badgesPreviewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));

		// Layout for preview label
		GridBagConstraints gbc_lblBadgepreview = new GridBagConstraints();
		gbc_lblBadgepreview.fill = GridBagConstraints.BOTH;
		gbc_lblBadgepreview.insets = new Insets(0, 0, 5, 5);
		gbc_lblBadgepreview.gridx = 1;
		gbc_lblBadgepreview.gridy = 5;
		previewPanel.add(badgesPreviewLabel, gbc_lblBadgepreview);
	}

	/**
	 * Returns the badgesPreviewLabel object for this panel.
	 *
	 * @return the badgesPreviewLabel property
	 */
	public JLabel getbBadgesPreviewLabel() {
		return badgesPreviewLabel;
	}

	/**
	 * Returns the previewPanel object for this panel.
	 *
	 * @return the previewPanel property
	 */
	public JPanel getPreviewPanel() {
		return previewPanel;
	}

	/**
	 * Returns the badgesSelectionList object for this panel.
	 *
	 * @return the badgesSelectionList property.
	 */
	public JList<Badge> getBadgeSelectionList() {
		return badgesSelectionList;
	}

	/**
	 * Returns the badgeScrollPane object for this panel.
	 *
	 * @return the badgeScrollPane property
	 */
	public JScrollPane getBadgeScrollPane() {
		return badgeScrollPane;
	}

	/**
	 * Returns the badgePreviewPanel object for this panel.
	 *
	 * @return the badgePreviewPanel property
	 */
	public BadgePreviewPanel getBadgePreviewPanel() {
		return badgePreviewPanel;
	}
}
