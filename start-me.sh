#!/usr/bin/env bash

main() {
    echo "You want to start the microservice (y/n)? "
    read -r shouldStartMicroservice
    if [ "$shouldStartMicroservice" = "y" ] || [ "$shouldStartMicroservice" = "Y" ]; then
       startMicroservice
    fi
}

startMicroservice() {
  echo 'STARTING MICROSERVICE'
  echo "What port should the microservice listen? "
  read -r port
  export SERVER_PORT="$port"
  mvn clean install
  java -jar target/*.jar
}

main
