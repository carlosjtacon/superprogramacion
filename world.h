#ifndef WORLD
#define WORLD

#include <stdlib.h>
#include <time.h>
#include <iostream>
#include "structures.h"

using namespace std;
/*
struct offset moves[8];
moves[0].i = -1;	moves[0].j = -1;
moves[1].i = -1;	moves[1].j =  0;
moves[2].i = -1;	moves[2].j =  1;
moves[3].i =  0;	moves[3].j = -1;
moves[4].i =  0;	moves[4].j =  1;
moves[5].i =  1;	moves[5].j = -1;
moves[6].i =  1;	moves[6].j =  0;
moves[7].i =  1;	moves[7].j =  1;
*/
void init_world(int* world, int w, int h);
void print_world(int* world, int w, int h);
void generate(int* _old, int* _new, int w, int h, offset moves[]);

#endif