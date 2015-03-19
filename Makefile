all: golife

golife: world.o handler.o main.cpp
	g++ -Wall world.o handler.o main.cpp -o golife

handler: handler.cpp handler.h
	g++ -c -Wall handler.cpp -o handler.o

world.o: world.cpp world.h
	g++ -c -Wall world.cpp -o world.o

clean:
	rm -f *.o
	rm -f test
	rm -f *.out
	rm -f main
	rm -f golife