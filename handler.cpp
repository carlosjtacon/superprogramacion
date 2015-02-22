#include "world.h"
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <unistd.h>

using namespace std;

/**
 * the purpose of this file is testing the new implemented features, and is built into the
 * 'test' object file. For production or delivery, this file should be removed.
 */

 int main(int argc, char const *argv[])
 {
 	int height, width;
 	if (argc == 1) {
 		height = 4;
 		width = 4;
 	} else {
 		height = atoi(argv[1]);
 		width = atoi(argv[2]);
 	}
 	size_t size = width * height * sizeof(int);

 	int * _old = (int*) malloc(size);
 	int * _new = (int*) malloc(size);
 	for (int i = 0; i < size; ++i)
 		_new[i] = 0;

 	system("clear");
 	// random_init_world(_old, width, height);
 	// glider_init_world(_old, width, height);
 	gosper_glider_gun_init_world(_old, width, height);
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
 		generate(_old, _new, width, height, moves);
 		print_world(_new, width, height);
 		usleep(50000);
 		system("clear");
 		generate(_new, _old, width, height, moves);
 		print_world(_old, width, height);
 		usleep(50000);
 		system("clear");
 	}

 	return 0;
 }