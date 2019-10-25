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
	
	public void setReadGameTime(Game game) throws Exception;
	public void setAddGameTime(Game game) throws Exception;
	public void setUpdateGameTime(Game game) throws Exception;
	
	public LocalDateTime getCurrentTime() throws Exception;
}
