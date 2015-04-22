package SixesWild.com.mimas.sixeswild.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SixesWild.com.mimas.sixeswild.boundaries.BuilderApplication;
import SixesWild.com.mimas.sixeswild.boundaries.BuilderSettingsPanel;
import SixesWild.com.mimas.sixeswild.entities.Tile;
import SixesWild.com.mimas.sixeswild.entities.TileType;

public class SaveButtonController implements ActionListener {
	BuilderApplication app;

	/**
	 * Creates a SaveButtonController instance with the specified
	 * BuilderApplication.
	 * 
	 * @param app
	 *            The BuilderApplication currently running.
	 */
	public SaveButtonController(BuilderApplication app) {
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

		// Print Out the Level Name
		String levelName = bsp.getUserLevelNameTextField().getText();
		System.out.println("Level Name: " + levelName);

		// Print Out the Level Type
		String levelType = bsp.getLevelTypeComboBox().getSelectedItem()
				.toString();
		System.out.println(" -Type: " + levelType);

		// Print Out the Moves
		String moveCount = bsp.getMovesTextField().getText();
		System.out.println(" -Move Count: " + moveCount);

		// Print Out Timer
		String timerCount = bsp.getTimerTextField().getText();
		System.out.println(" -Timer Count: " + timerCount);

		// Print Out Frequency of Tiles Grid
		String tf1, tf2, tf3, tf4, tf5, tf6;
		tf1 = bsp.getOnesTextField().getText();
		tf2 = bsp.getTwosTextField().getText();
		tf3 = bsp.getThreesTextField().getText();
		tf4 = bsp.getFoursTextField().getText();
		tf5 = bsp.getFivesTextField().getText();
		tf6 = bsp.getSixesTextField().getText();
		System.out.println("-- Tile Frequencies: ");
		System.out.println("    Ones: " + tf1);
		System.out.println("    Twos: " + tf2);
		System.out.println("    Threes: " + tf3);
		System.out.println("    Fours: " + tf4);
		System.out.println("    Fives: " + tf5);
		System.out.println("    Sixes: " + tf6);

		// Print Out Frequency of Multiplier Grid
		String mf1, mf2, mf3;
		mf2 = bsp.xtwoMultiplierTextField().getText();
		mf3 = bsp.xthreeMultiplierTextField().getText();
		mf1 = Double.toString(1.00 - (Double.parseDouble(mf2) + Double
				.parseDouble(mf3)));
		System.out.println("-- Multiplier Frequencies: ");
		System.out.println("    x1: " + mf1);
		System.out.println("    x2: " + mf2);
		System.out.println("    x3: " + mf3);

		// Print Out Special Moves Counts
		String m1, m2, m3, m4;
		m1 = bsp.getSpecialMoveOneLabel().getText();
		m2 = bsp.getSpecialMoveTwoLabel().getText();
		m3 = bsp.getSpecialMoveThreeLabel().getText();
		m4 = bsp.getSpecialMoveFourLabel().getText();
		System.out.println("-- SpecialMove Counts");
		System.out.println("    (1): " + m1);
		System.out.println("    (2): " + m2);
		System.out.println("    (3): " + m3);
		System.out.println("    (4): " + m4);

		// Print Out Score CutOffs
		String s1, s2, s3;
		s1 = bsp.getOneStarScoreTextField().getText();
		s2 = bsp.getTwoStarScoreTextField().getText();
		s3 = bsp.getThreeStarScoreTextField().getText();
		System.out.println("-- Score Cutoffs:");
		System.out.println("    1 Star: " + s1);
		System.out.println("    2 Star: " + s2);
		System.out.println("    3 Star: " + s3);

		// Print Out a Grid Version of the Level
		// N - Number
		// U - Null
		// T - Target
		// S - Six
		Tile currTile;
		// System.out.println(" -------------------");
		for (int i = 0; i < 9; i++) {
			// System.out.print("| ");
			for (int j = 0; j < 9; j++) {
				currTile = app.getBuilderView().getBoardViewPanel().getBoard()
						.getSquare(i, j).getTile();
				if (currTile.getType() == TileType.NULL) {
					System.out.print("U ");
				} else if (currTile.getType() == TileType.TARGET) {
					System.out.print("T ");
				} else if (currTile.getType() == TileType.SIX) {
					System.out.print("S ");
				} else if (currTile.getType() == TileType.NUMBER) {
					System.out.print("N ");
				} else {
					System.out.print("X ");
				}
			}
			// System.out.println("|");
		}
		// System.out.println(" -------------------");
	}
}
