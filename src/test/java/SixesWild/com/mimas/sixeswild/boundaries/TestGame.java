package SixesWild.com.mimas.sixeswild.boundaries;

import junit.framework.TestCase;
import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

public class TestGame extends TestCase {
	public void testBuilder(){
		GameApplication window = new GameApplication();
		window.getFrame().setVisible(true);
		
		assertTrue(window.equals(window));
	}
}
