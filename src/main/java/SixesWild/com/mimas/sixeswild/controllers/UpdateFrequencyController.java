package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;
import SixesWild.com.mimas.sixeswild.boundaries.BuilderSettingsPanel;
import SixesWild.com.mimas.sixeswild.entities.Board;
import SixesWild.com.mimas.sixeswild.entities.Tile;

/**
 * This controller handles updating the board when new frequencies have been
 * entered.
 *
 * @author Aditya Nivarthi
 */
public class UpdateFrequencyController implements ActionListener {

	private static final Logger logger = Logger.getGlobal();

	protected BuilderApplication app;

	/**
	 * Creates a UpdateFrequencyController instance with the specified
	 * BuilderApplication app.
	 *
	 * @param app
	 *            The BuilderApplication currently running.
	 */
	public UpdateFrequencyController(BuilderApplication app) {
		this.app = app;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		BuilderSettingsPanel bsp = app.getBuilderView()
				.getBuilderSettingsPanel();

		Tile tiles[][] = new Tile[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				tiles[i][j] = app.getBuilderView().getBoardViewPanel()
						.getBoard().getSquare(i, j).getTile();
			}
		}

		// Tile frequencies
		Double tf1, tf2, tf3, tf4, tf5, tf6;
		tf1 = 0.0;
		tf2 = 0.0;
		tf3 = 0.0;
		tf4 = 0.0;
		tf5 = 0.0;
		tf6 = 0.0;

		try {
			tf1 = Math
					.abs(Double.parseDouble(bsp.getOnesTextField().getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse tile frequency 1. Reverting to stock value of: "
							+ tf1);
		}

		try {
			tf2 = Math
					.abs(Double.parseDouble(bsp.getTwosTextField().getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse tile frequency 2. Reverting to stock value of: "
							+ tf2);
		}

		try {
			tf3 = Math.abs(Double.parseDouble(bsp.getThreesTextField()
					.getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse tile frequency 3. Reverting to stock value of: "
							+ tf3);
		}

		try {
			tf4 = Math.abs(Double
					.parseDouble(bsp.getFoursTextField().getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse tile frequency 4. Reverting to stock value of: "
							+ tf4);
		}

		try {
			tf5 = Math.abs(Double
					.parseDouble(bsp.getFivesTextField().getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse tile frequency 5. Reverting to stock value of: "
							+ tf5);
		}

		try {
			tf6 = Math.abs(Double
					.parseDouble(bsp.getSixesTextField().getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse tile frequency 6. Reverting to stock value of: "
							+ tf6);
		}

		ArrayList<Double> tileFreq = new ArrayList<Double>();
		tileFreq.add(tf1);
		tileFreq.add(tf2);
		tileFreq.add(tf3);
		tileFreq.add(tf4);
		tileFreq.add(tf5);
		tileFreq.add(tf6);

		// Multiplier frequencies
		Double mf1, mf2, mf3;
		mf2 = 0.0;
		mf3 = 0.0;

		try {
			mf2 = Math.abs(Double.parseDouble(bsp.getTwoMultiplierTextField()
					.getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse multiplier frequency 2. Reverting to stock value of: "
							+ mf2);
		}

		try {
			mf3 = Math.abs(Double.parseDouble(bsp.getThreeMultiplierTextField()
					.getText()));
		} catch (NumberFormatException nfe) {
			logger.log(Level.WARNING,
					"Failed to parse multiplier frequency 3. Reverting to stock value of: "
							+ mf3);
		}

		mf1 = (1.00 - ((mf2) + (mf3)));
		ArrayList<Double> multFreq = new ArrayList<Double>();
		multFreq.add(mf1);
		multFreq.add(mf2);
		multFreq.add(mf3);

		try {
			app.getBuilderView().getBoardViewPanel()
					.setBoard(new Board(tiles, tileFreq, multFreq));
		} catch (Exception a) {
			logger.log(Level.INFO, "Board failed to update with frequencies.");
		}
	}
}
