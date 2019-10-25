package com.hawliczek.tau.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

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
	public void setReadGameTimeMethodShouldSetDateWhenAddsAGame() throws Exception
	{
		GameManagerImpl gameManager = spy(GameManagerImpl.class);
		
		when((gameManager).getCurrentTime()).thenReturn(mockTime);
		Game game1 = new Game(1, "Rise Of The Tomb Raider", "Akcja", "Crystal Dynamics", "Square Enix", "09-02-2016");
		gameManager.addGame(game1);
		
		Game game2 = gameManager.getGameById(1);
		verify(gameManager, times(1)).setAddGameTime(game1);
		Assert.assertNotNull(game2.getAddGameTime());
	}		
}
