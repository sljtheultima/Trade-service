FROM openjdk:8-jdk-alpine

COPY build/libs/trade-simulator-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8089

ENV TRADE_URI=mongodb://mymongodb:27017/tradedb

ENTRYPOINT ["java", "-jar", "/app.jar"]
