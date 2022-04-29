FROM openjdk:11
VOLUME /tmp
COPY target/*.jar mars-rover-control.jar
ENTRYPOINT ["java","-jar","/mars-rover-control.jar"]