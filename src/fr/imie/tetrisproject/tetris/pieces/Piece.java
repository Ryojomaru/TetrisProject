package fr.imie.tetrisproject.tetris.pieces;

import fr.imie.tetrisproject.tetris.Block;
import fr.imie.tetrisproject.tetris.Coordinates;
import fr.imie.tetrisproject.tetris.Rotations;

public abstract class Piece {
	
	protected Block[][] pieceContainer;
	protected Coordinates coord;
	
	protected int height;
	protected int width;
	
	protected abstract Rotations[] getRotations();
	
	public Piece(Coordinates coord){
		this.coord = coord;
		this.pieceContainer = new Block[4][4];
	}
	
}
