package SixesWild.com.mimas.sixeswild.sixeswild;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;

public class TestBuilder extends SixesWildTestCase {
	public void testBuilder(){
		BuilderApplication window = new BuilderApplication();
		window.getFrame().setVisible(true);
		
		assertTrue(window.equals(window));
	}
}
