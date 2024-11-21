# Stage 1: Build the application
FROM maven:3.6.3-jdk-8 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application
#FROM openjdk:8-jre-alpine
FROM public.ecr.aws/docker/library/openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar book-catalog-management-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "book-catalog-management-service.jar"]
