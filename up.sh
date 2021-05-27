#!/usr/bin/env bash

## compile
./mvnw package -DskipTests


## run the project
java -jar target/*.jar
