NAME=CookieClickerAlpha

all: $(NAME)

$(NAME): main.o
	g++ main.o -o $(NAME)

main.o: main.cpp
	g++ -c -g main.cpp

clean:
	rm -f $(NAME) *.o

run: $(NAME)
	./$(NAME) < input.txt > output.txt; cat output.txt; rm -rf main.o

rerun: $(NAME)
	make clean; make run
