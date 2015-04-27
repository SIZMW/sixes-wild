package SixesWild.com.mimas.sixeswild.sixeswild;

import java.awt.event.MouseEvent;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;
import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import junit.framework.TestCase;

public class SixesWildTestCase extends TestCase{
	/** (dx,dy) are coordinates. Feel Free to Use as Is. */
	public MouseEvent createPressed (BuilderApplication game, int dx, int dy) {
		MouseEvent me = new MouseEvent(game.getFrame(), MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 0, false);
		return me;
	}
		
	/** (dx,dy) are coordinates. Feel Free to Use as Is. */
	public MouseEvent createReleased (BuilderApplication game, int dx, int dy) {
		MouseEvent me = new MouseEvent(game.getFrame(), MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 0, false);
		return me;
	}
	
	/** (dx,dy) are coordinates. Feel Free to Use as Is. */
	public MouseEvent createClicked (BuilderApplication game, int dx, int dy) {
		MouseEvent me = new MouseEvent(game.getFrame(), MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 1, false);
		return me;
	}
	
	/** (dx,dy) are coordinates. Feel Free to Use as Is. */
	public MouseEvent createDoubleClicked (BuilderApplication game, int dx, int dy) {
		MouseEvent me = new MouseEvent(game.getFrame(), MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 2, false);
		return me;
	}
	
	/** (dx,dy) are coordinates. Feel Free to Use as Is. */
	public MouseEvent createPressed (GameApplication game, int dx, int dy) {
		MouseEvent me = new MouseEvent(game.getFrame(), MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 0, false);
		return me;
	}
		
	/** (dx,dy) are coordinates. Feel Free to Use as Is. */
	public MouseEvent createReleased (GameApplication game, int dx, int dy) {
		MouseEvent me = new MouseEvent(game.getFrame(), MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 0, false);
		return me;
	}
	
	/** (dx,dy) are coordinates. Feel Free to Use as Is. */
	public MouseEvent createClicked (GameApplication game, int dx, int dy) {
		MouseEvent me = new MouseEvent(game.getFrame(), MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 1, false);
		return me;
	}
	
	/** (dx,dy) are coordinates. Feel Free to Use as Is. */
	public MouseEvent createDoubleClicked (GameApplication game, int dx, int dy) {
		MouseEvent me = new MouseEvent(game.getFrame(), MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 2, false);
		return me;
	}
}
