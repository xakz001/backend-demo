# Build stage
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

# Install SSL certificates so Gradle can download dependencies
RUN apt-get update && apt-get install -y ca-certificates && update-ca-certificates

# copy gradle wrapper and config
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./

# give execution permission
RUN chmod +x ./gradlew || true

# copy source code
COPY src src

# build the application
RUN ./gradlew bootJar -x test

# Runtime stage
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
