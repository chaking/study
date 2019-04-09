sourcefiles = \
Main.java \
Question.java


classfiles  = $(sourcefiles:.java=.class)
#classfiles = Simple3.class Simple2.class Simple1.class

all: $(classfiles)
run:
	java Main

%.class: %.java
	javac -d . -classpath . $<

clean:
	rm -f *.class
