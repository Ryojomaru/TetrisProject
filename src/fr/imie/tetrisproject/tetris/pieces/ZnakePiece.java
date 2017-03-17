package fr.imie.tetrisproject.tetris.pieces;

import org.newdawn.slick.Color;

import fr.imie.tetrisproject.tetris.Block;
import fr.imie.tetrisproject.tetris.Coordinates;
import fr.imie.tetrisproject.tetris.Rotations;

public class ZnakePiece extends Piece{

	private static final Color color = new Color(255,30,30);
	
	private static final Rotations[] rotations;
	
	@Override
	protected Rotations[] getRotations(){
		return rotations;
	}
	
	static {
        rotations = new Rotations[2];
        //Inner arrays are the columns (vertical) - read as rotated by 90 degrees clockwise
        rotations[0] = new Rotations(new Block[][] {
                {null,             new Block(color), new Block(color), null},
                {new Block(color), new Block(color), null, null},
                {null, null, null, null},
                {null, null, null, null},
        }, 3, 2);
        rotations[1] = new Rotations(new Block[][] {
                {new Block(color), null, null, null},
                {new Block(color), new Block(color), null, null},
                {null,             new Block(color),        null, null},
                {null, null, null, null},
        }, 2, 3);
    }
	
	public ZnakePiece(Coordinates coord){
		super(coord);
		
		this.pieceContainer = rotations[0].getBlock();
        this.height = rotations[0].getHeight();
        this.width = rotations[0].getWidth();
	}
}
