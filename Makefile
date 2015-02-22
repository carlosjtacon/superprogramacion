handler: world.o handler.cpp
	g++ world.o handler.cpp -o test

world.o: world.cpp world.h
	g++ -c -Wall world.cpp -o world.o

clean:
	rm *.o
	rm test