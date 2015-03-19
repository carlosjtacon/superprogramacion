#include "handler.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <unistd.h>
using namespace std;

//string de ayuda para el uso del programa
const char *HELP = "USAGE\n    ./golife (Run with the default configuration)\n    ./golife [Width][Height][Device Mode][Running Mode][Custom Pattern][--help]\n\nDESCRIPTION\nDevice Mode:\n    -cpu\t\tProgram runs on CPU\n    -gpu\t\tProgram runs on GPU Global Memory\n    -gpu-optimized\tProgram runs on GPU Shared Memory\n\nRunning Mode:\n    -a\t\t\tAuto\n    -m\t\t\tManual (Press return each interaction)\n\nPattern (Optional):\n    -gun\t\tGosper Glider Gun\n    -glider\t\tGosper Glider\n\n";
const int WIDTH = 40;
const int HEIGHT = 20;

int checkHostDevice(const char *argv[]) {
	//comprobamos que la entrada sea correcta y devolvemos un entero según el modo dispositivo
	if (strcmp(argv[3], "-cpu")==0) {
		return 1;
	} else if (strcmp(argv[3], "-gpu")==0) {
		return 2;
	} else if (strcmp(argv[3], "-gpu-optimized")==0) {
		return 3;
	} else {
		return 0;
	}
}

int checkMode (const char *argv[]) {
	//comprobamos si es auto o manual
	if (strcmp(argv[4], "-a")==0) {
		return 1;
	} else if (strcmp(argv[4], "-m")==0) {
		return 2;
	} else {
		return 0;
	}
}

int checkPattern (const char *argv[]) {
	// comprobamos que la entrada sea correcta (-gun) según la posicion indicada
	if (strcmp(argv[5], "-gun")==0) {
		return 1;
	} else if (strcmp(argv[5], "-glider")==0) {
		return 2;
	} else {
		return 0;
	}
}

int checkSize (const char *argv[]) {
	//comprobamos que los argumentos de tamaño sean convertibles a int
	if (atoi(argv[1])!=0 && atoi(argv[2])!=0) {
		return 1;
	} else {
		return 0;
	}
}

int main(int argc, const char *argv[]) {
	int devicemode;
	int mode;
	int pattern;
	int size;
	switch(argc) {
		case 1:
			// configuracion por defecto
			life_cpu(WIDTH, HEIGHT, 1, false);
			break;

		case 5:
			// posibles llamadas como size + gpu1/gpu2/cpu + auto/manual
			devicemode = checkHostDevice(argv);
			mode = checkMode(argv);
			size = checkSize(argv);
			if (size == 1 && mode == 1) {
				// auto
				switch (devicemode) {
					case 1:
						// cpu
						life_cpu(atoi(argv[1]), atoi(argv[2]), 0, false);
						break;
					case 2:
						// gpu
						life_gpu(atoi(argv[1]), atoi(argv[2]), 0, false);
						break;
					case 3:
						// gpu optimized
						// code here
						break;
					default:
						printf("%s", HELP);
						break;
				}
			} else if (size == 1 && mode == 2) {
				// manual
				switch (devicemode) {
					case 1:
						// cpu
						life_cpu(atoi(argv[1]), atoi(argv[2]), 0, true);
						break;
					case 2:
						// gpu
						life_gpu(atoi(argv[1]), atoi(argv[2]), 0, true);
						break;
					case 3:
						// gpu optimized
						// code here
						break;
					default:
						printf("%s", HELP);
						break;
				}
			} else {
				printf("%s", HELP);
			}
			break;

		case 6:
			// posibles llamadas como size + gpu1/gpu2/cpu + auto/manual + patron
			devicemode = checkHostDevice(argv);
			mode = checkMode(argv);
			size = checkSize(argv);
			pattern = checkPattern(argv);
			if (size == 1 && mode == 1 && pattern != 0) {
				// auto + pattern
				switch (devicemode) {
					case 1:
						// cpu
						life_cpu(atoi(argv[1]), atoi(argv[2]), pattern, false);
						break;
					case 2:
						// gpu
						life_gpu(atoi(argv[1]), atoi(argv[2]), pattern, false);
						break;
					case 3:
						// gpu optimized
						// code here
						break;
					default:
						printf("%s", HELP);
						break;
				}
			} else if (size == 1 && mode == 2 && pattern != 0) {
				// manual + pattern
				switch (devicemode) {
					case 1:
						// cpu
						life_cpu(atoi(argv[1]), atoi(argv[2]), pattern, true);
						break;
					case 2:
						// gpu
						life_gpu(atoi(argv[1]), atoi(argv[2]), pattern, true);
						break;
					case 3:
						// gpu optimized
						// code here
						break;
					default:
						printf("%s", HELP);
						break;
				}
			} else {
				printf("%s", HELP);
			}
			break;

		default:
			printf("%s", HELP);
	}

	return 0;
}