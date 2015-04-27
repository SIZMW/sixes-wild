package SixesWild.com.mimas.sixeswild.controllers;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import SixesWild.com.mimas.sixeswild.boundaries.GameApplication;
import SixesWild.com.mimas.sixeswild.entities.GameLevel;
import SixesWild.com.mimas.sixeswild.sixeswild.XMLParser;

public class LevelListController implements ListSelectionListener{

	GameApplication app;
	
	public LevelListController(GameApplication app){
		this.app = app;
	}
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {  
			/*// TODO get it working
			System.out.println("hi from list selection listener");	
			int c = app.getGameMenuView().getStoryMenuView().getLevelList().getSelectedIndex();
			if(app.getGameMenuView().getStoryMenuView().getPreviewPanel() == null) System.out.println("super man");
			
			GameLevel level = XMLParser.fileToLevel(XMLParser.STORY_DIR + (c+1) + XMLParser.XML_EXT);
			
			app.getGameMenuView().getStoryMenuView().getLevelPreviewLabel().setBoard(level.getBoard());;*/
			
			//app.getGameMenuView().getStoryMenuView().getLevelPreviewLabel().setText("" + c);
			//lblLevelPreview.setIcon(new ImageIcon("C:\\Users\\yahel\\workspace\\Software Engineering\\storylevelpreviews\\1.jpg"));
			//app.getGameMenuView().getStoryMenuView().getLevelPreviewLabel().setIcon(new ImageIcon("./storylevelpreviews/" + (c+1) + ".jpg")); 
			
			
			//lblLevelPreview.setIcon(null);
		}
	}

}
