package fr.imie.tetrisproject.dao;

import fr.imie.tetrisproject.dao.jdbc.JdbcHighscoreDao;
import fr.imie.tetrisproject.util.ConnectionManager;

public class DaoFactory {

	private DaoFactory() {
    }

    public static HighscoreDao getHighscoreDao() {
        return new JdbcHighscoreDao(ConnectionManager.getConnection());
    }

}
