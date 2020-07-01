FROM openjdk:8-jdk-alpine
WORKDIR .
EXPOSE 8081
COPY ./target/authservice-1.1.jar authservice.jar
ENTRYPOINT exec java -jar authservice.jar
