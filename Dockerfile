# Stage 1: Build the JAR file
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the JAR file
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM eclipse-temurin:21
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/myproject-0.0.1-SNAPSHOT.jar myproject.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "myproject.jar"]