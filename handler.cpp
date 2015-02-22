#include "world.h"
#include <stdio.h>
#include <stdlib.h>
#include <iostream>

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

    int * world = (int*) malloc(size);
	
	init_world(world, width, height);
	print_world(world, width, height);

	return 0;
}