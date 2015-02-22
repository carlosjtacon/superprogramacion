#include "world.h"

/**
 * this file contains all functions handy for handling the 2d world
 */

/**
 * INIT_WORLD populates an array representing a 2d matrix, of width w and
 * height h.
 * WARNING: 'world' must be allocated before the function call.
 */
void init_world(int* world, int w, int h)
{
    srand(time(NULL));
    for (int i = 0; i < w*h; ++i)
        world[i] = rand()%2;
}

/**
 * PRINT_WORLD traverses the array printing the content. If cell empty prints
 * 'O', if populated prints 'X'. w means width and h means height
 */
void print_world(int* world, int w, int h)
{
	for (int i = 0; i < w; ++i)
	{
		for (int j = 0; j < h; ++j)
		{
			int pos = i*w + j;
			if (world[pos] == 0)
				cout << 'O';
			else
				cout << 'X';
		}
		cout << endl;
	}
}