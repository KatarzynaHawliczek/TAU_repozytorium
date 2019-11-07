Feature: Select game by genre
  By selecting a game by genre I should get a game title with given genre.

  Scenario: I get game title: Black Desert Online with genre: MMO
    Given list of games
    When game is selected by "MMO"
    Then the result should be "Black Desert Online"
