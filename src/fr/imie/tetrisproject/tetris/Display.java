package fr.imie.tetrisproject.tetris;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import fr.imie.tetrisproject.tetris.pieces.Piece;

public class Display {
	
	private int blockSize = 20;

	public void display(Game game, GameContainer gameContainer, Graphics graphic){
		graphic.setBackground(Color.white);;;
		
		Piece piece = game.getActualPiece();
        Coordinates coordinates = piece.getCoordinates();
        Block[][] layout = piece.getPieceContainer();
        for (int x = 0; x < layout.length; x++) {
            for (int y = 0; y < layout[0].length; y++) {
                if (layout[x][y] != null) {
                    int xRenderCoord = blockSize * (coordinates.getX() + x);
                    int yRenderCoord = blockSize * (coordinates.getY() + y);
                    graphic.setColor(layout[x][y].getColor());
                    graphic.fill(new Rectangle(xRenderCoord, yRenderCoord, blockSize, blockSize));
                }
            }
        }
		
        for (int x = 0; x < game.getBoard().length; x++) {
            for (int y = 0; y < game.getBoard()[0].length; y++) {
                if (game.getBoard()[x][y] != null) {
                    int xRenderCoord = blockSize * x;
                    int yRenderCoord = blockSize * y;
                    graphic.setColor(game.getBoard()[x][y].getColor());
                    graphic.fill(new Rectangle(xRenderCoord, yRenderCoord, blockSize, blockSize));
                }
            }
        }
		graphic.setColor(Color.black);
		graphic.drawRect(0, 0, 10 * blockSize , 20 * blockSize);
		
		graphic.drawString("Score: " + game.getScore(), 250, 40);
	}
}
