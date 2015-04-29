package SixesWild.com.mimas.sixeswild.sixeswild;

import junit.framework.TestCase;
import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * This test case handles opening a GameApplication.
 *
 * @author Aditya Nivarthi
 */
public class TestGame extends TestCase {

	/**
	 * Tests running the game.
	 */
	public void testBuilder() {
		GameApplication window = new GameApplication();
		window.getFrame().setVisible(true);

		assertTrue(true);
	}
}
