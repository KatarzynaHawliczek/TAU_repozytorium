package com.hawliczek.tau.web;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hawliczek.tau.domain.JMGame;
import com.hawliczek.tau.service.JMGameManager;

@RestController
public class GameApi
{
	@Autowired
	JMGameManager gameManager;
	
	@RequestMapping("/")
	public String index()
	{
		return "Just checking if everything works.";
	}
	
	@RequestMapping(value="/game/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JMGame getGameById(@PathVariable("id") int id) throws SQLException
	{
		return gameManager.getGameById(id);
	}
	
	@RequestMapping(value="/games", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<JMGame> getAllGames(@RequestParam(value="filter", required=false) String f) throws SQLException
	{
		List<JMGame> games = new LinkedList<JMGame>();
		for(JMGame g : gameManager.getAllGames())
		{
			if(f == null)
			{
				games.add(g);
			}
			else if(g.getTitle().contains(f))
			{
				games.add(g);
			}
		}
		return games;
	}
	
	@RequestMapping(value="/game", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public JMGame addGame(@RequestBody JMGame game)
	{
		if(gameManager.addGame(game) < 1)
		{
			return null;
		}
		return game;
	}
	
	@RequestMapping(value="/game/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public int deleteGame(@PathVariable("id") int id) throws SQLException
	{
		return new Integer(gameManager.deleteGame(gameManager.getGameById(id)));
	}
	
	@RequestMapping(value="/game/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public int updateGame(@RequestBody JMGame game) throws SQLException
	{
		return gameManager.updateGame(game);
	}

	@RequestMapping(value="/game")
	public int deleteAllGames()
	{
		return gameManager.deleteAll();
	}
}