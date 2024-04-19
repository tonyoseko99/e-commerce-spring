## Use the official maven/Java 17 image to create a build artifact.
## https://hub.docker.com/_/maven
#FROM maven:3.8.1-openjdk-17-slim AS build
#
## Set the working directory in the image to /app
#WORKDIR /app
#
## Copy the pom.xml file to download dependencies
#COPY pom.xml .
#
## Download the dependencies
#RUN mvn dependency:go-offline -B
#
## Copy the rest of the working directory contents into the image
#COPY src ./src
#
## Build a release artifact.
#RUN mvn package -DskipTests
#
## Use OpenJDK for runtime
## https://hub.docker.com/_/openjdk
## Use java 17
#FROM openjdk:17-jdk-slim
#
## Refer to Maven build -> finalName
#ARG JAR_FILE=target/*.jar
#
## cd /opt/$SERVICE_NAME
#WORKDIR /opt/app
#
## cp target/spring-boot-web.jar /opt/$SERVICE_NAME/app.jar
#COPY --from=build ${JAR_FILE} app.jar
#
## java -jar /opt/$SERVICE_NAME/app.jar
#ENTRYPOINT ["java","-jar","app.jar"]