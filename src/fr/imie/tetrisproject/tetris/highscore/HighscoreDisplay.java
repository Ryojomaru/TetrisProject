package fr.imie.tetrisproject.tetris.highscore;

import fr.imie.tetrisproject.dao.DaoFactory;
import fr.imie.tetrisproject.dao.HighscoreDao;

public class HighscoreDisplay {
	
	public static Object[] HighscoreDisplay(){
		HighscoreDao highscoreDao;
		highscoreDao = DaoFactory.getHighscoreDao();
		
		Object[] scores = highscoreDao.topScores().toArray();
		
		return scores;
	}
	
}
