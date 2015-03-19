all: golife

golife: device.o world.o handler.o main.cpp
	nvcc device.o world.o handler.o main.cpp -o golife

device.o: device.cu device.h
	nvcc -c device.cu -o device.o

handler.o: handler.cpp handler.h
	nvcc -c handler.cpp -o handler.o

world.o: world.cpp world.h
	nvcc -c world.cpp -o world.o

clean:
	rm -f *.o
	rm -f *.out
	rm -f golife