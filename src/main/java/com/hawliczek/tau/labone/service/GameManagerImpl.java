package com.hawliczek.tau.labone.service;

import java.util.ArrayList;
import java.util.List;

import com.hawliczek.tau.labone.domain.Game;

public class GameManagerImpl implements GameManager
{
	List<Game> gameList = new ArrayList<Game>();

	@Override
	public void addGame(Game game)
	{
		gameList.add(game);
	}

	@Override
	public List<Game> getAllGames()
	{
		return null;
	}

	@Override
	public Game getGameById(int id)
	{
		for(Game game : gameList)
		{
			if(game.getId() == id)
			{
				return game;
			}
		}
		return null;
	}

	@Override
	public void updateGame(Game game, int id)
	{
		
	}

	@Override
	public void deleteGame(Game game)
	{
		
	}
}
