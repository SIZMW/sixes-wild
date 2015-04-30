package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.event.KeyEvent;

import junit.framework.TestCase;
import SixesWild.com.mimas.sixeswild.util.RobotGUITester;

/**
 * This test case handles coverage of the boundaries and controllers of the
 * level builder view.
 *
 * @author Aditya Nivarthi
 */
public class TestBuilderView extends TestCase {

	BuilderApplication window;
	RobotGUITester robot;

	/*
	 * (non-Javadoc)
	 *
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	public void setUp() {
		window = new BuilderApplication();
		window.getFrame().setVisible(true);
		robot = new RobotGUITester();

		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);
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
	 * Tests the special move increase and decrease buttons.
	 */
	public void testSpecialMoveButtons() {
		robot.robotMouseMove(RobotGUITester.SpecialMoveOneIncreasePoint);
		robot.leftClickPressAndRelease();
		robot.robotMouseMove(RobotGUITester.SpecialMoveOneDecreasePoint);
		robot.leftClickPressAndRelease();
		robot.robotMouseMove(RobotGUITester.SpecialMoveOneDecreasePoint);
		robot.leftClickPressAndRelease();

		robot.robotMouseMove(RobotGUITester.SpecialMoveTwoIncreasePoint);
		robot.leftClickPressAndRelease();
		robot.robotMouseMove(RobotGUITester.SpecialMoveTwoDecreasePoint);
		robot.leftClickPressAndRelease();
		robot.robotMouseMove(RobotGUITester.SpecialMoveTwoDecreasePoint);
		robot.leftClickPressAndRelease();

		robot.robotMouseMove(RobotGUITester.SpecialMoveThreeIncreasePoint);
		robot.leftClickPressAndRelease();
		robot.robotMouseMove(RobotGUITester.SpecialMoveThreeDecreasePoint);
		robot.leftClickPressAndRelease();
		robot.robotMouseMove(RobotGUITester.SpecialMoveThreeDecreasePoint);
		robot.leftClickPressAndRelease();

		robot.robotMouseMove(RobotGUITester.SpecialMoveFourIncreasePoint);
		robot.leftClickPressAndRelease();
		robot.robotMouseMove(RobotGUITester.SpecialMoveFourDecreasePoint);
		robot.leftClickPressAndRelease();
		robot.robotMouseMove(RobotGUITester.SpecialMoveFourDecreasePoint);
		robot.leftClickPressAndRelease();
	}

	/**
	 * Tests adding tiles and creating a new level.
	 */
	public void testNewLevelButton() {
		for (int i = 0; i < 9; i++) {
			robot.robotMouseMove(RobotGUITester.TilesOnBoard[i][i]);
			robot.leftClickPressAndRelease();
		}

		robot.robotMouseMove(RobotGUITester.NewLevelButtonPoint);
		robot.leftClickPressAndRelease();
	}

	/**
	 * Tests the undo and redo controllers.
	 */
	public void testUndoRedo() {

		// Place tiles
		for (int i = 0; i < 3; i++) {
			robot.robotMouseMove(RobotGUITester.TilesOnBoard[i][i]);
			robot.leftClickPressAndRelease();
		}

		// Undo placing tiles
		for (int i = 0; i < 3; i++) {
			robot.pressKey(KeyEvent.VK_CONTROL);
			robot.pressKey(KeyEvent.VK_Z);
			robot.releaseKey(KeyEvent.VK_CONTROL);
			robot.releaseKey(KeyEvent.VK_Z);
		}

		// Redo placing tiles
		for (int i = 0; i < 3; i++) {
			robot.pressKey(KeyEvent.VK_CONTROL);
			robot.pressKey(KeyEvent.VK_SHIFT);
			robot.pressKey(KeyEvent.VK_Z);
			robot.releaseKey(KeyEvent.VK_CONTROL);
			robot.releaseKey(KeyEvent.VK_SHIFT);
			robot.releaseKey(KeyEvent.VK_Z);
		}
	}

	/**
	 * Tests saving a level.
	 */
	public void testSaveLevel() {
		robot.robotMouseMove(RobotGUITester.SaveLevelButtonPoint);
		robot.leftClickPressAndRelease();
	}

	/**
	 * Tests opening a level.
	 */
	public void testOpenLevel() {
		robot.robotMouseMove(RobotGUITester.OpenLevelButtonPoint);
		robot.leftClickPressAndRelease();
	}

	/**
	 * Tests deleting a level.
	 */
	public void testDeleteLevel() {
		robot.robotMouseMove(RobotGUITester.DeleteLevelDropDownPoint);
		robot.leftClickPressAndRelease();
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
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				0.25, 60);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				0.25, 60);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				0.25, 60);
		robot.leftClickPressAndRelease();

		robot.robotMouseMove(RobotGUITester.DeleteLevelButtonPoint);
		robot.leftClickPressAndRelease();
	}

	/**
	 * Tests updating the frequencies after tiles are placed.
	 */
	public void testUpdateFrequency() {
		for (int i = 0; i < 3; i++) {
			robot.robotMouseMove(RobotGUITester.TilesOnBoard[i][i]);
			robot.leftClickPressAndRelease();
		}

		robot.robotMouseMove(RobotGUITester.TileFrequencyOneField);
		robot.leftClickPressAndRelease();
		robot.leftClickPressAndRelease();
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);
	}
}
