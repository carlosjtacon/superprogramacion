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


/**
 *GENERATE traverses the world calculating new generetions based on the simple
 *rules:
 *A dead cell surrounded by exactly 3 alive cells is revived.
 *An alive cell surronded by 2 or 3 alive cells gets to live, otherwise dies.
 */
void generate(int* _old, int* _new, int w, int h, offset moves[])
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