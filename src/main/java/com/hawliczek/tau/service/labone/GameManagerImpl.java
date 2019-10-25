package com.hawliczek.tau.service.labone;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.hawliczek.tau.domain.Game;

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
			throw new Exception("Gry o id = " + id + " nie znaleziono");
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

	@Override
	public void setReadGameTime(Game game) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAddGameTime(Game game) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateGameTime(Game game) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public LocalDateTime getCurrentTime() throws Exception
	{
		return LocalDateTime.now();
	}
}
