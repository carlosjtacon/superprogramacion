main: main.cpp
	g++ main.cpp -o golife

handler: world.o handler.cpp
	g++ world.o handler.cpp -o test

world.o: world.cpp world.h
	g++ -c -Wall world.cpp -o world.o

clean:
	rm -f *.o
	rm -f test
	rm -f *.out
	rm -f main
	rm -f golife