#include "world.h"

/**
 * this file contains all functions handy for handling the 2d world
 */

/**
 *GENERATE traverses the world calculating new generetions based on the simple
 *rules:
 *A dead cell surrounded by exactly 3 alive cells is revived.
 *An alive cell surronded by 2 or 3 alive cells gets to live, otherwise dies.
 */
void generate_cpu(int* _old, int* _new, int w, int h, offset moves[])
{
	for (int i = 0; i < w; ++i)
	{
		for (int j = 0; j < h; ++j)
		{
			//get nº of neighbours:
			int count = 0;
			int pos = i*w + j;
			for (int m = 0; m < 8; ++m)
			{
				// index of _old vector neigbour:
				int old_p = ((i+moves[m].i)%w)*w + (j+moves[m].j)%h;
				if (_old[old_p]>0)
					count++;
			}
			// cout << count;
			//apply rules:
			if (count > 3 || count < 2){
				_new[pos]=0;
				// cout << "killing" << endl;
			}
			else if (count == 2){
				_new[pos] = _old[pos];
				// cout << "keeping" << endl;
			}
			else{				//count == 3
				_new[pos]=1;
				// cout << "reviving" << endl;
			}
		}
	}
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
				cout << ' ';
			else
				cout << 'X';
		}
		cout << endl;
	}
}

/**
 * The following is the implementation of several patterns in the game of 
 * life, known for their characteristic behaviour
 */

/**
 * INIT_WORLD pobla un array representando una matriz 2d, con w width y
 * height h.
 * WARNING: 'world' must be allocated before the function call.
 */
void random_init_world(int* world, int w, int h)
{
    srand(time(NULL));
    for (int i = 0; i < w*h; ++i)
        world[i] = rand()%2;
}

/**
 * Un glider es un tipo de patron conocido como 'spaceship', que viaja por
 * el mundo
 */
void glider_init_world(int* world, int w, int h)
{
	world[0*w + 2] = 1;
	world[1*w + 0] = 1;
	world[1*w + 2] = 1;
	world[2*w + 1] = 1;
	world[2*w + 2] = 1;
}

/**
 * El gosper glider gun es un patron que genera periodicamente un glider.
 */
void gosper_glider_gun_init_world(int* world, int w, int h)
{
	world[5*w + 1] = 1;
	world[6*w + 1] = 1;
	world[5*w + 2] = 1;
	world[6*w + 2] = 1;
	world[6*w + 2] = 1;

	world[5*w + 11] = 1;
	world[6*w + 11] = 1;
	world[7*w + 11] = 1;
	world[4*w + 12] = 1;
	world[8*w + 12] = 1;
	world[3*w + 13] = 1;
	world[9*w + 13] = 1;
	world[3*w + 14] = 1;
	world[9*w + 14] = 1;
	world[6*w + 15] = 1;
	world[4*w + 16] = 1;
	world[8*w + 16] = 1;
	world[5*w + 17] = 1;
	world[6*w + 17] = 1;
	world[7*w + 17] = 1;
	world[6*w + 18] = 1;

	world[3*w + 21] = 1;
	world[4*w + 21] = 1;
	world[5*w + 21] = 1;
	world[3*w + 22] = 1;
	world[4*w + 22] = 1;
	world[5*w + 22] = 1;
	world[2*w + 23] = 1;
	world[6*w + 23] = 1;

	world[1*w + 25] = 1;
	world[2*w + 25] = 1;
	world[6*w + 25] = 1;
	world[7*w + 25] = 1;

	world[3*w + 35] = 1;
	world[4*w + 35] = 1;
	world[3*w + 36] = 1;
	world[4*w + 36] = 1;
}