FROM registry.access.redhat.com/ubi8/openjdk-21:1.21-1.1741652874
COPY target/*.jar /app.jar
EXPOSE 8080
ENV JAVA_APP_JAR="/app.jar"