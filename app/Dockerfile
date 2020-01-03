FROM openjdk:12-jre-alpine
WORKDIR /app
COPY app-shell/target/app-shell-*-SNAPSHOT.jar /app
ENV server_port=80
EXPOSE 80

CMD java -jar app-*-SNAPSHOT.jar
