#!/bin/bash

rm app.jar
MAIN_PATH=$(dirname $(pwd))
DOCKER_PATH=$MAIN_PATH/docker
JAR_PATH=$MAIN_PATH/build/libs/*.jar

cd "${MAIN_PATH}"

./gradlew bootJar

cd "${DOCKER_PATH}"

mv $JAR_PATH app.jar

docker build -t spring-kotlin .
