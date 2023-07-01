# Use the Amazon Corretto 11 base image
FROM amazoncorretto:17

# Set the working directory in the container
WORKDIR /app

ARG JAR_FILE=target/movie-api-0.0.1-SNAPSHOT.jar

# Copy the compiled JAR file to the container
COPY ${JAR_FILE} /app/movie-api.jar

# Expose the port on which the Spring Boot application will listen
EXPOSE 8083

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "/app/movie-api.jar"]
