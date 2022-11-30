compile: clear
	javac -d ./output *.java
run: clear compile
	java -Djava.system.class.loader=ProxyClassLoader -cp ./output ClassLoaderTest
clear:
	rm -rf ./output