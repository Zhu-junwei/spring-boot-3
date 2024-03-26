FROM openjdk:17-jdk-slim
LABEL authors="userName"

COPY target/*.jar   /java-docker-demo.jar

ENTRYPOINT ["java", "-jar","java-docker-demo.jar"]