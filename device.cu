/**
 * All code related to device, such as kernell and data hanling (copying, 
 * freeing) is placed here.
 */
#include "device.h"

__global__ 
void generate_gpu(int* _old, int* _new, int w, int h, offset moves[])
 {
 	int i = threadIdx.y + blockIdx.y * blockDim.y;
    int j = threadIdx.x + blockIdx.x * blockDim.x;

    int pos = i * w + j;

    struct offset moves2[8];
    moves2[0].i = -1;    moves2[0].j = -1;
    moves2[1].i = -1;    moves2[1].j =  0;
    moves2[2].i = -1;    moves2[2].j =  1;
    moves2[3].i =  0;    moves2[3].j = -1;
    moves2[4].i =  0;    moves2[4].j =  1;
    moves2[5].i =  1;    moves2[5].j = -1;
    moves2[6].i =  1;    moves2[6].j =  0;
    moves2[7].i =  1;    moves2[7].j =  1;

 	int count = 0;
 	for (int m = 0; m < 8; ++m)
 	{
		// index of _old vector neigbour:
 		int old_p = ((i+moves2[m].i)%w)*w + (j+moves2[m].j)%h;
 		if (_old[old_p]>0)
 			count++;
 	}
 	if (count > 3 || count < 2){
 		_new[pos]=0;
 	}
 	else if (count == 2){
 		_new[pos] = _old[pos];
 	}
	else{				//count == 3
		_new[pos]=1;
	} 
}

void call_generate_gpu(int* _old, int* _new, int w, int h, offset moves[])
{
	size_t size = w*h*sizeof(int);
    int* d_old;
	cudaMalloc((void **)&d_old,size);
	int* d_new;
	cudaMalloc((void **)&d_new,size);
    cudaMemcpy(d_old,_old,size,cudaMemcpyHostToDevice);
    cudaMemcpy(d_new,_new,size,cudaMemcpyHostToDevice);
	/*nota mental: puede que pete porque no estoy reservando memoria para moves
	pero al pasarse como valor, no se si hace falta*/
	dim3 gridSize(8,8);
	dim3 blockSize(8,8);
	generate_gpu <<<gridSize, blockSize>>> (d_old, d_new, w, h, moves);
	cudaMemcpy(_old, d_old, size, cudaMemcpyDeviceToHost);
	cudaMemcpy(_new, d_new, size, cudaMemcpyDeviceToHost);
	cudaFree((void **)&d_old);
	cudaFree((void **)&d_new);
}