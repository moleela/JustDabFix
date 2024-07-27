# Use a Gradle base image for the build stage
FROM gradle:8.5-jdk21 AS build

# Set build-time environment variables
ARG BUILD_DATE
ARG VERSION
ARG GIT_COMMIT
ARG ARCH
ARG OS

# Set labels
LABEL org.opencontainers.image.created="${BUILD_DATE}" \
      org.opencontainers.image.title="JustDabFix" \
      org.opencontainers.image.description="A description of JustDabFix" \
      org.opencontainers.image.version="${VERSION}" \
      org.opencontainers.image.url="https://github.com/moleela/JustDabFix" \
      org.opencontainers.image.source="https://github.com/moleela/JustDabFix" \
      org.opencontainers.image.revision="${GIT_COMMIT}" \
      org.opencontainers.image.vendor="Your Company" \
      org.opencontainers.image.licenses="MIT" \
      org.opencontainers.image.architecture="${ARCH}" \
      org.opencontainers.image.os="${OS}"

# Copy the project files into the container
COPY . /backend/

# Set working directory
WORKDIR /backend/

# Build the project, skipping tests to save time
RUN gradle build -x test

# Use a lightweight JDK image for the final runtime
FROM openjdk:21

# Copy the JAR file from the build stage
COPY --from=build /backend/build/libs/justdab-0.0.1-SNAPSHOT.jar /app/just-dab-app.jar

# Set working directory
WORKDIR /app

# Expose the port the application will run on
EXPOSE 8080

# Define the entry point for the container
ENTRYPOINT ["java", "-jar", "just-dab-app.jar"]
