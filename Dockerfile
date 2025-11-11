# Stage 1: Build the jar using Maven
FROM maven:3.9.2-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml first to cache dependencies
COPY pom.xml .

RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build jar (skip tests to speed up)
RUN mvn clean package -DskipTests -B

# Stage 2: Run the app
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port your app runs on
EXPOSE 9590

# Run the Spring Boot app
ENTRYPOINT ["java","-jar","/app/app.jar"]
