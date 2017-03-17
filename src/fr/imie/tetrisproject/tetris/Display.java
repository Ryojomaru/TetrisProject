package fr.imie.tetrisproject.tetris;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Display {
	
	private int blockSize = 20;

	public void display(Game game, GameContainer gameContainer, Graphics graphic){
		graphic.setColor(Color.white);
		graphic.drawRect(0, 0, 10 * blockSize , 20 * blockSize);
		
		graphic.drawString("Time: " , 250, 10);
        graphic.drawString("Score: " , 250, 40);
	}
}
