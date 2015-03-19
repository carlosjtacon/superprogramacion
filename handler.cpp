#include "handler.h"

// este fichero contiene las llamadas a game of life en host y device

 void life_cpu(int width, int height, int pattern)
 {
 	//llamada a ejecutar el juego de la vida en CPU, random o patrón y tamaño por parámetro
 	size_t size = width * height * sizeof(int);

 	int * _old = (int*) malloc(size);
 	int * _new = (int*) malloc(size);
 	for (int i = 0; i < size; ++i)
 		_new[i] = 0;

 	if (pattern == 1) {
 		gosper_glider_gun_init_world(_old, width, height);
 	} else if (pattern == 2) {
		glider_init_world(_old, width, height);
 	} else {
 		random_init_world(_old, width, height);
 	}
 	
 	system("clear");
 	print_world(_old, width, height);
 	usleep(50000);
 	system("clear");

 	struct offset moves[8];
 	moves[0].i = -1;	moves[0].j = -1;
 	moves[1].i = -1;	moves[1].j =  0;
 	moves[2].i = -1;	moves[2].j =  1;
 	moves[3].i =  0;	moves[3].j = -1;
 	moves[4].i =  0;	moves[4].j =  1;
 	moves[5].i =  1;	moves[5].j = -1;
 	moves[6].i =  1;	moves[6].j =  0;
 	moves[7].i =  1;	moves[7].j =  1;

 	while (1)
 	{
 		generate_cpu(_old, _new, width, height, moves);
 		print_world(_new, width, height);
 		usleep(50000);
 		system("clear");
 		generate_cpu(_new, _old, width, height, moves);
 		print_world(_old, width, height);
 		usleep(50000);
 		system("clear");
 	}
 }