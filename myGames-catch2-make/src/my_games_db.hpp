#ifndef __MY_GAMES_DATABASE_HPP__
#define __MY_GAMES_DATABASE_HPP__

#include "game.hpp"
#include <map>
#include <list>

using namespace std;

class MyGamesDatabase
{
    protected:
        map<int, game_t> myGamesDatabase;

    public:
        list<game_t> getAllGames();
        void addGame(const game_t &g);
        game_t getGameById(const int id);
        void deleteGame(const int id);
};

#endif