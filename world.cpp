#include "world.h"

/**
 * Funciones de apoyo para trabajar con el mundo en 2D
 */

/**
 * GENERATE CPU recorre el mundo calculando las nuevas generaciones con las normas:
 * Una celula muerta rodeada de 3 vivas se revive.
 * Una celda viva rodeada de 2 o 3 vivas sobrevive, sino muere.
 */
void generate_cpu(int* _old, int* _new, int w, int h, offset moves[])
{
	for (int i = 0; i < h; ++i)
	{
		for (int j = 0; j < w; ++j)
		{
			//get nº of neighbours:
			int count = 0;
			int pos = i*w + j;
			for (int m = 0; m < 8; ++m)
			{
				// index of _old vector neigbour:
				int old_p = mod((i+moves[m].i),h)*w + mod((j+moves[m].j),w);
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

int mod(int a, int b)
{
	if (a < 0)
		return b+a;
	else
		return a%b;
}

/**
 * PRINT_WORLD recorre el array imprimiendo el contenido. Si la celda esta vacía imprime
 * 'O', si tiene contenido 'X'. w es width y h es height
 */
void print_world(int* world, int w, int h)
{
	for (int i = 0; i < h; ++i)
	{
		for (int j = 0; j < w; ++j)
		{
			int pos = i*w + j;
			if (world[pos] == 0)
				printw("0 ");
			else
				printw(". ");
		}
		printw("\n");
	}
	refresh();			/* Print it on to the real screen */
}

/**
 * A partir de ahora son implementaciones de diferentes patrones de game of
 * life, conocidos por su comportamiento
 */

/**
 * INIT_WORLD pobla un array representando una matriz 2d, con w width y
 * height h.
 * WARNING: 'world' tiene que estar allocado antes de la llamada.
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
void glider_init_world(int* world, int w)
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
void gosper_glider_gun_init_world(int* world, int w)
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