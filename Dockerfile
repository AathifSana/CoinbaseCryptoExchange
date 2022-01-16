
FROM openjdk:8
MAINTAINER aathifs
COPY target/crypto-0.0.1-SNAPSHOT.jar crypto-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/crypto-0.0.1-SNAPSHOT.jar"]

