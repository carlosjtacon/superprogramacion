#include "world.h"
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <unistd.h>

int main(int argc, char const *argv[]) {
	switch(argc) {
		case 1:
			printf("Default Configuration\n");
			break;
		case 3:
			printf("a/m + gpu1/gpu2/cpu\n");
			break;
		case 4:
			printf("a/m + gpu1/gpu2/cpu + patron\n");
			break;
		case 6:
			printf("a/m + gpu1/gpu2/cpu + size value value\n");
			break;
		case 7:
			printf("a/m + gpu1/gpu2/cpu + patron + size value value\n");
			break;
		default:
			printf("ARGUMENTOS INCORRECTOS **HELP\n");
	}

	return 0;
}

int checkSize(int argc, char *argv[]) {
	for (int i = 0; i < argc; ++i)
	{
		/* code */
	}
}