package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.event.KeyEvent;

import junit.framework.TestCase;
import SixesWild.com.mimas.sixeswild.util.RobotGUITester;

/**
 * This test case handles all coverage on viewing and playing a level.
 *
 * @author Aditya Nivarthi
 */
public class TestLevelView extends TestCase {

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
	 * Test opening a level to play and exiting to the main menu.
	 */
	public void testPlayAndQuitLevel() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);

		robot.robotMouseMove(RobotGUITester.StoryLevelButtonPoint);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, seconds,
				fps);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(RobotGUITester.PlayLevelButtonPoint, seconds, fps);
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
		robot.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, seconds,
				fps);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(RobotGUITester.PlayLevelButtonPoint, seconds, fps);
		robot.leftClickPressAndRelease();
	}

	/*
	 * Tests doing a selection on a game board.
	 */
	public void testSelectionMove() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);

		robot.robotMouseMove(RobotGUITester.UserLevelButtonPoint);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, seconds,
				fps);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.leftClickPressAndRelease();

		robot.wait(1.0);

		robot.robotMouseMove(RobotGUITester.PlayLevelButtonPoint);
		robot.leftClickPressAndRelease();

		robot.robotMouseMove(RobotGUITester.TilesOnBoard[0][0]);
		robot.leftClickPress();
		for (int i = 0; i < 6; i++) {
			robot.robotDragMouse(RobotGUITester.TilesOnBoard[i][0], seconds,
					fps);
		}
		robot.leftClickRelease();

		robot.wait(3.0);
		assertTrue(window.getLevelPanel().getScore() > 0);

		robot.robotMouseMove(RobotGUITester.PopUpCloseButtonPoint);
		robot.leftClickPressAndRelease();
	}

	/**
	 * Tests the remove tile move on a game board.
	 */
	public void testRemoveTileMove() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);

		robot.robotMouseMove(RobotGUITester.StoryLevelButtonPoint);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, seconds,
				fps);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.leftClickPressAndRelease();

		robot.wait(1.0);

		robot.robotDragMouse(RobotGUITester.PlayLevelButtonPoint, seconds, fps);
		robot.leftClickPressAndRelease();

		robot.wait(1.0);

		int shiftNumber = window.getLevelPanel().getBoardViewPanel().getBoard()
				.getSquare(2, 2).getTile().getNumber();

		robot.robotDragMouse(RobotGUITester.RemoveTileMoveButtonPoint, seconds,
				fps);
		robot.leftClickPressAndRelease();

		robot.robotDragMouse(RobotGUITester.TilesOnBoard[2][3], seconds, fps);
		robot.leftClickPressAndRelease();

		assertEquals(window.getLevelPanel().getBoardViewPanel().getBoard()
				.getSquare(2, 3).getTile().getNumber(), shiftNumber);
		robot.wait(1.0);
	}

	/**
	 * Tests the swap tile move on a game board.
	 */
	public void testSwapTileMove() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);

		robot.robotMouseMove(RobotGUITester.StoryLevelButtonPoint);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, seconds,
				fps);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.leftClickPressAndRelease();

		robot.wait(1.0);

		robot.robotDragMouse(RobotGUITester.PlayLevelButtonPoint, seconds, fps);
		robot.leftClickPressAndRelease();

		robot.wait(1.0);

		int firstTileNumber = window.getLevelPanel().getBoardViewPanel()
				.getBoard().getSquare(2, 2).getTile().getNumber();
		int secondTileNumber = window.getLevelPanel().getBoardViewPanel()
				.getBoard().getSquare(2, 3).getTile().getNumber();

		robot.robotDragMouse(RobotGUITester.SwapTileMoveButtonPoint, seconds,
				fps);
		robot.leftClickPressAndRelease();

		robot.robotDragMouse(RobotGUITester.TilesOnBoard[2][3], seconds, fps);
		robot.leftClickPressAndRelease();

		robot.robotDragMouse(RobotGUITester.TilesOnBoard[2][2], seconds, fps);
		robot.leftClickPressAndRelease();

		assertEquals(window.getLevelPanel().getBoardViewPanel().getBoard()
				.getSquare(2, 3).getTile().getNumber(), firstTileNumber);
		assertEquals(window.getLevelPanel().getBoardViewPanel().getBoard()
				.getSquare(2, 2).getTile().getNumber(), secondTileNumber);
		robot.wait(1.0);
	}

	/**
	 * Tests the reset board move on a game board.
	 */
	public void testResetBoardMove() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);

		robot.robotMouseMove(RobotGUITester.StoryLevelButtonPoint);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, seconds,
				fps);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.leftClickPressAndRelease();

		robot.wait(1.0);

		robot.robotDragMouse(RobotGUITester.PlayLevelButtonPoint, seconds, fps);
		robot.leftClickPressAndRelease();

		robot.wait(1.0);

		robot.robotDragMouse(RobotGUITester.ResetBoardMoveButtonPoint, seconds,
				fps);
		robot.leftClickPressAndRelease();
		robot.wait(1.0);
	}

	/**
	 * Tests the XStacy move on a game board.
	 */
	public void testXStacyMove() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		robot.releaseKey(KeyEvent.VK_ENTER);

		robot.robotMouseMove(RobotGUITester.StoryLevelButtonPoint);
		robot.leftClickPressAndRelease();
		robot.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, seconds,
				fps);
		robot.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems,
				seconds, fps);
		robot.leftClickPressAndRelease();

		robot.wait(1.0);

		robot.robotDragMouse(RobotGUITester.PlayLevelButtonPoint, seconds, fps);
		robot.leftClickPressAndRelease();

		robot.wait(1.0);

		int moves = window.getLevelPanel().getLevel().getRestrictionCount();

		robot.robotDragMouse(RobotGUITester.XStacyMoveButtonPoint, seconds, fps);
		robot.leftClickPressAndRelease();

		assertEquals(moves + 10, window.getLevelPanel().getLevel()
				.getRestrictionCount());
		robot.wait(1.0);
	}
}
