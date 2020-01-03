FROM openjdk:12-alpine
WORKDIR /app
COPY user-service/target/user-service-*-SNAPSHOT.jar /app
ENV server_port=8080
EXPOSE 8080

CMD java -jar user-service-*-SNAPSHOT.jar
