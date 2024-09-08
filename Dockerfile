# Use the official Eclipse Temurin JDK 21 image as the base image
FROM eclipse-temurin:21-jdk AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the build.gradle.kts and settings.gradle.kts files
COPY build.gradle.kts settings.gradle.kts /app/

# Copy the gradle wrapper files
COPY gradlew /app/
COPY gradle /app/gradle

# Copy the source code
COPY src /app/src

# Download the dependencies and build the application
RUN ./gradlew build --no-daemon

FROM eclipse-temurin:21-jdk

#Copy jar from build
COPY --from=build /app/build/libs/echosrvr-1.0.jar /app/project.jar

# Expose the port the application will run on
EXPOSE 8080

# Set the entry point to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/project.jar"]
