package SixesWild.com.mimas.sixeswild.sixeswild;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

public class TestGame extends SixesWildTestCase {
	public void testBuilder(){
		GameApplication window = new GameApplication();
		window.getFrame().setVisible(true);
		
		assertTrue(window.equals(window));
	}
}
