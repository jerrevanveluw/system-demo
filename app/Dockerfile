FROM openjdk:8-jre-alpine
WORKDIR /app
COPY target/app-*-SNAPSHOT.jar /app
ENV server_port=80
EXPOSE 80

CMD java -jar app-*-SNAPSHOT.jar
