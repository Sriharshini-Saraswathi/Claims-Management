# For Java 8, try this
#FROM openjdk:8-jdk-alpine

# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/*.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/policy-service.jar /opt/app/policy-service.jar
COPY ${JAR_FILE} policy-service.jar

# java -jar /opt/app/policy-service.jar
ENTRYPOINT ["java","-jar","policy-service.jar"]