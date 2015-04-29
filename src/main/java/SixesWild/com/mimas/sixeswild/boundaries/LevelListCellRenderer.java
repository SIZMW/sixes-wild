package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 * This class represents the cell renderer for the story and user level list
 * views in the game menu view.
 *
 * @author Aditya Nivarthi
 */
public class LevelListCellRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;
	protected int highestLevel;

	/**
	 * Creates a LevelListCellRenderer instance with the specified highest level
	 * unlocked.
	 *
	 * @param highestLevelUnlocked
	 *            The highest level unlocked.
	 */
	public LevelListCellRenderer(int highestLevelUnlocked) {
		super();
		highestLevel = highestLevelUnlocked;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.swing.DefaultListCellRenderer#getListCellRendererComponent(javax
	 * .swing.JList, java.lang.Object, int, boolean, boolean)
	 */
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {

		// Unlock levels up to and including the highest unlocked level
		if (highestLevel <= index) {
			super.getListCellRendererComponent(list, value, index, false, false);
		} else {
			super.getListCellRendererComponent(list, value, index, isSelected,
					cellHasFocus);
		}
		return this;
	}
}
