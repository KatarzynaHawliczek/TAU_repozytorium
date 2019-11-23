package com.hawliczek.tau.test.rest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hawliczek.tau.domain.JMGame;
import com.hawliczek.tau.service.JMGameManager;
import com.hawliczek.tau.service.JMGameManagerImpl;

public class JMeterGameManagerTest
{
	JMGameManager gameManager;
	
	private final static String TITLE = "game";
	private final static String GENRE = "genre";
	private final static String DEVELOPER = "developer";
	private final static String PUBLISHER = "publisher";
	private final static String RELEASEDATE = "date";
	
	@Before
	public void setup() throws SQLException
	{
		gameManager = new JMGameManagerImpl();
	}
	
	@After
	public void cleanup() throws SQLException
	{
		
	}
	
	@Test
	public void checkConnection()
	{
		assertNotNull(gameManager.getConnection());
	}
	
	@Test
	public void checkAdding() throws SQLException
	{
		JMGame game = new JMGame();
		game.setTitle(TITLE);
		game.setGenre(GENRE);
		game.setDeveloper(DEVELOPER);
		game.setPublisher(PUBLISHER);
		game.setReleaseDate(RELEASEDATE);
		
		gameManager.deleteAll();
		assertEquals(1, gameManager.addGame(game));
		
		List<JMGame> games = gameManager.getAllGames();
		JMGame gameRetrieved = games.get(0);
		
		assertEquals(TITLE, gameRetrieved.getTitle());
		assertEquals(GENRE, gameRetrieved.getGenre());
		assertEquals(DEVELOPER, gameRetrieved.getDeveloper());
		assertEquals(PUBLISHER, gameRetrieved.getPublisher());
		assertEquals(RELEASEDATE, gameRetrieved.getReleaseDate());
	}
}
