FROM openjdk:12-jre-alpine
WORKDIR /app
COPY target/todo-*-SNAPSHOT.jar /app
ENV server_port=8080
EXPOSE 8080

CMD java -jar todo-*-SNAPSHOT.jar
