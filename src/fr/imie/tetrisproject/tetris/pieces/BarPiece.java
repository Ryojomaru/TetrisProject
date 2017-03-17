package fr.imie.tetrisproject.tetris.pieces;



import org.newdawn.slick.Color;

import fr.imie.tetrisproject.tetris.Block;
import fr.imie.tetrisproject.tetris.Coordinates;
import fr.imie.tetrisproject.tetris.Rotations;

public class BarPiece extends Piece{

	private static final Color color = new Color(90,240,255);
	
	private static final Rotations[] rotations;
	
	@Override
	protected Rotations[] getRotations(){
		return rotations;
	}
	
	static{
		rotations = new Rotations[2];
		
		rotations[0] = new Rotations(new Block[][] {
			{new Block(color), null, null, null},
            {new Block(color), null, null, null},
            {new Block(color), null, null, null},
            {new Block(color), null, null, null},
		}, 4, 1);
		
		rotations[1] = new Rotations(new Block[][] {
			{new Block(color), new Block(color), new Block(color), new Block(color)},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
		}, 1, 4);
	}
	
	public BarPiece(Coordinates coord){
		super(coord);
		
		this.pieceContainer = rotations[0].getBlock();
        this.height = rotations[0].getHeight();
        this.width = rotations[0].getWidth();
	}
	
}
