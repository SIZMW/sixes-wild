package SixesWild.com.mimas.sixeswild.util;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

/**
 * @author Yahel
 *
 * Class to help with testing boundaries and controllers by using a robot to click on buttons and perform other actions.
 */
public class RobotGUITester {

	static final int WindowHeaderWidth = 8;
	static final int WindowHeaderHeight = 30;
	
	// main menu buttons
	static final Point StoryLevelButtonPoint = new Point(20, 45);
	static final Point UserLevelButtonPoint = new Point(20, 175);
	static final Point BadgesLevelButtonPoint = new Point(20, 305);
	static final Point OptionsLevelButtonPoint = new Point(20, 435);
	static final Point CreditsLevelButtonPoint = new Point(20, 565);
	
	// level selection
	static final Point TopOfSelectionPanelPoint = new Point(175, 45);
	static final int DeltaYOfSelectionPanelItems = 17;
	static final Point PlayLevelButtonPoint = new Point(710, 590);
	
	// tile selection
	static final Point TilesOnBoard[][] = new Point[9][9];
	
	Robot rob;
	int autoDelay = 100;
	Point currentPoint = new Point(0, 0);
	
	/**
	 * Constructor for RobotGuiTester
	 * Creates a new robot and sets its auto delay.
	 */
	public RobotGUITester() {
		try{
			 rob = new Robot();
			 rob.setAutoDelay(autoDelay);
			 
			 initializeTilesOnBoard();
			 
		} catch (Exception e){
			
		}
	}
	
	public void initializeTilesOnBoard(){
		int x = 325;
		int y = 130;
		int deltaX = 65;
		int deltaY = 65;
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				TilesOnBoard[i][j] = new Point((x+(deltaX*i)), (y+(deltaY*j)));
			}
		}
	}
	
	/**
	 * Simulates a left click press
	 */
	public void leftClickPress(){
		rob.mousePress(InputEvent.BUTTON1_MASK);
	}
	
	/**
	 * Simulates a left click release
	 */
	public void leftClickRelease(){
		rob.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	/**
	 * Simulates a left click press and release
	 */
	public void leftClickPressAndRelease(){
		leftClickPress();
		leftClickRelease();
	}
	
	/**
	 * Drags the mouse from the old location to the new location
	 * 
	 * @param fromX The old x position
	 * @param fromY The old y position
	 * @param toX The new x position
	 * @param toY The new y position
	 * @param seconds The amount of seconds the mouse should drag for
	 * @param fps The frames per second (smoothness) of the dragging
	 */
	public void robotDragMouse(int fromX, int fromY, int toX, int toY, double seconds, int fps){
		int deltaTimeMilliseconds = (int) ((seconds * 1000) / fps);
		double deltaX = ((double)(toX - fromX))/fps;
		double deltaY = ((double)(toY - fromY))/fps;
		double newX = fromX;
		double newY = fromY;
		
		rob.mouseMove(fromX, fromY);
		rob.setAutoDelay(deltaTimeMilliseconds);
		for(int i = 0; i < fps; i++){
			newX += deltaX;
			newY += deltaY;
			
			rob.mouseMove((int) newX, (int) newY);
		}
		rob.setAutoDelay(autoDelay);
		
		currentPoint = MouseInfo.getPointerInfo().getLocation();
	}
	
	/**
	 * Drags the mouse from the old point to the new point
	 * 
	 * @param fromP The old point
	 * @param toP The new point
	 * @param seconds The amount of seconds the mouse should drag for
	 * @param fps The frames per second (smoothness) of the dragging
	 */
	public void robotDragMouse(Point fromP, Point toP, double seconds, int fps){
		robotDragMouse((int) fromP.getX(), (int) fromP.getY(), (int) toP.getX(), (int) toP.getY(), seconds, fps);
	}
	
	public void robotDragMouse(Point fromP, int deltaX, int deltaY, double seconds, int fps){
		robotDragMouse((int) fromP.getX(), (int) fromP.getY(), ((int) fromP.getX() + deltaX), ((int) fromP.getY() + deltaY), seconds, fps);
	}
	
	public void robotDragMouse(Point toP, double seconds, int fps){
		robotDragMouse(currentPoint, toP, seconds, fps);
	}
	
	public void robotDragMouse(int deltaX, int deltaY, double seconds, int fps){
		robotDragMouse(currentPoint, deltaX, deltaY, seconds, fps);
	}
	
	/**
	 * Moves the mouse to the specified point
	 * 
	 * @param x The x position
	 * @param y The y position
	 */
	public void robotMouseMove(int x, int y){
		rob.mouseMove(x, y);
		currentPoint = MouseInfo.getPointerInfo().getLocation();
	}
	
	/**
	 * Moves the mouse to the specified point
	 * 
	 * @param p The new point
	 */
	public void robotMouseMove(Point p){
		robotMouseMove((int) p.getX(), (int) p.getY());
	}
	
	/**
	 * makes the robot sleep for the specified time.
	 * 
	 * @param seconds The time to sleep for in seconds
	 */
	public void wait(double seconds){
		try{
			Thread.sleep((int) (seconds * 1000));
		} catch (Exception e){
			
		}
	}
	
	/**
	 * Tells the robot to simulate a keyboard event
	 * 
	 * @param key
	 */
	public void hitKey(String key){
		rob.keyPress(KeyEvent.VK_ENTER);
		try{
			Thread.sleep(rob.getAutoDelay());
		} catch (Exception e){
			
		}
	}
	
	public static void main(String[] args) {

		try {
			GameApplication window = new GameApplication();
			window.getFrame().setVisible(true);
			
			RobotGUITester r = new RobotGUITester();
			
			r.wait(1.0);
			
			r.hitKey("");
			
			// browse main game menus
			r.robotMouseMove(RobotGUITester.StoryLevelButtonPoint);
			r.leftClickPressAndRelease();
			r.robotDragMouse(RobotGUITester.UserLevelButtonPoint, 0.5, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(RobotGUITester.BadgesLevelButtonPoint, 0.5, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(RobotGUITester.OptionsLevelButtonPoint, 0.5, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(RobotGUITester.CreditsLevelButtonPoint, 0.5, 60);
			r.leftClickPressAndRelease();
			
			// go to story levels and preview levels
			r.robotDragMouse(RobotGUITester.StoryLevelButtonPoint, 0.5, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, 0.5, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems, 0.25, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems, 0.25, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems, 0.25, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems, 0.25, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems, 0.25, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems, 0.25, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems, 0.25, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems, 0.25, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems, 0.25, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems, 0.25, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems, 0.25, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems, 0.25, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(0, RobotGUITester.DeltaYOfSelectionPanelItems, 0.25, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(RobotGUITester.TopOfSelectionPanelPoint, 0.25, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(RobotGUITester.PlayLevelButtonPoint, 0.25, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(RobotGUITester.TilesOnBoard[0][0], 0.25, 60);
			r.leftClickPressAndRelease();
			r.robotDragMouse(RobotGUITester.TilesOnBoard[8][0], 0.25, 60);
			r.leftClickPressAndRelease();
			
			while(true){
				r.wait(1.0);
				System.out.println(MouseInfo.getPointerInfo().getLocation().getX() + " " + MouseInfo.getPointerInfo().getLocation().getY());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
