/**
 * All code related to device, such as kernell and data hanling (copying, 
 * freeing) is placed here.
 */
#include "device.h"

/**
* kernel no optimizado
**/
__global__ 
void generate_gpu(int* _old, int* _new, int w, int h)
 {
 	int i = threadIdx.y + blockIdx.y * blockDim.y;
    int j = threadIdx.x + blockIdx.x * blockDim.x;

    int pos = i * w + j;

    struct offset moves[8];
    moves[0].i = -1;    moves[0].j = -1;
    moves[1].i = -1;    moves[1].j =  0;
    moves[2].i = -1;    moves[2].j =  1;
    moves[3].i =  0;    moves[3].j = -1;
    moves[4].i =  0;    moves[4].j =  1;
    moves[5].i =  1;    moves[5].j = -1;
    moves[6].i =  1;    moves[6].j =  0;
    moves[7].i =  1;    moves[7].j =  1;

 	int count = 0;
 	for (int m = 0; m < 8; ++m)
 	{
		// index of _old vector neigbour:
 		int old_p = ((i+moves[m].i)%w)*w + (j+moves[m].j)%h;
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

/**
* kernel optimizado
**/
__global__ 
void generate_gpu_optimized(int* _old, int* _new, int w, int h)
 {
 	//coordenadas del hilo actual en _old o _new
 	int i = threadIdx.y + blockIdx.y * blockDim.y;
    int j = threadIdx.x + blockIdx.x * blockDim.x;
    //posición en el array lineal de la celda actual
    int pos = i * w + j;
    //submatriz a ser leída, en memoria compartida, incluye vecinos exteriores
    __shared__ int sub_world [TILE_W+2] [TILE_H+2];
    //coordenadas del hilo actual en matriz sub_world
    int si = threadIdx.y +1;
    int sj = threadIdx.x +1;
    //cada hilo carga su vecino superior izquierdo
    sub_world[si-1][sj-1] = _old[d_mod((i-1),h)*w+d_mod((j-1),w)];
    //cada hilo de la fila inferior carga el vecino izq y izquierdo inferior
    if (threadIdx.y == TILE_H-1)
    {
	    sub_world[si][sj-1] = _old[i*h+d_mod((j-1),w)];
	    sub_world[si+1][sj-1] = _old[d_mod((i+1),h)*w+d_mod((j-1),w)];
    }
    //cada hilo de la columna derecha se carga a si mismo y su vecino derecho
    if (threadIdx.x == TILE_W-1)
    {
    	sub_world[si][sj] = _old[pos];
    	sub_world[si][sj+1] = _old[i*w + d_mod((j+1),w)];
    }
    //el hilo de la esquina superior derecha carga su vecino superior y superior derecho
    if (threadIdx.y == 0 && threadIdx.x == TILE_W-1)
    {
    	sub_world[si-1][sj] = _old[d_mod((i-1),h)*w+j];
    	sub_world[si-1][sj+1] = _old[d_mod((i-1),h)*w+d_mod((j+1),w)];
    }
    //el hilo de la esquina inferior derecha carga su vecino inferior e inferior derecho
    if (threadIdx.y == TILE_H-1 && threadIdx.x == TILE_W-1)
    {
    	sub_world[si+1][sj] = _old[d_mod((i+1),h)*w + j];
    	sub_world[si+1][sj+1] = _old[d_mod((i+1),h)*w + d_mod((j+1),w)];
    }
    //esperar a que toda la submatriz esté cargada
	__syncthreads();
 	if (i >= w || j >= h)
	 	return;
	//sumar todos vecinos, así evitamos divergencia
 	int count = sub_world[si-1][sj-1]+sub_world[si-1][sj]+sub_world[si-1][sj+1]
 		+sub_world[si][sj-1]+sub_world[si][sj+1]
 		+sub_world[si+1][sj-1]+sub_world[si+1][sj]+sub_world[si+1][sj+1];
	//aplicar reglas
 	if (count > 3 || count < 2){
 		_new[pos]=0;
 	}
 	else if (count == 2){
 		_new[pos] = _old[pos];
 	}
	else{				//count == 3
		_new[pos]=1;
	}
	 _new[pos] = sub_world[si-1][sj-1];
	// _new[pos] = threadIdx.x;
}

/**
* wrapper para el kernel no optimizado
**/
void call_generate_gpu(int* _old, int* _new, int w, int h)
{
	size_t size = w*h*sizeof(int);
    int* d_old;
	cudaMalloc((void **)&d_old,size);
	int* d_new;
	cudaMalloc((void **)&d_new,size);
    cudaMemcpy(d_old,_old,size,cudaMemcpyHostToDevice);
    cudaMemcpy(d_new,_new,size,cudaMemcpyHostToDevice);
	dim3 gridSize(8,8);
	dim3 blockSize(8,8);
	generate_gpu <<<gridSize, blockSize>>> (d_old, d_new, w, h);
	cudaMemcpy(_old, d_old, size, cudaMemcpyDeviceToHost);
	cudaMemcpy(_new, d_new, size, cudaMemcpyDeviceToHost);
	cudaFree((void **)&d_old);
	cudaFree((void **)&d_new);
}

/**
* wrapper para el kernel optimizado
**/
void call_generate_gpu_optimized(int* _old, int* _new, int w, int h)
{
	size_t size = w*h*sizeof(int);
    int* d_old;
	cudaMalloc((void **)&d_old,size);
 	cout << "llega" << endl;
	int* d_new;
	cudaMalloc((void **)&d_new,size);
    cudaMemcpy(d_old,_old,size,cudaMemcpyHostToDevice);
    cudaMemcpy(d_new,_new,size,cudaMemcpyHostToDevice);
    int gridx = w/TILE_W;
    int gridy= h/TILE_H;
    if (w%TILE_W > 0)
    	gridx+=1;
    if (h%TILE_H > 0)
    	gridy+=1;
    cout << "gridx=" << gridx <<endl;
    cout << "gridy=" << gridy <<endl;
	dim3 gridSize(gridx, gridy);
	dim3 blockSize(TILE_W,TILE_H);
	generate_gpu_optimized <<<gridSize, blockSize>>> (d_old, d_new, w, h);
	cudaMemcpy(_old, d_old, size, cudaMemcpyDeviceToHost);
	cudaMemcpy(_new, d_new, size, cudaMemcpyDeviceToHost);
	cudaFree(d_old);
	cudaFree(d_new);
}

/**
* realiza la operación a mod b; A diferencia de '%' en C,
* esta función devuelve siempre el modulo positivo (-1 mod 5 = 4)
**/
__device__ 
int d_mod(int a, int b)
{
	if (a < 0)
		return b+a;
	else
		return a%b;
}