FROM openjdk:8-jdk-alpine

COPY build/libs/trade-simulator-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8089

ENV DB_HOST=mymongodb:27017
ENV DB_NAME=tradedb
ENV SERVER_PORT=8089

RUN sh -c 'echo spring.data.mongodb.uri=mongodb://tradedb:27017/trade > application.properties'

ENTRYPOINT ["java", "-jar", "/app.jar"]
