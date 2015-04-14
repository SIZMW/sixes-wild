package SixesWild.com.mimas.sixeswild.sixeswild;

import java.awt.EventQueue;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;

/**
 * This class is used to create and run an instance of the BuilderApplication for
 * Sixes Wild.
 * 
 * @author Aditya Nivarthi
 */
public class BuilderMain {

	/**
	 * Main to launch the builder.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuilderApplication window = new BuilderApplication();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
