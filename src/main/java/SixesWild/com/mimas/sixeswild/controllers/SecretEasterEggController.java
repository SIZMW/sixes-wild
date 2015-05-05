package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecretEasterEggController extends MouseAdapter {
	private static final Logger logger = Logger.getGlobal();
	private String person;

	protected Path perez = Paths.get("res\\Bisley.jar");
	protected Path duran = Paths.get("res\\AmericanToad.jar");
	protected Path jones = Paths.get("res\\eaglewing.jar");

	public SecretEasterEggController(String personName) {
		person = personName;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent me) {

		Path filePath = Paths.get("");
		Path creator = getCreator();
		String s = filePath.toAbsolutePath().toString();
		logger.log(Level.FINE, "Attempting to open file at location: "
				+ creator.toAbsolutePath().toString());
		ProcessBuilder pb = new ProcessBuilder("java", "-jar", creator
				.toAbsolutePath().toString());
		logger.log(Level.FINE, "Working in directory: " + s + "\\res\\");
		pb.directory(new File(s + "/res/"));
		try {
			pb.start();
		} catch (IOException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}
	}

	private Path getCreator() {
		if (person == "Marco") {
			logger.log(Level.FINE, "Mouse clicked on " + person);
			return duran;

		}
		if (person == "Joey") {
			logger.log(Level.FINE, "Mouse clicked on " + person);
			return perez;
		}

		if (person == "Cam") {
			logger.log(Level.FINE, "Mouse clicked on " + person);
			return jones;
		} else {
			return null;
		}
	}
}
