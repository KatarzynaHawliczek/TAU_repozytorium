package com.hawliczek.tau.test.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import com.hawliczek.tau.domain.Game;
import com.hawliczek.tau.service.GameManagerImpl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteGameByIdStepdefs
{
	private GameManagerImpl gameManager = new GameManagerImpl();
	private List<Game> deletedGames;
	
	@Given("^the list of games$")
	public void the_list_of_games() throws Exception 
	{
		Game game1 = new Game(1, "Rise Of The Tomb Raider", "Akcja", "Crystal Dynamics", "Square Enix", "09-02-2016");
		Game game2 = new Game(2, "Car Mechanic Simulator 2018", "Symulacje", "Red Dot Games", "PlayWay", "28-07-2017");
		Game game3 = new Game(3, "Mafia III", "Akcja", "Hangar 13", "2K", "07-10-2016");
		Game game4 = new Game(4, "Subnautica", "Przygodowe", "Unknown Worlds Entertainment", "Unknown Worlds Entertainment", "23-01-2018");
		Game game5 = new Game(5, "The Witcher 3: Wild Hunt", "RPG", "CD Project RED", "CD Project RED", "18-05-2015");
		Game game6 = new Game(6, "Black Desert Online", "MMO", "Pearl Abyss", "Kakao Games Europe B.V.", "24-05-2017");
		
		gameManager.addGame(game1);
		gameManager.addGame(game2);
		gameManager.addGame(game3);
		gameManager.addGame(game4);
		gameManager.addGame(game5);
		gameManager.addGame(game6);
	}
	
	@When("^delete game by list of ids from (\\d+) to (\\d+)$")
	public void delete_game_is_by_list_of_ids(int id_from, int id_to) throws Exception
	{
		deletedGames = gameManager.deleteGameById(id_from, id_to);
	}

	@Then("^number of titles (\\d+) should be deleted$")
	public void number_of_titles_should_be_deleted(int titles) throws Exception
	{
		assertEquals(titles, deletedGames.size());
		assertNull(gameManager.getGameById(titles));
	}
}
