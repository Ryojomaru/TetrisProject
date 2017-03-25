package fr.imie.tetrisproject.tetris;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Tetris extends BasicGame{

	private Game game;
	private Display display;
	
	public Tetris() {
		super("TetrisProject");
	}

	@Override
	public void init(GameContainer gameContainer) throws SlickException {
		game = new Game();
		display = new Display();
		gameContainer.setShowFPS(false);
	}	

	@Override
	public void update(GameContainer gameContainer, int delta) throws SlickException {
		game.update(gameContainer.getInput(), delta, gameContainer);
	}
	
	@Override
	public void render(GameContainer gameContainer, Graphics graphic) throws SlickException {
		display.display(game, gameContainer, graphic);
	}

}
