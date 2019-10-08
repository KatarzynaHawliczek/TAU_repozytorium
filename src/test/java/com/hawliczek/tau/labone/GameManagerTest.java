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
		assertEquals(game1, gameManager.getGameById(1));
	}
	
	@Test
	public void getGameByIdMethodShouldReturnAGameWithGivenId()
	{
		GameManagerImpl gameManager = new GameManagerImpl();
		Game game2 = new Game(2, "The Witcher 3: Wild Hunt ", "RPG", "CD Project RED", "CD Project RED", "18-05-2015");
		gameManager.addGame(game2);
		assertEquals(game2, gameManager.getGameById(2));
	}
}
