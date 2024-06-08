FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/DemorectanglesApplication-0.0.1-SNAPSHOT.jar DemorectanglesApplication.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","DemorectanglesApplication.jar"]

# Path: src/main/resources/application.properties