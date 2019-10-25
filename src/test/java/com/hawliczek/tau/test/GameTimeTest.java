package com.hawliczek.tau.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import com.hawliczek.tau.domain.Game;
import com.hawliczek.tau.service.labone.GameManagerImpl;

@RunWith(JUnit4.class)
public class GameTimeTest
{
	@Mock
	LocalDateTime mockTime = LocalDateTime.of(2009,  9, 13, 12, 30);
	
	@Before
	public void doBeforeEachTest()
	{
		assertNotNull(mockTime);
	}
	
	@Test
	public void setTimeOfAddingGameMethodShouldSetDateWhenAddsAGame() throws Exception
	{
		GameManagerImpl gameManager = spy(GameManagerImpl.class);
		
		when((gameManager).getCurrentTime()).thenReturn(mockTime);
		Game game1 = new Game(1, "Rise Of The Tomb Raider", "Akcja", "Crystal Dynamics", "Square Enix", "09-02-2016");
		gameManager.addGame(game1);
		
		Game addedGame = gameManager.getGameById(1);
		verify(gameManager, times(1)).setTimeOfAddingGame(game1);
		Assert.assertNotNull(addedGame.getAddGameTime());
	}
	
	@Test
	public void setTimeOfUpdatingGameMethodShouldSetDateWhenUpdatesAGame() throws Exception
	{
		GameManagerImpl gameManager = spy(GameManagerImpl.class);
		
		when((gameManager).getCurrentTime()).thenReturn(mockTime);
		Game game2 = new Game(2, "Car Mechanic Simulator 2018", "Symulacje", "Red Dot Games", "PlayWay", "28-07-2017");
		gameManager.addGame(game2);
		
		game2.setPublisher("PlayWay S.A.");
		gameManager.updateGame(game2, 2);
		
		verify(gameManager, times(1)).setTimeOfUpdatingGame(game2);
		Assert.assertNotNull(game2.getUpdateGameTime());
	}
	
	@Test
	public void setTimeOfLastReadingGameMethodShouldSetDateWhenReadsAGameById() throws Exception
	{
		GameManagerImpl gameManager = spy(GameManagerImpl.class);
		
		when((gameManager).getCurrentTime()).thenReturn(mockTime);
		Game game3 = new Game(3, "Mafia III", "Akcja", "Hangar 13", "2K", "07-10-2016");
		gameManager.addGame(game3);
		
		Game readGame = gameManager.getGameById(3);
		
		verify(gameManager, times(1)).setTimeOfLastReadingGame(readGame);
		Assert.assertNotNull(readGame.getReadGameTime());
	}
	
	@Test
	public void setTimeOfLastReadingGameMethodShouldSetDateWhenReadsAllGames() throws Exception
	{
        GameManagerImpl gameManager = spy(GameManagerImpl.class);
		
		when((gameManager).getCurrentTime()).thenReturn(mockTime);
		Game game4 = new Game(4, "Grand Theft Auto V", "Akcja", "Rockstar North", "Rockstar Games", "14-04-2015");
		Game game5 = new Game(5, "Subnautica", "Przygodowe", "Unknown Worlds Entertainment", "Unknown Worlds Entertainment", "23-01-2018");
		Game game6 = new Game(6, "The Witcher 3: Wild Hunt", "RPG", "CD Project RED", "CD Project RED", "18-05-2015");
		gameManager.addGame(game4);
		gameManager.addGame(game5);
		gameManager.addGame(game6);
		
		List<Game> games = gameManager.getAllGames();
		for(Game game : games)
		{
			verify(gameManager, times(1)).setTimeOfLastReadingGame(game);
			Assert.assertNotNull(game.getReadGameTime());
		}
	}
}
