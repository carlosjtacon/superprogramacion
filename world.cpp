#include "world.h"

void init_world(int* world, int size)
{
    world = (int*) malloc(size*sizeof(int));

    srand(time(NULL));

    for (int i = 0; i < size; ++i)
    {
        world[i] = rand()%2;
    }
}