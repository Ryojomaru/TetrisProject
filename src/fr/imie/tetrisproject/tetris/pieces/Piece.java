package fr.imie.tetrisproject.tetris.pieces;

import fr.imie.tetrisproject.tetris.Block;
import fr.imie.tetrisproject.tetris.Coordinates;
import fr.imie.tetrisproject.tetris.Game;
import fr.imie.tetrisproject.tetris.Rotations;

public abstract class Piece {
	
	protected Block[][] pieceContainer;
	protected Coordinates coordinates;
	
	protected int height;
	protected int width;
	
	private int actualRotation = 0;
	
	protected abstract Rotations[] getRotations();
	
	public Piece(Coordinates coordinates){
		this.coordinates = coordinates;
		this.pieceContainer = new Block[4][4];
	}
	
	public void Rotate(Block[][] board) {
        int nextRotation = actualRotation < getRotations().length - 1 ? actualRotation + 1 : 0;
        Block[][] nextBoard = getRotations()[nextRotation].getBlock();

        for (int x = 0; x < nextBoard.length; x++) {
            for (int y = 0; y < nextBoard[0].length; y++) {
                if (nextBoard[x][y] != null) {
                    int tankXCoord = coordinates.getX() + x;
                    int tankYCoord = coordinates.getY() + y;
                    if (tankXCoord >= 10 || tankYCoord >= 20 - 1 || board[tankXCoord][tankYCoord] != null) {
                        return;
                    }
                }
            }
        }

        this.actualRotation = nextRotation;
        this.pieceContainer = getRotations()[actualRotation].getBlock();
        this.height = getRotations()[actualRotation].getHeight();
        this.width = getRotations()[actualRotation].getWidth();
    }
    
    public void moveRight(final Block[][] board) {
        if (coordinates.getX() >= (10 - width)) {
            return;
        }

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] != null) {
                    int tankXCoord = coordinates.getX() + x;
                    int tankYCoord = coordinates.getY() + y;
                    if (board[tankXCoord + 1][tankYCoord] != null) {
                        return;
                    }
                }
            }
        }
        coordinates = new Coordinates(getCoordinates().getX() + 1, getCoordinates().getY());
    }
    
    public void moveLeft(final Block[][] board) {
        if (coordinates.getX() <= 0) {
            return;
        }

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] != null) {
                    int tankXCoord = coordinates.getX() + x;
                    int tankYCoord = coordinates.getY() + y;
                    if (board[tankXCoord - 1][tankYCoord] != null) {
                        return;
                    }
                }
            }
        }

        coordinates = new Coordinates(coordinates.getX() - 1, coordinates.getY());
    }

	
	public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates newCoordinates) {
        this.coordinates = newCoordinates;
    }
    
    public Block[][] getPieceContainer() {
        return pieceContainer;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
