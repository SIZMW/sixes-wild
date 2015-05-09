package SixesWild.com.mimas.sixeswild.boundaries;

import java.io.File;
import java.util.Comparator;

/**
 * This class represents the comparator for comparing the file names to
 * determine numerical order of the levels on disk.
 * 
 * @author Aditya Nivarthi
 */
public class LevelNumericalComparator implements Comparator<File> {

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(File f1, File f2) {
		int n1 = Integer.parseInt(f1.getName().substring(0,
				f1.getName().indexOf(".")));
		int n2 = Integer.parseInt(f2.getName().substring(0,
				f2.getName().indexOf(".")));
		return Integer.compare(n1, n2);
	}
}
