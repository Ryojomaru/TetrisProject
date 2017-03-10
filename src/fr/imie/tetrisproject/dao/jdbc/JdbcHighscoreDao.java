package fr.imie.tetrisproject.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.imie.tetrisproject.dao.HighscoreDao;
import fr.imie.tetrisproject.model.Highscore;

public class JdbcHighscoreDao extends JdbcDao implements HighscoreDao{

	public JdbcHighscoreDao(Connection connection) {
		super(connection);
	}

	@Override
	public void finalScore(Highscore highscore) {
		try (PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO score(score,name) VALUES (?,?)")){
			stmt.setInt(1, highscore.getScore());
			stmt.setString(2, highscore.getName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("A wild exception appeared !");
		}
	}

	@Override
	public List<Highscore> topScores() {
		try (PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM score ORDER BY score DESC LIMIT 5")){
			List<Highscore> highscores = new ArrayList<>();
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				highscores.add(toHighscore(result));
			}
			return highscores;
		} catch (SQLException e) {
			throw new RuntimeException("A Wild exception appeared !");
		}
	}
	
	private Highscore toHighscore (ResultSet resultSet) throws SQLException{
		Highscore highscore = new Highscore();
		highscore.setId(resultSet.getInt(1));
		highscore.setScore(resultSet.getInt(2));
		highscore.setName(resultSet.getString(3));
		return highscore;
	}

}
