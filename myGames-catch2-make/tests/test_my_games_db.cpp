#include "catch.hpp"
#include "../src/my_games_db.hpp"
#include <map>
#include <list>
#include <iostream>

using namespace std;
using namespace Catch::Matchers;

class Database : public MyGamesDatabase
{
    public:
        void setDb(map<int, game_t> d)
        {
            myGamesDatabase = d;
        };
};

TEST_CASE("Getting all data from the database", "[myGamesDatabase][getAllGames]") 
{
    SECTION("GetAllGames method is present") 
    {
        REQUIRE_NOTHROW([]() {MyGamesDatabase db; db.getAllGames(); }());
    }

    SECTION("GetAllGames method should return empy list when database is empty") 
    {
        MyGamesDatabase db;
        list<game_t> result = db.getAllGames();
        REQUIRE(result == list<game_t>{});
    }

    SECTION("GetAllGames method should return all games from database") 
    {
        Database db;
        map<int, game_t> expected = 
        {
            {1, {1, "GTA V", 2015}},
            {2, {2, "Tomb Raider", 2016}},
            {3, {3, "Mafia III",2016}}
        };
        db.setDb(expected);
        list<game_t> expected_list;
        for(auto e: expected)
        {
            expected_list.push_back(e.second);
        }
        REQUIRE(db.getAllGames() == expected_list);
    }
}

TEST_CASE("Adding data to the database", "[myGamesDatabase][addGame]")
{
    SECTION("The database object can be created")
    {
        Database db;
        map<int, game_t> allGames = 
        {
            {1, {1, "GTA V", 2015}},
            {2, {2, "Tomb Raider", 2016}}
        };
        db.setDb(allGames);
        list<game_t> all_games_list;
        for(auto e: allGames)
        {
            all_games_list.push_back(e.second);
        }
        REQUIRE(db.getAllGames() == all_games_list);
        
        SECTION("AddGame method should add a game to the database")
        {
            REQUIRE_NOTHROW(db.addGame({3, "Mafia III", 2016}));
            
            SECTION("The database should contain element with the title Mafia III")
            {
                all_games_list.push_back({3, "Mafia III", 2016});
                REQUIRE(db.getAllGames() == all_games_list);
            }
        }
    }
}

TEST_CASE("Getting data from database by id", "[myGamesDatabase][getGameById]")
{
    SECTION("The database object can be created")
    {
        Database db;
        map<int, game_t> allGames = 
        {
            {1, {1, "GTA V", 2015}},
            {2, {2, "Tomb Raider", 2016}},
            {3, {3, "Mafia III", 2016}}
        };
        db.setDb(allGames);
        
        SECTION("GetGameById method should get a game with id 2")
        {
            REQUIRE_NOTHROW(db.getGameById(2));
            
            SECTION("database return product with id 2")
            {
                game_t game_to_compare = {2, "Tomb Raider", 2016};
                REQUIRE(db.getGameById(2) == game_to_compare);
            }
        }
    }
}

SCENARIO("Deleting data from database","[myGamesDatabase][bdd][deleteGame]") 
{
    GIVEN("We have some data in database") 
    {
        Database db;
        map<int, game_t> allGames = 
        {
            {1, {1, "GTA V", 2015}},
            {2, {2, "Tomb Raider", 2016}},
            {3, {3, "Mafia III", 2016}}
        };
        db.setDb(allGames);
        list<game_t> all_games_list;
        for(auto e: allGames)
        {
            all_games_list.push_back(e.second);
        }
        CHECK(db.getAllGames() == all_games_list);

        WHEN("We remove game with id 2 from the database") 
        {
            REQUIRE_NOTHROW(db.deleteGame(2));
            THEN("The database shouldn't contain a game with id 2") 
            {
                for(auto g: db.getAllGames())
                {
                    CHECK(g.id != 2);
                }
            }
        }

        WHEN("We try to remove game that doesn't exist in the database")
        {
            THEN("The exception should be thrown") 
            {
                REQUIRE_THROWS_AS(db.deleteGame(10), invalid_argument);
            }

            THEN("The exception should contain suitable message")
            {
                REQUIRE_THROWS_WITH(db.deleteGame(10), EndsWith("not found") || StartsWith("game"));
            }
        }
    }
}
