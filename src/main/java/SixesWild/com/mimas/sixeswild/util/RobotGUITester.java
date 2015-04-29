package SixesWild.com.mimas.sixeswild.util;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RobotGUITester {

	static final int WindowHeaderWidth = 8;
	static final int WindowHeaderHeight = 30;
	
	Robot rob;
	
	public RobotGUITester() {
		try{
			 rob = new Robot();
		} catch (Exception e){
			
		}
	}
	
	public void leftClickPress(){
		rob.mousePress(InputEvent.BUTTON1_MASK);
	}
	
	public void leftClickRelease(){
		rob.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
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
		rob.setAutoDelay(100);
	}
	
	public void robotMouseMove(int x, int y){
		rob.mouseMove(x, y);
	}
	
	public void wait(double seconds){
		try{
			Thread.sleep((int) (seconds * 1000));
		} catch (Exception e){
			
		}
	}
	
	public void hitKey(String key){
		rob.keyPress(KeyEvent.VK_ENTER);
	}
	
	public static void main(String[] args) {
		RobotGUITester r = new RobotGUITester();
		r.wait(3.0);
		r.robotMouseMove(0, 0);
		r.robotDragMouse(0, 0, RobotGUITester.WindowHeaderWidth, RobotGUITester.WindowHeaderHeight, 1.0, 60);
		r.robotMouseMove(RobotGUITester.WindowHeaderWidth, RobotGUITester.WindowHeaderHeight);
		r.hitKey("");
	}
}
