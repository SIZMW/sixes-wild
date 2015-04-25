package SixesWild.com.mimas.sixeswild.entities;

import junit.framework.TestCase;
/**
 * This test handles the all aspects relating to the badge.
 * @author Marco Duran
 *
 */
public class TestBadge extends TestCase {
	Badge badge;
	String name;
	String description;
	boolean isUnlocked;
	/**
	 * Created a badge with filled parameters
	 */
	public void setUp(){
		String name = "Test1";
		String description = "This is a test";
		boolean isUnlocked = false;
		
		badge = new Badge(name, description, isUnlocked);
	}
	
	public void tearDown(){}
	
	public void testBadgeMethods(){
		assertFalse(badge.canBeUnlocked());
		assertFalse(badge.isUnlocked);
		
		assertEquals(badge.getName(), badge.name);
		assertEquals(badge.getDescription(), badge.description);
		
		badge.unlock();
		assertTrue(badge.canBeUnlocked());
		assertTrue(badge.isUnlocked);
		
		badge.lock();
		assertFalse(badge.canBeUnlocked());
		assertFalse(badge.isUnlocked);
		
	}
	
	
}
