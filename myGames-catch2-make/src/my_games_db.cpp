#include "my_games_db.hpp"
#include "game.hpp"

using namespace std;

list<game_t> MyGamesDatabase::getAllGames()
{
    list<game_t> result;
    for(auto &e: myGamesDatabase)
    {
        result.push_back(e.second);
    }
    return result;
}

void MyGamesDatabase::addGame(const game_t &g)
{
    myGamesDatabase[g.id] = g;
}

game_t MyGamesDatabase::getGameById(const int id)
{
    for(auto &e: myGamesDatabase)
    {
        if(e.second.id == id)
        {
            return e.second;
        }
    }
}

void MyGamesDatabase::deleteGame(const int id)
{
    if(myGamesDatabase.count(id) == 0)
    {
        throw invalid_argument("game not found");
    } 
    myGamesDatabase.erase(id);
}
