FROM maven:3-jdk-8 AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:go-offline && \
    mvn dependency:resolve-plugins

COPY src/ /app/src
RUN mvn package

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/todo-*-SNAPSHOT.jar /app
ENV server_port=8080
EXPOSE 8080

CMD java -jar todo-*-SNAPSHOT.jar
