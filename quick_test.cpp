int main(int argc, char const *argv[])
{
	struct offset
	{
		int i;
		int j;
	};

	struct offset moves[8];
	moves[0].i = -1;	moves[0].j = -1;
	moves[1].i = -1;	moves[1].j =  0;
	moves[2].i = -1;	moves[2].j =  1;
	moves[3].i =  0;	moves[3].j = -1;
	moves[4].i =  0;	moves[4].j =  1;
	moves[5].i =  1;	moves[5].j = -1;
	moves[6].i =  1;	moves[6].j =  0;
	moves[7].i =  1;	moves[7].j =  1;
	return 0;
}