# Use a base image that has Java
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/marco-0.0.1-SNAPSHOT.jar marco.jar

# Expose the port your application runs on
EXPOSE 8080

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "marco.jar"]