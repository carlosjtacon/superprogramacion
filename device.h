#ifndef DEVICE
#define DEVICE

#ifndef TILE_W
#define TILE_W 16
#endif
#ifndef TILE_H
#define TILE_H 16
#endif

/**
* elejimos tesela de 16 para modo óptimo porque 16*16 es 256 hilos/bloque, que garantiza
* llenar el SM, para todas las compute capabilities
**/

#include <cuda_runtime.h>
#include <iostream>
#include "structures.h"

using namespace std;

__global__ void generate_gpu(int* _old, int* _new, int w, int h, offset moves[]);
__global__ void generate_gpu_optimized(int* _old, int* _new, int w, int h, offset moves[]);
void call_generate_gpu_optimized(int* _old, int* _new, int w, int h, offset moves[]);
void call_generate_gpu(int* _old, int* _new, int w, int h, offset moves[]);
__device__ int d_mod(int a, int b); 

#endif