FROM openjdk:8-jdk-alpine
RUN mkdir /app
WORKDIR /app
COPY target/Kubernetes-Assignment-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "Kubernetes-Assignment-0.0.1-SNAPSHOT.jar"]