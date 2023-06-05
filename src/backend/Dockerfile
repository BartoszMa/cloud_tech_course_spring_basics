
FROM gradle:8.1-jdk17-focal AS build
WORKDIR /app
COPY . .
RUN gradle build

FROM openjdk:21-jdk-slim-buster

WORKDIR /app

COPY --from=build /app/build/libs/*.jar /app/spring-boot-application.jar

EXPOSE 4200

ENTRYPOINT ["java", "-jar","/app/spring-boot-application.jar"]

