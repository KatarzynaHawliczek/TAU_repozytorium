package com.hawliczek.tau.labone;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.hawliczek.tau.labone.domain.Game;
import com.hawliczek.tau.labone.service.GameManagerImpl;

@RunWith(JUnit4.class)
public class GameManagerTest
{
	@Test
	public void emptyTest()
	{
		Assert.assertTrue(true);
	}
	
	@Test
	public void addGameMethodShouldAddAGame()
	{
		GameManagerImpl gameManager = new GameManagerImpl();
		Game game1 = new Game(1, "Rise Of The Tomb Raider", "Akcja", "Crystal Dynamics", "Square Enix", "09-02-2016");
		gameManager.addGame(game1);
      	assertEquals(game1.getTitle(), gameManager.getGameById(1).getTitle());
	}
	
	@Test
	public void getGameByIdMethodShouldReturnAGameWithGivenId()
	{
		GameManagerImpl gameManager = new GameManagerImpl();
		Game game2 = new Game(2, "The Witcher 3: Wild Hunt", "RPG", "CD Project RED", "CD Project RED", "18-05-2015");
		gameManager.addGame(game2);
		assertEquals(2, gameManager.getGameById(2).getId());
	}
	
	@Test
	public void getAllGamesMethodShouldReturnAllGamesFromTheList()
	{
		GameManagerImpl gameManager = new GameManagerImpl();
		Game game3 = new Game(3, "Mafia III", "Akcja", "Hangar 13", "2K", "07-10-2016");
		Game game4 = new Game(4, "Grand Theft Auto V", "Akcja", "Rockstar North", "Rockstar Games", "14-04-2015");
		gameManager.addGame(game3);
		gameManager.addGame(game4);
		assertNotNull(gameManager.getAllGames());
	}
}
