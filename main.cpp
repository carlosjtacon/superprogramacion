#include "world.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <unistd.h>
using namespace std;

const char *HELP = "USAGE\n    ./golife (Run with the default configuration)\n    ./golife [Device Mode] [Running Mode] [Custom Pattern] [--help]\n\nDESCRIPTION\nDevice Mode:\n    -cpu\t\tProgram runs on CPU\n    -gpu\t\tProgram runs on GPU\n    -gpu-optimized\t Program runs on GPU Shared Memory\n\nRunning Mode:\n    -a\t\t\t Auto\n    -m [w][h]\t\tManual [Width] [Height]\n\nPattern (Optional):\n    -gun\t\tGosper Glider Gun\n";

int checkHostDevice(const char *argv[]) {
	//comprobamos que la entrada sea correcta y devolvemos un entero según el modo dispositivo
	if (strcmp(argv[1], "-cpu")==0) {
		printf("-cpu\n");
		return 1;
	} else if (strcmp(argv[1], "-gpu")==0) {
		printf("-gpu\n");
		return 2;
	} else if (strcmp(argv[1], "-gpu-optimized")==0) {
		printf("-gpu-optimized\n");
		return 3;
	} else {
		printf("%s", HELP);
		return 0;
	}
}

int checkMode (const char *mode, const char *argv[]) {
	//comprobamos si es auto o manual
	if (strcmp(argv[2], "-a")==0 && strcmp(argv[2], mode)==0) {
		printf("-a\n");
		return 1;
	} else if (strcmp(argv[2], "-m")==0 && strcmp(argv[2], mode)==0) {
		printf("-m\n");
		return 2;
	} else {
		printf("%s", HELP);
		return 0;
	}
}

int checkGun (int pos, const char *argv[]) {
	// comprobamos que la entrada sea correcta (-gun) según la posicion indicada
	if (strcmp(argv[pos], "-gun")==0) {
		printf("-gun\n");
		return 1;
	} else {
		printf("%s", HELP);
		return 0;
	}
}

int checkSize (const char *argv[]) {
	//comprobamos que los argumentos de tamaño sean convertibles a int
	if (atoi(argv[3])!=0 && atoi(argv[4])!=0) {
		printf("se puede hacer cast\n");
		return 1;
	} else {
		printf("%s", HELP);
		return 0;
	}
}

int main(int argc, const char *argv[]) {
	int devicemode;
	int mode;
	int gun;
	int size;
	switch(argc) {
		case 1:
			printf("Default Configuration\n");
			break;
		case 3:
			printf("gpu1/gpu2/cpu + a\n");
			devicemode = checkHostDevice(argv);
			mode = checkMode("-a", argv);
			break;
		case 4:
			printf("gpu1/gpu2/cpu + a + patron\n");
			devicemode = checkHostDevice(argv);
			mode = checkMode("-a", argv);
			gun = checkGun(3, argv);
			break;
		case 5:
			printf("gpu1/gpu2/cpu + m + value + value\n");
			devicemode = checkHostDevice(argv);
			mode = checkMode("-m", argv);
			size = checkSize(argv);
			break;
		case 6:
			printf("gpu1/gpu2/cpu + m + value + value + patron\n");
			devicemode = checkHostDevice(argv);
			mode = checkMode("-m", argv);
			size = checkSize(argv);
			gun = checkGun(5, argv);
			break;
		default:
			printf("%s", HELP);
	}

	return 0;
}