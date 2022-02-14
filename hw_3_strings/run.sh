#!/bin/bash
cd ../
cd reverse_string_util/
mvn clean install
cd ../
cd hw_3_strings/
rm dependency-reduced-pom.xml
mvn clean package
java -jar target/main.jar
