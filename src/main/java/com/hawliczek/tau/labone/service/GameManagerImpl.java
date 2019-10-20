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
	public List<Game> getAllGames() throws Exception
	{
		return gameList;
	}

	@Override
	public Game getGameById(int id) throws Exception
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
	public void updateGame(Game game, int id) throws Exception
	{
		Game gameToUpdate = getGameById(game.getId());
		if(gameToUpdate != null)
		{
			gameToUpdate.setTitle(game.getTitle());
			gameToUpdate.setGenre(game.getGenre());
			gameToUpdate.setDeveloper(game.getDeveloper());
			gameToUpdate.setPublisher(game.getPublisher());
			gameToUpdate.setReleaseDate(game.getReleaseDate());
		}
		else
		{
			//rzucić wyjątek
		}
	}

	@Override
	public void deleteGame(int id) throws Exception
	{
		Game game = getGameById(id);
		if(game != null)
		{
			gameList.remove(game);
		}
	}
}
