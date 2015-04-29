package SixesWild.com.mimas.sixeswild.sixeswild;

import junit.framework.TestCase;
import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;

/**
 * This test case handles opening the BuilderApplication.
 *
 * @author Aditya Nivarthi
 */
public class TestBuilder extends TestCase {

	/**
	 * Tests running the level builder.
	 */
	public void testBuilder() {
		BuilderApplication window = new BuilderApplication();
		window.getFrame().setVisible(true);

		assertTrue(true);
	}
}
