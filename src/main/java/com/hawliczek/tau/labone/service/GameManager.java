package com.hawliczek.tau.labone.service;

import java.util.List;

import com.hawliczek.tau.labone.domain.Game;

public interface GameManager
{
	public void addGame(Game game);
	public List<Game> getAllGames() throws Exception;
	public Game getGameById(int id) throws Exception;
	public void updateGame(Game game, int id) throws Exception;
	public void deleteGame(int id) throws Exception;
}
