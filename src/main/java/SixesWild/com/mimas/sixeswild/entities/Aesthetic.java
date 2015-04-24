package SixesWild.com.mimas.sixeswild.entities;

import java.awt.Color;

/**
 * Aesthetic defines the color scheme used across the different views within the
 * game.
 * 
 * @author Marco Duran
 */
public class Aesthetic {
	protected String name;
	protected Color background;
	protected Color tileOne, tileTwo, tileThree, tileFour, tileFive, tileSix;
	protected Color target, nullTile, marked;

	/**
	 * Creates an Aesthetic instance with the specified name and Colors.
	 * 
	 * @param name
	 *            The name of the aesthetic.
	 * @param background
	 *            The background color of the aesthetic.
	 * @param tileOne
	 *            The color of tile one in the aesthetic.
	 * @param tileTwo
	 *            The color of tile two in the aesthetic.
	 * @param tileThree
	 *            The color of tile three in the aesthetic.
	 * @param tileFour
	 *            The color of tile four in the aesthetic.
	 * @param tileFive
	 *            The color of tile five in the aesthetic.
	 * @param tileSix
	 *            The color of tile six in the aesthetic.
	 * @param target
	 *            The color of the target tile in the aesthetic.
	 * @param nullTile
	 *            The color of the null tile in the aesthetic.
	 */
	public Aesthetic(String name, Color background, Color tileOne,
			Color tileTwo, Color tileThree, Color tileFour, Color tileFive,
			Color tileSix, Color target, Color nullTile) {
		this.name = name;
		this.background = background;
		this.tileOne = tileOne;
		this.tileTwo = tileTwo;
		this.tileThree = tileThree;
		this.tileFour = tileFour;
		this.tileFive = tileFive;
		this.tileSix = tileSix;
		this.target = target;
		this.nullTile = nullTile;
		this.marked = Color.GRAY;
	}

	/**
	 * Returns the name of the aesthetic
	 * 
	 * @return String name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns tile color one of the aesthetic.
	 * 
	 * @return Color for tile one
	 */
	public Color getTileOneColor() {
		return this.tileOne;
	}

	/**
	 * Returns tile color two of the aesthetic.
	 * 
	 * @return Color for tile two
	 */
	public Color getTileTwoColor() {
		return this.tileTwo;
	}

	/**
	 * Returns tile color three of the aesthetic.
	 * 
	 * @return Color for tile three
	 */
	public Color getTileThreeColor() {
		return this.tileThree;
	}

	/**
	 * Returns tile color four of the aesthetic.
	 * 
	 * @return Color for tile four
	 */
	public Color getTileFourColor() {
		return this.tileFour;
	}

	/**
	 * Returns tile color five of the aesthetic.
	 * 
	 * @return Color for tile five
	 */
	public Color getTileFiveColor() {
		return this.tileFive;
	}

	/**
	 * Returns tile color six of the aesthetic.
	 * 
	 * @return Color for tile six
	 */
	public Color getTileSixColor() {
		return this.tileSix;
	}

	/**
	 * Returns marked tile color of the aesthetic.
	 * 
	 * @return Color for marked tile
	 */
	public Color getMarkedColor() {
		return this.marked;
	}

	/**
	 * Returns target tile color of the aesthetic.
	 * 
	 * @return Color for target tile
	 */
	public Color getTargetColor() {
		return this.target;
	}

	/**
	 * Returns null tile color of the aesthetic.
	 * 
	 * @return Color for null tile
	 */
	public Color getNullTileColor() {
		return this.nullTile;
	}

	/**
	 * Returns background color of the aesthetic.
	 * 
	 * @return Color for background
	 */
	public Color getBackgroundColor() {
		return this.background;
	}
}
