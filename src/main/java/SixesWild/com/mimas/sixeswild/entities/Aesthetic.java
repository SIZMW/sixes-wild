package SixesWild.com.mimas.sixeswild.entities;

import java.awt.Color;
/**
 * 
 * @author Marco Duran
 *
 */
public class Aesthetic {
	String name;
	Color background;
	Color tileOne, tileTwo, tileThree,
		  tileFour, tileFive, tileSix;
	Color target, nullTile, marked;
	
	/** Constructor for the aesthetic */
	public Aesthetic(String name, Color background, Color tileOne, Color tileTwo,
					Color tileThree, Color tileFour, Color tileFive, Color tileSix,
					Color target, Color nullTile){
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
	/** Receives the name of the aesthetic */
	public String getName(){
		return this.name;
	}
	
	/** Receives the color for tile one */
	public Color getTileOneColor(){
		return this.tileOne;
	}
	
	/** Receives the color for tile two */
	public Color getTileTwoColor(){
		return this.tileTwo;
	}
	
	/** Receives the color for tile three */
	public Color getTileThreeColor(){
		return this.tileThree;
	}
	
	/** Receives the color for tile four */
	public Color getTileFourColor(){
		return this.tileFour;
	}
	
	/** Receives the color for tile five */
	public Color getTileFiveColor(){
		return this.tileFive;
	}
	
	/** Receives the color for tile six */
	public Color getTileSixColor(){
		return this.tileSix;
	}
	
	/** Receives the color for marked tile */
	public Color getMarkedColor(){
		return this.marked;
	}
	
	/** Receives the color for target tile */
	public Color getTargetColor(){
		return this.target;
	}
	
	/** Receives the color for null tile */
	public Color getNullTileColor(){
		return this.nullTile;
	}
	/** Receives the color for tile one */
	public Color getBackgroundColor(){
		return this.background;
	}
	
}