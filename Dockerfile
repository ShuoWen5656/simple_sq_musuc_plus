FROM maven:3.9.4-eclipse-temurin-17-alpine AS builder
MAINTAINER SQ

WORKDIR /build/

COPY pom.xml /build/
COPY src /build/src/

RUN mvn clean package

From mcr.microsoft.com/openjdk/jdk:17-ubuntu

# 设置默认的环境变量
ENV DB_IP="localhost"
ENV DB_PORT="3306"
ENV DB_NAME="sqmusic"
ENV DB_USERNAME="root"
ENV DB_PASSWORD="root"

WORKDIR /app

COPY --from=builder  /build/target/MusicServer2.0.jar /app/app.jar

EXPOSE 8099

VOLUME ["/music"]

CMD ["java", "-jar", "app.jar"]

