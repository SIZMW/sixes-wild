package SixesWild.com.mimas.sixeswild.sixeswild;

import junit.framework.TestCase;
import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;

public class TestBuilder extends TestCase {
	public void testBuilder(){
		BuilderApplication window = new BuilderApplication();
		window.getFrame().setVisible(true);
		
		assertTrue(true);
	}
}
