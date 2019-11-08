Feature: Select games by genre
  By selecting a game by genre I should get a list of games titles with given genre.

  Scenario Outline: I get games with given genre
    Given list of games
    When game is selected by "<genre>"
    Then the result should be a list of games with "<title>"
    
    Examples:
      | genre     | title                       |
      | MMO       | Black Desert Online         |
      | Symulacje | Car Mechanic Simulator 2018 |  
      | Akcja     | Rise Of The Tomb Raider     |
      | Akcja     | Mafia III                   |
