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
	protected DefaultListModel<String> badgeListModel;
	protected JScrollPane badgeScrollPane;
	protected JPanel previewPanel;
	protected ArrayList<Badge> badgeNames;
	protected JLabel badgesPreviewLabel;
	protected JList<String> badgesList;

	/**
	 * Creates a BadgesPanel instance with the specified list of badge names.
	 *
	 * @param badgeNames
	 *            The list of badge names.
	 */
	public BadgesPanel(ArrayList<Badge> badgeNames) {

		// Attributes
		this.badgeNames = badgeNames;

		// Layout of panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Add the list of badge names
		badgeListModel = new DefaultListModel<String>();
		for (Badge e : this.badgeNames) {
			badgeListModel.addElement(e.getName());
		}

		// Badge list scroll pane
		badgeScrollPane = new JScrollPane();
		badgesList = new JList<String>(badgeListModel);
		badgesList.setPreferredSize(new Dimension(100, 100));
		badgesList.setMinimumSize(new Dimension(100, 100));
		badgesList.setMaximumSize(new Dimension(100, 100));
		badgeScrollPane.setViewportView(badgesList);

		// Layout for scroll pane
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		add(badgeScrollPane, gbc_list);

		// Preview panel
		previewPanel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(previewPanel, gbc_panel);

		// Layout for preview panel
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		previewPanel.setLayout(gbl_panel);

		// Badges preview label
		badgesPreviewLabel = new JLabel("BadgePreview", SwingConstants.CENTER);
		badgesPreviewLabel.setBackground(Color.WHITE);
		badgesPreviewLabel.setPreferredSize(new Dimension(66, 14));
		badgesPreviewLabel.setMinimumSize(new Dimension(66, 14));
		badgesPreviewLabel.setMaximumSize(new Dimension(66, 14));
		badgesPreviewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));

		// Layout for preview label
		GridBagConstraints gbc_lblBadgepreview = new GridBagConstraints();
		gbc_lblBadgepreview.gridheight = 3;
		gbc_lblBadgepreview.fill = GridBagConstraints.BOTH;
		gbc_lblBadgepreview.insets = new Insets(0, 0, 5, 5);
		gbc_lblBadgepreview.gridx = 1;
		gbc_lblBadgepreview.gridy = 1;
		previewPanel.add(badgesPreviewLabel, gbc_lblBadgepreview);
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
	 * Returns the badgesList object for this panel.
	 * 
	 * @return the badgesList property.
	 */
	public JList<String> getBadgesList() {
		return badgesList;
	}

	/**
	 * Returns the badgeNamesobject for this panel.
	 *
	 * @return the badgeNames property
	 */
	public ArrayList<Badge> getBadgeNameList() {
		return badgeNames;
	}

	/**
	 * Returns the badgeScrollPane object for this panel.
	 *
	 * @return the badgeScrollPane property
	 */
	public JScrollPane getBadgeScrollPane() {
		return badgeScrollPane;
	}
}
