package SixesWild.com.mimas.sixeswild.entities;

import java.awt.Color;
/**
 * 
 * @author Marco Duran
 *
 */
public class Aesthetic {
	Color background;
	Color tileOne, tileTwo, tileThree,
		  tileFour, tileFive, tileSix;
	
	/** Constructor for the aesthetic */
	public Aesthetic(Color background, Color tileOne, Color tileTwo, Color tileThree, Color tileFour, Color tileFive, Color tileSix){
		this.background = background;
		this.tileOne = tileOne;
		this.tileTwo = tileTwo;
		this.tileThree = tileThree;
		this.tileFour = tileFour;
		this.tileFive = tileFive;
		this.tileSix = tileSix;
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
	
	/** Receives the color for tile one */
	public Color getBackgroundColor(){
		return this.background;
	}
	
}
