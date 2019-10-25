package com.hawliczek.tau.service.labone;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.hawliczek.tau.domain.Game;

public class GameManagerImpl implements GameManager
{
	List<Game> gameList = new ArrayList<Game>();

	@Override
	public void addGame(Game game) throws Exception
	{
		setTimeOfAddingGame(game);
		gameList.add(game);
	}

	@Override
	public List<Game> getAllGames() throws Exception
	{
		for(Game game : gameList)
		{
			setTimeOfLastReadingGame(game);
		}
		return gameList;
	}

	@Override
	public Game getGameById(int id) throws Exception
	{
		for(Game game : gameList)
		{
			if(game.getId() == id)
			{
				setTimeOfLastReadingGame(game);
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
			
			setTimeOfUpdatingGame(gameToUpdate);
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
	public void setTimeOfLastReadingGame(Game game) throws Exception
	{
		game.setReadGameTime(getCurrentTime());
		
	}

	@Override
	public void setTimeOfAddingGame(Game game) throws Exception
	{
		game.setAddGameTime(getCurrentTime());
	}

	@Override
	public void setTimeOfUpdatingGame(Game game) throws Exception
	{
		game.setUpdateGameTime(getCurrentTime());
	}

	@Override
	public LocalDateTime getCurrentTime() throws Exception
	{
		return LocalDateTime.now();
	}

	@Override
	public Game getDateInfo(Game game) throws Exception
	{
		setTimeOfAddingGame(game);
		setTimeOfLastReadingGame(game);
		setTimeOfUpdatingGame(game);
		return game;
	}
}
