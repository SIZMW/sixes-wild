package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecretEasterEggController implements MouseListener {
	private static final Logger logger = Logger.getGlobal();
	private  static String person;
	
	protected Path perez = Paths.get("res\\Bisley.jar");
	
	public SecretEasterEggController(String personName){
		this.person = personName;
		
	}
	
	public void mouseClicked(MouseEvent me) {
		
		logger.log(Level.FINE, "Mouse clicked on " + person);
		Path filePath = Paths.get("");
		String s = filePath.toAbsolutePath().toString();
		logger.log(Level.FINE, "Attempting to open file at location: "  + perez.toAbsolutePath().toString());
		ProcessBuilder pb = new ProcessBuilder("java", "-jar", perez.toAbsolutePath().toString());
		logger.log(Level.FINE, "Working in directory: "  + s + "\\res\\");
		pb.directory(new File(s + "/res/"));
		try {
			pb.start();
		} catch (IOException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
