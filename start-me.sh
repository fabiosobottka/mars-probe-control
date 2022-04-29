#!/usr/bin/env bash

main() {
    echo "You want to start the microservice (y/n)? "
    read -r shouldStartMicroservice
    if [ "$shouldStartMicroservice" = "y" ] || [ "$shouldStartMicroservice" = "Y" ]; then
       startMicroservice
    fi
	
	echo "You want to start the microservice as docker container (y/n)? "
	read -r shouldStartMicroserviceAsDockerContainer
    if [ "$shouldStartMicroserviceAsDockerContainer" = "y" ] || [ "$shouldStartMicroserviceAsDockerContainer" = "Y" ]; then
       startMicroserviceAsDockerContainer
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

startMicroserviceAsDockerContainer() {
  echo 'STARTING MICROSERVICE'
  mvn clean install
  docker build -t mars-rover-control .
  winpty docker run -p 8080:8080 -it --rm --name mars_rover_control_instance mars-rover-control
}

main
