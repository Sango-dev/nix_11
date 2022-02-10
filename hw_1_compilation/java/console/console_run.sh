#!/bin/sh
rm -rf build

rm *.MF
javac -sourcepath ./src -d build/classes -cp ./libs/number-to-words-1.0.0.jar:./libs/rxjava-string-1.1.1.jar:./libs/commons-lang3-3.11.jar:./libs/java-string-similarity-2.0.0.jar:./libs/commons-math3-3.6.jar src/ua/com/alevel/Main.java

echo Main-Class: ua.com.alevel.Main>MANIFEST.MF

mkdir -p build/jar
cd build/classes

jar xf ../../libs/commons-lang3-3.11.jar org
jar xf ../../libs/number-to-words-1.0.0.jar uk
jar xf ../../libs/rxjava-string-1.1.1.jar rx
jar xf ../../libs/java-string-similarity-2.0.0.jar info

jar xf ../../libs/commons-math3-3.6.jar org
cd ../../

jar cfm build/jar/main.jar MANIFEST.MF -C build/classes/ .
java -jar build/jar/main.jar
