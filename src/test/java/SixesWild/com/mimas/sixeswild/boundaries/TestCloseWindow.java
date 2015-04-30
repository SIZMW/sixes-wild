package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.event.KeyEvent;

import junit.framework.TestCase;
import SixesWild.com.mimas.sixeswild.util.RobotGUITester;

public class TestCloseWindow extends TestCase {

	GameApplication window;
	RobotGUITester robot;

	/*
	 * (non-Javadoc)
	 *
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	public void setUp() {
		window = new GameApplication();
		window.getFrame().setVisible(true);
		robot = new RobotGUITester();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	public void tearDown() {
		window.getFrame().dispose();
	}

	/**
	 * Tests closing the window.
	 */
	public void testSelectLevelToPreview() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.robotMouseMove(RobotGUITester.CloseWindowButtonPoint);
		robot.leftClickPressAndRelease();
	}
}
