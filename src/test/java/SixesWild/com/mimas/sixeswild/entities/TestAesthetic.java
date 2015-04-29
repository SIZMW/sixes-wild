package SixesWild.com.mimas.sixeswild.entities;

import java.awt.Color;

import junit.framework.TestCase;

/**
 * This test case handles all coverage for the Aesthetic class.
 *
 * @author Marco Duran
 */
public class TestAesthetic extends TestCase {
	Aesthetic aesthetic;
	Color red;
	Color black;
	Color blue;
	Color green;
	Color magenta;
	Color yellow;
	Color gray;
	Color cyan;
	Color orange;
	Color pink;
	String name;

	/*
	 * (non-Javadoc)
	 *
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	public void setUp() {
		name = "Test";
		red = Color.RED;
		black = Color.BLACK;
		blue = Color.BLUE;
		green = Color.GREEN;
		magenta = Color.MAGENTA;
		yellow = Color.YELLOW;
		gray = Color.GRAY;
		cyan = Color.CYAN;
		orange = Color.ORANGE;
		pink = Color.PINK;

		aesthetic = new Aesthetic(name, gray, red, black, blue, green, magenta,
				yellow, cyan, orange);
	}

	/**
	 * Tests all of the Aesthetic methods
	 */
	public void testAestheticMethods() {
		assertEquals(aesthetic.getName(), name);
		assertEquals(aesthetic.getBackgroundColor(), gray);
		assertEquals(aesthetic.getTileOneColor(), red);
		assertEquals(aesthetic.getTileTwoColor(), black);
		assertEquals(aesthetic.getTileThreeColor(), blue);
		assertEquals(aesthetic.getTileFourColor(), green);
		assertEquals(aesthetic.getTileFiveColor(), magenta);
		assertEquals(aesthetic.getTileSixColor(), yellow);
		assertEquals(aesthetic.getMarkedColor(), gray);
		assertEquals(aesthetic.getTargetColor(), cyan);
		assertEquals(aesthetic.getNullTileColor(), orange);
	}
}
