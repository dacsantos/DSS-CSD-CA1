# Stage 1: Build the Spring Boot app using Maven
FROM maven:3.9.1-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ ./src/
RUN mvn clean verify
RUN mvn package -DskipTests

# Stage 2: Run the Spring Boot app using a JRE-only image
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/datasetProject-0.0.1-SNAPSHOT.jar datasetProject-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "datasetProject-0.0.1-SNAPSHOT.jar"]
