#include "handler.h"

// este fichero contiene las llamadas a game of life en host y device

void life(int width, int height, int pattern,  bool manual, int device) {
 	//llamada a ejecutar el juego de la vida en CPU, random o patrón y tamaño por parámetro + manual/auto

 	// estructura de coordenadas para los vecinos
 	struct offset moves[8];
 	moves[0].i = -1;	moves[0].j = -1;
 	moves[1].i = -1;	moves[1].j =  0;
 	moves[2].i = -1;	moves[2].j =  1;
 	moves[3].i =  0;	moves[3].j = -1;
 	moves[4].i =  0;	moves[4].j =  1;
 	moves[5].i =  1;	moves[5].j = -1;
 	moves[6].i =  1;	moves[6].j =  0;
 	moves[7].i =  1;	moves[7].j =  1;

 	size_t size = width * height * sizeof(int);

 	int * _old = (int*) malloc(size);
 	int * _new = (int*) malloc(size);
 	for (int i = 0; i < size; ++i)
 		_new[i] = 0;

 	//se inicia con un patrón especifico o aleatorio
 	if (pattern == 1 && width >= 40 && height >= 40) {
 		gosper_glider_gun_init_world(_old, width);
 	} else if (pattern == 2 && width > 10 && height > 10) {
		glider_init_world(_old, width);
 	} else if (pattern == 0) {
 		random_init_world(_old, width, height);
 	} else {
 		printf("Tamaño incorrecto para el patrón seleccionado.\n");
 		return;
 	}
 	
 	//empieza la iteración en cpu
 	system("clear");
 	print_world(_old, width, height);
 	usleep(50000);

 	while (1)
 	{
 		if(manual) getchar();
 		system("clear");
 		switch (device) {
 			case 0:
 				generate_cpu(_old, _new, width, height, moves);
 				break;
 			case 1:
 				generate_gpu(_old, _new, width, height);
 				break;
 			case 2:
 				generate_gpu_optimized(_old, _new, width, height);
 				break;
 		}
 		print_world(_new, width, height);
 		usleep(50000);
 		if(manual) getchar();
 		system("clear");
 		switch (device) {
 			case 0:
 				generate_cpu(_new, _old, width, height, moves);
 				break;
 			case 1:
 				generate_gpu(_new, _old, width, height);
 				break;
 			case 2:
 				generate_gpu_optimized(_new, _old, width, height);
 				break;
 		}
 		print_world(_old, width, height);
 		usleep(50000);
 	}
}