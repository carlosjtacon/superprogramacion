#ifndef WORLD
#define WORLD

#include <stdlib.h>
#include <time.h>
#include <iostream>
#include "structures.h"
#include <ncurses.h>

using namespace std;

void generate_cpu(int* _old, int* _new, int w, int h, offset moves[]);
void print_world(int* world, int w, int h);
void random_init_world(int* world, int w, int h);
void glider_init_world(int* world, int w);
void gosper_glider_gun_init_world(int* world, int w);
int mod(int a, int b);

#endif