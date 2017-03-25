package fr.imie.tetrisproject.tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import fr.imie.tetrisproject.dao.DaoFactory;
import fr.imie.tetrisproject.dao.HighscoreDao;
import fr.imie.tetrisproject.model.Highscore;
import fr.imie.tetrisproject.tetris.pieces.BarPiece;
import fr.imie.tetrisproject.tetris.pieces.BedLeftPiece;
import fr.imie.tetrisproject.tetris.pieces.BedRightPiece;
import fr.imie.tetrisproject.tetris.pieces.FatPiece;
import fr.imie.tetrisproject.tetris.pieces.MushroomPiece;
import fr.imie.tetrisproject.tetris.pieces.Piece;
import fr.imie.tetrisproject.tetris.pieces.SnakePiece;
import fr.imie.tetrisproject.tetris.pieces.ZnakePiece;

public class Game {

	private Boolean isTickPassed;
	
	private Piece actualPiece;	
	
	private int timeAccumulator = 0;
    private int tickLength = 1000;
    private int ticks = 0;
	
	private Random random;
	
	private Block[][] board;
	private int score;
	
	public Game(){
		random = new Random();
		board = new Block[10][20];
		pieceGenerator();
	}
	
	public void update(Input input, int delta, GameContainer gameContainer){
		boolean tickPassed = false;
        timeAccumulator += delta;
        
        if (timeAccumulator > tickLength) {
            tickPassed = true;
            ticks += 1;
            timeAccumulator -= tickLength;
        }

        if (input.isKeyPressed(Input.KEY_P)) {
			gameContainer.pause();
		} else if (gameContainer.isPaused() == true && input.isKeyPressed(Input.KEY_P)) {
			gameContainer.resume();
		}
        if (input.isKeyPressed(Input.KEY_LEFT)) {
            actualPiece.moveLeft(board);
        }
        if (input.isKeyPressed(Input.KEY_RIGHT)) {
            actualPiece.moveRight(board);
        }
        if (input.isKeyPressed(Input.KEY_DOWN)) {
            if (pieceCanBeDropped()) {
                gravity();
            }
        }
        if (input.isKeyPressed(Input.KEY_UP)) {
            actualPiece.Rotate(board);
        }

        if (tickPassed) {
            if (pieceCanBeDropped()) {
                gravity();
            } else {
                wipeLines();
                pieceGenerator();
            }
            /*if () {
				HighscoreDao highscoreDao;
				highscoreDao = DaoFactory.getHighscoreDao();
				highscoreDao.finalScore(score);
			}*/
        }
	}
	
	private void wipeLines() {	
        List<Integer> rowsToRemove = new ArrayList<Integer>();
        for (int y = 0; y < 20; y++) {
            boolean rowFull = true;
            for (int x = 0; x < 10; x++) {
                if (board[x][y] == null) {
                    rowFull = false;
                    break;
                }
            }
            if (rowFull) {
                rowsToRemove.add(y);
            }
        }
            
            score += rowsToRemove.size() * rowsToRemove.size();

            wipeLinesAndGravity(rowsToRemove);
        }
	
	private void wipeLinesAndGravity(List<Integer> rowsToRemove) {

        for (int y = 20 - 1; y >= 0; y--) {
            if (rowsToRemove.contains(y)) {
                for (int x = 0; x < 10; x++) {
                    board[x][y] = null;
                }
            } else {
                int numberOfRowsWiped = getNumberOfRowsWiped(y, rowsToRemove);
                if (numberOfRowsWiped > 0) {
                    for (int x = 0; x < 10; x++) {
                        board[x][y + numberOfRowsWiped] = board[x][y];
                        board[x][y] = null;
                    }
                }
            }
        }
    }
	
	private int getNumberOfRowsWiped(int row, List<Integer> rowsToRemove) {
        int number = 0;
        for (Integer removedRow : rowsToRemove) {
            if (removedRow > row) {
                number++;
            }
        }
        return number;
    }
	
	public void gravity(){
		Coordinates newCoord = new Coordinates(actualPiece.getCoordinates().getX(), actualPiece.getCoordinates().getY() + 1);
        actualPiece.setCoordinates(newCoord);
	}
	
	private boolean pieceCanBeDropped() {
        if (actualPiece.getCoordinates().getY() >= (20 - actualPiece.getHeight())) {
            return false;
        }

        Block[][] layout = actualPiece.getPieceContainer();
        for (int x = 0; x < layout.length; x++) {
            for (int y = 0; y < layout[0].length; y++) {
                if (layout[x][y] != null) {
                    int tankXCoord = actualPiece.getCoordinates().getX() + x;
                    int tankYCoord = actualPiece.getCoordinates().getY() + y;
                    if (board[tankXCoord][tankYCoord + 1] != null) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

	public void pieceGenerator(){
		int newPiece = random.nextInt(7);
		
		Coordinates startingPosition = new Coordinates(5,0);
		
		switch (newPiece) {
		case 0:
			actualPiece = new BarPiece(startingPosition);
			break;

		case 1:
			actualPiece = new BedLeftPiece(startingPosition);
			break;
			
		case 2:
			actualPiece = new BedRightPiece(startingPosition);
			break;

		case 3:
			actualPiece = new FatPiece(startingPosition);
			break;
		case 4:
			actualPiece = new MushroomPiece(startingPosition);
			break;
			
		case 5:
			actualPiece = new SnakePiece(startingPosition);
			break;

		case 6:
			actualPiece = new ZnakePiece(startingPosition);
			break;
			
		default:
			break;
		}
	}
	
	public Piece getActualPiece() {
        return actualPiece;
    }
	
	public int getTicks() {
        return ticks;
    }
	
	public Block[][] getBoard() {
        return board;
    }

    public int getScore() {
        return score;
    }
}
