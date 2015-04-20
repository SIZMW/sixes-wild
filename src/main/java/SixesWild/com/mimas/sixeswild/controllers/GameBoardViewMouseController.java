package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

public class GameBoardViewMouseController extends MouseAdapter {

	GameApplication app;
	
	public GameBoardViewMouseController(GameApplication app) {
		this.app = app;
	}
	
	public void mousePressed(MouseEvent me) {
		app.getLevelPanel().getBoardViewPanel().updateSelection(me.getX(), me.getY());
		app.getLevelPanel().getBoardViewPanel().updateUI();
	}
	
	public void mouseReleased(MouseEvent me) {
		app.getLevelPanel().getBoardViewPanel().applySelection();
		app.getLevelPanel().getBoardViewPanel().updateUI();
	}
}
