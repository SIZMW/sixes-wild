package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

public class GameBoardViewMouseMotionController extends MouseAdapter {

	GameApplication app;
	
	public GameBoardViewMouseMotionController(GameApplication app) {
		this.app = app;
	}
	
	public void mouseDragged(MouseEvent me) {
		app.getLevelPanel().getBoardViewPanel().updateSelection(me.getX(), me.getY());
		app.getLevelPanel().getBoardViewPanel().updateUI();
	}
}
