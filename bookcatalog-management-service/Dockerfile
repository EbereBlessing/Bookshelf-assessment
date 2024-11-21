# Stage 1: Build the application
FROM maven:3.6.3-jdk-8 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application
#FROM openjdk:8-jre-alpine
FROM 70416136397.dkr.ecr.us-east-1.amazonaws.com/openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar book-catalog-management-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "book-catalog-management-service.jar"]
