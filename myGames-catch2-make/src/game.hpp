#ifndef __GAME__
#define __GAME__

#include <string>
#include <iostream>

using namespace std;

struct game_t 
{
    int id;
    string title;
    int release_date;
};

inline bool operator == (const game_t &g1, const game_t &g2) 
{
    return (g1.id == g2.id) && (g1.title == g2.title) && (g1.release_date == g2.release_date);
}

inline ostream &operator<<(std::ostream &out, const game_t &g) 
{
    out << "{" << g.id << ", " << g.title << ", " << g.release_date << "}";
    return out;
}

#endif