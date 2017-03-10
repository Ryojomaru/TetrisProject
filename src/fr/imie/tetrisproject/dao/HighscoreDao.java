package fr.imie.tetrisproject.dao;

import java.util.List;

import fr.imie.tetrisproject.model.Highscore;

public interface HighscoreDao {

	void finalScore(Highscore highscore);
	List<Highscore> topScores();
}
