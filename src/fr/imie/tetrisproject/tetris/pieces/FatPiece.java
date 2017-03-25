package fr.imie.tetrisproject.tetris.pieces;

import org.newdawn.slick.Color;

import fr.imie.tetrisproject.tetris.Block;
import fr.imie.tetrisproject.tetris.Coordinates;
import fr.imie.tetrisproject.tetris.Rotations;

public class FatPiece extends Piece{

	private static final Color color = new Color(255,255,5);
	
	private static final Rotations[] rotations;
	
	@Override
	protected Rotations[] getRotations() {
		return null;
	}
	
	static{
		rotations = new Rotations[1];
	
		rotations[0] = new Rotations(new Block[][] {
			{null, new Block(color), new Block(color), null},
			{null, new Block(color), new Block(color), null},
			{null, null, null, null},
			{null, null, null, null},
		}, 2, 2);
	}
	
	public FatPiece(Coordinates coord){
		super(coord);
		
		this.pieceContainer = rotations[0].getBlock();
		this.height = rotations[0].getHeight();
		this.width = rotations[0].getWidth();
	}
	
	@Override
	public void Rotate(Block[][] board){
		
	}
}
