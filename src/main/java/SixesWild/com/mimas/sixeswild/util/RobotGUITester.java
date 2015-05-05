package SixesWild.com.mimas.sixeswild.util;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * This class is used to handle testing interaction for test cases on the
 * boundaries and controllers.
 *
 * @author Yahel Nachum
 */
public class RobotGUITester {

	public static final int WindowHeaderWidth = 8;
	public static final int WindowHeaderHeight = 30;

	// Main menu buttons
	public static final Point StoryLevelButtonPoint = new Point(20, 45);
	public static final Point UserLevelButtonPoint = new Point(20, 175);
	public static final Point BadgesButtonPoint = new Point(20, 305);
	public static final Point OptionsLevelButtonPoint = new Point(20, 435);
	public static final Point CreditsLevelButtonPoint = new Point(20, 565);
	public static final Point CloseWindowButtonPoint = new Point(970, 10);
	public static final Point ExitLevelButtonPoint = new Point(914, 60);

	// Level selection
	public static final Point TopOfSelectionPanelPoint = new Point(175, 45);
	public static final int DeltaYOfSelectionPanelItems = 17;
	public static final Point PlayLevelButtonPoint = new Point(710, 590);

	// Game playing
	public static final Point PopUpCloseButtonPoint = new Point(627, 311);

	// Builder buttons
	public static final Point SpecialMoveOneDecreasePoint = new Point(102, 414);
	public static final Point SpecialMoveOneIncreasePoint = new Point(142, 414);
	public static final Point SpecialMoveTwoDecreasePoint = new Point(102, 476);
	public static final Point SpecialMoveTwoIncreasePoint = new Point(142, 476);
	public static final Point SpecialMoveThreeDecreasePoint = new Point(266,
			414);
	public static final Point SpecialMoveThreeIncreasePoint = new Point(312,
			414);
	public static final Point SpecialMoveFourDecreasePoint = new Point(266, 476);
	public static final Point SpecialMoveFourIncreasePoint = new Point(312, 476);
	public static final Point NewLevelButtonPoint = new Point(388, 60);
	public static final Point SaveLevelButtonPoint = new Point(472, 60);
	public static final Point OpenLevelButtonPoint = new Point(550, 60);
	public static final Point DeleteLevelButtonPoint = new Point(786, 56);
	public static final Point DeleteLevelDropDownPoint = new Point(900, 64);
	public static final Point TileFrequencyOneField = new Point(96, 254);

	// Tile selection
	public static final Point TilesOnBoard[][] = new Point[9][9];
	public static final Point TilesOnBuilderBoard[][] = new Point[9][9];

	protected Robot rob;
	protected int autoDelay = 100;
	protected Point currentPoint = new Point(0, 0);

	/**
	 * Creates a RobotGUITester instance.
	 */
	public RobotGUITester() {
		try {
			rob = new Robot();
			rob.setAutoDelay(autoDelay);

			initializeTilesOnBoard();

		} catch (Exception e) {

		}
	}

