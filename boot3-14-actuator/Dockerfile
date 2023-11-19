FROM openjdk:17-jdk-slim
LABEL authors="loki"

COPY target/*.jar   /java-docker-demo.jar

ENTRYPOINT ["java", "-jar","java-docker-demo.jar"]