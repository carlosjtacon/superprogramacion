#include "handler.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <unistd.h>
using namespace std;

//string de ayuda para el uso del programa
const char *HELP = "USAGE\n    ./golife (Run with the default configuration)\n    ./golife [Device Mode] [Running Mode] [Custom Pattern] [--help]\n\nDESCRIPTION\nDevice Mode:\n    -cpu\t\tProgram runs on CPU\n    -gpu\t\tProgram runs on GPU\n    -gpu-optimized\t Program runs on GPU Shared Memory\n\nRunning Mode:\n    -a\t\t\t Auto\n    -m [w][h]\t\tManual [Width] [Height]\n\nPattern (Optional):\n    -gun\t\tGosper Glider Gun\n    -glider\t\tGosper Glider\n";
const int WIDTH = 64;
const int HEIGHT = 64;

int checkHostDevice(const char *argv[]) {
	//comprobamos que la entrada sea correcta y devolvemos un entero según el modo dispositivo
	if (strcmp(argv[1], "-cpu")==0) {
		return 1;
	} else if (strcmp(argv[1], "-gpu")==0) {
		return 2;
	} else if (strcmp(argv[1], "-gpu-optimized")==0) {
		return 3;
	} else {
		return 0;
	}
}

int checkMode (const char *mode, const char *argv[]) {
	//comprobamos si es auto o manual
	if (strcmp(argv[2], "-a")==0 && strcmp(argv[2], mode)==0) {
		return 1;
	} else if (strcmp(argv[2], "-m")==0 && strcmp(argv[2], mode)==0) {
		return 2;
	} else {
		return 0;
	}
}

int checkPattern (int pos, const char *argv[]) {
	// comprobamos que la entrada sea correcta (-gun) según la posicion indicada
	if (strcmp(argv[pos], "-gun")==0) {
		return 1;
	} else if (strcmp(argv[pos], "-glider")==0) {
		return 2;
	} else {
		return 0;
	}
}

int checkSize (const char *argv[]) {
	//comprobamos que los argumentos de tamaño sean convertibles a int
	if (atoi(argv[3])!=0 && atoi(argv[4])!=0) {
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
			life_cpu(WIDTH, HEIGHT, true);
			break;
		case 3:
			// posibles llamadas como gpu1/gpu2/cpu + auto
			devicemode = checkHostDevice(argv);
			mode = checkMode("-a", argv);
			if (mode == 1) {
				// auto
				switch (devicemode) {
					case 1:
						// cpu
						life_cpu(WIDTH, HEIGHT, 0);
						break;
					case 2:
						// gpu
						// code here
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
		case 4:
			// posibles llamadas como gpu1/gpu2/cpu + auto + patron
			devicemode = checkHostDevice(argv);
			mode = checkMode("-a", argv);
			pattern = checkPattern(3, argv);
			if (mode == 1 && pattern != 0) {
				// auto + pattern
				switch (devicemode) {
					case 1:
						// cpu
						life_cpu(WIDTH, HEIGHT, pattern);
						break;
					case 2:
						// gpu
						// code here
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
		case 5:
			// posibles llamadas como gpu1/gpu2/cpu + manual + valores
			devicemode = checkHostDevice(argv);
			mode = checkMode("-m", argv);
			size = checkSize(argv);
			if (mode == 2 && size == 1) {
				// manual + valores 
				switch (devicemode) {
					case 1:
						// cpu
						life_cpu(atoi(argv[3]), atoi(argv[4]), 0);
						break;
					case 2:
						// gpu
						// code here
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
			// posibles llamadas como gpu1/gpu2/cpu + manual + valores + glider gun
			devicemode = checkHostDevice(argv);
			mode = checkMode("-m", argv);
			size = checkSize(argv);
			pattern = checkPattern(5, argv);
			if (mode == 2 && size == 1 && pattern == 1) {
				// manual + valores + pattern
				switch (devicemode) {
					case 1:
						// cpu
						life_cpu(atoi(argv[3]), atoi(argv[4]), pattern);
						break;
					case 2:
						// gpu
						// code here
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