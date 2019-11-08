Feature: Delete games by list of ids
  By deleting games by list of ids I should get a list os games with given ids deleted.

  Scenario Outline: I delete games with given list of ids
    Given the list of games
    When delete game by list of ids from <id_from> to <id_to>
    Then  number of titles <titles> should be deleted 

    Examples: 
      | id_from | id_to | titles |
      | 1       | 3     | 3      |
      | 2       | 5     | 4      | 
