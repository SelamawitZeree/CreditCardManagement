# Step 1: Choose a base image
# We use official OpenJDK 17 slim version (small and efficient)
FROM openjdk:21-jdk-slim

# Step 2: Set the working directory inside the container
# All commands will run inside /app
WORKDIR /app

# Step 3: Copy the Spring Boot JAR into the container
# 'target/creditCardManagement-0.0.1-SNAPSHOT.jar' is your built jar
# Inside container, we rename it to app.jar for simplicity
COPY target/creditCardManagement-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Set the command to run your app
# This will run when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
