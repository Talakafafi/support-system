# Stage 1: Build the app
FROM maven:3.9.2-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom and source
COPY pom.xml .
COPY src ./src

# Build jar (skip tests to speed up)
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:17-jdk-slim

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 9095
EXPOSE 9095

# Set environment variable for Railway
ENV PORT=9095

# Run the jar
ENTRYPOINT ["java","-jar","app.jar"]
