package SixesWild.com.mimas.sixeswild.controllers;

import javax.swing.JPanel;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.boundaries.LevelSelectionPanel;

public class StoryMenuButtonController {
	GameApplication app;
	//levellist TODO!
	
	public StoryMenuButtonController(GameApplication app){
		this.app = app;
	}
	
	public void process(){ //Make boolean TODO
		
		
		JPanel currPanel = app.getMainPanel().getPanel();
		currPanel.removeAll();
		currPanel.add(new LevelSelectionPanel());
		}
	
	
}
