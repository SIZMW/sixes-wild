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
	 * Tests opening the story level menu to display the preview.
	 */
	public void testSelectStoryLevelToPreview() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);

		robot.robotMouseMove(RobotGUITester.StoryLevelButtonPoint);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, 0.5, 60);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				0.25, 60);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				0.25, 60);
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
		robot.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, 0.5, 60);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				0.25, 60);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				0.25, 60);
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
		robot.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, 0.5, 60);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				0.25, 60);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				0.25, 60);
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
	 * Test opening a level to play and exiting to the main menu.
	 */
	public void testPlayAndQuitLevel() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);

		robot.robotMouseMove(RobotGUITester.StoryLevelButtonPoint);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, 0.5, 60);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(RobotGUITester.PlayLevelButtonPoint, 0.25, 60);
		robot.leftClickPressAndRelease();
		robot.robotMouseMove(RobotGUITester.ExitLevelButtonPoint);
		robot.leftClickPressAndRelease();
	}

	/**
	 * Test opening a locked level.
	 */
	public void testLockedLevelPlay() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);

		robot.robotMouseMove(RobotGUITester.StoryLevelButtonPoint);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, 0.5, 60);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				0.25, 60);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				0.25, 60);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				0.25, 60);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				0.25, 60);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				0.25, 60);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(RobotGUITester.PlayLevelButtonPoint, 0.25, 60);
		robot.leftClickPressAndRelease();
	}
}
