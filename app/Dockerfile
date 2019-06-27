FROM maven:3-jdk-8 AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:go-offline

COPY src/ /app/src
RUN mvn package

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/app-*-SNAPSHOT.jar /app
ENV server_port=80
EXPOSE 80

CMD java -jar app-*-SNAPSHOT.jar
