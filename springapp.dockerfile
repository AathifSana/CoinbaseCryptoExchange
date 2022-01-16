
FROM openjdk:8
MAINTAINER aathifs
COPY target/CoinbaseCryptoExchange-0.1.jar CoinbaseCryptoExchange-0.1.jar
ENTRYPOINT ["java","-jar","/CoinbaseCryptoExchange-0.1.jar"]

