package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;

public class TestPointThresholds extends TestCase {

	public void testPointThresholdMethods(){
		PointThresholds p = new PointThresholds();
		
		assertEquals(p.getOneStarThreshold(), 0);
		assertEquals(p.getTwoStarThreshold(), 0);
		assertEquals(p.getThreeStarThreshold(), 0);
		
		p.setStarThresholds(5, 10, 20);
		
		assertEquals(p.getOneStarThreshold(), 5);
		assertEquals(p.getTwoStarThreshold(), 10);
		assertEquals(p.getThreeStarThreshold(), 20);
		
		p.setStarThresholds(50, 40, 30);
		
		assertEquals(p.getOneStarThreshold(), 30);
		assertEquals(p.getTwoStarThreshold(), 40);
		assertEquals(p.getThreeStarThreshold(), 50);
		
		PointThresholds p1 = new PointThresholds(6, 3, 1);
		
		assertEquals(p1.getOneStarThreshold(), 1);
		assertEquals(p1.getTwoStarThreshold(), 3);
		assertEquals(p1.getThreeStarThreshold(), 6);
	}
}
