package com.hawliczek.tau.labone.service;

import java.util.List;

import com.hawliczek.tau.labone.domain.Game;

public interface GameManager
{
	public void addGame(Game game);
	public List<Game> getAllGames();
	public Game getGameById(int id);
	public void updateGame(Game game, int id);
	public void deleteGame(Game game);
}
