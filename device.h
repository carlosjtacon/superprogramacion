#ifndef DEVICE
#define DEVICE

#include <cuda_runtime.h>
#include "structures.h"
__global__ void generate_gpu(int* _old, int* _new, int w, int h, offset moves[]);
void call_generate_gpu(int* _old, int* _new, int w, int h, offset moves[]);

#endif