FROM openjdk:11
VOLUME /tmp
COPY target/*.jar mars-probe-control.jar
ENTRYPOINT ["java","-jar","/mars-probe-control.jar"]