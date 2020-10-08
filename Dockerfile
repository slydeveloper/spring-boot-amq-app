# build stage
FROM maven:3.6.3-jdk-8-slim AS build-stage
LABEL maintainer="sylwek.sokolowski@gmail.com"

COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package -Dmaven.test.skip=true

# dev stage
FROM java:8-jre-alpine as dev-stage
LABEL maintainer="sylwek.sokolowski@gmail.com"

COPY --from=build-stage /tmp/target/*.jar /opt/app.jar
EXPOSE 8080
WORKDIR /opt
ENTRYPOINT ["java","-jar","app.jar"]