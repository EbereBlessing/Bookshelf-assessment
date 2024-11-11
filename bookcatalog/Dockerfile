# Stage 1: Build the application
FROM maven:3.6.3-jdk-8 AS build
WORKDIR /app

# Copy the application's source code into the container
COPY . .

# Build the application and package it as a .jar filels
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:8-jre-alpine
WORKDIR /app

# Copy the .jar file from the build stage
COPY --from=build /app/target/*.jar book-catalog-service.jar
EXPOSE 8080
# Run the .jar file
ENTRYPOINT ["java", "-jar", "book-catalog-service.jar"]
