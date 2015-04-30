package SixesWild.com.mimas.sixeswild.boundaries;

import java.awt.event.KeyEvent;

import junit.framework.TestCase;
import SixesWild.com.mimas.sixeswild.util.RobotGUITester;

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

	public void testSpecialMoveButtons() {
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);

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
	
	public void testNewLevelButton(){
		robot.wait(1.0);
		robot.pressKey(KeyEvent.VK_ENTER);
		
		for(int i = 0; i < 9; i++){
			robot.robotMouseMove(RobotGUITester.TilesOnBoard[i][i]);
			robot.leftClickPressAndRelease();
		}
		
		robot.robotMouseMove(RobotGUITester.NewLevelButtonPoint);
		robot.leftClickPressAndRelease();
	}
}
