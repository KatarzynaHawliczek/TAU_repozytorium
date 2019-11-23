package com.hawliczek.tau.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hawliczek.tau.domain.JMGame;

public interface JMGameManager
{
	public Connection getConnection();
	public void setConnection(Connection connection) throws SQLException;
	public int addGame(JMGame game);
	public int deleteGame(JMGame game);
	public int updateGame(JMGame game) throws SQLException;
	public JMGame getGameById(int id) throws SQLException;
	public int deleteAll();
	public List<JMGame> getAllGames();
}
