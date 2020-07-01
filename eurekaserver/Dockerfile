FROM openjdk:8-jdk-alpine
WORKDIR .
 EXPOSE 8761
COPY ./target/eurekaserver-1.1.jar eurekaserver.jar
ENTRYPOINT exec java -jar eurekaserver.jar