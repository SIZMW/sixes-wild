package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.event.KeyEvent;

import junit.framework.TestCase;
import SixesWild.com.mimas.sixeswild.util.RobotGUITester;

/**
 * This test case handles all coverage in viewing the game menu.
 *
 * @author Aditya Nivarthi
 */
public class TestGameMenuView extends TestCase {

	GameApplication window;
	RobotGUITester robot;

	int fps;
	double seconds;

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
		fps = 240;
		seconds = 0.25;
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
	 * Tests opening the story level menu to display the preview.
	 */
	public void testSelectStoryLevelToPreview() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);

		robot.robotMouseMove(RobotGUITester.StoryLevelButtonPoint);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, seconds,
				fps);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.leftClickPressAndRelease();
	}

	/**
	 * Tests opening the user level menu to display the preview.
	 */
	public void testSelectUserLevelToPreview() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);

		robot.robotMouseMove(RobotGUITester.UserLevelButtonPoint);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, seconds,
				fps);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.leftClickPressAndRelease();
	}

	/**
	 * Tests opening the badges menu to display the preview.
	 */
	public void testSelectBadgesToPreview() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);
		robot.robotMouseMove(RobotGUITester.BadgesButtonPoint);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, seconds,
				fps);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.leftClickPressAndRelease();
	}

	/**
	 * Tests opening the options menu.
	 */
	public void testOptionsMenu() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);

		robot.robotMouseMove(RobotGUITester.OptionsLevelButtonPoint);
		robot.leftClickPressAndRelease();
	}

	/**
	 * Tests opening the credits menu.
	 */
	public void testCreditsMenu() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);

		robot.robotMouseMove(RobotGUITester.CreditsLevelButtonPoint);
		robot.leftClickPressAndRelease();
	}

	/**
	 * Tests the secret easter egg.
	 */
	public void testSecret() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);

		robot.robotMouseMove(RobotGUITester.CreditsLevelButtonPoint);
		robot.leftClickPressAndRelease();

		robot.wait(1.0);

		robot.robotDragMouse(RobotGUITester.SecretEggOnePoint, seconds, fps);
		robot.leftClickPressAndRelease();
		robot.wait(1.0);

		robot.robotDragMouse(RobotGUITester.SecretEggOneClosePoint, seconds,
				fps);
		robot.leftClickPressAndRelease();
	}
}
