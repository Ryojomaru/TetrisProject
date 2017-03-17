package fr.imie.tetrisproject.tetris;

import org.newdawn.slick.Color;

public class Block {

	private Color color;
	
	public Block(Color color){
		this.color = color;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}
	
}
