package fr.imie.tetrisproject.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcDao {

	private Connection connection;
	
	protected JdbcDao(Connection connection){
		this.connection = connection;
	}
	
	public Connection getConnection(){
		return connection;
	}
	
	public void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("A wild exception appeared !");
		}
	}
}