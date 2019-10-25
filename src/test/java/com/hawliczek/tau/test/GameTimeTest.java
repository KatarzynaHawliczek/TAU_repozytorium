package com.hawliczek.tau.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
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
import com.hawliczek.tau.service.GameManagerImpl;

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
		verify(gameManager, atMost(1)).setTimeOfAddingGame(game1);
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
		
		verify(gameManager, atLeastOnce()).setTimeOfUpdatingGame(game2);
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
		
		//verify(gameManager, never()).deleteGame(3);
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
			verify(gameManager, atLeast(1)).setTimeOfLastReadingGame(game);
			Assert.assertNotNull(game.getReadGameTime());
		}
	}
	
	@Test
	public void getDateInfoMethodShouldGetDateInformationsOfAGame() throws Exception
	{
		GameManagerImpl gameManager = spy(GameManagerImpl.class);
		
		when((gameManager).getCurrentTime()).thenReturn(mockTime);
		Game game7 = new Game(7, "The Elder Scrolls V: Skyrim Special Edition", "RPG", "Bethesda", "Bethesda Softworks", "28-10-2016");
		gameManager.addGame(game7);
		
		Game testGame = gameManager.getGameById(7);
		testGame.setDeveloper("Bethesda Game Studios");
		gameManager.updateGame(testGame, 7);
		Game testedGame = gameManager.getGameById(7);		
		
		verify(gameManager, atMost(1)).getTimeInfo(testedGame);
		
		Assert.assertNotNull(testedGame.getReadGameTime());
		Assert.assertNotNull(testedGame.getAddGameTime());
		Assert.assertNotNull(testedGame.getUpdateGameTime());
	}
	
	@Test
	public void testOnlyMethod() throws Exception
	{
        GameManagerImpl gameManager = spy(GameManagerImpl.class);
		
		when((gameManager).getCurrentTime()).thenReturn(mockTime);
		Game testGame = mock(Game.class);
		testGame.setTitle("Perfect World International");
		
		verify(testGame, only()).setTitle("Perfect World International");
		
		Assert.assertNotNull(testGame.getTitle(), "Perfect World International");
	}
	
	@Test
	public void setSaveAddGameTimeMethodShouldSwitchOn() throws Exception
	{
		GameManagerImpl gameManager = spy(GameManagerImpl.class);
		
		when((gameManager).getCurrentTime()).thenReturn(mockTime);
		gameManager.setSaveAddGameTime(true);
		Game game8 = new Game(8, "Heroes of Might & Magic III - HD Edition", "Strategia", "Dotemu", "Ubisoft Entertainment", "29-01-2015");
		gameManager.addGame(game8);
		
		verify(gameManager, atLeastOnce()).isSaveAddGameTime();
		verify(gameManager, times(1)).setTimeOfAddingGame(game8);
		
		Assert.assertNotNull(game8.getAddGameTime());
		assertEquals(mockTime, game8.getAddGameTime());
	}
	
	@Test
	public void setSaveAddGameTimeMethodShouldSwitchOff() throws Exception
	{
		GameManagerImpl gameManager = spy(GameManagerImpl.class);
		
		when((gameManager).getCurrentTime()).thenReturn(mockTime);
		gameManager.setSaveAddGameTime(false);
		Game game9 = new Game(9, "Far Cry Primal", "Akcja", "Ubisoft", "Ubisoft", "01-03-2016");
		gameManager.addGame(game9);
		
		verify(gameManager, atLeastOnce()).isSaveAddGameTime();
		verify(gameManager, never()).setTimeOfAddingGame(game9);
		
		Assert.assertNull(game9.getAddGameTime());
		assertEquals(null, game9.getAddGameTime());
	}
	
	@Test
	public void setSaveUpdateGameTimeMethodShouldSwitchOn() throws Exception
	{
		GameManagerImpl gameManager = spy(GameManagerImpl.class);
		
		when((gameManager).getCurrentTime()).thenReturn(mockTime);
		gameManager.setSaveUpdateGameTime(true);
		Game game10 = new Game(10, "Fishing Planet", "Symulacje", "Fishing Planet LLC", "Fishing Planet", "11-08-2015");
		gameManager.addGame(game10);
		game10.setPublisher("Fishing Planet LLC");
		gameManager.updateGame(game10, 10);
		
		verify(gameManager, atLeastOnce()).isSaveUpdateGameTime();
		verify(gameManager, times(1)).setTimeOfUpdatingGame(game10);
		
		Assert.assertNotNull(game10.getUpdateGameTime());
		assertEquals(mockTime, game10.getUpdateGameTime());
	}
	
	@Test
	public void setSaveUpdateGameTimeMethodShouldSwitchOff() throws Exception
	{
		GameManagerImpl gameManager = spy(GameManagerImpl.class);
		
		when((gameManager).getCurrentTime()).thenReturn(mockTime);
		gameManager.setSaveUpdateGameTime(false);
		Game game11 = new Game(11, "Assassin's Creed Origins", "Akcja", "Ubisoft", "Ubisoft", "27-10-2017");
		gameManager.addGame(game11);
		game11.setDeveloper("Ubisoft Montreal");
		gameManager.updateGame(game11, 11);
		
		verify(gameManager, atLeastOnce()).isSaveUpdateGameTime();
		verify(gameManager, never()).setTimeOfUpdatingGame(game11);
		
		Assert.assertNull(game11.getUpdateGameTime());
		assertEquals(null, game11.getUpdateGameTime());
	}
	
	@Test
	public void setSaveReadGameTimeMethodShouldSwitchOn() throws Exception
	{
		GameManagerImpl gameManager = spy(GameManagerImpl.class);
		
		when((gameManager).getCurrentTime()).thenReturn(mockTime);
		gameManager.setSaveReadGameTime(true);
		Game game12 = new Game(12, "Black Desert Online", "MMO", "Pearl Abyss", "Kakao Games Europe B.V.", "24-05-2017");
		gameManager.addGame(game12);
		Game readGame = gameManager.getGameById(12);
		
		verify(gameManager, atLeastOnce()).isSaveReadGameTime();
		verify(gameManager, times(1)).setTimeOfLastReadingGame(game12);
		
		Assert.assertNotNull(readGame.getReadGameTime());
		assertEquals(mockTime, readGame.getReadGameTime());
	}
	
	@Test
	public void setSaveReadGameTimeMethodShouldSwitchOff() throws Exception
	{
		GameManagerImpl gameManager = spy(GameManagerImpl.class);
		
		when((gameManager).getCurrentTime()).thenReturn(mockTime);
		gameManager.setSaveReadGameTime(false);
		Game game13 = new Game(13, "MudRunner", "Symulacje", "Saber Interactive", "Focus Home Interactive", "31-10-2017");
		gameManager.addGame(game13);
		Game readGame = gameManager.getGameById(13);
		
		verify(gameManager, atLeastOnce()).isSaveReadGameTime();
		verify(gameManager, never()).setTimeOfLastReadingGame(game13);
		
		Assert.assertNull(readGame.getReadGameTime());
		assertEquals(null, readGame.getReadGameTime());
	}
}
