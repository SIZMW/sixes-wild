package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.Component;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;

public class LevelListController implements ListSelectionListener{

	GameApplication app;
	
	public LevelListController(GameApplication app){
		this.app = app;
	}
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {  
			// TODO get it working
			System.out.println("hi from list selection listener");	
			System.out.println(app.getGameMenuView().getStoryMenuView().getLevelList().getSelectedIndex());
			int c = app.getGameMenuView().getStoryMenuView().getPreviewPanel().getComponentCount();
			System.out.println(c);
			//lblLevelPreview.setIcon(null);
		}
	}

}
