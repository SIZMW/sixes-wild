package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ExitButtonController implements ActionListener {
	GameApplication app;

	// TODO Add list of levels as attribute

	/**
	 * Constructor for the StoryMenuButtonController class.
	 * 
	 * @param app
	 *            The GameApplication currently running.
	 */
	public ExitButtonController(GameApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		Container contentContainer = app.getFrame().getContentPane();
		JPanel currentPanel = new JPanel();
		contentContainer.removeAll();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		currentPanel.setPreferredSize(new Dimension(800, 600));
		currentPanel.setLayout(gridBagLayout);

		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		
		currentPanel.add(this.app.getMainPanel(), gbc_list);
		contentContainer.add(currentPanel);
		contentContainer.revalidate();
		contentContainer.repaint();
	}
}