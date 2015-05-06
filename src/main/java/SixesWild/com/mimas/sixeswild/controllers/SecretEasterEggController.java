package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This controller handles opening the secret easter eggs for the solitaire
 * games.
 *
 * @author Joey Perez
 */
public class SecretEasterEggController extends MouseAdapter {

	private static final Logger logger = Logger.getGlobal();

	protected String version;

	/**
	 * Creates a SecretEasterEggController with the specified version.
	 *
	 * @param version
	 *            The name of the solitaire version to run.
	 */
	public SecretEasterEggController(String version) {
		this.version = version;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent me) {

		// Get file name of jar
		String file = getClass().getClassLoader().getResource("secret/")
				.toString().substring(6)
				+ version + ".jar";

		logger.log(Level.FINE, "Attempting to open file at location: " + file);

		// Create process
		ProcessBuilder pb = new ProcessBuilder("java", "-jar", file);
		File runJar = new File(getClass().getClassLoader()
				.getResource("secret/" + version + ".jar").getFile());
		pb.directory(runJar.getParentFile());

		try {
			pb.start();
		} catch (IOException x) {
			logger.log(Level.SEVERE, "Failed to run egg version: " + version);
		}
	}
}
