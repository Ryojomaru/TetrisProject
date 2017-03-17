package fr.imie.tetrisproject.tetris;

public class Rotations {

	private Block[][] block;
    private int height;
    private int width;

    public Rotations(Block[][] block, int height, int length) {
        this.block = block;
        this.height = height;
        this.width = length;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Block[][] getBlock() {
        return block;
    }
	
}
