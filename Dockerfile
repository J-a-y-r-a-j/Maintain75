# Use a lightweight OpenJDK image
FROM openjdk:21-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar learn-thymeleaf-1.0.SNAPSHOT.jar

# Expose the port your Spring Boot app runs on (default 8080)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "learn-thymeleaf-1.0.SNAPSHOT.jar"]
