# Stage 1: Build the jar using Maven
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app

# Copy Maven config and source
COPY pom.xml .
COPY src ./src

# Build jar (skip tests to speed up)
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 9090

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
