package SixesWild.com.mimas.sixeswild.entities;

import java.awt.Color;

/**
 * Aesthetic defines a color scheme to be used throughout the game.
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
	 *            The color of the background.
	 * @param tileOne
	 *            The color of the one tile.
	 * @param tileTwo
	 *            The color of the two tile.
	 * @param tileThree
	 *            The color of the three tile.
	 * @param tileFour
	 *            The color of the four tile.
	 * @param tileFive
	 *            The color of the five tile.
	 * @param tileSix
	 *            The color of the six tile.
	 * @param target
	 *            The color of the target tile.
	 * @param nullTile
	 *            The color of the null tile.
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
		marked = Color.GRAY;
	}

	/**
	 * Returns the name of the aesthetic
	 *
	 * @return a String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the one tile color.
	 *
	 * @return a Color
	 */
	public Color getTileOneColor() {
		return tileOne;
	}

	/**
	 * Returns the two tile color.
	 *
	 * @return a Color
	 */
	public Color getTileTwoColor() {
		return tileTwo;
	}

	/**
	 * Returns the three tile color.
	 *
	 * @return a Color
	 */
	public Color getTileThreeColor() {
		return tileThree;
	}

	/**
	 * Returns the four tile color.
	 *
	 * @return a Color
	 */
	public Color getTileFourColor() {
		return tileFour;
	}

	/**
	 * Returns the five tile color.
	 *
	 * @return a Color
	 */
	public Color getTileFiveColor() {
		return tileFive;
	}

	/**
	 * Returns the six tile color.
	 *
	 * @return a Color
	 */
	public Color getTileSixColor() {
		return tileSix;
	}

	/**
	 * Returns the marked tile color.
	 *
	 * @return a Color
	 */
	public Color getMarkedColor() {
		return marked;
	}

	/**
	 * Returns the target tile color.
	 *
	 * @return a Color
	 */
	public Color getTargetColor() {
		return target;
	}

	/**
	 * Returns the null tile color.
	 *
	 * @return a Color
	 */
	public Color getNullTileColor() {
		return nullTile;
	}

	/**
	 * Returns the background color.
	 *
	 * @return a Color
	 */
	public Color getBackgroundColor() {
		return background;
	}
}
