FROM openjdk:12-alpine
WORKDIR /app
COPY target/userdailyfable-*-SNAPSHOT.jar /app
ENV server_port=8080
EXPOSE 8080

CMD java -jar userdailyfable-*-SNAPSHOT.jar
