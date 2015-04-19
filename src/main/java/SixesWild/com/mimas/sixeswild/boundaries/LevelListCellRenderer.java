package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class LevelListCellRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;
	int highestLevel;

	public LevelListCellRenderer(int highestLevelUnlocked) {
		super();
		this.highestLevel = highestLevelUnlocked;
	}

	public Component getListCellRendererComponent(JList<?> list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		int levelNumber = Integer.parseInt(((String) value).substring(
				((String) value).indexOf(" ") + 1,
				((String) value).indexOf(":")));

		if (this.highestLevel <= levelNumber) {
			super.getListCellRendererComponent(list, value, index, false, false);
		} else {
			super.getListCellRendererComponent(list, value, index, isSelected,
					cellHasFocus);
		}
		return this;
	}
}
