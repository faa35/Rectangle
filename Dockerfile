# FROM maven:3.8.5-openjdk-17 AS build
# COPY . .
# RUN mvn clean package -DskipTests

# FROM openjdk:17.0.1-jdk-slim
# COPY --from=build /target/DemorectanglesApplication-0.0.1-SNAPSHOT.jar DemorectanglesApplication.jar
# EXPOSE 8080
# ENTRYPOINT ["java","-jar","DemorectanglesApplication.jar"]

# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the Docker image
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/DemorectanglesApplication-0.0.1-SNAPSHOT.jar DemorectanglesApplication.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "DemorectanglesApplication.jar"]