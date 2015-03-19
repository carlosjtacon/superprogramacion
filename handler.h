#ifndef HANDLER
#define HANDLER

#include "world.h"
#include "device.h"
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <unistd.h>

using namespace std;

void life_cpu(int width, int height, int pattern, bool manual);
void life_gpu(int width, int height, int pattern, bool manual);

#endif