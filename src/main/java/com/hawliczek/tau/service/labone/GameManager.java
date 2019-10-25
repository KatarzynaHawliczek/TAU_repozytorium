package com.hawliczek.tau.service.labone;

import java.time.LocalDateTime;
import java.util.List;

import com.hawliczek.tau.domain.Game;

public interface GameManager
{
	public void addGame(Game game) throws Exception;
	public List<Game> getAllGames() throws Exception;
	public Game getGameById(int id) throws Exception;
	public void updateGame(Game game, int id) throws Exception;
	public void deleteGame(int id) throws Exception;
	
	public void setTimeOfLastReadingGame(Game game) throws Exception;
	public void setTimeOfAddingGame(Game game) throws Exception;
	public void setTimeOfUpdatingGame(Game game) throws Exception;
	
	public LocalDateTime getCurrentTime() throws Exception;
}
