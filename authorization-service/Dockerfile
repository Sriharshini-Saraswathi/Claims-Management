# For Java 8, try this
#FROM openjdk:8-jdk-alpine

# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/*.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/authorization-service.jar /opt/app/authorization-service.jar
COPY ${JAR_FILE} authorization-service.jar

# java -jar /opt/app/authorization-service.jar
ENTRYPOINT ["java","-jar","authorization-service.jar"]