	/**
	 * Initializes the tile coordinate locations on the screen.
	 */
	public void initializeTilesOnBoard() {
		int x = 325;
		int y = 130;
		int deltaX = 65;
		int deltaY = 65;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				TilesOnBoard[i][j] = new Point((x + (deltaX * i)),
						(y + (deltaY * j)));
				TilesOnBuilderBoard[i][j] = new Point((81 + x + (deltaX * i)),
						(y + (deltaY * j)));
			}
		}
	}

	/**
	 * Simulates a left click press
	 */
	public void leftClickPress() {
		rob.mousePress(InputEvent.BUTTON1_MASK);
	}

	/**
	 * Simulates a left click release
	 */
	public void leftClickRelease() {
		rob.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	/**
	 * Simulates a left click press and release
	 */
	public void leftClickPressAndRelease() {
		leftClickPress();
		leftClickRelease();
	}

	/**
	 * Drags the mouse from the old location to the new location
	 *
	 * @param fromX
	 *            The starting horizontal coordinate.
	 * @param fromY
	 *            The starting vertical coordinate.
	 * @param toX
	 *            The ending horizontal coordinate.
	 * @param toY
	 *            The ending vertical coordinate.
	 * @param seconds
	 *            The length of time to drag the mouse.
	 * @param fps
	 *            The frames per second of the dragging action.
	 */
	public void robotDragMouse(int fromX, int fromY, int toX, int toY,
			double seconds, int fps) {
		int deltaTimeMilliseconds = (int) ((seconds * 1000) / fps);
		double deltaX = ((double) (toX - fromX)) / fps;
		double deltaY = ((double) (toY - fromY)) / fps;
		double newX = fromX;
		double newY = fromY;

		rob.mouseMove(fromX, fromY);
		rob.setAutoDelay(deltaTimeMilliseconds);
		for (int i = 0; i < fps; i++) {
			newX += deltaX;
			newY += deltaY;

			rob.mouseMove((int) newX, (int) newY);
		}
		rob.setAutoDelay(autoDelay);

		currentPoint = MouseInfo.getPointerInfo().getLocation();
	}

	/**
	 * Drags the mouse from the starting point to the ending point.
	 *
	 * @param fromP
	 *            The starting point of the drag.
	 * @param toP
	 *            The ending point of the drag.
	 * @param seconds
	 *            The length of time to drag the mouse.
	 * @param fps
	 *            The frames per second of the dragging action.
	 */
	public void robotDragMouse(Point fromP, Point toP, double seconds, int fps) {
		robotDragMouse((int) fromP.getX(), (int) fromP.getY(),
				(int) toP.getX(), (int) toP.getY(), seconds, fps);
	}

	/**
	 * Drags the mouse from the starting point to a new location designated by
	 * the delta distances.
	 *
	 * @param fromP
	 *            The starting point of the drag.
	 * @param deltaX
	 *            The horizontal distance to move.
	 * @param deltaY
	 *            The vertical distance to move.
	 * @param seconds
	 *            The length of time to drag the mouse.
	 * @param fps
	 *            The frames per second of the dragging action.
	 */
	public void robotDragMouse(Point fromP, int deltaX, int deltaY,
			double seconds, int fps) {
		robotDragMouse((int) fromP.getX(), (int) fromP.getY(),
				((int) fromP.getX() + deltaX), ((int) fromP.getY() + deltaY),
				seconds, fps);
	}

	/**
	 * Drags the mouse from the current position to the new position.
	 *
	 * @param toP
	 *            The ending point of the drag.
	 * @param seconds
	 *            The length of time to drag the mouse.
	 * @param fps
	 *            The frames per second of the dragging action.
	 */
	public void robotDragMouse(Point toP, double seconds, int fps) {
		robotDragMouse(currentPoint, toP, seconds, fps);
	}

	public void robotDragMouse(int deltaX, int deltaY, double seconds, int fps) {
		robotDragMouse(currentPoint, deltaX, deltaY, seconds, fps);
	}

	/**
	 * Moves the mouse to the specified point
	 *
	 * @param x
	 *            The x position
	 * @param y
	 *            The y position
	 */
	public void robotMouseMove(int x, int y) {
		rob.mouseMove(x, y);
		currentPoint = MouseInfo.getPointerInfo().getLocation();
	}

	/**
	 * Moves the mouse to the specified point
	 *
	 * @param p
	 *            The new point
	 */
	public void robotMouseMove(Point p) {
		robotMouseMove((int) p.getX(), (int) p.getY());
	}

	/**
	 * Pause robot movement for the specified length of time.
	 *
	 * @param seconds
	 *            The time to sleep for in seconds.
	 */
	public void wait(double seconds) {
		try {
			Thread.sleep((int) (seconds * 1000));
		} catch (Exception e) {

		}
	}

	/**
	 * Simulates a key press.
	 *
	 * @param keyEventConstant
	 *            The key constant for the key press to simulate.
	 */
	public void pressKey(int keyEventConstant) {
		rob.keyPress(keyEventConstant);
		try {
			Thread.sleep(rob.getAutoDelay());
		} catch (Exception e) {

		}
	}

	/**
	 * Simulates a key release.
	 *
	 * @param keyEventConstant
	 *            The key constant for the key press to simulate.
	 */
	public void releaseKey(int keyEventConstant) {
		rob.keyRelease(keyEventConstant);
		try {
			Thread.sleep(rob.getAutoDelay());
		} catch (Exception e) {

		}
	}

	// public static void main(String args[]) {
	// BuilderApplication app = new BuilderApplication();
	// app.getFrame().setVisible(true);
	// while (true) {
	// System.out.println(MouseInfo.getPointerInfo().getLocation().getX()
	// + " " + MouseInfo.getPointerInfo().getLocation().getY());
	// }
	// }
}
