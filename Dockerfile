FROM maven AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-jammy
COPY --from=build /target/DemorectanglesApplication-0.0.1-SNAPSHOT.jar DemorectanglesApplication.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","DemorectanglesApplication.jar"]

# Path: src/main/resources/application.properties