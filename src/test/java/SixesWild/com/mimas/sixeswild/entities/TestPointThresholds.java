package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

/**
 * This test case handles testing all the methods on PointThresholds.
 * 
 * @author Aditya Nivarthi
 */
public class TestPointThresholds extends TestCase {

	/**
	 * Test all methods on PointThresholds.
	 */
	public void testPointThresholdMethods() {
		// Set default values
		PointThresholds p = new PointThresholds();

		// Test default values
		assertEquals(p.getOneStarThreshold(), 0);
		assertEquals(p.getTwoStarThreshold(), 0);
		assertEquals(p.getThreeStarThreshold(), 0);

		// Set values
		p.setStarThresholds(5, 10, 20);

		// Test set values
		assertEquals(p.getOneStarThreshold(), 5);
		assertEquals(p.getTwoStarThreshold(), 10);
		assertEquals(p.getThreeStarThreshold(), 20);

		// Set invalid values
		p.setStarThresholds(50, 40, 30);

		// Test corrected values
		assertEquals(p.getOneStarThreshold(), 30);
		assertEquals(p.getTwoStarThreshold(), 40);
		assertEquals(p.getThreeStarThreshold(), 50);

		// Set custom values
		PointThresholds p1 = new PointThresholds(6, 3, 1);

		// Test custom values
		assertEquals(p1.getOneStarThreshold(), 1);
		assertEquals(p1.getTwoStarThreshold(), 3);
		assertEquals(p1.getThreeStarThreshold(), 6);
	}
}
