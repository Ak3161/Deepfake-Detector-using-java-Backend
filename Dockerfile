FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/AiDeepfake-Detector-1.0.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
