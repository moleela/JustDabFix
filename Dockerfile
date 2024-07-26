FROM gradle:8.5-jdk21 AS build

# Copy the project files
COPY . /home/gradle/project

WORKDIR /home/gradle/project

# Build the project
RUN gradle build -x test

FROM openjdk:21

# Add the jar to the container
COPY --from=build /home/gradle/project/build/libs/justdab-0.0.1-SNAPSHOT.jar /app/just-dab-app.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "just-dab-app.jar"]
