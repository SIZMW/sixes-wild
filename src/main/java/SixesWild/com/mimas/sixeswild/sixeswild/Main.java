package SixesWild.com.mimas.sixeswild.sixeswild;

import java.awt.EventQueue;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * This class is used to create and run an instance of the GameApplication for
 * Sixes Wild.
 * 
 * @author Aditya Nivarthi
 */
public class Main {

	/**
	 * Main to launch the game.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameApplication window = new GameApplication();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
